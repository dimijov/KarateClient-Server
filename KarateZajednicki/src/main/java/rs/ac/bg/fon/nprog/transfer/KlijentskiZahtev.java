/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.bg.fon.nprog.transfer;

import java.io.Serializable;


/**
 * Klasa koja predstavlja klijentski zahtev.
 * 
 * Klijentski zahtev se sastoji od operacije koju je potrebno izvršiti i parametra koji se odnosi na tu operaciju.
 * 
 * Operacija je predstavljena finalnom int vrednošću koja se odnosi na određenu operaciju iz klase Operacije.
 * Parametar je objekat koji klijent šalje kao deo zahteva.
 * 
 * Zahtev se šalje sa klijenta ka serveru radi izvršavanja određene operacije.
 * Takođe, implementira interfejs Serializable kako bi objekat mogao da se prenosi preko mreže.
 * 
 * @author HP
 * @version 1.1.0
 */
public class KlijentskiZahtev implements Serializable {
    
	/**
     * Operacija zahteva.
     * 
     * Ova vrednost predstavlja redni broj operacije koja se želi izvršiti.
     * Vriednost operacije se uzima iz klase Operacije.
     */
	private int operacija;
	
	/**
     * Parametar zahteva.
     * 
     * Objekat koji klijent šalje kao deo zahteva.
     */
    private Object parametar;

    
    /**
     * Metoda koja vraća operaciju zahteva.
     * 
     * @return Operacija zahteva kao finalna int vrednost iz klase Operacije.
     */
    public int getOperacija() {
        return operacija;
    }

    /**
     * Metoda koja postavlja operaciju zahteva.
     * @param operacija Operacija zahteva kao finalna int vrednost iz klase Operacije. 
     */
    public void setOperacija(int operacija) {
        this.operacija = operacija;
    }

    
    /**
     * Metoda koja vraća parametar zahteva.
     * 
     * @return Parametar zahteva kao objekat klase Object.
     */
    public Object getParametar() {
        return parametar;
    }

    /**
     * Metoda koja postavlja parametar zahteva.
     * @param parametar Parametar zahteva kao objekat klase Object.
     */
    public void setParametar(Object parametar) {
        this.parametar = parametar;
    }
    
}
