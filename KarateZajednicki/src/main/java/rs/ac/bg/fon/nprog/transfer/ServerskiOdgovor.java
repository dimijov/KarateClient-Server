/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.bg.fon.nprog.transfer;

import java.io.Serializable;

/**
 * Klasa koja predstavlja serverski odgovor na klijentski zahtev.
 * 
 * Serverski odgovor se sastoji od podataka koji se šalju nazad klijentu,uspešnosti izvršavanja operacije i eventualnoh izuzetka koji se desio prilikom izvršavanja operacije.
 * 
 * Podaci predstavljaju rezultat izvršavanja operacije.
 * Uspešnost je celobrojna vrednost koja ima vrednost 1 ukoliko je operacija uspešno izvršena, inače ima vrednost različitu od 1.
 * Exception predstavlja eventualni izuzetak koji se desio prilikom izvršavanja operacije. Ukoliko je operacija uspešno izvršena, vrednost exception je null.
 * Odgovor se šalje sa servera ka klijentu kao odgovor na određeni zahtev.
 * 
 * Takođe, implementira interfejs Serializable kako bi objekat mogao da se prenosi preko mreže.
 * 
 * @author HP
 * @version 1.1.0
 */
public class ServerskiOdgovor implements Serializable {
    
	/**
	 * Podaci koji se šalju nazad klijentu.
	 * Ovi podaci predstavljaju rezultat izvršavanja operacije.
	 */
    private Object podaci;
    
    /**
     * Uspešnost izvršavanja operacije.
	 * Ova vrednost predstavlja uspešnost izvršavanja operacije i može imati vrednost 1 ukoliko je operacija uspešno izvršena.
	 * U suprotnom, vrednost je različita od 1.
     */
    private int uspesnost;
    
    /**
     * Izuzetak koji se desio prilikom izvršavanja operacije.
     * Exception predstavlja eventualni izuzetak koji se desio prilikom izvršavanja operacije.
     * Ukoliko je operacija uspešno izvršena, vrednost exception je null.
     * 
     */
    private Exception exception;

    /**
     * Metoda koja vraća podatke odgovora.
     * @return Podaci odgovora kao objekat.
     */
    public Object getPodaci() {
        return podaci;
    }

    /**
     * Metoda koja postavlja podatke odgovora.
     * @param podaci Podaci odgovora kao objekat.
     */
    public void setPodaci(Object podaci) {
        this.podaci = podaci;
    }

    /**
     * Metoda koja vraća uspešnost izvršavanja operacije.
     * @return  Uspesnost izvršavanja operacije kao int.
     * <ul>
     * <li>1 - uspešno</li>
     * <li>else - neuspešno</li>
     * </ul>
     */
    public int getUspesnost() {
        return uspesnost;
    }

    /**
     * Metoda koja postavlja uspešnost izvršavanja operacije.
     * @param uspesnost Uspesnost izvršavanja operacije kao celobrojna vrednost.
     * <ul>
     * <li>1 - uspešno</li>
     * <li>else - neuspešno</li>
     * </ul>
     */
    public void setUspesnost(int uspesnost) {
        this.uspesnost = uspesnost;
    }

    /**
     * Metoda koja vraća izuzetak koji se desio prilikom izvršavanja operacije.
     * @return Izuzetak koji se desio prilikom izvršavanja operacije.
     */
    public Exception getException() {
        return exception;
    }

    /**
     * Metoda koja postavlja izuzetak koji se desio prilikom izvršavanja operacije.
     * @param exception Izuzetak koji se desio prilikom izvršavanja operacije.
     */
    public void setException(Exception exception) {
        this.exception = exception;
    }
    
}
