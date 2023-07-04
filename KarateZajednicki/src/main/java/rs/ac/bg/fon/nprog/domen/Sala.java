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
* Klasa koja predstavlja informacije o sali u karate klubu.
* 
* Ova klasa implementira interfejs OpstiDomenskiObjekat u odnosu na tabelu sala u bazi.
* 
* Sala ima svoj ID koji je jedinstven, naziv i kapacitet.
* 
*
* @author HP
* @version 1.1.0
* 
*/
public class Sala implements OpstiDomenskiObjekat {
    
	
	/**
	 * ID sale kao int.
	 */
    private int salaID;
    
    /**
     * Naziv sale kao String.
     */
    private String naziv;
    
    /**
     * Kapacitet sale kao int.
     */
    private int kapacitet;

    
    /**
     * Konstruktor koji inicijalizuje objekat klase Sala.
     */
    public Sala() {
    }

    
    /**
     * Konstruktor koji inicijalizuje objekat klase Sala sa prosledjenim ID-jem.
     *
     * @param salaID ID sale kao int.
     */
    public Sala(int salaID) {
    	setSalaID(salaID);
    }

    
    /**
     * Konstruktor koji inicijalizuje objekat klase Sala sa prosledjenim vrednostima svih atributa.
     *
     * @param salaID ID sale kao int.
     * @param naziv Naziv sale kao String.
     * @param kapacitet Kapacitet sale kao int.
     */
    public Sala(int salaID, String naziv, int kapacitet) {
        setSalaID(salaID);
        setNaziv(naziv);
        setKapacitet(kapacitet);
    }

    
    /**
     * Metoda koja vraca kapacitet sale.
     *
     * @return Kapacitet sale kao int.
     */
    public int getKapacitet() {
        return kapacitet;
    }

    
    /**
     * Metoda koja postavlja kapacitet sale.
     *
     * @param kapacitet Kapacitet sale kao int.
     * @throws IllegalArgumentException ako je kapacitet manji od 1.
     */
    public void setKapacitet(int kapacitet) {
    	if(kapacitet<1) {
    		throw new IllegalArgumentException("Kapacitet ne sme biti manji od jedan");
    	}
        this.kapacitet = kapacitet;
    }

    
    /**
     * Metoda koja vraca ID sale.
     *
     * @return ID sale kao int.
     */
    public int getSalaID() {
        return salaID;
    }

    
    /**
     * Metoda koja postavlja ID sale.
     *
     * @param salaID ID sale kao int.
     * @throws IllegalArgumentException ako je salaID manji od 1.
     */
    public void setSalaID(int salaID) {
    	if(salaID<0) {
    		throw new IllegalArgumentException("SalaId ne sme biti manje od nula");
    	}
        this.salaID = salaID;
    }

    
    /**
     * Metoda koja vraca naziv sale.
     *
     * @return Naziv sale kao String.
     */
    public String getNaziv() {
        return naziv;
    }

    
    /**
     * Metoda koja postavlja naziv sale.
     *
     * @param naziv Naziv sale kao String.
     * @throws NullPointerException ako je naziv null.
     */
    public void setNaziv(String naziv) {
    	if(naziv==null) {
    		throw new NullPointerException("Naziv ne sme biti null");
    	}
        this.naziv = naziv;
    }

    
    /**
     * Metoda koja vraca String koji predstavlja naziv sale.
     *
     * @return Naziv sale kao String.
     */
    @Override
    public String toString() {
        return naziv;
    }


    
    /**
     * Metoda koja poredi dve sale po njihovom ID-u i vraca true ili false.
     *
     * @param obj Objekat sa kojim se vrsi upoređivanje.
     * @return
     *<ul>
     *<li>true - ako su oba objekta klase Sala i imaju isti ID.</li>
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
        final Sala other = (Sala) obj;
        return this.salaID == other.salaID;
    }
    
     @Override
    public String vratiImeTabele() {
        return "sala";
    }

     @Override
    public String vratiParametre() {
        return String.format("'%s', '%s', '%s'", salaID, naziv,kapacitet);
    }

    @Override
    public String vratiPK() {
        return "salaID";
    }

    @Override
    public int vratiVrednostPK() {
         return salaID;
    }

    @Override
    public String vratiSlozenPK() {
        return null;
    }

    @Override
    public List<OpstiDomenskiObjekat> RSuTabelu(ResultSet rs) {
        
         List<OpstiDomenskiObjekat> sale = new ArrayList<>();
     
         try {
             while (rs.next()) {
                 int salaID = rs.getInt("salaID");
                 String nazivSale = rs.getString("naziv");
                 int kapacitet=rs.getInt("kapacitet");
                 Sala s=new Sala(salaID, nazivSale, kapacitet);
                 
                 sale.add(s);
             }
         } catch (SQLException ex) {
             Logger.getLogger(Sala.class.getName()).log(Level.SEVERE, null, ex);
             System.out.println("Greska kod RSuTabelu za Sale");
         }
        
        return sale;
    }

    @Override
    public String vratiUpdate() {
        return String.format("salaID='%s', naziv='%s', kapacitet='%s'", salaID, naziv,kapacitet);
    }

    @Override
    public void postaviVrednostPK(int pk) {
        this.salaID=pk;
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
