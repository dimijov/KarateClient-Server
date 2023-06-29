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
public class Vezba implements OpstiDomenskiObjekat {
    
    private int vezbaID;
    private String naziv;
    private String opis;
    private int duzina;

    public Vezba() {
    }

    public Vezba(int vezbaID) {
        this.vezbaID = vezbaID;
    }

    public Vezba(int vezbaID, String naziv, String opis,int duzina) {
        this.vezbaID = vezbaID;
        this.naziv = naziv;
        this.opis = opis;
        this.duzina=duzina;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
    	if(opis==null) {
    		throw new NullPointerException("Opis ne sme biti null");
    	}
        this.opis = opis;
    }

    public int getVezbaID() {
        return vezbaID;
    }

    public void setVezbaID(int vezbaID) {
    	if(vezbaID<1) {
    		throw new IllegalArgumentException("VezbaId ne sme biti manja od jedan");
    	}
        this.vezbaID = vezbaID;
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

    public int getDuzina() {
        return duzina;
    }

    public void setDuzina(int duzina) {
    	if(duzina<=0) {
    		throw new IllegalArgumentException("Duzina ne sme biti nula ili manje od nula");
    	}
        this.duzina = duzina;
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
