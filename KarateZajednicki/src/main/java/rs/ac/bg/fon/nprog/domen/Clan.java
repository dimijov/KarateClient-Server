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
* Klasa koja predstavlja člana karate kluba.
* 
* Ova klasa implementira interfejs OpstiDomenskiObjekat u odnosu na tabelu clan u bazi.
* 
* Član ima svoj ID koji je jedinstven identifikator, kao i ime, prezime, datum rođenja, adresu, broj telefona, grad odakle je i grupa kojoj pripada.
* 
*
* @author HP
* @version 1.1.0
* 
*/
public class Clan implements OpstiDomenskiObjekat{
    
	
	/**
	 * ID člana kao int.
	 */
    private int clanID;
    
    /**
     * Ime člana kao String.
     */
    private String ime;
    
    /**
     * Prezime člana kao String.
     */
    private String prezime;
    
    /**
     * Datum rođenja člana kao java.util.Date.
     */
    private Date datumRodjenja;
    
    /**
     * Adresa člana kao String.
     */
    private String adresa;
    
    /**
     * Broj telefona člana kao String.
     */
    private String brojTelefona;
    
    /**
     * Grad odakle je član kao objekat klase Grad.
     */
    private Grad grad;
    
    /**
     * Grupa kojoj član pripada kao objekat klase Grupa.
     */
    private Grupa grupa;

    
    /**
     * Konstruktor koji inicijalizuje objekat klase Clan.
     */
    public Clan() {
    }

    
    /**
     * Konstruktor koji inicijalizuje objekat klase Clan sa prosleđenim ID-jem.
     * 
     * @param clanID ID člana kao int.
     */
    public Clan(int clanID) {
    	setClanID(clanID);
    }

    
    /**
     * Konstruktor koji inicijalizuje objekat klase Clan sa prosleđenim vrednostima svih atributa.
     * 
     * @param clanID ID člana kao int.
     * @param ime Ime člana kao String.
     * @param prezime Prezime člana kao String.
     * @param datumRodjenja Datum rođenja člana kao java.util.Date.
     * @param adresa Adresa člana kao String.
     * @param brojTelefona Broj telefona člana kao String.
     * @param grad Grad odakle je član kao objekat klase Grad.
     * @param grupa Grupa kojoj član pripada kao objekat klase Grupa.
     */
    public Clan(int clanID, String ime, String prezime, Date datumRodjenja, String adresa, String brojTelefona, Grad grad, Grupa grupa) {
       setClanID(clanID);
       setIme(ime);
       setPrezime(prezime);
       setDatumRodjenja(datumRodjenja);
       setAdresa(adresa);
       setBrojTelefona(brojTelefona);
       setGrad(grad);
       setGrupa(grupa);
    }

    
    /**
     * Metoda koja vraća grupu kojoj član pripada.
     * 
     * @return Grupa kojoj član pripada kao objekat klase Grupa.
     */
    public Grupa getGrupa() {
        return grupa;
    }

    
    /**
     * Metoda koja postavlja grupu kojoj član pripada.
     * 
     * @param grupa Grupa kojoj član pripada kao objekat klase Grupa.
     * @throws NullPointerException ako je grupa null.
     */
    public void setGrupa(Grupa grupa) {
    	if(grupa==null) {
    		throw new NullPointerException("Grupa ne sme biti null");
    	}
        this.grupa = grupa;
    }

    
    /**
     * Metoda koja vraća ID člana.
     * 
     * @return ID člana kao int.
     */
    public int getClanID() {
        return clanID;
    }

    
    /**
     * Metoda koja postavlja ID člana.
     * 
     * @param clanID ID člana kao int.
     * @throws IllegalArgumentException ako je clanID manji od 1.
     */
    public void setClanID(int clanID) {
    	if(clanID<0) {
    		throw new IllegalArgumentException("ClanId ne sme biti manji od nula");
    	}
        this.clanID = clanID;
    }

    
    /**
     * Metoda koja vraća ime člana.
     * 
     * @return Ime člana kao String.
     */
    public String getIme() {
        return ime;
    }

    
    /**
     * Metoda koja postavlja ime člana.
     * 
     * @param ime Ime člana kao String.
     * @throws NullPointerException ako je ime null.
     */
    public void setIme(String ime) {
    	if(ime==null) {
    		throw new NullPointerException("Ime ne sme biti null");
    	}
        this.ime = ime;
    }

    
    /**
     * Metoda koja vraća prezime člana.
     * 
     * @return Prezime člana kao String.
     */
    public String getPrezime() {
        return prezime;
    }

    
    /**
     * Metoda koja postavlja prezime člana.
     * 
     * @param prezime Prezime člana kao String.
     * @throws NullPointerException ako je prezime null.
     */
    public void setPrezime(String prezime) {
    	if(prezime==null) {
    		throw new NullPointerException("Prezime ne sme biti null");
    	}
        this.prezime = prezime;
    }

    
    /**
     * Metoda koja vraća datum rođenja člana.
     * 
     * @return Datum rođenja člana kao java.util.Date.
     */
    public Date getDatumRodjenja() {
        return datumRodjenja;
    }

    
    /**
     * Metoda koja postavlja datum rođenja člana.
     * 
     * @param datumRodjenja Datum rođenja člana kao java.util.Date.
     * @throws IllegalArgumentException ako je datumRodjenja posle današnjeg datuma.
     */
    public void setDatumRodjenja(Date datumRodjenja) {
    	if(datumRodjenja.after(new Date())) {
    		throw new IllegalArgumentException("Datum rodjenja ne sme biti posle danasnjeg datuma");
    	}
        this.datumRodjenja = datumRodjenja;
    }

    
    /**
     * Metoda koja vraća adresu člana.
     * 
     * @return Adresa člana kao String.
     */
    public String getAdresa() {
        return adresa;
    }

    
    /**
     * Metoda koja postavlja adresu člana.
     * 
     * @param adresa Adresa člana kao String.
     * @throws NullPointerException ako je adresa null.
     */
    public void setAdresa(String adresa) {
    	if(adresa==null) {
    		throw new NullPointerException("Adresa ne sme biti null");
    	}
        this.adresa = adresa;
    }

    
    /**
     * Metoda koja vraća broj telefona člana.
     * 
     * @return Broj telefona člana kao String.
     */
    public String getBrojTelefona() {
        return brojTelefona;
    }

    
    /**
     * Metoda koja postavlja broj telefona člana.
     * 
     * @param brojTelefona Broj telefona člana kao String.
     * @throws NullPointerException ako je brojTelefona null.
     * @throws IllegalArgumentException ako brojTelefona nije u formatu za Republiku Srbiju (počinje sa +381 i ima 8 ili 9 cifara).
     */
    public void setBrojTelefona(String brojTelefona) {
    	if(brojTelefona==null) {
    		throw new NullPointerException("Broj telefona ne sme biti null");
    	}
    	
    	 if (!brojTelefona.matches("^\\+381\\d{8,9}$")){
             throw new IllegalArgumentException("Broj telefona nije u formatu za Republiku Srbiju\n Pocinje sa +381 i ima 8 ili 9 cifara");
         }
    	
        this.brojTelefona = brojTelefona;
    }

    
    /**
     * Metoda koja vraća grad odakle je član.
     * 
     * @return Grad odakle je član kao objekat klase Grad.
     */
    public Grad getGrad() {
        return grad;
    }

    
    /**
     * Metoda koja postavlja grad odakle je član.
     * 
     * @param grad Grad odakle je član kao objekat klase Grad.
     * @throws NullPointerException ako je grad null.
     */
    public void setGrad(Grad grad) {
    	if(grad==null) {
    		throw new NullPointerException("Grad ne sme biti null");
    	}
        this.grad = grad;
    }

    
    /**
     * Metoda koja vraća String koji predstavlja ime i prezime člana.
     * 
     * @return Ime i prezime člana kao String.
     */
    @Override
    public String toString() {
        return ime+" "+prezime;
    }


    
    /**
     * Metoda koja poredi dva člana po njihovom ID-u i vraća true ili false.
     * 
     * @param obj Objekat sa kojim se vrši upoređivanje.
     * @return
     * <ul>
     * <li>true - ako su oba objekta klase Clan i imaju isti ID.</li>
     * <li>false - u svim ostalim slučajevima.</li>
     * </ul>
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
