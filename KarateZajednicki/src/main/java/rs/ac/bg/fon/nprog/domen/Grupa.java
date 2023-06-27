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
public class Grupa implements OpstiDomenskiObjekat{
    
    private int grupaID;
    private String naziv;

    public Grupa() {
    }

    public Grupa(int grupaID) {
        this.grupaID = grupaID;
    }
    
    

    public Grupa(int grupaID, String naziv) {
        this.grupaID = grupaID;
        this.naziv = naziv;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public int getGrupaID() {
        return grupaID;
    }

    public void setGrupaID(int grupaID) {
        this.grupaID = grupaID;
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
        final Grupa other = (Grupa) obj;
        return this.grupaID == other.grupaID;
    }

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
