/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.bg.fon.nprog.so.trener;

import java.util.List;

import rs.ac.bg.fon.nprog.domen.OpstiDomenskiObjekat;
import rs.ac.bg.fon.nprog.domen.Trener;
import rs.ac.bg.fon.nprog.exception.ServerskiException;
import rs.ac.bg.fon.nprog.kontroler.Kontroler;
import rs.ac.bg.fon.nprog.so.OpstaSO;

/**
 * Klasa koja predstavlja sistemsku operaciju za prijavljivanje trenera na sistem na osnovu unetih parametara.
 * Parametri koji se unose su korisnicko ime i lozinka.
 * Klasa nasleđuje OpstaSO koja predstavlja apstraktnu sistemsku operaciju.
 * 
 * @author HP
 * @version 1.0.0
 */
public class SOUlogujTrenera extends OpstaSO {

	
	/**
     * Uneti parametri za prijavljivanje trenera na sistem.
     * Predstavlja trenera sa korisnickim imenom i lozinkom.
     */
    private OpstiDomenskiObjekat unetiParametri;
    
    /**
     * Ulogovani trener kao rezultat prijavljivanja.
     */
    private OpstiDomenskiObjekat ulogovanKorisnik;
    
    
    /**
     * Metoda u kojoj se izvršava operacija prijavljivanja trenera na sistem na osnovu unetih parametara.
     * Parametri koji se unose su korisnicko ime i lozinka.
     * Rezultat operacije je ulogovan trener.
     * 
     * @throws ServerskiException 
     * Ukoliko dođe do greške prilikom izvršavanja operacije.
     * Konkretno ukoliko je trener vec ulogovan ili ukoliko ne postoji trener sa datim korsnickim imenom i lozinkom u bazi.
     */
    @Override
    protected void izvrsiKonkretnuOperaciju() throws ServerskiException {
        List<OpstiDomenskiObjekat> listaTrenera = dbb.vratiSveObjekte(new Trener());
        Trener unetiTrener = (Trener) unetiParametri;
        for (OpstiDomenskiObjekat t : listaTrenera) {
            Trener trenerIzBaze = (Trener) t;
            if (trenerIzBaze.getUsername().equals(unetiTrener.getUsername()) && trenerIzBaze.getPassword().equals(unetiTrener.getPassword())) {
                ulogovanKorisnik = trenerIzBaze;
                int indeks = Kontroler.vratiInstancu().getListaKorisnika().indexOf(trenerIzBaze);
                Trener izListe = (Trener) Kontroler.vratiInstancu().getListaKorisnika().get(indeks);
                if (izListe.isUlogovan()) {
                    throw new ServerskiException("Trener je vec ulogovan!");
                } else {
                    izListe.setUlogovan(true);
                }
                return;
            }
            }
        
        throw new ServerskiException("Nije pronadjen trener!");
    }

    
    /**
     * Metoda koja vraca ulogovanog trenera.
     * 
     * @return Ulogovan trener kao rezultat prijavljivanja.
     */
    public OpstiDomenskiObjekat getUlogovanKorisnik() {
        return ulogovanKorisnik;
    }

    /**
     * Metoda koja vraca prosledjene parametre trenera za prijavljivanje.
     * 
     * @return Uneti parametri za prijavljivanje trenera na sistem.
     */
    public OpstiDomenskiObjekat getUnetiParametri() {
        return unetiParametri;
    }

    
    /**
     * Metoda koja postavlja ulogovanog trenera.
     * 
     * @param ulogovanKorisnik Ulogovan trener kao rezultat prijavljivanja.
     */
    public void setUlogovanKorisnik(OpstiDomenskiObjekat ulogovanKorisnik) {
        this.ulogovanKorisnik = ulogovanKorisnik;
    }

    
    /**
     * Metoda koja postavlja prosledjene parametre trenera za prijavljivanje.
     * 
     * @param unetiParametri Uneti parametri za prijavljivanje trenera na sistem.
     */
    public void setUnetiParametri(OpstiDomenskiObjekat unetiParametri) {
        this.unetiParametri = unetiParametri;
    }
    
    @Override
    protected void proveriPreduslov() throws ServerskiException {
    }
    
    
    
}
