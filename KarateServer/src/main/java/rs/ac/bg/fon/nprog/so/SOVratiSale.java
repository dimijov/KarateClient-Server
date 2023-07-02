/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.bg.fon.nprog.so;


import java.util.List;

import rs.ac.bg.fon.nprog.db.DBBroker;
import rs.ac.bg.fon.nprog.domen.OpstiDomenskiObjekat;
import rs.ac.bg.fon.nprog.domen.Sala;
import rs.ac.bg.fon.nprog.exception.ServerskiException;

/**
 * 
 * Klasa koja predstavlja sistemsku operaciju za prikaz informacija svih sala koje postoje
 * u bazi Karate kluba. Iz baze podataka ucitavaju se podaci o salama i rezultat 
 * operacije je lista objekata klase Sala.
 * 
 * 
 * Klasa nasledjuje OpstaSO koja predstavlja apstraktnu sistemsku operaciju.
 * 
 * @author HP
 * @version 1.1.0
 *
 */
public class SOVratiSale extends OpstaSO {
    
	/**
     * Promenljiva u kojoj se čuvaju sale kao rezultat upita.
     */
    List<OpstiDomenskiObjekat> lista;
    
    
    /**
     * Podrazumevani konstruktor.
     */
    public SOVratiSale() {
     	super();
     }
     
    
    /**
     * Konstruktor koji prima objekat klase DBBroker.
     * @param dbb Objekat klase DBBroker za komunikaciju sa bazom podataka.
     */
     public SOVratiSale(DBBroker dbb) {
     	super(dbb);
     }
    
    
     /**
      * Metoda u kojoj se poziva operacija za vracanje svih sala iz baze podataka.
      * Rezultat operacije su sale sa svim podacima.
      */
    @Override
    protected void izvrsiKonkretnuOperaciju() throws ServerskiException {
        lista = dbb.vratiSveObjekte(new Sala());
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
