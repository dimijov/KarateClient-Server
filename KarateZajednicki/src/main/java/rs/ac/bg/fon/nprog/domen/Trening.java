/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.bg.fon.nprog.domen;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author HP
 */
public class Trening implements OpstiDomenskiObjekat {
    
    private int treningID;
    private String naziv;
    private Date datumVreme;
    private int trajanje;
    private List<OpstiDomenskiObjekat> listaStavki;
    private Trener trener;
    private Grupa grupa;
    private Sala sala;

    public Trening() {
    }

    public Trening(int treningID) {
        this.treningID = treningID;
    }

    public Trening(int treningID, String naziv, Date datumVreme, int trajanje, Trener trener, Grupa grupa, Sala sala) {
        this.treningID = treningID;
        this.naziv = naziv;
        this.datumVreme = datumVreme;
        this.trajanje = trajanje;
        this.trener = trener;
        this.listaStavki = new ArrayList<>();
        this.grupa = grupa;
        this.sala = sala;
    }

    public Sala getSala() {
        return sala;
    }

    public void setSala(Sala sala) {
    	if(sala==null) {
    		throw new NullPointerException("Sala ne sme biti null");
    	}
        this.sala = sala;
    }

    public int getTreningID() {
        return treningID;
    }

    public void setTreningID(int treningID) {
    	if(treningID<1) {
    		throw new IllegalArgumentException("TreningId ne sme biti manji od jedan");
    	}
        this.treningID = treningID;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
    	if(naziv==null) {
    		throw new NullPointerException("Naziv ne sme biti null");
    	}
        this.naziv = naziv;
    }

    public Date getDatumVreme() {
        return datumVreme;
    }

    public void setDatumVreme(Date datumVreme) {
        this.datumVreme = datumVreme;
    }

    public int getTrajanje() {
        return trajanje;
    }

    public void setTrajanje(int trajanje) {
    	if(trajanje<=0) {
    		throw new IllegalArgumentException("Trajanje ne sme biti nula ili manje od nule");
    	}
        this.trajanje = trajanje;
    }

    public Trener getTrener() {
        return trener;
    }

    public void setTrener(Trener trener) {
    	if(trener==null) {
    		throw new NullPointerException("Trener ne sme biti null");
    	}
        this.trener = trener;
    }

    public List<OpstiDomenskiObjekat> getListaStavki() {
        return listaStavki;
    }

    public void setListaStavki(List<OpstiDomenskiObjekat> listaStavki) {
        this.listaStavki = listaStavki;
    }

    public Grupa getGrupa() {
        return grupa;
    }

    public void setGrupa(Grupa grupa) {
    	if(grupa==null) {
    		throw new NullPointerException("Grupa ne sme biti null");
    	}
        this.grupa = grupa;
    }

    @Override
    public String toString() {
        return "Trening: "+naziv+",datum i vreme pocetka: "+datumVreme+",projektovano ukupno trajanje: "+trajanje+" min";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Trening other = (Trening) obj;
        return this.treningID == other.treningID;
    }
    
    

   @Override
    public String vratiImeTabele() {

        return "trening";
    }

    @Override
    public String vratiParametre() {

         java.sql.Timestamp sqlDatumVreme=new java.sql.Timestamp(datumVreme.getTime());
         return String.format("'%s', '%s', '%s', '%s', '%s', '%s', '%s'", treningID, naziv, sqlDatumVreme, trajanje,trener.getTrenerID(),grupa.getGrupaID(),sala.getSalaID());
    }

    @Override
    public String vratiPK() {

        return "treningID";
    }

    @Override
    public int vratiVrednostPK() {

        return treningID;
    }

    @Override
    public String vratiSlozenPK() {
        return null;
    }

    @Override
    public List<OpstiDomenskiObjekat> RSuTabelu(ResultSet rs) {

         List<OpstiDomenskiObjekat> treninzi = new ArrayList<>();
      
        try {
            while (rs.next()) {
                int treningID = rs.getInt("treningID");
                String naziv=rs.getString("nazivTreninga");
                Date datumVreme = rs.getTimestamp("datumVreme");
                int trajanje = rs.getInt("trajanje");
                int trenerID = rs.getInt("trenerID");
                int grupaID = rs.getInt("grupaID");
                int salaID = rs.getInt("salaID");
                
                Trening t=new Trening(treningID, naziv, datumVreme, trajanje, new Trener(trenerID,rs.getString("ime"),rs.getString("prezime"),rs.getInt("godineIskustva"),rs.getString("pojas"),rs.getString("username"),rs.getString("password")), new Grupa(rs.getInt("grupaID"),rs.getString("nazivGrupe")), new Sala(rs.getInt("salaID"), rs.getString("nazivSale"), rs.getInt("kapacitet")));
                StavkaTreninga st = new StavkaTreninga(rs.getInt("rbStavke"),t, rs.getInt("brojPonavljanja"),rs.getString("tezina") ,rs.getInt("trajanjeStavke") ,new Vezba(rs.getInt("vezbaID"),rs.getString("nazivVezbe"), rs.getString("opis"), rs.getInt("duzina")));
  
              
               
               if(!treninzi.contains(t)){
                  t.getListaStavki().add(st);
                  treninzi.add(t);
               }else{
                   for (OpstiDomenskiObjekat odo : treninzi) {
                       Trening tr=(Trening) odo;
                       if(t.equals(tr)){
                           tr.getListaStavki().add(st);
                       }
                   }
               }
                
               
  
            }  
        } catch (SQLException ex) {
            Logger.getLogger(Trening.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Greska kod RSuTabelu za Treninge");
        }
        return treninzi;
    }
    @Override
    public String vratiUpdate() {

        java.sql.Timestamp datumVremeSQL = new java.sql.Timestamp(datumVreme.getTime());
    return String.format("treningID='%s', naziv='%s', datumVreme='%s', trajanje='%s',trenerID='%s',grupaID='%s',salaID='%s'", treningID, naziv,datumVremeSQL,trajanje,trener.getTrenerID(),grupa.getGrupaID(),sala.getSalaID());

    }

    

    
    @Override
    public void postaviVrednostPK(int pk) {

        this.treningID = pk;
    }

    @Override
    public String kolone() {
        return  "t.treningID, t.naziv AS nazivTreninga, t.datumVreme, t.trajanje,tr.trenerID ,tr.ime ,tr.prezime ,tr.godineIskustva ,tr.pojas ,tr.username ,tr.password , g.grupaID ,  g.naziv AS nazivGrupe, s.salaID , s.naziv AS nazivSale, s.kapacitet, st.rbStavke, st.brojPonavljanja, st.tezina, st.trajanje AS trajanjeStavke,v.vezbaID, v.naziv AS nazivVezbe, v.opis, v.duzina";
    }

    @Override
    public String vratiUslovZaJoin() {
        return "trening t JOIN grupa g ON t.grupaID = g.grupaID " +
                "JOIN sala s ON s.salaID = t.salaID " +
                "JOIN trener tr ON tr.trenerID = t.trenerID " +
                "JOIN stavkatreninga st ON st.treningID = t.treningID " +
                "JOIN vezba v ON v.vezbaID = st.vezbaID ";
                
    }

    @Override
    public String vratiAtributPretrazivanja() {
        return " tr.trenerID = "; 
    }

    @Override
    public String vratiVrednostAtributa() {
        return String.valueOf(trener.getTrenerID());
    }

    @Override
    public String vratiAtributePretrazivanja() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String datum = sdf.format(datumVreme);
        return String.format(" tr.trenerID ='%s' AND DATE(datumVreme) = '%s' ",trener.getTrenerID(),datum);
    }
    
    
    
}
