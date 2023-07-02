/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.bg.fon.nprog.so.trening;

import rs.ac.bg.fon.nprog.db.DBBroker;
import rs.ac.bg.fon.nprog.domen.OpstiDomenskiObjekat;
import rs.ac.bg.fon.nprog.exception.ServerskiException;
import rs.ac.bg.fon.nprog.so.OpstaSO;

/**
 * Klasa koja predstavlja sistemsku operaciju za brisanje treninga iz karate kluba na osnovu zadatog parametra.
 * 
 * Klasa nasleđuje OpstaSO koja predstavlja apstraktnu sistemsku operaciju.
 * 
 * @author HP
 * @version 1.0.0
 */
public class SOObrisiTrening extends OpstaSO {
    
	/**
	 * Parametar koji predstavlja trening karate kluba koji treba obrisati.
	 */
    private OpstiDomenskiObjekat param;
    
    /**
     * Obrisan trening kao rezultat brisanja.
     */
    private OpstiDomenskiObjekat obrisan;
    
    
    /**
     * Konstruktor koji prima parametar za brisanje treninga.
     * 
     * @param param Trening karate kluba koji treba obrisati.
     */
    public SOObrisiTrening(OpstiDomenskiObjekat param) {
    	super();
        this.param = param;
    }
    
    
    /**
     * Konstruktor koji prima objekat klase DBBroker.
     * 
     * @param dbb Objekat klase DBBroker za komunikaciju sa bazom podataka.
     */
    public SOObrisiTrening(DBBroker dbb) {
    	super(dbb);
    }
    
    
    /**
     * Metoda u kojoj se izvršava operacija brisanja treninga iz karate kluba na osnovu zadatog treninga.
     * Rezultat operacije je obrisan trening.
     * 
     * @throws ServerskiException Ukoliko dođe do greške prilikom izvršavanja operacije.
     */
    @Override
    protected void izvrsiKonkretnuOperaciju() throws ServerskiException {
        obrisan = dbb.obrisiObjekat(param);
    }

    
    /**
     * Metoda koja vraća obrisani trening karate kluba.
     * 
     * @return Objekat klase OpstiDomenskiObjekat koji predstavlja obrisani trening karate kluba.
     */
    public OpstiDomenskiObjekat getObrisan() {
        return obrisan;
    }
    
    @Override
    protected void proveriPreduslov() throws ServerskiException {
    }
    
    /**
     * Metoda koja postavlja prosledjeni trening karate kluba koji treba obrisati.
     * 
     * @param param Parametar koji predstavlja trening karate kluba koji treba obrisati.
     */
    public void setParam(OpstiDomenskiObjekat param) {
		this.param = param;
	}
    
    /**
     * Metoda koja vraća trening karate kluba koji treba obrisati.
     * 
     * @return Parametar koji predstavlja trening karate kluba koji treba obrisati.
     */
    public OpstiDomenskiObjekat getParam() {
		return param;
	}
}
