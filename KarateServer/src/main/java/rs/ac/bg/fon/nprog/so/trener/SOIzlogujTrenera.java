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
 *
 * @author HP
 */
public class SOIzlogujTrenera extends OpstaSO {
    
    private OpstiDomenskiObjekat trener;

    public SOIzlogujTrenera(OpstiDomenskiObjekat trener) {
        this.trener = trener;
    }

    @Override
    protected void izvrsiKonkretnuOperaciju() throws ServerskiException {
        int indeks = Kontroler.vratiInstancu().getListaKorisnika().indexOf(trener);
        if (indeks != -1) {
            ((Trener) Kontroler.vratiInstancu().getListaKorisnika().get(indeks)).setUlogovan(false);
        }
    }

    public OpstiDomenskiObjekat getTrener() {
        return trener;
    }

    public void setTrener(OpstiDomenskiObjekat trener) {
        this.trener = trener;
    }

    @Override
    protected void proveriPreduslov() throws ServerskiException {
    }
   
    
    
}
