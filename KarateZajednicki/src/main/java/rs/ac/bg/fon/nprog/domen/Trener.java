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
public class Trener implements OpstiDomenskiObjekat {
    
    private int trenerID;
    private String ime;
    private String prezime;
    private int godineIskustva;
    private String pojas;
    private String username;
    private String password;
    
    
    private boolean ulogovan;

    public Trener() {
    }

    public Trener(int trenerID) {
        this.trenerID = trenerID;
    }

    public Trener(String username, String password) {
        this.username = username;
        this.password = password;
    }

    
    public Trener(int trenerID, String ime, String prezime, int godineIskustva, String pojas, String username, String password) {
        this.trenerID = trenerID;
        this.ime = ime;
        this.prezime = prezime;
        this.godineIskustva = godineIskustva;
        this.pojas = pojas;
        this.username = username;
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getTrenerID() {
        return trenerID;
    }

    public void setTrenerID(int trenerID) {
        this.trenerID = trenerID;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public int getGodineIskustva() {
        return godineIskustva;
    }

    public void setGodineIskustva(int godineIskustva) {
        this.godineIskustva = godineIskustva;
    }

    public String getPojas() {
        return pojas;
    }

    public void setPojas(String pojas) {
        this.pojas = pojas;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return ime+" "+prezime;
    }

    public void setUlogovan(boolean ulogovan) {
        this.ulogovan = ulogovan;
    }

    public boolean isUlogovan() {
        return ulogovan;
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
