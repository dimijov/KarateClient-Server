/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.bg.fon.nprog.konstante;

/**
 * Klasa koja sadrži konstante koje predstavljaju nazive sistemskih operacija koje se izvršavaju na serveru.
 * 
 * Sve operacije su definisane kao javne statičke finalne celobrojne promenjive.
 * 
 * Ove konstante se koriste za identifikaciju operacija prilikom komunikacije klijenta sa serverom.
 * Svaka operacija ima jedinstvenu vrednost.
 * 
 * @author HP
 * 
 * @version 1.1.0
 */
public class Operacije {
    
	/**
     * Konstanta koja predstavlja operaciju za prijavljivanje trenera.
     */
    public static final int LOGIN = 1;
    
    /**
     * Konstanta koja predstavlja operaciju za vracanje liste gradova.
     */
    public static final int VRATI_GRADOVE = 22;
    
    /**
     * Konstanta koja predstavlja operaciju za vracanje liste grupa.
     */
    public static final int VRATI_GRUPE = 33;
    
    /**
     * Konstanta koja predstavlja operaciju za čuvanje člana.
     */
    public static final int ZAPAMTI_CLANA = 44;
    
    /**
     * Konstanta koja predstavlja operaciju za vraćanje liste članova.
     */
    public static final int VRATI_CLANOVE = 45;
    
    /**
     * Konstanta koja predstavlja operaciju za pronalaženje članova.
     */
    public static final int NADJI_CLANOVE = 46;
    
    /**
     * Konstanta koja predstavlja operaciju za učitavanje podataka o članu.
     */
    public static final int UCITAJ_CLANA = 47;
    
    /**
     * Konstanta koja predstavlja operaciju za izmenu člana.
     */
    public static final int IZMENI_CLANA = 48;
    
    /**
     * Konstanta koja predstavlja operaciju za brisanje člana.
     */
    public static final int OBRISI_CLANA= 49;
    
    /**
     * Konstanta koja predstavlja operaciju za vraćanje liste treninga.
     */
    public static final int VRATI_TRENINGE =111;
    
    /**
     * Konstanta koja predstavlja operaciju za vraćanje liste sala.
     */
    public static final int VRATI_SALE = 55;
    
    /**
     * Konstanta koja predstavlja operaciju za čuvanje treninga.
     */
    public static final int ZAPAMTI_TRENING=112;
    
    /**
     * Konstanta koja predstavlja operaciju za vraćanje liste vežbi.
     */
    public static final int VRATI_VEZBE=66;
    
    /**
     * Konstanta koja predstavlja operaciju za pronalaženje treninga.
     */
    public static final int NADJI_TRENINGE = 113;
    
    /**
     * Konstanta koja predstavlja operaciju za učitavanje podataka o treningu.
     */
    public static final int UCITAJ_TRENING = 114;
    
    /**
     * Konstanta koja predstavlja operaciju za izmenu treninga.
     */
    public static final int IZMENI_TRENING=115;
    
    /**
     * Konstanta koja predstavlja operaciju za brisanje treninga.
     */
    public static final int OBRISI_TRENING=116;
    
    /**
     * Konstanta koja predstavlja operaciju za odjavu trenera.
     */
    public static final int IZLOGUJ_TRENERA=120;
    
}
