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
 *
 * @author HP
 */
public class Kontroler {
    private static Kontroler instanca;
    private List<OpstiDomenskiObjekat> listaKorisnika;

    private Kontroler() {
    }

    public static Kontroler vratiInstancu() {
        if (instanca == null) {
            instanca = new Kontroler();
        }
        return instanca;
    }

    public List<OpstiDomenskiObjekat> getListaKorisnika() throws ServerskiException {
       if (listaKorisnika == null) {
            listaKorisnika = vratiListuKorisnika();
        }
        return listaKorisnika;
    }

    private List<OpstiDomenskiObjekat> vratiListuKorisnika() throws ServerskiException {
        SOUcitajListuKorisnika souk = new SOUcitajListuKorisnika();
        souk.izvrsiOperaciju();
        return souk.getLista();
    }
    
    
    public OpstiDomenskiObjekat ulogujKosrisnika(Trener tren) throws ServerskiException {
        SOUlogujTrenera sot = new SOUlogujTrenera();
        sot.setUnetiParametri(tren);
        sot.izvrsiOperaciju();
        return sot.getUlogovanKorisnik();
    }

    public List<OpstiDomenskiObjekat> vratiListuGradova() throws ServerskiException {
        SOVratiGradove sov = new SOVratiGradove();
        sov.izvrsiOperaciju();
        return sov.getLista();
    }

    public List<OpstiDomenskiObjekat> vratiListuGrupa() throws ServerskiException {
        SOVratiGrupe sovg = new SOVratiGrupe();
        sovg.izvrsiOperaciju();
        return sovg.getLista();
    }

    public OpstiDomenskiObjekat kreirajClana(Clan c) throws ServerskiException {
        SOZapamtiClana soz = new SOZapamtiClana(c);
        soz.izvrsiOperaciju();
        return soz.getClan();
    }
    
    public List<OpstiDomenskiObjekat> vratiListuClanova() throws ServerskiException {
        SOVratiClanove sovc = new SOVratiClanove();
        sovc.izvrsiOperaciju();
        return sovc.getLista();
    }

    public List<OpstiDomenskiObjekat> pretraziClanove(Clan cl) throws ServerskiException {
        SONadjiClanove sonc=new SONadjiClanove(cl);
        sonc.izvrsiOperaciju();
        return sonc.getLista();
    }

    public OpstiDomenskiObjekat izmeniClana(Clan cla) throws ServerskiException {
        SOIzmeniClana soic=new SOIzmeniClana(cla);
        soic.izvrsiOperaciju();
        return soic.getClan();
    }

    public OpstiDomenskiObjekat obrisiClana(Clan clao) throws ServerskiException {
        SOObrisiClana sooc=new SOObrisiClana(clao);
        sooc.izvrsiOperaciju();
        return sooc.getObrisan();
    }

    public List<OpstiDomenskiObjekat> vratiListuVezbi() throws ServerskiException {
        SOVratiVezbe sovv=new SOVratiVezbe();
        sovv.izvrsiOperaciju();
        return sovv.getLista();
        
    }

    public List<OpstiDomenskiObjekat> vratiListuSala() throws ServerskiException {
        SOVratiSale sovs=new SOVratiSale();
        sovs.izvrsiOperaciju();
        return sovs.getLista();
    }

    public OpstiDomenskiObjekat kreirajTrening(Trening tr) throws ServerskiException {
        SOZapamtiTrening sozt=new SOZapamtiTrening(tr);
        sozt.izvrsiOperaciju();
        return sozt.getTrening();
    }

    public List<OpstiDomenskiObjekat> vratiTreninge(Trening trening1) throws ServerskiException {
        SOVratiTreninge sovt=new SOVratiTreninge(trening1);
        sovt.izvrsiOperaciju();
        return sovt.getListaTreninga();
    }

    public List<OpstiDomenskiObjekat> nadjiTreninge(Trening tt) throws ServerskiException {
        SONadjiTreninge sont=new SONadjiTreninge(tt);
        sont.izvrsiOperaciju();
        return sont.getListaNadjenih();
    }

    public OpstiDomenskiObjekat obrisiTrening(Trening tzb) throws ServerskiException {
        SOObrisiTrening soot=new SOObrisiTrening(tzb);
        soot.izvrsiOperaciju();
        return soot.getObrisan();
    }

    public OpstiDomenskiObjekat izmeniTrening(Trening tzi) throws ServerskiException {
        SOIzmeniTrening soit=new SOIzmeniTrening(tzi);
        soit.izvrsiOperaciju();
        return soit.getTrening();
    }

    public void izlogujTrenera(Trener ulogovan) throws ServerskiException {
        SOIzlogujTrenera soim = new SOIzlogujTrenera(ulogovan);
        soim.izvrsiOperaciju();
    }

    
    
    

    
    
    
    
}
