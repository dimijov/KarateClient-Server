/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.bg.fon.nprog.so.clan;

import rs.ac.bg.fon.nprog.db.DBBroker;
import rs.ac.bg.fon.nprog.domen.Clan;
import rs.ac.bg.fon.nprog.domen.OpstiDomenskiObjekat;
import rs.ac.bg.fon.nprog.exception.ServerskiException;
import rs.ac.bg.fon.nprog.so.OpstaSO;

/**
 * 
 * Klasa koja predstavlja sistemsku operaciju za pamćenje člana karate kluba.
 * 
 * Klasa nasledjuje OpstaSO koja predstavlja apstraktnu sistemsku operaciju.
 * 
 * @author HP
 * @version 1.1.0
 *
 */
public class SOZapamtiClana extends OpstaSO {
    
	/**
	 * Član karate kluba koga treba sačuvati
	 */
    private OpstiDomenskiObjekat param;
    
    /**
     * Sačuvani član kao rezultat upita.
     */
    private OpstiDomenskiObjekat clan;
    
    /**
     * Konstruktor koji prima člana kao objekat klase OpstiDomenskiObjekat kao parametar.
     * @param param Objekat klase OpstiDomenskiObjekat koji predstavlja člana karate kluba kojeg treba sačuvati.
     */
    public SOZapamtiClana(OpstiDomenskiObjekat param){
    	super();
        this.param=param;
    }
    
    /**
     * Konstruktor koji prima objekat klase DBBroker.
     * @param dbb Objekat klase DBBroker za komunikaciju sa bazom podataka.
     */
    public SOZapamtiClana(DBBroker dbb) {
        super(dbb);
    }

    /**
     * Metoda u kojoj se poziva operacija za čuvanje člana karate kluba u bazi podataka.
     * Rezultat operacije je objekat klase OpstiDomenskiObjekat koji predstavlja sačuvanog člana.
     * @throws ServerskiException Ukoliko dođe do greške prilikom izvršavanja operacije.
     */
    @Override
    protected void izvrsiKonkretnuOperaciju() throws ServerskiException {
        clan = dbb.sacuvajObjekat(param);
    }

    /**
     * Metoda koja vraća prosledjenog člana kojeg treba sačuvati u bazi.
     * 
     * @return Objekat klase OpstiDomenskiObjekat koji predstavlja člana karate kluba kojeg treba sačuvati.
     */
    public OpstiDomenskiObjekat getParam() {
        return param;
    }

    /**
     * Metoda koja postavlja člana karate kluba kojeg treba sačuvati.
     * 
     * @param param Objekat klase OpstiDomenskiObjekat koji predstavlja člana karate kluba koji treba sačuvati.
     */
    public void setParam(OpstiDomenskiObjekat param) {
        this.param = param;
    }

    
    /**
     * Metoda koja vraća sačuvanog člana karate kluba.
     * 
     * @return Objekat klase OpstiDomenskiObjekat koji predstavlja sačuvanog člana karate kluba.
     */
    public OpstiDomenskiObjekat getClan() {
        return clan;
    }

    
    /**
     * Metoda koja proverava preduslove za izvršavanje sistemske operacije.
     * 
     * @throws ServerskiException Ukoliko preduslovi za izvršavanje operacije nisu ispunjeni.
     * Prosledjeni {@link #param} nije instanca klase član i različit je od null.
     */
    @Override
    protected void proveriPreduslov() throws ServerskiException {
    	if(!(param instanceof Clan) && param!=null) {
    		throw new ServerskiException("Poslati objekat nije odogvarajuce klase");
    	}
    }
   
    
   
    
    
    
}
