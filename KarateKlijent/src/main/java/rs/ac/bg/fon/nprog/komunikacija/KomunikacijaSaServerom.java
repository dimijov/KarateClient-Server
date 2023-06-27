/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.bg.fon.nprog.komunikacija;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import rs.ac.bg.fon.nprog.transfer.KlijentskiZahtev;
import rs.ac.bg.fon.nprog.transfer.ServerskiOdgovor;


/**
 *
 * @author HP
 */
public class KomunikacijaSaServerom {
    
    private static KomunikacijaSaServerom instanca;
    
    private static Socket socket;
    ObjectInputStream in;
    ObjectOutputStream out;

    private KomunikacijaSaServerom() {
    }
    
    public static KomunikacijaSaServerom vratiInstancu(){
        if(instanca==null){
            instanca=new KomunikacijaSaServerom();
        }
        return instanca;
    }

    public Socket getSocket() {
        return socket;
    }

    public  void setSocket(Socket socket) {
        try {
            KomunikacijaSaServerom.socket = socket;
            out = new ObjectOutputStream(KomunikacijaSaServerom.socket.getOutputStream());  
            in = new ObjectInputStream(KomunikacijaSaServerom.socket.getInputStream());
        } catch (IOException ex) {
            Logger.getLogger(KomunikacijaSaServerom.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void posaljiZahtev(KlijentskiZahtev kt) throws IOException {
        out.writeUnshared(kt);
    }

    public ServerskiOdgovor procitajOdgovor() throws IOException, ClassNotFoundException  {
        return (ServerskiOdgovor) in.readUnshared();
    }
    
}
