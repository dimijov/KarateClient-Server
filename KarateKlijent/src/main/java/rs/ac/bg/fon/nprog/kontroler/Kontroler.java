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
import rs.ac.bg.fon.nprog.komunikacija.KomunikacijaSaServerom;
import rs.ac.bg.fon.nprog.konstante.Operacije;
import rs.ac.bg.fon.nprog.transfer.KlijentskiZahtev;
import rs.ac.bg.fon.nprog.transfer.ServerskiOdgovor;

/**
 *
 * @author HP
 */
public class Kontroler {
    
    private static Kontroler instanca;

    private Kontroler() {
    }

    public static Kontroler vratiInstancu() {
        if (instanca == null) {
            instanca = new Kontroler();
        }
        return instanca;
    }
    
    private Object posaljiZahtev(int operacija, Object parametar) throws Exception {
        KlijentskiZahtev kz = new KlijentskiZahtev();
        kz.setOperacija(operacija);
        kz.setParametar(parametar);
        KomunikacijaSaServerom.vratiInstancu().posaljiZahtev(kz);
        ServerskiOdgovor so = KomunikacijaSaServerom.vratiInstancu().procitajOdgovor();
        if (so.getUspesnost() == 1) {
            return so.getPodaci();
        } else {
            Exception ex = so.getException();
            throw ex;
        }
    }
    
     private Object posaljiZahtev(int operacija) throws Exception {
        return posaljiZahtev(operacija, null);
    }

    public OpstiDomenskiObjekat ulogujKorisnika(String username, String sifra) throws Exception {
        Trener t=new Trener(username, sifra);
        return (OpstiDomenskiObjekat) posaljiZahtev(Operacije.LOGIN, t);
    }

    public List<OpstiDomenskiObjekat> vratiGradove() throws Exception {
        return  (List<OpstiDomenskiObjekat>) posaljiZahtev(Operacije.VRATI_GRADOVE);
    }

    public List<OpstiDomenskiObjekat> vratiGrupe() throws Exception {
        return  (List<OpstiDomenskiObjekat>) posaljiZahtev(Operacije.VRATI_GRUPE);
    }

    public OpstiDomenskiObjekat sacuvajClana(Clan c) throws Exception {
        return (OpstiDomenskiObjekat) posaljiZahtev(Operacije.ZAPAMTI_CLANA, c);
    }

    public List<OpstiDomenskiObjekat> vratiClanove() throws Exception {
        return  (List<OpstiDomenskiObjekat>) posaljiZahtev(Operacije.VRATI_CLANOVE);
    }

    public List<OpstiDomenskiObjekat> nadjiClanove(Clan c) throws Exception {
         return (List<OpstiDomenskiObjekat>) posaljiZahtev(Operacije.NADJI_CLANOVE, c);
    }

    public Clan izmeniClana(Clan c) throws Exception {
        return (Clan) posaljiZahtev(Operacije.IZMENI_CLANA,c);
    }

    public Clan obrisiClana(Clan c) throws Exception {
        return (Clan) posaljiZahtev(Operacije.OBRISI_CLANA, c);
    }

    public List<OpstiDomenskiObjekat> vratiVezbe() throws Exception {
        return (List<OpstiDomenskiObjekat>) posaljiZahtev(Operacije.VRATI_VEZBE);
    }

    public List<OpstiDomenskiObjekat> vratiSale() throws Exception {
        return (List<OpstiDomenskiObjekat>) posaljiZahtev(Operacije.VRATI_SALE);
    }

    public OpstiDomenskiObjekat sacuvajTrening(Trening t) throws Exception {
        return (OpstiDomenskiObjekat) posaljiZahtev(Operacije.ZAPAMTI_TRENING, t);
    }

    public List<OpstiDomenskiObjekat> vratiTreninge(Trening t) throws Exception {
        return (List<OpstiDomenskiObjekat>) posaljiZahtev(Operacije.VRATI_TRENINGE, t);
    }

    public List<OpstiDomenskiObjekat> nadjiTreninge(Trening tr) throws Exception {
        return (List<OpstiDomenskiObjekat>) posaljiZahtev(Operacije.NADJI_TRENINGE, tr);
    }

    public OpstiDomenskiObjekat obrisiTrening(Trening trO) throws Exception {
        return (OpstiDomenskiObjekat) posaljiZahtev(Operacije.OBRISI_TRENING, trO);
    }

    public OpstiDomenskiObjekat izmeniTrening(Trening tre) throws Exception {
        return (OpstiDomenskiObjekat) posaljiZahtev(Operacije.IZMENI_TRENING, tre);
    }

    public OpstiDomenskiObjekat izlogujTrening(Trener ulogovaniTrener) throws Exception {
        return (OpstiDomenskiObjekat) posaljiZahtev(Operacije.IZLOGUJ_TRENERA, ulogovaniTrener);
    }
}
