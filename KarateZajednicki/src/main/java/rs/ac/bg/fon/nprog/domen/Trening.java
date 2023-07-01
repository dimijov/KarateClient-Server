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
 * Klasa koja predstavlja trening u karate klubu.
 *
 * Ova klasa implementira interfejs OpstiDomenskiObjekat u odnosu na tabelu trening u bazi.
 *
 * Trening ima svoj ID koji je jedinstven identifikator, naziv koji opisuje trening,
 * datum i vreme početka treninga, trajanje treninga, trenera koji vodi trening,
 * grupu za koju se trening održava i salu u kojoj se trening održava.
 * 
 * Takođe, sadrži i listu stavki, koje predstavljaju pojedinačne delove treninga.
 * 
 * 
 * @author HP
 * @version 1.0.0
 * 
 */
public class Trening implements OpstiDomenskiObjekat {
    
	
	 /**
     * ID treninga kao int.
     */
    private int treningID;
    
    /**
     * Naziv treninga kao String.
     */
    private String naziv;
    
    /**
     * Datum i vreme početka treninga kao Date.
     */
    private Date datumVreme;
    
    /**
     * Trajanje treninga u minutima kao int.
     */
    private int trajanje;
    
    /**
     * Lista stavki koje čine StavkaTreninga kao List<OpstiDomenskiObjekat>.
     */
    private List<OpstiDomenskiObjekat> listaStavki;
    
    /**
     * Trener koji vodi trening kao objekat klase Trener.
     */
    private Trener trener;
    
    /**
     * Grupa za koju se trening održava kao objekat klase Grupa.
     */
    private Grupa grupa;
    
    /**
     * Sala u kojoj se trening održava kao objekat klase Sala.
     */
    private Sala sala;

    
    /**
     * Konstruktor koji inicijalizuje objekat klase Trening.
     */
    public Trening() {
    }

    
    /**
     * Konstruktor koji inicijalizuje objekat klase Trening sa prosleđenim ID-jem.
     * 
     * @param treningID ID treninga kao int.
     */
    public Trening(int treningID) {
        this.treningID = treningID;
    }

    
    /**
     * Konstruktor koji inicijalizuje objekat klase Trening sa prosleđenim vrednostima svih atributa.
     * 
     * @param treningID ID treninga kao int.
     * @param naziv Naziv treninga kao String.
     * @param datumVreme Datum i vreme početka treninga kao Date.
     * @param trajanje Trajanje treninga u minutima kao int.
     * @param trener Trener koji vodi trening kao objekat klase Trener.
     * @param grupa Grupa za koju se trening održava kao objekat klase Grupa.
     * @param sala Sala u kojoj se trening održava kao objekat klase Sala.
     */
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

    
    /**
     * Metoda koja vraća salu u kojoj se trening održava.
     * 
     * @return Sala u kojoj se trening održava kao objekat klase Sala.
     */
    public Sala getSala() {
        return sala;
    }

    
    /**
     * Metoda koja postavlja salu u kojoj se trening održava.
     * 
     * @param sala Sala u kojoj se trening održava kao objekat klase Sala.
     * @throws NullPointerException ako je sala null.
     */
    public void setSala(Sala sala) {
    	if(sala==null) {
    		throw new NullPointerException("Sala ne sme biti null");
    	}
        this.sala = sala;
    }

    
    /**
     * Metoda koja vraća ID treninga.
     * 
     * @return ID treninga kao int.
     */
    public int getTreningID() {
        return treningID;
    }

    
    /**
     * Metoda koja postavlja ID treninga.
     * 
     * @param treningID ID treninga kao int.
     * @throws IllegalArgumentException ako je treningID manji od 1.
     */
    public void setTreningID(int treningID) {
    	if(treningID<1) {
    		throw new IllegalArgumentException("TreningId ne sme biti manji od jedan");
    	}
        this.treningID = treningID;
    }

    
    /**
     * Metoda koja vraća naziv treninga.
     * 
     * @return Naziv treninga kao String.
     */
    public String getNaziv() {
        return naziv;
    }

    
    /**
     * Metoda koja postavlja naziv treninga.
     * 
     * @param naziv Naziv treninga kao String.
     * @throws NullPointerException ako je naziv null.
     */
    public void setNaziv(String naziv) {
    	if(naziv==null) {
    		throw new NullPointerException("Naziv ne sme biti null");
    	}
        this.naziv = naziv;
    }

    
    /**
     * Metoda koja vraća datum i vreme početka treninga.
     * 
     * @return Datum i vreme početka treninga kao Date.
     */
    public Date getDatumVreme() {
        return datumVreme;
    }

    
    /**
     * Metoda koja postavlja datum i vreme početka treninga.
     * 
     * @param datumVreme Datum i vreme početka treninga kao Date.
     */
    public void setDatumVreme(Date datumVreme) {
        this.datumVreme = datumVreme;
    }

    
    /**
     * Metoda koja vraća trajanje treninga.
     * 
     * @return Trajanje treninga u minutima kao int.
     */
    public int getTrajanje() {
        return trajanje;
    }

    
    /**
     * Metoda koja postavlja trajanje treninga.
     * 
     * @param trajanje Trajanje treninga u minutima kao int.
     * @throws IllegalArgumentException ako je trajanje manje od 0.
     */
    public void setTrajanje(int trajanje) {
    	if(trajanje<0) {
    		throw new IllegalArgumentException("Trajanje ne sme biti nula ili manje od nule");
    	}
        this.trajanje = trajanje;
    }

    
    /**
     * Metoda koja vraća trenera koji vodi trening.
     * 
     * @return Trener koji vodi trening kao objekat klase Trener.
     */
    public Trener getTrener() {
        return trener;
    }

    
    /**
     * Metoda koja postavlja trenera koji vodi trening.
     * 
     * @param trener Trener koji vodi trening kao objekat klase Trener.
     * @throws NullPointerException ako je trener null.
     */
    public void setTrener(Trener trener) {
    	if(trener==null) {
    		throw new NullPointerException("Trener ne sme biti null");
    	}
        this.trener = trener;
    }

    
    /**
     * Metoda koja vraća listu stavki treninga.
     * 
     * @return Lista stavki treninga kao List objekata koji implementiraju interfejs OpstiDomenskiObjekat.
     */
    public List<OpstiDomenskiObjekat> getListaStavki() {
        return listaStavki;
    }

    
    /**
     * Metoda koja postavlja listu stavki treninga.
     * 
     * @param listaStavki Lista stavki treninga kao List objekata koji implementiraju interfejs OpstiDomenskiObjekat.
     */
    public void setListaStavki(List<OpstiDomenskiObjekat> listaStavki) {
        this.listaStavki = listaStavki;
    }

    
    /**
     * Metoda koja vraća grupu kojoj trening pripada.
     * 
     * @return Grupa kojoj trening pripada kao objekat klase Grupa.
     */
    public Grupa getGrupa() {
        return grupa;
    }

    
    /**
     * Metoda koja postavlja grupu kojoj trening pripada.
     * 
     * @param grupa Grupa kojoj trening pripada kao objekat klase Grupa.
     * @throws NullPointerException ako je grupa null.
     */
    public void setGrupa(Grupa grupa) {
    	if(grupa==null) {
    		throw new NullPointerException("Grupa ne sme biti null");
    	}
        this.grupa = grupa;
    }

    
    /**
     * Metoda koja vraća String reprezentaciju objekta Trening.
     * 
     * @return String koji predstavlja vremenske podatke objekta Trening.
     */
    @Override
    public String toString() {
        return "Trening: "+naziv+",datum i vreme pocetka: "+datumVreme+",projektovano ukupno trajanje: "+trajanje+" min";
    }

    
    /**
     * Metoda koja proverava da li je prosleđeni objekat jednak trenutnom treningu.
     * 
     * @param obj Objekat sa kojim se vrši poređenje.
     * @return 
     *	<ul>
     *	<li>true - ako su oba objekta klase Trening i imaju isti ID.</li>
     *	<li>false - u svim ostalim slučajevima.</li>
     *	</ul>
     */
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
