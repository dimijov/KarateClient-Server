/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.bg.fon.nprog.so;


import java.util.List;

import rs.ac.bg.fon.nprog.db.DBBroker;
import rs.ac.bg.fon.nprog.domen.Grupa;
import rs.ac.bg.fon.nprog.domen.OpstiDomenskiObjekat;
import rs.ac.bg.fon.nprog.exception.ServerskiException;

/**
 * 
 * Klasa koja predstavlja sistemsku operaciju za prikaz informacija svih grupa koje postoje
 * u bazi Karate kluba. Iz baze podataka ucitavaju se podaci o grupama i rezultat 
 * operacije je lista objekata klase Grupa.
 * 
 * 
 * Klasa nasledjuje OpstaSO koja predstavlja apstraktnu sistemsku operaciju.
 * 
 * @author HP
 * @version 1.1.0
 *
 */
public class SOVratiGrupe extends OpstaSO {
	
	/**
     * Promenljiva u kojoj se čuvaju grupe kao rezultat upita.
     */
     List<OpstiDomenskiObjekat> lista;

     /**
      * Podrazumevani konstruktor.
      */
     public SOVratiGrupe() {
     	super();
     }
     
     /**
      * Konstruktor koji prima objekat klase DBBroker.
      * @param dbb Objekat klase DBBroker za komunikaciju sa bazom podataka.
      */
     public SOVratiGrupe(DBBroker dbb) {
     	super(dbb);
     }
     
     /**
      * Metoda u kojoj se poziva operacija za vracanje svih grupa iz baze podataka.
      * Rezultat operacije su grupe sa svim podacima.
      * @throws ServerskiException Ukoliko dođe do greške prilikom izvršavanja operacije.
      */
    @Override
    protected void izvrsiKonkretnuOperaciju() throws ServerskiException {
        lista = dbb.vratiSveObjekte(new Grupa());
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
