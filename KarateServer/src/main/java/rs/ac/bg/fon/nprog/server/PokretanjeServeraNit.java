/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.bg.fon.nprog.server;


import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import rs.ac.bg.fon.nprog.forme.ServerskaForma;

/**
 *
 * @author HP
 */
public class PokretanjeServeraNit extends Thread{
    
    private ServerSocket serverSocket;
    public static int brojPorta = 9000;
    static List<ObradaKlijentskihZahtevaNit> klijenti = new ArrayList<>();
    private static boolean radi = false;
    ServerskaForma sf;
    public PokretanjeServeraNit(ServerskaForma sf) {
            try {
                serverSocket = new ServerSocket(brojPorta);
                this.sf=sf;
                System.out.println("Pokrenut server");
            } catch (IOException ex) {
                Logger.getLogger(PokretanjeServeraNit.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("Serverski soket nije kreiran");
            }
    }

    @Override
    public void run() {
       
            while (!isInterrupted()) {
                try {
                    Socket socket = serverSocket.accept();
                    ObradaKlijentskihZahtevaNit okz = new ObradaKlijentskihZahtevaNit(socket, klijenti,sf);
                    okz.start();
                    klijenti.add(okz);
                    System.out.println("Klijent je povezan na server!");
                } catch (IOException ex) {
                    Logger.getLogger(PokretanjeServeraNit.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
    }

    public ServerSocket getServerSocket() {
        return serverSocket;
    }

    public void setServerSocket(ServerSocket serverSocket) {
        this.serverSocket = serverSocket;
    }

    public static boolean isRadi() {
        return radi;
    }

    public static void setRadi(boolean radi) {
        PokretanjeServeraNit.radi = radi;
    }

    
    public void zaustaviNiti() {
        
         try {
             serverSocket.close();
             for (ObradaKlijentskihZahtevaNit klijentNit : klijenti) {
                 klijentNit.getSocket().close();
             }
         } catch (IOException ex) {
             Logger.getLogger(PokretanjeServeraNit.class.getName()).log(Level.SEVERE, null, ex);
         }
       
    }

    
    
}
