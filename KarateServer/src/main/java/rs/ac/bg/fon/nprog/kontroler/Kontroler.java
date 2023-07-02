/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.bg.fon.nprog.kontroler;

import java.util.List;

import rs.ac.bg.fon.nprog.domen.Clan;
import rs.ac.bg.fon.nprog.domen.OpstiDomenskiObjekat;
import rs.ac.bg.fon.nprog.domen.Trener;
import rs.ac.bg.fon.nprog.domen.Trening;
import rs.ac.bg.fon.nprog.exception.ServerskiException;
import rs.ac.bg.fon.nprog.so.SOVratiGradove;
import rs.ac.bg.fon.nprog.so.SOVratiGrupe;
import rs.ac.bg.fon.nprog.so.SOVratiSale;
import rs.ac.bg.fon.nprog.so.SOVratiVezbe;
import rs.ac.bg.fon.nprog.so.clan.SOIzmeniClana;
import rs.ac.bg.fon.nprog.so.clan.SONadjiClanove;
import rs.ac.bg.fon.nprog.so.clan.SOObrisiClana;
import rs.ac.bg.fon.nprog.so.clan.SOVratiClanove;
import rs.ac.bg.fon.nprog.so.clan.SOZapamtiClana;
import rs.ac.bg.fon.nprog.so.trener.SOIzlogujTrenera;
import rs.ac.bg.fon.nprog.so.trener.SOUcitajListuKorisnika;
import rs.ac.bg.fon.nprog.so.trener.SOUlogujTrenera;
import rs.ac.bg.fon.nprog.so.trening.SOIzmeniTrening;
import rs.ac.bg.fon.nprog.so.trening.SONadjiTreninge;
import rs.ac.bg.fon.nprog.so.trening.SOObrisiTrening;
import rs.ac.bg.fon.nprog.so.trening.SOVratiTreninge;
import rs.ac.bg.fon.nprog.so.trening.SOZapamtiTrening;

/**
 * Predstavlja klasu u okviru koje se pozivaju sve sistemske operacije.
 * Kontroler je zadužen da izabere i kreira odgovarajuću sistemsku operaciju za zahtev koji je stigao.
 * Nakon toga, Kontroler prihvata i vraća rezultat te sistemske operacije.
 * Implementiran je pomoću Singleton paterna kako bi se osiguralo kreiranje samo jedne instance Kontroler-a.
 * 
 * 
 * @author HP
 * @version 1.1.0
 */
public class Kontroler {
	
	/**
     * Instanca klase Kontroler koja ce se kreirati samo jednom prilikom prvog zahteva za nju. Svaki sledeci
     * put kada je potreban Kontroler bice vracena prvobitno kreirana instanca.
     */
    private static Kontroler instanca;
    
    /**
     * Lista korisnika sistema koja predstavlja sve trenere u bazi.
     */
    private List<OpstiDomenskiObjekat> listaKorisnika;

    
    /**
     * Privatni konstruktor koji osigurava da se instanca klase Kontroler moze napraviti jedino pozivom
     * metode getInstance().
     */
    private Kontroler() {
    }

    /**
     * Vraca instancu klase Kontroler. Ukoliko instanca ne postoji, kreira je.
     * 
     * @return Instanca klase Kontroler.
     */
    public static Kontroler vratiInstancu() {
        if (instanca == null) {
            instanca = new Kontroler();
        }
        return instanca;
    }

    
    /**
     * Metoda koja vraća listu korisnika sistema, odnosno sve trenere iz baze podataka.
     * Ukoliko lista korisnika nije prethodno učitana, metoda je učitava i pamti kako bi se izbeglo ponovno učitavanje.
     *
     * @return Lista korisnika sistema kao lista objekata klase OpstiDomenskiObjekat.
     * @throws ServerskiException Ukoliko nastane greška prilikom učitavanja liste korisnika iz baze.
     */
    public List<OpstiDomenskiObjekat> getListaKorisnika() throws ServerskiException {
       if (listaKorisnika == null) {
            listaKorisnika = vratiListuKorisnika();
        }
        return listaKorisnika;
    }

    
    /**
     * Privatna metoda koja poziva sistemsku operaciju za učitavanje liste korisnika sistema, odnosno trenera iz baze podataka.
     * @return Lista korisnika sistema kao lista objekata klase OpstiDomenskiObjekat.
     * @throws ServerskiException Ukoliko nastane greška prilikom učitavanja liste korisnika iz baze.
     */
    private List<OpstiDomenskiObjekat> vratiListuKorisnika() throws ServerskiException {
        SOUcitajListuKorisnika souk = new SOUcitajListuKorisnika();
        souk.izvrsiOperaciju();
        return souk.getLista();
    }
    
    /**
     * Metoda koja poziva sistemsku operaciju za logovanje trenera na osnovu unetih parametara.
     * Ukoliko su uneti parametri ispravni i postoji trener sa datim korisničkim imenom i lozinkom,
     * metoda vrši logovanje tog trenera i vraća ulogovanog korisnika.
     * Ukoliko uneti parametri nisu validni ili ne postoji trener sa datim parametrima,
     * metoda baca ServerskiException.
     *
     * @param tren Trener koji se pokušava prijaviti.
     * @return Ulogovan trener kao objekat klase OpstiDomenskiObjekat.
     * @throws ServerskiException
     * <ul>
     * <li>Ukoliko uneti parametri nisu validni</li>
     * <li>Ukoliko ne postoji trener u bazi</li>
     * <li>Ukoliko je trener vec prijavljen</li>
     * </ul>
     */
    public OpstiDomenskiObjekat ulogujKosrisnika(Trener tren) throws ServerskiException {
        SOUlogujTrenera sot = new SOUlogujTrenera();
        sot.setUnetiParametri(tren);
        sot.izvrsiOperaciju();
        return sot.getUlogovanKorisnik();
    }

    
    /**
     * Metoda koja poziva sistemsku operaciju za vraćanje liste gradova iz baze podataka.
     *
     * @return Lista gradova kao lista objekata klase OpstiDomenskiObjekat.
     * @throws ServerskiException Ukoliko nastane greška prilikom učitavanja liste gradova iz baze.
     */
    public List<OpstiDomenskiObjekat> vratiListuGradova() throws ServerskiException {
        SOVratiGradove sov = new SOVratiGradove();
        sov.izvrsiOperaciju();
        return sov.getLista();
    }

    
    /**
     * Metoda koja poziva sistemsku operaciju za vraćanje liste grupa iz baze podataka.
     *
     * @return Lista grupa kao lista objekata klase OpstiDomenskiObjekat.
     * @throws ServerskiException Ukoliko nastane greška prilikom učitavanja liste grupa iz baze.
     */
    public List<OpstiDomenskiObjekat> vratiListuGrupa() throws ServerskiException {
        SOVratiGrupe sovg = new SOVratiGrupe();
        sovg.izvrsiOperaciju();
        return sovg.getLista();
    }

    
    /**
     * Metoda koja poziva sistemsku operaciju za čuvanje novog člana u bazi podataka.
     *
     * @param c Član koji se čuva u bazi podataka.
     * @return Sačuvani član kao objekat klase OpstiDomenskiObjekat.
     * @throws ServerskiException Ukoliko nastane greška prilikom čuvanja člana unutar baze podataka.
     */
    public OpstiDomenskiObjekat kreirajClana(Clan c) throws ServerskiException {
        SOZapamtiClana soz = new SOZapamtiClana(c);
        soz.izvrsiOperaciju();
        return soz.getClan();
    }
    
    
    /**
     * Metoda koja poziva sistemsku operaciju za vraćanje liste članova iz baze podataka.
     *
     * @return Lista članova kao lista objekata klase OpstiDomenskiObjekat.
     * @throws ServerskiException Ukoliko nastane greška prilikom učitavanja liste članova iz baze.
     */
    public List<OpstiDomenskiObjekat> vratiListuClanova() throws ServerskiException {
        SOVratiClanove sovc = new SOVratiClanove();
        sovc.izvrsiOperaciju();
        return sovc.getLista();
    }

    
    /**
     * Metoda koja poziva sistemsku operaciju koja filtrira i vraća članove iz baze podataka.
     * Pretraga se sprovodi na osnovu grupe kojoj član pripada.
     * Ukoliko nastane greška prilikom filtriranja ili učitavanja člana, metoda baca izuzetak.
     *
     * @param cl Clan sa postavljenom vrednošću Grupe na osnovu koje se pretraga vrši.
     * @return Filtrirana lista članova kao lista objekata klase OpstiDomenskiObjekat.
     * @throws ServerskiException Ukoliko nastane greška prilikom filtriranja ili učitavanja članova iz baze.
     */
    public List<OpstiDomenskiObjekat> pretraziClanove(Clan cl) throws ServerskiException {
        SONadjiClanove sonc=new SONadjiClanove(cl);
        sonc.izvrsiOperaciju();
        return sonc.getLista();
    }

    
    /**
     * Metoda koja poziva sistemsku operaciju za izmenu podataka o članu u bazi podataka.
     * Ukoliko nastane greška prilikom izmene, metoda baca izuzetak.
     *
     * @param cla Član čije informacije treba izmeniti.
     * @return Izmenjeni član kao objekat klase OpstiDomenskiObjekat.
     * @throws ServerskiException Ukoliko nastane greška prilikom izmene članau bazi.
     */
    public OpstiDomenskiObjekat izmeniClana(Clan cla) throws ServerskiException {
        SOIzmeniClana soic=new SOIzmeniClana(cla);
        soic.izvrsiOperaciju();
        return soic.getClan();
    }

    /**
     * Metoda koja poziva sistemsku operaciju za brisanje člana iz baze podataka.
     * Ukoliko nastane greška prilikom brisanja, metoda baca izuzetak.
     *
     * @param clao Član kog je potrebno obrisati iz baze podataka.
     * @return Obrisani član kao objekat klase OpstiDomenskiObjekat.
     * @throws ServerskiException Ukoliko nastane greska prilikom brisanja člana.
     */
    public OpstiDomenskiObjekat obrisiClana(Clan clao) throws ServerskiException {
        SOObrisiClana sooc=new SOObrisiClana(clao);
        sooc.izvrsiOperaciju();
        return sooc.getObrisan();
    }

    
    /**
     * Metoda koja poziva sistemsku operaciju za vraćanje liste vežbi iz baze podataka.
     *
     * @return Lista vežbi kao lista objekata klase OpstiDomenskiObjekat.
     * @throws ServerskiException Ukoliko nastane greška prilikom učitavanja liste vežbi iz baze.
     */
    public List<OpstiDomenskiObjekat> vratiListuVezbi() throws ServerskiException {
        SOVratiVezbe sovv=new SOVratiVezbe();
        sovv.izvrsiOperaciju();
        return sovv.getLista();
        
    }

    
    /**
     * Metoda koja poziva sistemsku operaciju za vraćanje liste sala iz baze podataka.
     *
     * @return Lista sala kao lista objekata klase OpstiDomenskiObjekat.
     * @throws ServerskiException Ukoliko nastane greška prilikom učitavanja liste sala iz baze.
     */
    public List<OpstiDomenskiObjekat> vratiListuSala() throws ServerskiException {
        SOVratiSale sovs=new SOVratiSale();
        sovs.izvrsiOperaciju();
        return sovs.getLista();
    }

    
    /**
     * Metoda koja poziva sistemsku operaciju za čuvanje treninga u bazi podataka.
     *
     * @param tr Trening koji se čuva u bazi.
     * @return Sačuvani trening kao objekat klase OpstiDomenskiObjekat.
     * @throws ServerskiException Ukoliko nastane greška prilikom čuvanja treninga u bazi.
     */
    public OpstiDomenskiObjekat kreirajTrening(Trening tr) throws ServerskiException {
        SOZapamtiTrening sozt=new SOZapamtiTrening(tr);
        sozt.izvrsiOperaciju();
        return sozt.getTrening();
    }

    
    /**
     * Metoda koja poziva sistemsku operaciju koja filtrira i vraća treninge iz baze podataka.
     * Pretraga se sprovodi na osnovu trenera zaduženog za dati trening.
     * Ukoliko nastane greška prilikom filtriranja ili učitavanja treninga, metoda baca izuzetak.
     *
     * @param trening1 Trening sa postavljenom vrednošću za trenera zaduženog za taj trening.
     * @return Filtrirana lista treninga kao lista objekata klase OpstiDomenskiObjekat.
     * @throws ServerskiException ukoliko nastane greška prilikom filtriranja ili učitavanja treninga iz baze.
     */
    public List<OpstiDomenskiObjekat> vratiTreninge(Trening trening1) throws ServerskiException {
        SOVratiTreninge sovt=new SOVratiTreninge(trening1);
        sovt.izvrsiOperaciju();
        return sovt.getListaTreninga();
    }

    
    /**
     * Metoda koja poziva sistemsku operaciju koja filtrira i vraća treninge iz baze podataka.
     * Pretraga se sprovodi na osnovu trenera zaduženog za dati trening i datuma kad se trening održava.
     * Ukoliko nastane greška prilikom filtriranja ili učitavanja treninga, metoda baca izuzetak.
     *
     * @param tt Trening sa postavljenom vrednošću datuma i vremena održavanja kao i trenera zaduženog za isti.
     * @return Filtrirana lista treninga kao lista objekata klase OpstiDomenskiObjekat.
     * @throws ServerskiException ukoliko nastane greska prilikom filtriranja ili učitavanja treninga iz baze.
     */
    public List<OpstiDomenskiObjekat> nadjiTreninge(Trening tt) throws ServerskiException {
        SONadjiTreninge sont=new SONadjiTreninge(tt);
        sont.izvrsiOperaciju();
        return sont.getListaNadjenih();
    }

    /**
     * Metoda koja poziva sistemsku operaciju za brisanje treninga iz baze podataka.
     * Ukoliko nastane greška prilikom brisanja, metoda baca izuzetak.
     *
     * @param tzb Trening kog je potrebno obrisati iz baze podataka.
     * @return Obrisani trening kao objekat klase OpstiDomenskiObjekat.
     * @throws ServerskiException Ukoliko nastane greška prilikom brisanja treninga u bazi.
     */
    public OpstiDomenskiObjekat obrisiTrening(Trening tzb) throws ServerskiException {
        SOObrisiTrening soot=new SOObrisiTrening(tzb);
        soot.izvrsiOperaciju();
        return soot.getObrisan();
    }

    /**
     * Metoda koja poziva sistemsku operaciju za izmenu podataka o treningu u bazi podataka.
     * Ukoliko nastane greška prilikom izmene, metoda baca izuzetak.
     *
     * @param tzi Trening čije informacije treba izmeniti.
     * @return Izmenjeni trening kao objekat klase OpstiDomenskiObjekat.
     * @throws ServerskiException Ukoliko nastane greška prilikom izmene treninga u bazi.
     */
    public OpstiDomenskiObjekat izmeniTrening(Trening tzi) throws ServerskiException {
        SOIzmeniTrening soit=new SOIzmeniTrening(tzi);
        soit.izvrsiOperaciju();
        return soit.getTrening();
    }

    

	/**
	 * Metoda koja poziva sistemsku operaciju za odjavu trenera iz sistema.
	 *
	 * @param ulogovan Trener koji želi da se odjavi.
	 * @throws ServerskiException Ukoliko nastane greška prilikom odjavljivanja trenera.
	 */
    public void izlogujTrenera(Trener ulogovan) throws ServerskiException {
        SOIzlogujTrenera soim = new SOIzlogujTrenera(ulogovan);
        soim.izvrsiOperaciju();
    }

    
    
    

    
    
    
    
}
