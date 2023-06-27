/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.bg.fon.nprog.domen;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author HP
 */
public class StavkaTreninga implements OpstiDomenskiObjekat{
    
    
    private int rbStavke;
    private Trening trening;
    private int brojPonavljanja;
    private String tezina;
    private int trajanje;
    private Vezba vezba;

    public StavkaTreninga() {
    }
    
    public StavkaTreninga(Trening trening){
        this.trening=trening;
    }

    public StavkaTreninga(int rbStavke, Trening trening, int brojPonavljanja, String tezina, int trajanje, Vezba vezba) {
        this.rbStavke = rbStavke;
        this.trening = trening;
        this.brojPonavljanja = brojPonavljanja;
        this.tezina = tezina;
        this.trajanje = trajanje;
        this.vezba = vezba;
    }

    public Vezba getVezba() {
        return vezba;
    }

    public void setVezba(Vezba vezba) {
        this.vezba = vezba;
    }

    public int getRbStavke() {
        return rbStavke;
    }

    public void setRbStavke(int rbStavke) {
        this.rbStavke = rbStavke;
    }

    public Trening getTrening() {
        return trening;
    }

    public void setTrening(Trening trening) {
        this.trening = trening;
    }

    public int getBrojPonavljanja() {
        return brojPonavljanja;
    }

    public void setBrojPonavljanja(int brojPonavljanja) {
        this.brojPonavljanja = brojPonavljanja;
    }

    public String getTezina() {
        return tezina;
    }

    public void setTezina(String tezina) {
        this.tezina = tezina;
    }

    public int getTrajanje() {
        return trajanje;
    }

    public void setTrajanje(int trajanje) {
        this.trajanje = trajanje;
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
        final StavkaTreninga other = (StavkaTreninga) obj;
        if (this.rbStavke != other.rbStavke) {
            return false;
        }
        return Objects.equals(this.trening, other.trening);
    }

   
    @Override
    public String vratiImeTabele() {

        return "stavkatreninga";
    }

    @Override
    public String vratiParametre() {
        return String.format("'%s', '%s', '%s', '%s', '%s', '%s'", rbStavke, trening.getTreningID(), brojPonavljanja,tezina,trajanje,vezba.getVezbaID());
    }

    @Override
    public String vratiPK() {

        return null;
    }

    @Override
    public int vratiVrednostPK() {
        return trening.getTreningID();
    }

    @Override
    public String vratiSlozenPK() {

        return String.format(" rbStavke='%d' AND treningID='%d' ",  rbStavke,trening.getTreningID());
    }

    @Override
    public List<OpstiDomenskiObjekat> RSuTabelu(ResultSet rs) {

           List<OpstiDomenskiObjekat> stavke = new ArrayList<>();
        
        try {
            while (rs.next()) {
                int rbStavke = rs.getInt("rbStavke");
                int treningID = rs.getInt("treningID");
                int brojPonavljanja = rs.getInt("brojPonavljanja");
                String tezina = rs.getString("tezina");
                int trajanje=rs.getInt("trajanje");
                int vezbaID = rs.getInt("vezbaID");
                Vezba v=new Vezba(vezbaID, rs.getString("naziv"),rs.getString("opis"),rs.getInt("duzina"));
               
                Trening t=new Trening(treningID);
                
               
                stavke.add(new StavkaTreninga(rbStavke, t, brojPonavljanja, tezina, trajanje, v));
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(StavkaTreninga.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Greska kod RSuTabelu za StavkaTreninga");
        }
        
        return stavke;
    }

    @Override
    public String vratiUpdate() {

        return String.format("rbStavke='%s',treningID='%s', brojPonavljanja='%s', tezina='%s', trajanje='%s', vezbaID='%s'", rbStavke, trening.getTreningID(), brojPonavljanja,tezina,trajanje,vezba.getVezbaID());
    }

    @Override
    public void postaviVrednostPK(int pk) {
    }

    @Override
    public String kolone() {
        return " * ";
    }

    @Override
    public String vratiUslovZaJoin() {
        return "stavkatreninga st JOIN vezba v ON st.vezbaID = v.vezbaID ";

    }

    @Override
    public String vratiAtributPretrazivanja() {
        return " treningID = ";
    }

    @Override
    public String vratiVrednostAtributa() {
        return trening.getTreningID()+"";
    }
    
    @Override
    public String vratiAtributePretrazivanja() {
        return null;
    }

    
    
}
