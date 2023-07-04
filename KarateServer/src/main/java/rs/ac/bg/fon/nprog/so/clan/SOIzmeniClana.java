/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.bg.fon.nprog.so.clan;

import rs.ac.bg.fon.nprog.db.DBBroker;
import rs.ac.bg.fon.nprog.domen.Clan;
import rs.ac.bg.fon.nprog.domen.OpstiDomenskiObjekat;
import rs.ac.bg.fon.nprog.exception.ServerskiException;
import rs.ac.bg.fon.nprog.so.OpstaSO;

/**
 * Klasa koja predstavlja sistemsku operaciju za izmenu člana karate kluba.
 * 
 * Klasa nasleđuje OpstaSO koja predstavlja apstraktnu sistemsku operaciju.
 * 
 * @author HP
 * @version 1.1.0
 */
public class SOIzmeniClana extends OpstaSO {
    
    private OpstiDomenskiObjekat param;
    private OpstiDomenskiObjekat clan;

    
    /**
     * Konstruktor koji prima člana kao objekat klase OpstiDomenskiObjekat kao parametar.
     * 
     * @param param Objekat klase OpstiDomenskiObjekat koji predstavlja člana karate kluba kojeg treba izmeniti.
     */
    public SOIzmeniClana(OpstiDomenskiObjekat param) {
    	super();
        setParam(param);
    }
    
    /**
     * Konstruktor koji prima objekat klase DBBroker.
     * 
     * @param dbb Objekat klase DBBroker za komunikaciju sa bazom podataka.
     */
    public SOIzmeniClana(DBBroker dbb) {
        super(dbb);
    }

    
    /**
     * Metoda u kojoj se poziva operacija za izmenu člana karate kluba u bazi podataka.
     * Rezultat operacije je objekat klase OpstiDomenskiObjekat koji predstavlja izmenjenog člana.
     * 
     * @throws ServerskiException Ukoliko dođe do greške prilikom izvršavanja operacije.
     */
    @Override
    protected void izvrsiKonkretnuOperaciju() throws ServerskiException {
        clan = dbb.izmeniObjekat(param);
        
    }

    
    /**
     * Metoda koja vraća člana karate kluba koga treba izmeniti.
     * 
     * @return Objekat klase OpstiDomenskiObjekat koji predstavlja člana karate kluba kojeg treba izmeniti.
     */
    public OpstiDomenskiObjekat getParam() {
        return param;
    }

    
    /**
     * Metoda koja postavlja člana karate kluba kojeg treba izmeniti.
     * 
     * @param param Objekat klase OpstiDomenskiObjekat koji predstavlja člana karate kluba kojeg treba izmeniti.
     */
    public void setParam(OpstiDomenskiObjekat param) {
        this.param = param;
    }

    
    /**
     * Metoda koja vraća izmenjenog člana karate kluba.
     * 
     * @return Objekat klase OpstiDomenskiObjekat koji predstavlja izmenjenog člana karate kluba.
     */
    public OpstiDomenskiObjekat getClan() {
        return clan;
    }

    
    /**
     * Metoda koja proverava preduslove za izvršavanje operacije.
     * 
     * @throws ServerskiException Ukoliko preduslovi za izvršavanje operacije nisu ispunjeni.
     * Prosleđeni {@link #param} nije instanca klase Clan i različit je od null.
     */
    @Override
    protected void proveriPreduslov() throws ServerskiException {
    	if(!(param instanceof Clan) && param!=null) {
    		throw new ServerskiException("Poslati objekat nije odogvarajuce klase");
    	}
    }
    
    
}
