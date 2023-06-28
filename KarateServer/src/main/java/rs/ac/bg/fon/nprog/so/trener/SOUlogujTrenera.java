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
 *
 * @author HP
 */
public class SOUlogujTrenera extends OpstaSO {

    private OpstiDomenskiObjekat unetiParametri;
    private OpstiDomenskiObjekat ulogovanKorisnik;
    
    
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

    public OpstiDomenskiObjekat getUlogovanKorisnik() {
        return ulogovanKorisnik;
    }

    public OpstiDomenskiObjekat getUnetiParametri() {
        return unetiParametri;
    }

    public void setUlogovanKorisnik(OpstiDomenskiObjekat ulogovanKorisnik) {
        this.ulogovanKorisnik = ulogovanKorisnik;
    }

    public void setUnetiParametri(OpstiDomenskiObjekat unetiParametri) {
        this.unetiParametri = unetiParametri;
    }
    
    @Override
    protected void proveriPreduslov() throws ServerskiException {
    }
    
    
    
}
