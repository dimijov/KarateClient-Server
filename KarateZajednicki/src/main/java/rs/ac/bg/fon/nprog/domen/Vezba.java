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
* Klasa koja predstavlja vezbu u programu treninga.
* 
* Ova klasa implementira interfejs OpstiDomenskiObjekat u odnosu na tabelu vezba u bazi.
* 
* Vezba ima svoj ID koji je jedinstven identifikator, naziv, opis i trajanje.
* 
*
* @author HP
* @version 1.1.0
* 
*/
public class Vezba implements OpstiDomenskiObjekat {
    
	/**
     * ID vezbe kao int.
     */
    private int vezbaID;
    
    /**
     * Naziv vezbe kao String.
     */
    private String naziv;
    
    /**
     * Opis vezbe kao String.
     */
    private String opis;
    
    /**
     * Trajanje vezbe kao int.
     */
    private int duzina;

    
    /**
     * Konstruktor koji inicijalizuje objekat klase Vezba.
     */
    public Vezba() {
    }

    
    /**
     * Konstruktor koji inicijalizuje objekat klase Vezba sa prosledjenim ID-jem.
     * 
     * @param vezbaID ID vezbe kao int.
     */
    public Vezba(int vezbaID) {
        this.vezbaID = vezbaID;
    }

    
    /**
     * Konstruktor koji inicijalizuje objekat klase Vezba sa prosleđenim vrednostima svih atributa.
     * 
     * @param vezbaID ID vezbe kao int.
     * @param naziv Naziv vezbe kao String.
     * @param opis Opis vezbe kao String.
     * @param duzina Trajanje vezbe kao int.
     */
    public Vezba(int vezbaID, String naziv, String opis,int duzina) {
        this.vezbaID = vezbaID;
        this.naziv = naziv;
        this.opis = opis;
        this.duzina=duzina;
    }

    
    /**
     * Metoda koja vraca opis vezbe.
     * 
     * @return Opis vezbe kao String.
     */
    public String getOpis() {
        return opis;
    }

    
    /**
     * Metoda koja postavlja opis vezbe.
     * 
     * @param opis Opis vezbe kao String.
     * @throws NullPointerException ako je opis null.
     */
    public void setOpis(String opis) {
    	if(opis==null) {
    		throw new NullPointerException("Opis ne sme biti null");
    	}
        this.opis = opis;
    }

    
    /**
     * Metoda koja vraca ID vezbe.
     * @return ID vezbe kao int.
     */
    public int getVezbaID() {
        return vezbaID;
    }

    /**
     * Metoda koja postavlja ID vezbe.
     * 
     * @param vezbaID ID vezbe kao int.
     * @throws IllegalArgumentException ako je vezbaID manji od 1.
     */
    public void setVezbaID(int vezbaID) {
    	if(vezbaID<1) {
    		throw new IllegalArgumentException("VezbaId ne sme biti manja od jedan");
    	}
        this.vezbaID = vezbaID;
    }

    
    /**
     * Metoda koja vraca naziv vezbe.
     * 
     * @return Naziv vezbe kao String.
     */
    public String getNaziv() {
        return naziv;
    }

    
    /**
     * Metoda koja postavlja naziv vezbe.
     * 
     * @param naziv Naziv vezbe kao String.
     * @throws NullPointerException ako je naziv null.
     */
    public void setNaziv(String naziv) {
    	if(naziv==null) {
    		throw new NullPointerException("Naziv ne sme biti null");
    	}
        this.naziv = naziv;
    }

    
    /**
     * Metoda koja vraca trajanje vezbe.
     * 
     * @return Trajanje vezbe kao String.
     */
    public int getDuzina() {
        return duzina;
    }

    
    /**
     * Metoda koja postavlja trajanje vezbe.
     * 
     * @param duzina Trajanje vezbe kao int.
     * @throws IllegalArgumentException ako je trajanje manje od 1.
     */
    public void setDuzina(int duzina) {
    	if(duzina<=0) {
    		throw new IllegalArgumentException("Duzina ne sme biti nula ili manje od nula");
    	}
        this.duzina = duzina;
    }

    
    /**
     * Metoda koja vraca String koji predstavlja naziv vezbe.
     *
     * @return Naziv vezbe kao String.
     */
    @Override
    public String toString() {
        return naziv;
    }

    
    /**
     * Metoda koja poredi dve vezbe po njihovom ID-u i vraca true ili false.
     *
     * @param obj Objekat sa kojim se vrsi upoređivanje.
     * @return
     *<ul>
     *<li>true - ako su oba objekta klase Vezba i imaju isti ID.</li>
     *<li>false - u svim ostalim slučajevima.</li>
     *</ul>
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
        final Vezba other = (Vezba) obj;
        return this.vezbaID == other.vezbaID;
    }
    
      
     @Override
    public String vratiImeTabele() {
        return "vezba";
    }

    @Override
    public String vratiParametre() {
        return String.format("'%s', '%s', '%s', '%s'", vezbaID, naziv,opis,duzina);
    }

    @Override
    public String vratiPK() {
        return "vezbaID";
    }

    @Override
    public int vratiVrednostPK() {
         return vezbaID;
    }

    @Override
    public String vratiSlozenPK() {
        return null;
    }

    @Override
    public List<OpstiDomenskiObjekat> RSuTabelu(ResultSet rs) {
        
         List<OpstiDomenskiObjekat> vezbe = new ArrayList<>();
     
         try {
             while (rs.next()) {
                 int vezbaID = rs.getInt("vezbaID");
                 String nazivVezbe = rs.getString("naziv");
                 String opis=rs.getString("opis");
                 int duzina=rs.getInt("duzina");
                 Vezba v=new Vezba(vezbaID, nazivVezbe, opis,duzina);
                 
                 vezbe.add(v);
             }
         } catch (SQLException ex) {
             Logger.getLogger(Vezba.class.getName()).log(Level.SEVERE, null, ex);
             System.out.println("Greska kod RSuTabelu za Vezbu");
         }
        
        return vezbe;
    }

    @Override
    public String vratiUpdate() {
        return String.format("vezbaID='%s', naziv='%s', opis='%s, duzina='%s'", vezbaID, naziv,opis,duzina);
    }

    @Override
    public void postaviVrednostPK(int pk) {
        this.vezbaID=pk;
    }

    @Override
    public String vratiUslovZaJoin() {
        return "";
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
    public String vratiAtributePretrazivanja() {
        return null;
    }
     
    
    
    
}
