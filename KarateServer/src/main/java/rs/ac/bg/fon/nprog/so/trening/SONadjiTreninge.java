/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.bg.fon.nprog.so.trening;



import java.util.List;

import rs.ac.bg.fon.nprog.db.DBBroker;
import rs.ac.bg.fon.nprog.domen.OpstiDomenskiObjekat;
import rs.ac.bg.fon.nprog.domen.Trening;
import rs.ac.bg.fon.nprog.exception.ServerskiException;
import rs.ac.bg.fon.nprog.so.OpstaSO;

/**
 * Klasa koja predstavlja sistemsku operaciju za pronalaženje treninga karate kluba na osnovu zadatog treninga.
 * Pretraga se vrši na osnovu podataka prosleđenog treninga, prema datumu i prema treneru zaduženom za dati trening.
 * Klasa nasleđuje OpstaSO koja predstavlja apstraktnu sistemsku operaciju.
 * 
 * @author HP
 * @version 1.1.0
 */
public class SONadjiTreninge extends OpstaSO {
    
	
	/**
     * Trening na osnovu kojeg se vrši pretraga.
     */
    private Trening trening;
    
    /**
     * Lista pronađenih treninga karate kluba kao rezultat pretrage.
     */
    private List<OpstiDomenskiObjekat> listaNadjenih;

    
    /**
     * Konstruktor koji prima trening za pretragu.
     * 
     * @param trening Trening na osnovu kojeg se vrši pretraga.
     */
    public SONadjiTreninge(Trening trening) {
    	super();
        this.trening = trening;
    }
    
    
    /**
     * Konstruktor koji prima objekat klase DBBroker.
     * 
     * @param dbb Objekat klase DBBroker za komunikaciju sa bazom podataka.
     */
    public SONadjiTreninge(DBBroker dbb) {
    	super(dbb);
    }

    
    /**
     * Metoda u kojoj se izvršava operacija pretrage treninga karate kluba na osnovu zadatog treninga.
     * Pretraga se vrši na osnovu trenera zaduženog za taj trening i datuma održavanja tog treninga.
     * Rezultat operacije je lista objekata klase OpstiDomenskiObjekat koja predstavlja pronađene treninge.
     * 
     * @throws ServerskiException Ukoliko dođe do greške prilikom izvršavanja operacije.
     */
    @Override
    protected void izvrsiKonkretnuOperaciju() throws ServerskiException {
        
    	listaNadjenih=dbb.nadjiObjekte(trening);
        
    }
    
    
    /**
     * Metoda koja postavlja prosledjeni trening na osnovu kojeg se vrši pretraga.
     * 
     * @param trening Trening na osnovu kojeg se vrši pretraga.
     */
    public void setTrening(Trening trening) {
		this.trening = trening;
	}
    
    
    /**
     * Metoda koja vraća prosledjeni trening na osnovu kojeg se vrši pretraga.
     * 
     * @return Trening na osnovu kojeg se vrši pretraga.
     */
    public Trening getTrening() {
		return trening;
	}

    
    /**
     * Metoda koja vraća pronađene treninge karate kluba.
     * 
     * @return Lista pronađenih treninga karate kluba kao rezultat pretrage.
     */
    public List<OpstiDomenskiObjekat> getListaNadjenih() {
        return listaNadjenih;
    }
    
    @Override
    protected void proveriPreduslov() throws ServerskiException {
    }
}
