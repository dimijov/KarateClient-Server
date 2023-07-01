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
* Klasa koja predstavlja stavku treninga.
* 
* Ova klasa implementira interfejs OpstiDomenskiObjekat u odnosu na tabelu stavkatreninga u bazi.
* 
* Stavka treninga ima svoj redni broj stavke koji je njen identifikator, kao i atribute koji opisuju stavku treninga, kao što su broj ponavljanja, težina, trajanje i vežba.
* Stavka treninga takođe ima referencu na trening kojem pripada.
*
* @author HP
* @version 1.1.0
* 
*/
public class StavkaTreninga implements OpstiDomenskiObjekat{
    
    /**
     * Redni broj stavke treninga kao int.
     */
    private int rbStavke;
    
    /**
     * Trening kojem pripada stavka treninga kao objekat klase Trening.
     */
    private Trening trening;
    
    /**
     * Broj ponavljanja stavke treninga kao int.
     */
    private int brojPonavljanja;
    
    /**
     * Težina stavke treninga kao String.
     */
    private String tezina;
    
    /**
     * Trajanje stavke treninga u minutima kao int.
     */
    private int trajanje;
    
    /**
     * Vežba koja se izvodi u  okviru stavke treninga kao objekat klase Vezba.
     */
    private Vezba vezba;

    /**
     * Konstruktor koji inicijalizuje objekat klase StavkaTreninga.
     */
    public StavkaTreninga() {
    }
    
    /**
     * Konstruktor koji inicijalizuje objekat klase StavkaTreninga sa referencom na trening.
     * @param trening Trening kojem pripada stavka treninga.
     */
    public StavkaTreninga(Trening trening){
        this.trening=trening;
    }

    
    /**
     * Konstruktor koji inicijalizuje objekat klase StavkaTreninga sa svim atributima.
     * @param rbStavke Redni broj stavke treninga kao int.
     * @param trening Trening kojem pripada stavka treninga kao objekat klase Trening.
     * @param brojPonavljanja Broj ponavljanja stavke treninga kao int.
     * @param tezina Težina stavke treninga kao String.
     * @param trajanje Trajanje stavke treninga u minutima kao int.
     * @param vezba Vežba koja se izvodi u okviru stavke treninga kao objekat klase Vezba.
     */
    public StavkaTreninga(int rbStavke, Trening trening, int brojPonavljanja, String tezina, int trajanje, Vezba vezba) {
        this.rbStavke = rbStavke;
        this.trening = trening;
        this.brojPonavljanja = brojPonavljanja;
        this.tezina = tezina;
        this.trajanje = trajanje;
        this.vezba = vezba;
    }

    /**
     * Metoda koja vraća vežbu koja se izvodi u okviru stavke treninga.
     * @return Vežba koja se izvodi u okviru stavke treninga kao objekat klase Vezba.
     */
    public Vezba getVezba() {
        return vezba;
    }

    /**
     * Metoda koja postavlja vežbu koja se izvodi u okviru stavke treninga.
     * @param vezba Vežba koja se izvodi u okviru stavki treninga kao objekat klase Vezba.
     * @throws NullPointerException ako je vežba null.
     */
    public void setVezba(Vezba vezba) {
    	if(vezba==null) {
    		throw new NullPointerException("Vezba ne sme biti null");
    	}
        this.vezba = vezba;
    }

    /**
     * Metoda koja vraća redni broj stavke treninga.
     * @return Redni broj stavke treninga kao int.
     */
    public int getRbStavke() {
        return rbStavke;
    }

    /**
     * Metoda koja postavlja redni broj stavke treninga.
     * @param rbStavke Redni broj stavke treninga kao int.
     * @throws IllegalArgumentException ako je redni broj stavke manji od 1.
     */
    public void setRbStavke(int rbStavke) {
    	if(rbStavke<1) {
    		throw new IllegalArgumentException("Redni broj stavke ne sme biti manji od jedan");
    	}
        this.rbStavke = rbStavke;
    }

    /**
     * Metoda koja vraća trening kojem pripada stavka treninga.
     * @return Trening kojem pripada stavka treninga kao objekat klase Trening.
     */
    public Trening getTrening() {
        return trening;
    }

    
    /**
     * Metoda koja postavlja trening kojem pripada stavka treninga.
     * @param trening Trening kojem pripada stavka treninga kao objekat klase Trening.
     * @throws NullPointerException ako je trening null.
     */
    public void setTrening(Trening trening) {
    	if(trening==null) {
    		throw new NullPointerException("Trening ne sme biti null");
    	}
        this.trening = trening;
    }

    
    /**
     * Metoda koja vraća broj ponavljanja stavke treninga.
     * @return Broj ponavljanja stavke treninga kao int.
     */
    public int getBrojPonavljanja() {
        return brojPonavljanja;
    }

    
    /**
     * Metoda koja postavlja broj ponavljanja stavke treninga.
     * @param brojPonavljanja Broj ponavljanja stavke treninga kao int.
     * @throws IllegalArgumentException ako je broj ponavljanja manji od 1.
     */
    public void setBrojPonavljanja(int brojPonavljanja) {
    	if(brojPonavljanja<1) {
    		throw new IllegalArgumentException("Broj ponavljanja ne sme biti manji od jedan");
    	}
        this.brojPonavljanja = brojPonavljanja;
    }

    /**
     * Metoda koja vraća težinu stavke treninga.
     * @return Težina stavke treninga kao String.
     */
    public String getTezina() {
        return tezina;
    }

    /**
     * Metoda koja postavlja težinu stavke treninga.
     * @param tezina Težina stavke treninga kao String.
     * @throws NullPointerException ako je težina null.
     * @throws IllegalArgumentException ako težina nije "lako", "srednje" ili "teško".
     */
    public void setTezina(String tezina) {
    	if(tezina==null) {
    		throw new NullPointerException("Tezina ne sme biti null");
    	}
    	if(!tezina.equalsIgnoreCase("lako") && !tezina.equalsIgnoreCase("srednje") && !tezina.equalsIgnoreCase("tesko")) {
    		throw new IllegalArgumentException("Tezina mora biti: lako, srednje ili tesko");
    	}
        this.tezina = tezina;
    }

    /**
     * Metoda koja vraća trajanje stavke treninga u minutima.
     * @return Trajanje stavke treninga u minutima kao int.
     */
    public int getTrajanje() {
        return trajanje;
    }

    /**
     * Metoda koja postavlja trajanje stavke treninga u minutima.
     * @param trajanje Trajanje stavke treninga u minutima kao int.
     * @throws IllegalArgumentException ako je trajanje manje od 0.
     */
    public void setTrajanje(int trajanje) {
    	if(trajanje<0) {
    		throw new IllegalArgumentException("Trajanje ne sme biti manje od nula");
    	}
        this.trajanje = trajanje;
    }


    /**
     * Metoda koja vrši poređenje dve stavke treninga na osnovu njihovog rednog broja i treninga kojem pripadaju.
     * 
     * @param obj Objekat sa kojim se vrši poređenje.
     * @return
     * <ul>
     * <li>true - ako su oba objekta klase StavkaTreninga, imaju isti redni broj i pripadaju istom treningu.</li>
     * <li>false - u svim ostalim slučajevima.</li>
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
