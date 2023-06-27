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

import rs.ac.bg.fon.nprog.domen.OpstiDomenskiObjekat;
import rs.ac.bg.fon.nprog.forme.ServerskaForma;



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
