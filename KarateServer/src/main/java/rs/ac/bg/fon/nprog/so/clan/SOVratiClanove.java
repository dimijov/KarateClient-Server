/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.bg.fon.nprog.so.clan;


import java.util.List;

import rs.ac.bg.fon.nprog.db.DBBroker;
import rs.ac.bg.fon.nprog.domen.Clan;
import rs.ac.bg.fon.nprog.domen.OpstiDomenskiObjekat;
import rs.ac.bg.fon.nprog.exception.ServerskiException;
import rs.ac.bg.fon.nprog.so.OpstaSO;

/**
 * 
 * Klasa koja predstavlja sistemsku operaciju za prikaz informacija svih članova koji postoje
 * u bazi Karate kluba. Iz baze podataka ucitavaju se podaci o članovima i rezultat 
 * operacije je lista objekata klase Clan.
 * 
 * 
 * Klasa nasledjuje OpstaSO koja predstavlja apstraktnu sistemsku operaciju.
 * 
 * @author HP
 * @version 1.1.0
 *
 */
public class SOVratiClanove extends OpstaSO {
    
	/**
     * Promenljiva u kojoj se čuvaju članovi kao rezultat upita.
     */
    List<OpstiDomenskiObjekat> lista;

    /**
     * Podrazumevani konstruktor.
     */
    public SOVratiClanove() {
    	super();
	}
    
    
    /**
     * Konstruktor koji prima objekat klase DBBroker.
     * @param dbb Objekat klase DBBroker za komunikaciju sa bazom podataka.
     */
    public SOVratiClanove(DBBroker dbb) {
    	super(dbb);
	}
    
    /**
     * Metoda u kojoj se poziva operacija za vraćanje svih članova iz baze podataka.
     * Rezultat operacije su članovi sa svim podacima o njima .
     * @throws ServerskiException Ukoliko dođe do greške prilikom izvršavanja operacije.
     */
    @Override
    protected void izvrsiKonkretnuOperaciju() throws ServerskiException {
        lista = dbb.vratiSveObjekte(new Clan());
       
    }

    
    /**
     * Metoda za dobijanje rezultata operacije.
     * @return Lista objekata klase OpstiDomenskiObjekat, koja predstavlja sve članove.
     */
    public List<OpstiDomenskiObjekat> getLista() {
        return lista;
    }

    
    @Override
    protected void proveriPreduslov() throws ServerskiException {
    }
    
}
