/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.bg.fon.nprog.so.trener;

import rs.ac.bg.fon.nprog.domen.OpstiDomenskiObjekat;
import rs.ac.bg.fon.nprog.domen.Trener;
import rs.ac.bg.fon.nprog.exception.ServerskiException;
import rs.ac.bg.fon.nprog.kontroler.Kontroler;
import rs.ac.bg.fon.nprog.so.OpstaSO;

/**
 * Klasa koja predstavlja sistemsku operaciju za odjavljivanje trenera sa sistema.
 * 
 * Klasa nasleđuje OpstaSO koja predstavlja apstraktnu sistemsku operaciju.
 * 
 * @author HP
 * @version 1.0.0
 */
public class SOIzlogujTrenera extends OpstaSO {
    
	/**
     * Trener koji se odjavljuje sa sistema.
     */
    private OpstiDomenskiObjekat trener;

    
    /**
     * Konstruktor koji prima trenera koji se odjavljuje sa sistema.
     * 
     * @param trener Trener koji se odjavljuje sa sistema.
     */
    public SOIzlogujTrenera(OpstiDomenskiObjekat trener) {
        this.trener = trener;
    }

    
    /**
     * Metoda u kojoj se izvršava operacija odjavljivanja trenera sa sistema.
     * Postavlja se vrednost atributa "ulogovan" trenera na false.
     * 
     * @throws ServerskiException Ukoliko dođe do greške prilikom izvršavanja operacije.
     */
    @Override
    protected void izvrsiKonkretnuOperaciju() throws ServerskiException {
        int indeks = Kontroler.vratiInstancu().getListaKorisnika().indexOf(trener);
        if (indeks != -1) {
            ((Trener) Kontroler.vratiInstancu().getListaKorisnika().get(indeks)).setUlogovan(false);
        }
    }

    
    /**
     * Metoda koja vraca trenera koji se odjavljuje sa sistema.
     * 
     * @return Trener koji se odjavljuje sa sistema.
     */
    public OpstiDomenskiObjekat getTrener() {
        return trener;
    }

    /**
     * Metoda koja postavlja prosledjenog trenera koji se odjavljuje sa sistema.
     * 
     * @param trener Trener koji se odjavljuje sa sistema.
     */
    public void setTrener(OpstiDomenskiObjekat trener) {
        this.trener = trener;
    }

    @Override
    protected void proveriPreduslov() throws ServerskiException {
    }
   
    
    
}
