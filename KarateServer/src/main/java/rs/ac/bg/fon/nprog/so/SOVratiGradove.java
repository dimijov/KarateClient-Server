/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.bg.fon.nprog.so;


import java.util.List;

import rs.ac.bg.fon.nprog.db.DBBroker;
import rs.ac.bg.fon.nprog.domen.Grad;
import rs.ac.bg.fon.nprog.domen.OpstiDomenskiObjekat;
import rs.ac.bg.fon.nprog.exception.ServerskiException;

/**
 * 
 * Klasa koja predstavlja sistemsku operaciju za prikaz informacija svih gradova koji postoje
 * u bazi Karate kluba. Iz baze podataka ucitavaju se podaci o gradovima i rezultat 
 * operacije je lista objekata klase Grad.
 * 
 * 
 * Klasa nasledjuje OpstaSO koja predstavlja apstraktnu sistemsku operaciju.
 * 
 * @author HP
 * @version 1.1.0
 *
 */
public class SOVratiGradove extends OpstaSO {

	/**
     * Promenljiva u kojoj se čuvaju gradovi kao rezultat upita.
     */
     List<OpstiDomenskiObjekat> lista;
     
     /**
      * Podrazumevani konstruktor.
      */
     public SOVratiGradove() {
     	super();
     }

     /**
      * Konstruktor koji prima objekat klase DBBroker.
      * @param dbb Objekat klase DBBroker za komunikaciju sa bazom podataka.
      */
     public SOVratiGradove(DBBroker dbb) {
 		super(dbb);
 	}
    
     
     /**
     * Metoda u kojoj se poziva operacija za vracanje svih gradova iz baze podataka.
     * Rezultat operacije su gradovi sa svim podacima.
     */
    @Override
    protected void izvrsiKonkretnuOperaciju() throws ServerskiException {
         lista = dbb.vratiSveObjekte((OpstiDomenskiObjekat) new Grad());
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
