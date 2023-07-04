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
* Klasa koja predstavlja grupu u karate klubu.
* 
* Ova klasa implementira interfejs OpstiDomenskiObjekat u odnosu na tabelu grupa u bazi.
* 
* Grupa ima svoj ID koji je jedinstven identifikator, kao i naziv koji opisuje grupu.
* 
*
* @author HP
* @version 1.1.0
* 
*/
public class Grupa implements OpstiDomenskiObjekat{
    
	/**
	 * ID grupe kao int.
	 */
    private int grupaID;
    
    /**
     * Naziv grupe kao String.
     */
    private String naziv;

    /**
     * Konstruktor koji inicijalizuje objekat klase Grupa.
     */
    public Grupa() {
    }

    
    /**
     * Konstruktor koji inicijalizuje objekat klase Grupa sa prosleđenim ID-jem.
     * @param grupaID ID grupe kao int.
     */
    public Grupa(int grupaID) {
        setGrupaID(grupaID);
    }
    
    
    /**
     * Konstruktor koji inicijalizuje objekat klase Grupa sa prosleđenim vrednostima svih atributa.
     * @param grupaID ID grupe kao int.
     * @param naziv Naziv grupe kao String.
     */
    public Grupa(int grupaID, String naziv) {
        setGrupaID(grupaID);
        setNaziv(naziv);
    }

    
    /**
     * Metoda koja vraca naziv grupe.
     * @return Naziv grupe kao String.
     */
    public String getNaziv() {
        return naziv;
    }

    
    /**
     * Metoda koja postavlja naziv grupe.
     * @param naziv Naziv grupe kao String.
     * @throws NullPointerException ako je naziv null.
     */
    public void setNaziv(String naziv) {
    	if(naziv==null) {
    		throw new NullPointerException("Naziv ne sme biti null");
    	}
        this.naziv = naziv;
    }

    /**
     * Metoda koja vraca ID grupe.
     * @return ID grupe kao int.
     */
    public int getGrupaID() {
        return grupaID;
    }

    /**
     * Metoda koja postavlja ID grupe.
     * @param grupaID ID grupe kao int.
     * @throws IllegalArgumentException ako je grupaID manji od 1.
     */
    public void setGrupaID(int grupaID) {
    	if(grupaID<0) {
    		throw new IllegalArgumentException("GrupaId ne sme biti manja od nula");
    	}
        this.grupaID = grupaID;
    }

   
    /**
     * Poredi dve grupe po njihovom ID-u i vraća true ili false.
     * @param obj Objekat sa kojim se vrši upoređivanje.
     * @return
     *  <ul>
     *  <li>true - ako su oba objekta klase Grupa i imaju isti ID.</li>
     *  <li>false - u svim ostalim slučajevima.</li>
     *  </ul>
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
        final Grupa other = (Grupa) obj;
        return this.grupaID == other.grupaID;
    }

    /**
     * 
     * Vraca String koji predstavlja naziv grupe. 
     * @return Naziv grupe kao String.
     *
     */
    @Override
    public String toString() {
        return naziv;
    }

    @Override
    public String vratiImeTabele() {
        return "grupa";
    }

     @Override
    public String vratiParametre() {
        return String.format("'%s', '%s'", grupaID, naziv);
    }

    @Override
    public String vratiPK() {
        return "grupaID";
    }

    @Override
    public int vratiVrednostPK() {
         return grupaID;
    }

    @Override
    public String vratiSlozenPK() {
        return null;
    }

    @Override
    public List<OpstiDomenskiObjekat> RSuTabelu(ResultSet rs) {
        
         List<OpstiDomenskiObjekat> grupe = new ArrayList<>();
     
         try {
             while (rs.next()) {
                 int grupaID = rs.getInt("grupaID");
                 String nazivGrupe = rs.getString("naziv");
                 Grupa g = new Grupa(grupaID, nazivGrupe);
                 
                 grupe.add(g);
             }
         } catch (SQLException ex) {
             Logger.getLogger(Grupa.class.getName()).log(Level.SEVERE, null, ex);
             System.out.println("Greska kod RSuTabelu za Grupe");
         }
        
        return grupe;
    }

    @Override
    public String vratiUpdate() {
        return String.format("grupaID='%s', naziv='%s'", grupaID, naziv);
    }

    @Override
    public void postaviVrednostPK(int pk) {
        this.grupaID=pk;
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
