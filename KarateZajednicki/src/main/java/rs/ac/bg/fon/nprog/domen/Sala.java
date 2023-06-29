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
 * @author HP
 */
public class Sala implements OpstiDomenskiObjekat {
    
    private int salaID;
    private String naziv;
    private int kapacitet;

    public Sala() {
    }

    public Sala(int salaID) {
        this.salaID = salaID;
    }

    
    public Sala(int salaID, String naziv, int kapacitet) {
        this.salaID = salaID;
        this.naziv = naziv;
        this.kapacitet = kapacitet;
    }

    public int getKapacitet() {
        return kapacitet;
    }

    public void setKapacitet(int kapacitet) {
    	if(kapacitet<1) {
    		throw new IllegalArgumentException("Kapacitet ne sme biti manji od jedan");
    	}
        this.kapacitet = kapacitet;
    }

    public int getSalaID() {
        return salaID;
    }

    public void setSalaID(int salaID) {
    	if(salaID<1) {
    		throw new IllegalArgumentException("SalaId ne sme biti manje od jedan");
    	}
        this.salaID = salaID;
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

    @Override
    public String toString() {
        return naziv;
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
