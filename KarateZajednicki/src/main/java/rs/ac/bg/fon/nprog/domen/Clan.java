/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.bg.fon.nprog.domen;

import java.util.Date;
import java.util.List;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;



/**
 *
 * @author HP
 */
public class Clan implements OpstiDomenskiObjekat{
    
    private int clanID;
    private String ime;
    private String prezime;
    private Date datumRodjenja;
    private String adresa;
    private String brojTelefona;
    private Grad grad;
    private Grupa grupa;

    public Clan() {
    }

    public Clan(int clanID) {
        this.clanID = clanID;
    }

    
    
    public Clan(int clanID, String ime, String prezime, Date datumRodjenja, String adresa, String brojTelefona, Grad grad, Grupa grupa) {
        this.clanID = clanID;
        this.ime = ime;
        this.prezime = prezime;
        this.datumRodjenja = datumRodjenja;
        this.adresa = adresa;
        this.brojTelefona = brojTelefona;
        this.grad = grad;
        this.grupa = grupa;
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

    public int getClanID() {
        return clanID;
    }

    public void setClanID(int clanID) {
    	if(clanID<1) {
    		throw new IllegalArgumentException("ClanId ne sme biti manji od jedan");
    	}
        this.clanID = clanID;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
    	if(ime==null) {
    		throw new NullPointerException("Ime ne sme biti null");
    	}
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
    	if(prezime==null) {
    		throw new NullPointerException("Prezime ne sme biti null");
    	}
        this.prezime = prezime;
    }

    public Date getDatumRodjenja() {
        return datumRodjenja;
    }

    public void setDatumRodjenja(Date datumRodjenja) {
    	if(datumRodjenja.after(new Date())) {
    		throw new IllegalArgumentException("Datum rodjenja ne sme biti posle danasnjeg datuma");
    	}
        this.datumRodjenja = datumRodjenja;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
    	if(adresa==null) {
    		throw new NullPointerException("Adresa ne sme biti null");
    	}
        this.adresa = adresa;
    }

    public String getBrojTelefona() {
        return brojTelefona;
    }

    public void setBrojTelefona(String brojTelefona) {
    	if(brojTelefona==null) {
    		throw new NullPointerException("Broj telefona ne sme biti null");
    	}
    	
    	 if (!brojTelefona.matches("^\\+381\\d{8,9}$")){
             throw new IllegalArgumentException("Broj telefona nije u formatu za Republiku Srbiju\n Pocinje sa +381 i ima 8 ili 9 cifara");
         }
    	
        this.brojTelefona = brojTelefona;
    }

    public Grad getGrad() {
        return grad;
    }

    public void setGrad(Grad grad) {
    	if(grad==null) {
    		throw new NullPointerException("Grad ne sme biti null");
    	}
        this.grad = grad;
    }

    @Override
    public String toString() {
        return ime+" "+prezime;
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
        final Clan other = (Clan) obj;
        return this.clanID == other.clanID;
    }
    
    
     @Override
    public String vratiImeTabele() {

        return "clan";
    }

    @Override
    public String vratiParametre() {
       java.sql.Date sqlDatumRodjenja=new java.sql.Date(datumRodjenja.getTime());
       return String.format("'%s', '%s', '%s', '%s', '%s','%s', '%s', '%s'", clanID, ime,prezime,sqlDatumRodjenja, adresa,brojTelefona,grad.getGradID(), grupa.getGrupaID());
    }

    @Override
    public String vratiPK() {
        return "clanID";
    }

    @Override
    public int vratiVrednostPK() {

        return clanID;
    }

    @Override
    public String vratiSlozenPK() {
      
        return null;
    }

    @Override
    public List<OpstiDomenskiObjekat> RSuTabelu(ResultSet rs) {

         List<OpstiDomenskiObjekat> clanovi = new ArrayList<>();
    
        try {
            while (rs.next()) {
                int clanID = rs.getInt("clanID");
                String ime = rs.getString("ime");
                String prezime = rs.getString("prezime");
                Date datumRodjenja = rs.getDate("datumRodjenja");
                String adresa = rs.getString("adresa");
                String brojTelefona = rs.getString("brojTelefona");
                int gradID = rs.getInt("gradID");
                int grupaID=rs.getInt("grupaID");
                
                Clan c = new Clan(clanID, ime, prezime, datumRodjenja, adresa, brojTelefona, new Grad(rs.getInt("gradID"),rs.getString("nazivGrada"),rs.getInt("postanskiBroj")), new Grupa(rs.getInt("grupaID"),rs.getString("nazivGrupe")));
                clanovi.add(c);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Clan.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Greska kod RSuTabelu za Clana");
        }
       
        return clanovi;
    }

    @Override
    public String vratiUpdate() {
        //DATUM PROVERI
        java.sql.Date datumRodjenjaSQL=new java.sql.Date(datumRodjenja.getTime());
        return String.format("clanID='%s', ime='%s', prezime='%s', datumRodjenja='%s',adresa='%s', brojTelefona='%s',gradID='%s',grupaID='%s'", clanID, ime,prezime, datumRodjenjaSQL,adresa,brojTelefona,grad.getGradID(),grupa.getGrupaID());
    }

    @Override
    public void postaviVrednostPK(int pk) {
        this.clanID = pk;
    }

    @Override
    public String vratiUslovZaJoin() {
      return "clan c JOIN grupa g ON c.grupaID = g.grupaID " +
             "JOIN grad gr ON c.gradID = gr.gradID";
    }

    @Override
    public String vratiAtributPretrazivanja() {
        return " c.grupaID = ";
    }

    @Override
    public String vratiVrednostAtributa() {
        return String.valueOf(grupa.getGrupaID());
    }

    @Override
    public String kolone() {
        return " c.*, g.naziv AS nazivGrupe, gr.naziv AS nazivGrada, gr.postanskiBroj";
    }

    @Override
    public String vratiAtributePretrazivanja() {
        return null;
    }
    
    
    
}
