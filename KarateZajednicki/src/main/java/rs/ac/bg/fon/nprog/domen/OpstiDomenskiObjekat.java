/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package rs.ac.bg.fon.nprog.domen;

import java.io.Serializable;
import java.sql.ResultSet;
import java.util.List;

/**
 * Interfejs koji daje specifikaciju operacija koje su neophodne za rad sa generickim upitima prilikom komunikacije sa bazom podataka.
 * 
 * Predstavlja visi nivo apstrakcije u odosu na sve domenske klase. 
 * 
 * Takođe, nasledjuje interfejs Serializable kako bi objekat mogao da se prenosi preko mreze.
 * 
 * @author HP
 * @version 1.1.0
 *
 */
public interface OpstiDomenskiObjekat extends Serializable {
    
	
	/**
	 * Vraca naziv tabele u bazi podataka.
	 * 
	 * @return Naziv tabele kao String.
	 */
    public String vratiImeTabele();
    
    
    /**
     * Vraca unete vrednosti za atribute klase.
     * 
     * @return Vrednosti atributa klase odvojeni zarezima kao jedan String.
     */
    public String vratiParametre();
    
   
    /**
     * Vraca naziv kolone primarnoh kljuca.
     * 
     * @return Naziv primarnog kljuca kao String.
     */
    public String vratiPK();
    
    
    /**
     * Vraca vrednost primarnog kljuca.
     * 
     * @return Vrednost primarnog kljuca.
     */
    public int vratiVrednostPK();
    
    
    /**
     * Vraca slozeni primarni kljuc.
     * 
     * @return Slozeni primarni kljuc kao String.
     */
    public String vratiSlozenPK();
    
    
    /**
     * Vraca listu objekata koja predstavlja ucitane redove iz baze podataka nakon izvsenja upita.
     * Prolazi se po redovima, ucitavaju se podaci iz svakog reda baze podataka i postavljaju
     * na vrednosti atributa objekta koji se dodaje u listu.
     *
     * @param rs Objekat koji sadrzi podatke iz baze podataka nakon izvrsavanja upita.
     * @return Lista objekata ucitanih na osnovu vrednosti u bazi podataka nakon izvrsavanja upita.
     */
    public List<OpstiDomenskiObjekat> RSuTabelu(ResultSet rs);
    
    
    /**
     * Vraca deo upita koji sadrzi imena kolona i vrednosti atributa klase potrebne za azuriranja reda u bazi podataka.
     * 
     * @return String koji predstavlja imena kolona i vrednosti atributa klase.
     */
    public String vratiUpdate();
    
    
    /**
     * Postavlja vrednost primarnog kljuca objekta.
     * 
     * @param pk Vrednost primarnog kljuca kao int.
     */
    public void postaviVrednostPK(int pk);
    
    
    /**
     * Vraca nazive svih kolona tabele koje se koriste u upitu.
     * 
     * @return Nazivi kolona tabele odvojeni zarezima kao jedan String.
     */
    public String kolone();
    
   
    /**
     * Vraca uslov za JOIN operaciju na osnovu kojeg se vrsi spajanje tabele.
     * 
     * @return Uslov za JOIN operaciju kao String.
     */
    public String vratiUslovZaJoin();
    
   
    /**
     * Vraca naziv atributa koji se koristi za pretragu objekta.
     * 
     * @return Naziv atributa za pretragu kao String.
     * @throws UnsupportedOperationException Ukoliko se pozove za klase koje nemaju definisano ponasanje metode.
     */
    public String vratiAtributPretrazivanja();
    
    
    /**
     * Vraca vrednost atributa koji se koristi za pretragu objekta.
     * 
     * @return Vrednost atributa za pretragu kao String.
     * @throws UnsupportedOperationException Ukoliko se pozove za klase koje nemaju definisano ponasanje metode.
     */
    public String vratiVrednostAtributa();
    
    
    /**
     * Vraca deo upita koji sadrzi kolone sa podacima na osnovu kojih se vrsi pretraga.
     * 
     * @return Atributi za pretragu odvojeni zarezima kao jedan String.
     */
    public String vratiAtributePretrazivanja();
    
}
