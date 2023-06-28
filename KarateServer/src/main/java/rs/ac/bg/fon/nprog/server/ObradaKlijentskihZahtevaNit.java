/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.bg.fon.nprog.server;


import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.SocketException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import rs.ac.bg.fon.nprog.domen.Clan;
import rs.ac.bg.fon.nprog.domen.OpstiDomenskiObjekat;
import rs.ac.bg.fon.nprog.domen.Trener;
import rs.ac.bg.fon.nprog.domen.Trening;
import rs.ac.bg.fon.nprog.exception.ServerskiException;
import rs.ac.bg.fon.nprog.forme.ServerskaForma;
import rs.ac.bg.fon.nprog.konstante.Operacije;
import rs.ac.bg.fon.nprog.kontroler.Kontroler;
import rs.ac.bg.fon.nprog.transfer.KlijentskiZahtev;
import rs.ac.bg.fon.nprog.transfer.ServerskiOdgovor;





/**
 *
 * @author HP
 */

public class ObradaKlijentskihZahtevaNit extends Thread {
    
    private Socket socket;
    private List<ObradaKlijentskihZahtevaNit> klijenti;
    ObjectInputStream in;
    ObjectOutputStream out;
    OpstiDomenskiObjekat korisnik;
    ServerskaForma sf;
    
    
    public ObradaKlijentskihZahtevaNit(Socket socket, List<ObradaKlijentskihZahtevaNit> klijenti,ServerskaForma sf) {
        this.socket = socket;
        this.klijenti = klijenti;
        this.sf=sf;
    }

    @Override
    public void run() {
        try {
            in = new ObjectInputStream(socket.getInputStream());
            out = new ObjectOutputStream(socket.getOutputStream());
            while(true){
                System.out.println("Cekam zahtev");
                KlijentskiZahtev kz=(KlijentskiZahtev) in.readUnshared();
                ServerskiOdgovor so=new ServerskiOdgovor();
                try{
                    int operacija=kz.getOperacija();
                    switch(operacija){
                        case Operacije.LOGIN:
                            Trener tren=(Trener) kz.getParametar();
                            korisnik=Kontroler.vratiInstancu().ulogujKosrisnika(tren);
                            sf.ubaciUlogovanog(korisnik);
                            so.setPodaci(korisnik);
                            break;
                        case Operacije.VRATI_GRADOVE:
                            List<OpstiDomenskiObjekat> listaGradova = Kontroler.vratiInstancu().vratiListuGradova();
                            so.setPodaci(listaGradova);
                            break;
                        case Operacije.VRATI_GRUPE:
                            List<OpstiDomenskiObjekat> listaGrupa = Kontroler.vratiInstancu().vratiListuGrupa();
                            so.setPodaci(listaGrupa);
                            break;
                        case Operacije.ZAPAMTI_CLANA:
                            Clan c = (Clan) kz.getParametar();
                            OpstiDomenskiObjekat clan = Kontroler.vratiInstancu().kreirajClana(c);
                            so.setPodaci(clan);
                            break;
                        case Operacije.VRATI_CLANOVE:
                            List<OpstiDomenskiObjekat> listaSvihClanova = Kontroler.vratiInstancu().vratiListuClanova();
                            so.setPodaci(listaSvihClanova);
                            break;
                        case Operacije.NADJI_CLANOVE:
                            Clan cl = (Clan) kz.getParametar();
                            List<OpstiDomenskiObjekat> listaClanova = Kontroler.vratiInstancu().pretraziClanove(cl);
                            so.setPodaci(listaClanova);
                            break;
                        case Operacije.IZMENI_CLANA:
                            Clan cla=(Clan) kz.getParametar();
                            OpstiDomenskiObjekat clanI=Kontroler.vratiInstancu().izmeniClana(cla);
                            so.setPodaci(clanI);
                            break;
                        case Operacije.OBRISI_CLANA:
                            Clan clao=(Clan) kz.getParametar();
                            OpstiDomenskiObjekat clanO=Kontroler.vratiInstancu().obrisiClana(clao);
                            so.setPodaci(clanO);
                            break;
                        case Operacije.VRATI_VEZBE:
                            List<OpstiDomenskiObjekat> listaVezbi = Kontroler.vratiInstancu().vratiListuVezbi();
                            so.setPodaci(listaVezbi);
                            break;
                        case Operacije.VRATI_SALE:
                            List<OpstiDomenskiObjekat> listaSala = Kontroler.vratiInstancu().vratiListuSala();
                            so.setPodaci(listaSala);
                            break;
                        case Operacije.ZAPAMTI_TRENING:
                            Trening tr=(Trening) kz.getParametar();
                            OpstiDomenskiObjekat trN=Kontroler.vratiInstancu().kreirajTrening(tr);
                            so.setPodaci(trN);
                            break;
                        case Operacije.VRATI_TRENINGE:
                            Trening trening1=(Trening) kz.getParametar();
                            List<OpstiDomenskiObjekat> treng=Kontroler.vratiInstancu().vratiTreninge(trening1);
                            so.setPodaci(treng);
                            break;
                        case Operacije.NADJI_TRENINGE:
                            Trening tt=(Trening) kz.getParametar();
                            List<OpstiDomenskiObjekat> nadjeni=Kontroler.vratiInstancu().nadjiTreninge(tt);
                            so.setPodaci(nadjeni);
                            break;
                        case Operacije.OBRISI_TRENING:
                            Trening tzb=(Trening) kz.getParametar();
                            OpstiDomenskiObjekat obrisan=Kontroler.vratiInstancu().obrisiTrening(tzb);
                            so.setPodaci(obrisan);
                            break;
                        case Operacije.IZMENI_TRENING:
                            Trening tzi=(Trening) kz.getParametar();
                            OpstiDomenskiObjekat izmenjen=Kontroler.vratiInstancu().izmeniTrening(tzi);
                            so.setPodaci(izmenjen);
                            break;
                        case Operacije.IZLOGUJ_TRENERA:
                            Trener ulogovan = (Trener) kz.getParametar();
                            Kontroler.vratiInstancu().izlogujTrenera(ulogovan);
                            break;
                    }
                    so.setUspesnost(1);
                 } catch (ServerskiException ex) {
                    so.setUspesnost(-1);
                    so.setException(ex);
                }
                    out.writeUnshared(so);
                //}
            }
       } catch (SocketException ex) {
            try {
                System.out.println("Klijent se iskljucuje ili logout...");
                Kontroler.vratiInstancu().izlogujTrenera((Trener) korisnik);
                sf.izbaciUlogovanog(korisnik);
                in.close();
                out.close();
                socket.close();
                klijenti.remove(this);
            } catch (IOException ex1) {
                Logger.getLogger(ObradaKlijentskihZahtevaNit.class.getName()).log(Level.SEVERE, null, ex1);
            } catch (ServerskiException ex1) {
                Logger.getLogger(ObradaKlijentskihZahtevaNit.class.getName()).log(Level.SEVERE, null, ex1);
            }
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(ObradaKlijentskihZahtevaNit.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
   
    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    public OpstiDomenskiObjekat getKorisnik() {
        return korisnik;
    }

    public void setKorisnik(OpstiDomenskiObjekat korisnik) {
        this.korisnik = korisnik;
    }

   
    
    
    
}
