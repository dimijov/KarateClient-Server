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
public class Grad implements OpstiDomenskiObjekat{
    
     private int gradID;
     private String naziv;
     private int postanskiBroj;

    public Grad() {
    }

    public Grad(int gradID) {
        this.gradID = gradID;
    }

    
    public Grad(int gradID, String naziv, int postanskiBroj) {
        this.gradID = gradID;
        this.naziv = naziv;
        this.postanskiBroj = postanskiBroj;
    }

    @Override
    public String toString() {
        return naziv;
    }

    public int getGradID() {
        return gradID;
    }

    public void setGradID(int gradID) {
    	if(gradID<1) {
    		throw new IllegalArgumentException("GradId ne sme biti manji od jedan");
    	}
        this.gradID = gradID;
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

    public int getPostanskiBroj() {
        return postanskiBroj;
    }

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
