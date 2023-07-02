/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.bg.fon.nprog.so;

import rs.ac.bg.fon.nprog.db.DBBroker;
import rs.ac.bg.fon.nprog.domen.OpstiDomenskiObjekat;
import rs.ac.bg.fon.nprog.exception.ServerskiException;

/**
 * 
 * Klasa koja predstavlja apstraktnu sistemsku operaciju. 
 * OpstaSO je apstraktna klasa koja definiše osnovni šablon za izvršavanje sistemske operacije, dok neke specifične metode prepušta podklasama. 
 * Sve sistemske operacije nasledjuju ovu apstraktnu klasu.
 * Klasa sadrži mehanizam za upravljanje transakcijama i izvršavanje operacija nad bazom podataka.
 * Svaka klasa koja nasledjuje ovu klasu treba da implementira metode proveriPreduslov() i izvrsiKonkretnuOperaciju().
 * 
 * 
 * 
 * @author HP
 * @version 1.1.0
 *
 */
public abstract class OpstaSO {
    
    /**
     * Objekat klase DBBroker za komunikaciju sa bazom podataka.
     */
    protected DBBroker dbb;

    /**
     * Konstruktor koji kreira novi objekat klase DBBroker.
     */
    public OpstaSO() {
        this.dbb = new DBBroker();
    }
    
    /**
     * Konstruktor koji prima postojeći objekat klase DBBroker.
     * @param dbb Objekat klase DBBroker za komunikaciju sa bazom podataka.
     */
    public OpstaSO(DBBroker dbb) {
    	this.dbb=dbb;
    }

    
    /**
     * Metoda koja izvršava sistemsku operaciju.
	 * Metoda otvara konekciju sa bazom podataka, proverava preduslove operacije,
	 * izvršava konkretnu operaciju, potvrđuje transakciju ako je uspešno izvršena,
	 * a u slučaju greške poništava transakciju.
	 * Na kraju zatvara konekciju sa bazom podataka.
	 * @throws ServerskiException Ako se desi greška prilikom izvršavanja operacije.
     */
    synchronized public void izvrsiOperaciju() throws ServerskiException {
        otvoriKonekciju();
        try {
            proveriPreduslov();
            izvrsiKonkretnuOperaciju();
            potvrdiTransakciju();
        } catch (ServerskiException e) {
            ponistiTransakciju();
            throw e;
        } finally {
            zatvoriKonekciju();
        }
    }

    
    /**
     * Metoda za potvrdu transakcije.
     * Metoda poziva metodu potvrdiTransakciju() objekta DBBroker.
     * @throws ServerskiException Ako se desi greška prilikom potvrđivanja transakcije
     */
    private void potvrdiTransakciju() throws ServerskiException {
        dbb.potvrdiTransakciju();
    }

    /**
     * 
     * Metoda za poništavanje transakcije.
     * Metoda poziva metodu ponistiTransakciju() objekta DBBroker.
     */
    private void ponistiTransakciju() {
        dbb.ponistiTransakciju();
    }

    
    /**
     * Metoda za zatvaranje konekcije sa bazom podataka.
     * Metoda poziva metodu raskiniKonekciju() objekta DBBroker.
     * @throws ServerskiException Ako se desi greška prilikom zatvaranja konekcije.
     */
    private void zatvoriKonekciju() throws ServerskiException {
        dbb.raskiniKonekciju();
    }

    /**
     * Metoda za otvaranje konekcije sa bazom podataka.
     * Metoda poziva metodu uspostaviKonekciju() objekta DBBroker.
     * @throws ServerskiException Ako se desi greška prilikom otvaranja konekcije.
     */
    private void otvoriKonekciju() throws ServerskiException {
        dbb.uspostaviKonekciju();
    }

    
    /**
     * Apstraktna metoda za proveru preduslova operacije.
     * Svaka konkretizacija ove klase treba da implementira ovu metodu kako bi proverila
	 * da li su ispunjeni svi preduslovi za izvršavanje operacije.
     * @throws ServerskiException Ako preduslov nije ispunjen.
     */
    protected abstract void proveriPreduslov() throws ServerskiException;
    
    
    /**
     * Apstraktna metoda za izvršavanje konkretne operacije.
     * Svaka konkretizacija ove klase treba da implementira ovu metodu kako bi izvršila
     * specifične operacije nad bazom podataka.
     * @throws ServerskiException Ako se desi greška prilikom izvršavanja operacije.
     */
    protected abstract void izvrsiKonkretnuOperaciju() throws ServerskiException;
}
