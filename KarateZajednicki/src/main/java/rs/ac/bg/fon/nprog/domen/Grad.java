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
* Klasa koja predstavlja osnovne podatke o gradu u Srbiji.
* 
* Ova klasa implementira interfejs OpstiDomenskiObjekat u odnosu na tabelu grad u bazi.
* 
* Grad ima svoj ID koji ga jedinstveno identifikuje, naziv i postanski broj.
* 
*
* @author HP
* @version 1.1.0
* 
*/
public class Grad implements OpstiDomenskiObjekat{
    
	/**
	 * ID grada kao int.
	 */
     private int gradID;
     
     /**
      * Naziv grada kao String.
      */
     private String naziv;
     
     /**
      * Postanski broj grada kao int.
      */
     private int postanskiBroj;

     
     /**
      * Konstruktor koji inicijalizuje objekat klase Grad.
      */
    public Grad() {
    }
    
    
    /**
     * Konstruktor koji inicijalizuje objekat klase Grad sa prosledjenim ID-jem.
     * 
     * @param gradID ID grada kao int.
     */
    public Grad(int gradID) {
        this.gradID = gradID;
    }

    
    /**
     * Konstruktor koji inicijalizuje objekat klase Grad sa prosledjenim vrednostima svih atributa.
     * 
     * @param gradID ID grada kao int.
     * @param naziv Naziv grada kao String.
     * @param postanskiBroj Postanski broj grada kao int.
     */
    public Grad(int gradID, String naziv, int postanskiBroj) {
        this.gradID = gradID;
        this.naziv = naziv;
        this.postanskiBroj = postanskiBroj;
    }

    
    /**
     * 
     * Vraca String koji predstavlja naziv grada. 
     * @return Naziv grada kao String.
     *
     */
    @Override
    public String toString() {
        return naziv;
    }

    
    /**
     * Metoda koja vraca ID grada.
     * 
     * @return ID grada kao int.
     */
    public int getGradID() {
        return gradID;
    }

    
    /**
     * Metoda koja postavlja ID grada.
     * 
     * @param gradID ID grada kao int.
     * @throws IllegalArgumentException ako je gradID manji od 1.
     */
    public void setGradID(int gradID) {
    	if(gradID<1) {
    		throw new IllegalArgumentException("GradId ne sme biti manji od jedan");
    	}
        this.gradID = gradID;
    }

    
    /**
     * Metoda koja vraca naziv grada.
     * 
     * @return Naziv grada kao String.
     */
    public String getNaziv() {
        return naziv;
    }

    
    /**
     * Metoda koja postavlja naziv grada.
     * 
     * @param naziv Naziv grada kao String.
     * @throws NullPointerException ako je naziv null.
     */
    public void setNaziv(String naziv) {
    	if(naziv==null) {
    		throw new NullPointerException("Naziv ne sme biti null");
    	}
        this.naziv = naziv;
    }

    
    /**
     * Metoda koja vraca postanski broj grada.
     * 
     * @return Postanski broj grada kao int.
     */
    public int getPostanskiBroj() {
        return postanskiBroj;
    }

    /**
     * Metoda koja postavlja postanski broj grada.
     * 
     * @param postanskiBroj Postanski broj grada kao int.
     * @throws IllegalArgumentException ako je postanski broj manji od 0.
     */
    public void setPostanskiBroj(int postanskiBroj) {
    	if(postanskiBroj<0) {
    		throw new IllegalArgumentException("Postanski broj ne sme biti manji od nula");
    	}
        this.postanskiBroj = postanskiBroj;
    }
    
    
     @Override
    public String vratiImeTabele() {
        return "grad";
    }

    @Override
    public String vratiParametre() {
        return String.format("'%s', '%s', '%s'", gradID, naziv,postanskiBroj);
    }

    @Override
    public String vratiPK() {
        return "gradID";
    }

    @Override
    public int vratiVrednostPK() {
         return gradID;
    }

    @Override
    public String vratiSlozenPK() {
        return null;
    }

    @Override
    public List<OpstiDomenskiObjekat> RSuTabelu(ResultSet rs) {
        
         List<OpstiDomenskiObjekat> gradovi = new ArrayList<>();
     
         try {
             while (rs.next()) {
                 int gradID = rs.getInt("gradID");
                 String nazivGrada = rs.getString("naziv");
                 int postanskiBroj=rs.getInt("postanskiBroj");
                 Grad g = new Grad(gradID, nazivGrada,postanskiBroj);
                 
                 gradovi.add(g);
             }
         } catch (SQLException ex) {
             Logger.getLogger(Grad.class.getName()).log(Level.SEVERE, null, ex);
             System.out.println("Greska kod RSuTabelu za Grad");
         }
        
        return gradovi;
    }

    @Override
    public String vratiUpdate() {
        return String.format("gradID='%s', naziv='%s', postanskiBroj='%s'", gradID, naziv,postanskiBroj);
    }

    @Override
    public void postaviVrednostPK(int pk) {
        this.gradID=pk;
    }

    /**
     * Poredi dva grada po njihovom ID-u i vraca true ili false.
     * 
     * @param obj Objekat sa kojim se vrsi uporedjivanje.
     * @return
     * <ul>
     * <li>true - ako su oba objekta klase Grad i imaju isti ID. </li>
     * <li>false - u svim ostalim slucajevima. </li>
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
        final Grad other = (Grad) obj;
        return this.gradID == other.gradID;
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
