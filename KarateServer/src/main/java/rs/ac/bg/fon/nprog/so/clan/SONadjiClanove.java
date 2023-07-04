/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.bg.fon.nprog.so.clan;


import java.util.ArrayList;
import java.util.List;

import rs.ac.bg.fon.nprog.db.DBBroker;
import rs.ac.bg.fon.nprog.domen.Clan;
import rs.ac.bg.fon.nprog.domen.OpstiDomenskiObjekat;
import rs.ac.bg.fon.nprog.exception.ServerskiException;
import rs.ac.bg.fon.nprog.so.OpstaSO;

/**
 * Klasa koja predstavlja sistemsku operaciju za pronalaženje članova karate kluba.
 * Pretraga se vrši na osnovu grupe kojoj član pripada.
 * Klasa nasleđuje OpstaSO koja predstavlja apstraktnu sistemsku operaciju.
 * 
 * @author HP
 * @version 1.1.0
 */
public class SONadjiClanove extends OpstaSO {
    
	/**
     * Inicijalizovana {@link ArrayList} članova karate kluba koja predstavlja rezultat pretrage.
     */
    List<OpstiDomenskiObjekat> lista = new ArrayList<>();
    
    /**
     * Član karate kluba na osnovu kojeg se vrši pretraga kao objekat klase Član.
     */
    Clan clan;

    
    /**
     * Konstruktor koji prima člana karate kluba kao parametar.
     * 
     * @param clan Član karate kluba na osnovu kojeg se vrši pretraga.
     */
    public SONadjiClanove(Clan clan) {
        setClan(clan);
    }
    
    /**
     * Konstruktor koji prima objekat klase DBBroker.
     * 
     * @param dbb Objekat klase DBBroker za komunikaciju sa bazom podataka.
     */
    public SONadjiClanove(DBBroker dbb) {
    	super(dbb);
    }

    
    /**
     * Metoda u kojoj se poziva operacija za pretraživanje članova po grupi kojoj {@link #clan} pripada.
     * Rezultat operacije je lista objekata klase OpstiDomenskiObjekat koja predstavlja pronađene članove.
     * <ul>
     * <li> {@link #clan} - naziv grupe "Sve grupe" - vraća sve članove iz baze</li>
     * <li> {@link #clan} - naziv grupe "početnička","srednja","napredna","takimčarska" - vraća sve članove konkretne grupe iz baze</li>
     * </ul>
     * @throws ServerskiException Ukoliko dođe do greške prilikom izvršavanja operacije.
     */
    @Override
    protected void izvrsiKonkretnuOperaciju() throws ServerskiException {
        
        if(clan.getGrupa().getNaziv().equals("Sve grupe")) {
            List<OpstiDomenskiObjekat> clanovi = dbb.vratiSveObjekte(new Clan());
            lista.addAll(clanovi);
        } else {
            List<OpstiDomenskiObjekat> clanovi=dbb.vratiObjekte(clan);
            lista.addAll(clanovi);           
          
        }
    }

    
    /**
     * Metoda za dobijanje rezultata operacije.
     * @return Lista objekata klase OpstiDomenskiObjekat, koja predstavlja pronadjene članove.
     */
    public List<OpstiDomenskiObjekat> getLista() {
        return lista;
    }
    
    /**
     * Metoda koja postavlja člana na osnovu kog se vrši pretraga.
     * 
     * @param clan Član karate kluba na osnovu kojeg se vrši pretraga kao objekat klase Clan.
     */
    public void setClan(Clan clan) {
		this.clan = clan;
	}
    
    /**
     * Metoda koja vraća člana na osnovu kog se vrši pretraga.
     * 
     * @return Član karate kluba na osnovu kojeg se vrši pretraga kao objekat klase Clan.
     */
    public Clan getClan() {
		return clan;
	}
    
    
    /**
     * Metoda koja proverava preduslove za izvršavanje operacije.
     * 
     * @throws ServerskiException Ukoliko preduslovi za izvršavanje operacije nisu ispunjeni.
     * Prosleđeni član karate kluba je null.
     */
    @Override
    protected void proveriPreduslov() throws ServerskiException {
    	if (clan==null) {
    		throw new ServerskiException("Objekat na osnovu kog se pretrazuje ne sme biti null");
    	}
    }
    
    
    
    
}
