/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.bg.fon.nprog.so.clan;

import rs.ac.bg.fon.nprog.db.DBBroker;
import rs.ac.bg.fon.nprog.domen.OpstiDomenskiObjekat;
import rs.ac.bg.fon.nprog.exception.ServerskiException;
import rs.ac.bg.fon.nprog.so.OpstaSO;

/**
 * 
 * Klasa koja predstavlja sistemsku operaciju za brisanje člana karate kluba.
 * 
 * Klasa nasledjuje OpstaSO koja predstavlja apstraktnu sistemsku operaciju.
 * 
 * @author HP
 * @version 1.1.0
 *
 */
public class SOObrisiClana extends OpstaSO{
    
	/**
	 * Član karate kluba koga treba obrisati.
	 */
    private OpstiDomenskiObjekat param;
    
    /**
     * Obrisani član kao rezultat upita.
     */
    private OpstiDomenskiObjekat obrisan;
    
    
    /**
     * Konstruktor koji prima člana kao objekat klase OpstiDomenskiObjekat kao parametar.
     * @param param Objekat klase OpstiDomenskiObjekat koji predstavlja člana karate kluba kojeg treba obrisati.
     */
    public SOObrisiClana(OpstiDomenskiObjekat param) {
    	super();
        setParam(param);
    }
    
    /**
     * Konstruktor koji prima objekat klase DBBroker.
     * @param dbb Objekat klase DBBroker za komunikaciju sa bazom podataka.
     */
    public SOObrisiClana(DBBroker dbb) {
    	super(dbb);
    }
    
    /**
     * Metoda u kojoj se poziva operacija za brisanje člana karate kluba u bazi podataka.
     * Rezultat operacije je objekat klase OpstiDomenskiObjekat koji predstavlja obrisanog člana.
     * @throws ServerskiException Ukoliko dođe do greške prilikom izvršavanja operacije.
     */
    @Override
    protected void izvrsiKonkretnuOperaciju() throws ServerskiException {
        obrisan = dbb.obrisiObjekat(param);
       
    }
    
    /**
     * Metoda koja postavlja člana karate kluba kojeg treba obrisati.
     * 
     * @param param Objekat klase OpstiDomenskiObjekat koji predstavlja člana karate kluba koji treba obrisati.
     */
    public void setParam(OpstiDomenskiObjekat param) {
		this.param = param;
	}
    
    
    /**
     * Metoda koja vraća prosledjenog člana kojeg treba obrisati u bazi.
     * 
     * @return Objekat klase OpstiDomenskiObjekat koji predstavlja člana karate kluba kojeg treba obrisati.
     */
    public OpstiDomenskiObjekat getParam() {
		return param;
	}

    
    /**
     * Metoda koja vraća obrisanog člana karate kluba.
     * 
     * @return Objekat klase OpstiDomenskiObjekat koji predstavlja obrisanog člana karate kluba.
     */
    public OpstiDomenskiObjekat getObrisan() {
        return obrisan;
    }
    
    @Override
    protected void proveriPreduslov() throws ServerskiException {
    }
    
}
