/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.bg.fon.nprog.so.trening;

import rs.ac.bg.fon.nprog.exception.ServerskiException;
import rs.ac.bg.fon.nprog.so.OpstaSO;

import java.util.ArrayList;
import java.util.List;

import rs.ac.bg.fon.nprog.db.DBBroker;
import rs.ac.bg.fon.nprog.domen.OpstiDomenskiObjekat;

/**
 * Klasa koja predstavlja sistemsku operaciju za vraćanje treninga karate kluba na osnovu ulogovanog korisnika.
 * 
 * Klasa nasleđuje OpstaSO koja predstavlja apstraktnu sistemsku operaciju.
 * 
 * @author HP
 * @version 1.1.0
 */
public class SOVratiTreninge extends OpstaSO {
    
	/**
     * Lista treninga karate kluba za datog trenera kao rezultat upita.
     */
    private List<OpstiDomenskiObjekat> listaTreninga;
    
    /**
     * Ulogovani trener na osnovu kojeg se vraćaju treninzi karate kluba.
     */
    private OpstiDomenskiObjekat ulogovani;
    
    
    /**
     * Konstruktor koji prima ulogovanog trenera kao objekat klase OpstiDomenskiObjekat.
     * Takodje, inicijalizuje listu treninga kao praznu {@link ArrayList}.
     * 
     * @param ulogovani Ulogovani trener na osnovu kojeg se vraćaju treninzi karate kluba.
     */
    public SOVratiTreninge(OpstiDomenskiObjekat ulogovani) {
    	super();
        listaTreninga = new ArrayList<>();
        this.ulogovani=ulogovani;
    }
    
    
    /**
     * Konstruktor koji prima objekat klase DBBroker.
     * 
     * @param dbb Objekat klase DBBroker za komunikaciju sa bazom podataka.
     */
    public SOVratiTreninge(DBBroker dbb) {
    	super(dbb);
    }

    
    /**
     * Metoda za dobijanje rezultata operacije.
     * @return Lista objekata klase OpstiDomenskiObjekat, koja predstavlja sve treninge ulogovanog trenera.
     */
    public List<OpstiDomenskiObjekat> getListaTreninga() {
        return listaTreninga;
    }
    
    /**
     * Metoda koja vraca prosledjenog ulogovanog trenera.
     * 
     * @return Ulogovani trener klase OpstiDomenskiObjekat na osnovu kojeg se vraćaju treninzi karate kluba.
     */
    public OpstiDomenskiObjekat getUlogovani() {
		return ulogovani;
	}
    /**
     * Metoda koja postavlja prosledjenog ulogovanog trenera.
     * @param ulogovani Ulogovani trener klase OpstiDomenskiObjekat na osnovu kojeg se vraćaju treninzi karate kluba.
     */
    public void setUlogovani(OpstiDomenskiObjekat ulogovani) {
		this.ulogovani = ulogovani;
	}

    
    /**
     * Metoda u kojoj se izvršava operacija vraćanja svih treninga karate kluba za datog ulogovanog trenera.
     * Rezultat operacije je lista objekata klase OpstiDomenskiObjekat koja predstavlja listu treninga.
     * 
     * @throws ServerskiException Ukoliko dođe do greške prilikom izvršavanja operacije.
     */
    @Override
    protected void izvrsiKonkretnuOperaciju() throws ServerskiException {
        listaTreninga = dbb.vratiObjekte(ulogovani);
       
    }
    
    @Override
    protected void proveriPreduslov() throws ServerskiException {
    }

}
