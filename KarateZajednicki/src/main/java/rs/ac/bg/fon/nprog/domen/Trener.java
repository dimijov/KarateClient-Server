/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.bg.fon.nprog.domen;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * Klasa koja predstavlja trenera u karate klubu.
 * 
 * Ova klasa implementira interfejs OpstiDomenskiObjekat u odnosu na tabelu trener u bazi.
 * 
 * Trener ima svoj ID koji ga jedinstveno identifikuje, ime, prezime, godine iskustva, pojas, korisnicko ime i lozinku.
 * 
 * Takođe, trener ima i atribut ulogovan koji označava da li je trener trenutno ulogovan na sistem.
 *
 * @author HP
 * @version 1.1.0
 * 
 */
public class Trener implements OpstiDomenskiObjekat {
    
	/**
	 * ID trenera kao int.
	 */
    private int trenerID;
    
    /**
     * Ime trenera kao int.
     */
    private String ime;
    
    /**
     * Prezime trenera kao String.
     */
    private String prezime;
    
    /**
     * Godine iskustva trenera kao int.
     */
    private int godineIskustva;
    
    /**
     * Pojas trenera kao String.
     */
    private String pojas;
    
    /**
     * Korisnicko ime trenera kao String.
     */
    private String username;
    
    /**
     * Lozinka trenera kao String;
     */
    private String password;
    
    /**
     * Indikator da li je trener ulogovan ili ne.
     * 
     * <ul>
	 * <li>true - Ako je trener ulogovan na sistem </li>
	 * <li>false - Ako trener nije ulogovan ja sistem </li>
	 * </ul>
     */
    private boolean ulogovan;

    
    /**
     * Konstruktor koji inicijalizuje objekat klase Trener.
     */
    public Trener() {
    }

    
    /**
     * Konstruktor koji inicijalizuje objekat klase Trener sa prosledjenim ID-jem.
     * @param trenerID ID trenera kao int.
     */
    public Trener(int trenerID) {
        this.trenerID = trenerID;
    }

    
    /**
     * Konstruktor koji inicijalizuje objekat klase Trener sa prosledjenim korisnickim imenom i lozinkom.
     * @param username Korisnicko ime trenera kao String.
     * @param password Lozinka trenera kao String.
     */
    public Trener(String username, String password) {
        this.username = username;
        this.password = password;
    }

    
    /**
     * Konstruktor koji inicijalizuje objekat klase Trener sa prosledjenim vrednostima svih atributa.
     * @param trenerID ID trenera kao int.
     * @param ime Ime trenera kao String.
     * @param prezime Prezime trenera kao String.
     * @param godineIskustva Godine iskustva trenera kao int.
     * @param pojas Pojas trenera kao String.
     * @param username Korisnicko ime trenera kao String.
     * @param password Lozinka trenera kao String.
     */
    public Trener(int trenerID, String ime, String prezime, int godineIskustva, String pojas, String username, String password) {
        this.trenerID = trenerID;
        this.ime = ime;
        this.prezime = prezime;
        this.godineIskustva = godineIskustva;
        this.pojas = pojas;
        this.username = username;
        this.password = password;
    }

    
    /**
     * Metoda koja vraca lozinku trenera.
     * @return Lozinka trenera kao String.
     */
    public String getPassword() {
        return password;
    }

    
    /**
     * Metoda koja postavlja lozinku trenera.
     * @param password Lozinka trenera kao String.
     * @throws NullPointerException ako je password null.
     */
    public void setPassword(String password) {
    	if(password==null) {
    		throw new NullPointerException("Password ne sme biti null");
    	}
        this.password = password;
    }

    
    /**
     * Metoda koja vraca ID trenera.
     * @return ID trenera kao int.
     */
    public int getTrenerID() {
        return trenerID;
    }

    
    /**
     * Metoda koja postavlja ID trenera.
     * @param trenerID ID trenera kao int.
     * @throws IllegalArgumentException ako je trenerID manji od 1.
     */
    public void setTrenerID(int trenerID) {
    	if(trenerID<1) {
    		throw new IllegalArgumentException("TrenerID ne sme biti manji od jedan");
    	}
        this.trenerID = trenerID;
    }

    
    /**
     * Metoda koja vraca ime trenera.
     * @return Ime trenera kao String.
     */
    public String getIme() {
        return ime;
    }

    
    /**
     * Metoda koja postavlja ime trenera.
     * @param ime Ime trenera kao String.
     * @throws NullPointerException ako je ime null.
     */
    public void setIme(String ime) {
    	if(ime==null) {
    		throw new NullPointerException("Ime ne sme biti null");
    	}
        this.ime = ime;
    }

    
    /**
     * Metoda koja vraca prezime trenera.
     * @return Prezime trenera kao String.
     */
    public String getPrezime() {
        return prezime;
    }

    
    /**
     * Metoda koja postavlja prezime trenera.
     * @param prezime Prezime trenera kao String.
     * @throws NullPointerException ako je prezime null.
     */
    public void setPrezime(String prezime) {
    	if(prezime==null) {
    		throw new NullPointerException("Prezime ne sme biti null");
    	}
        this.prezime = prezime;
    }

    
    /**
     * Metoda koja vraca godine iskustva trenera.
     * @return Godine iskustva trenera kao int.
     */
    public int getGodineIskustva() {
        return godineIskustva;
    }

    
    /**
     * Metoda koja postavlja godine iskustva trenera.
     * @param godineIskustva Godine iskustva trenera kao int.
     * @throws IllegalArgumentException ako su godineIskustva manje od 0.
     */
    public void setGodineIskustva(int godineIskustva) {
    	if(godineIskustva<0) {
    		throw new IllegalArgumentException("Godine iskustva ne smeju biti manji od nula");
    	}
        this.godineIskustva = godineIskustva;
    }

    
    /**
     * Metoda koja vraca pojas trenera.
     * @return Pojas trenera kao String.
     */
    public String getPojas() {
        return pojas;
    }

    
    /**
     * Metoda koja postavlja pojas trenera.
     * @param pojas Pojas trenera kao String.
     * @throws NullPointerException ako je pojas null.
     * @throws IllegalArgumentException ako pojas nije "crni", "plavi" ili "braon".
     */
    public void setPojas(String pojas) {
    	if(pojas==null) {
    		throw new NullPointerException("Pojas ne sme biti null");
    	}
    	if(!pojas.equalsIgnoreCase("crni") && !pojas.equalsIgnoreCase("plavi") && !pojas.equalsIgnoreCase("braon")) {
    		throw new IllegalArgumentException("Pojas trenera mora biti:crni,braon ili plavi");
    	}
        this.pojas = pojas;
    }

    
    /**
     * Metoda koja vraca korisnicko ime trenera.
     * @return Korisnicko ime trenera kao String.
     */
    public String getUsername() {
        return username;
    }

    
    /**
     * Metoda koja postavlja korisnicko ime trenera.
     * @param username Korisnicko ime trenera kao String.
     * @throws NullPointerException ako je username null.
     */
    public void setUsername(String username) {
    	if(username==null) {
    		throw new NullPointerException("Username ne sme biti null");
    	}
        this.username = username;
    }

    
    /**
     * 
     * Vraca String koji predstavlja ime i prezime trenera. 
     * @return Ime i prezime trenera kao String.
     *
     */
    @Override
    public String toString() {
        return ime+" "+prezime;
    }

    
    /**
     * Metoda koja postavlja indikator da li je trener ulogovan ili ne.
     * @param ulogovan boolean Indikator da li je trener ulogovan.
     * <ul>
	 * <li>true - Ako je trener ulogovan na sistem </li>
	 * <li>false - Ako trener nije ulogovan ja sistem </li>
	 * </ul>
     */
    public void setUlogovan(boolean ulogovan) {
        this.ulogovan = ulogovan;
    }
    
    
    /**
     * Metoda koja vraca indikator da li je trener ulogovan ili ne.
     * @return  boolean Indikator da li je trener ulogovan.
     * <ul>
	 * <li>true - Ako je trener ulogovan na sistem </li>
	 * <li>false - Ako trener nije ulogovan ja sistem </li>
	 * </ul>
     */
    public boolean isUlogovan() {
        return ulogovan;
    }

    
    /**
     * Poredi dva trenera po njihovom ID imenu i vraca true ili false.
     * 
     * @param obj Objekat sa kojim se vrsi uporedjivanje.
     * @return
	 * <ul>
	 * <li>true - ako su oba objekta klase Trener i imaju isti ID. </li>
	 * <li>false - u svim ostalim slucajevima </li>
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
        final Trener other = (Trener) obj;
        return this.trenerID == other.trenerID;
    }
    
     @Override
    public String vratiImeTabele() {

        return "trener";
    }

    @Override
    public String vratiParametre() {
       return String.format("'%s', '%s', '%s', '%s', '%s','%s', '%s'", trenerID, ime,prezime,godineIskustva, pojas,username,password);
    }

    @Override
    public String vratiPK() {
        return "trenerID";
    }

    @Override
    public int vratiVrednostPK() {

        return trenerID;
    }

    @Override
    public String vratiSlozenPK() {
      
        return null;
    }

    @Override
    public List<OpstiDomenskiObjekat> RSuTabelu(ResultSet rs) {

         List<OpstiDomenskiObjekat> treneri = new ArrayList<>();
    
        try {
            while (rs.next()) {
                int trenerID = rs.getInt("trenerID");
                String ime = rs.getString("ime");
                String prezime = rs.getString("prezime");
                int godineIskustva=rs.getInt("godineIskustva");
                String pojas = rs.getString("pojas");
                String username = rs.getString("username");
                String password = rs.getString("password");
                
                Trener t=new Trener(trenerID, ime, prezime, godineIskustva, pojas, username, password);
                treneri.add(t);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Trener.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Greska kod RSuTabelu za Trenera");
        }
       
        return treneri;
    }

    @Override
    public String vratiUpdate() {
        return String.format("trenerID='%s', ime='%s', prezime='%s', godineIskustva='%s',pojas='%s', username='%s',password='%s'", trenerID, ime,prezime, godineIskustva,pojas,username,password);
    }

    @Override
    public void postaviVrednostPK(int pk) {
        this.trenerID = pk;
    }


    @Override
    public String vratiAtributPretrazivanja() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String vratiVrednostAtributa() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    
    @Override
    public String kolone() {
        return null;
    }

    @Override
    public String vratiUslovZaJoin() {
        return "";    
    }
    
    @Override
    public String vratiAtributePretrazivanja() {
        return null;
    }
    
    
    
    
    
    
}
