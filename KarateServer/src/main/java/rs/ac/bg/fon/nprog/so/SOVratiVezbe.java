/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.bg.fon.nprog.so;


import java.util.List;

import rs.ac.bg.fon.nprog.db.DBBroker;
import rs.ac.bg.fon.nprog.domen.OpstiDomenskiObjekat;
import rs.ac.bg.fon.nprog.domen.Vezba;
import rs.ac.bg.fon.nprog.exception.ServerskiException;

/**
 * 
 * Klasa koja predstavlja sistemsku operaciju za prikaz informacija svih vežbi koje postoje
 * u bazi Karate kluba. Iz baze podataka učitavaju se podaci o vežbama i rezultat 
 * operacije je lista objekata klase Vezba.
 * 
 * 
 * Klasa nasledjuje OpstaSO koja predstavlja apstraktnu sistemsku operaciju.
 * 
 * @author HP
 * @version 1.1.0
 *
 */
public class SOVratiVezbe extends OpstaSO {
    
	/**
     * Promenljiva u kojoj se čuvaju vežbe kao rezultat upita.
     */
    List<OpstiDomenskiObjekat> lista;
    
    /**
     * Podrazumevani konstruktor.
     */
    public SOVratiVezbe() {
    	super();
    }
    
    /**
     * Konstruktor koji prima objekat klase DBBroker.
     * @param dbb Objekat klase DBBroker za komunikaciju sa bazom podataka.
     */
    public SOVratiVezbe(DBBroker dbb) {
    	super(dbb);
    }

    /**
     * Metoda u kojoj se poziva operacija za vracanje svih vežbi iz baze podataka.
     * Rezultat operacije su vežbe sa svim podacima.
     * @throws ServerskiException Ukoliko dođe do greške prilikom izvršavanja operacije.
     */
	@Override
    protected void izvrsiKonkretnuOperaciju() throws ServerskiException {
        lista = dbb.vratiSveObjekte(new Vezba());
    }

	/**
     * Metoda za dobijanje rezultata operacije.
     * @return Lista objekata klase OpstiDomenskiObjekat, koja predstavlja rezultat operacije.
     */
    public List<OpstiDomenskiObjekat> getLista() {
        return lista;
    }
    
    @Override
    protected void proveriPreduslov() throws ServerskiException {
    }
    
}
