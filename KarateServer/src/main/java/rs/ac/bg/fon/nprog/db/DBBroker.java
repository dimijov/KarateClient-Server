/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.bg.fon.nprog.db;




import java.sql.ResultSet;
import java.sql.Statement;
import java.io.IOException;
import java.sql.Connection;
import java.util.logging.Level;
import java.util.logging.Logger;

import rs.ac.bg.fon.nprog.domen.OpstiDomenskiObjekat;
import rs.ac.bg.fon.nprog.exception.ServerskiException;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author HP
 */
public class DBBroker {
    
    private Connection konekcija;

    public DBBroker() {
    }
    
    
    public void uspostaviKonekciju() throws ServerskiException {
       
        try {
            String url = Util.getInstance().getURL();
            String user = Util.getInstance().getUser();
            String password = Util.getInstance().getPassword();
            konekcija = DriverManager.getConnection(url, user, password);
            konekcija.setAutoCommit(false);  
            
        }catch (IOException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
            throw new ServerskiException("Greska kod citanja iz properties fajla!");
            
        }catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
            throw new ServerskiException("Konekcija na bazu neuspesna!");
        }
    }

    public void raskiniKonekciju() throws ServerskiException {
        try {
            konekcija.close();
           
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
            throw new ServerskiException("Raskidanje konekcije neuspesno!");
        }
    }

    public void potvrdiTransakciju() throws ServerskiException {

        try {
            konekcija.commit();
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Nije uspela potvrda transakcije");
        }
   
    }

    public void ponistiTransakciju() {
        try {
            konekcija.rollback();
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Nije uspelo ponistavanje transakcije");

        }
        
    }

    public List<OpstiDomenskiObjekat> vratiSveObjekte(OpstiDomenskiObjekat odo) throws ServerskiException {
        try {
            String upit;
            if(odo.kolone()==null){
                upit = "SELECT * FROM " + odo.vratiImeTabele();
            }else{
                upit = "SELECT "+odo.kolone()+" FROM " + odo.vratiUslovZaJoin();
            }
            System.out.println(upit);
            Statement s = konekcija.createStatement();
            ResultSet rs = s.executeQuery(upit);
            List<OpstiDomenskiObjekat> listaObjekata = odo.RSuTabelu(rs);
            s.close();
            return listaObjekata;
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
            throw new ServerskiException("Sistem ne moze da prikaze podatke o " + odo.getClass().getName() + ".");
        }
        
    }

    public OpstiDomenskiObjekat sacuvajObjekat(OpstiDomenskiObjekat odo) throws ServerskiException {
         
        try {
            String upit = String.format("INSERT INTO %s VALUES (%s)", odo.vratiImeTabele(), odo.vratiParametre());
            System.out.println(upit);
            Statement s = konekcija.createStatement();
            s.executeUpdate(upit);
            ResultSet rs = s.executeQuery("SELECT LAST_INSERT_ID() as poslednjiID from " + odo.vratiImeTabele());
            while (rs.next()) {
                int lastid = rs.getInt("poslednjiID");
                odo.postaviVrednostPK(lastid);
                break;
            }
            s.close();
            return odo;            
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
            throw new ServerskiException("Sistem ne moze da zapamti "+odo.getClass().getName());
        }
    }

    
    public OpstiDomenskiObjekat izmeniObjekat(OpstiDomenskiObjekat odo) throws ServerskiException {
        try {
            String upit;
            if (odo.vratiPK() != null) {
                upit = String.format("UPDATE %s SET %s WHERE %s = %s", odo.vratiImeTabele(), odo.vratiUpdate(), odo.vratiPK(), odo.vratiVrednostPK());
            } else {
                upit = String.format("UPDATE %s SET %s WHERE %s", odo.vratiImeTabele(), odo.vratiUpdate(), odo.vratiSlozenPK());
            }
           
            Statement s = konekcija.createStatement();
            s.executeUpdate(upit);
            s.close();
            return odo;
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
            throw new ServerskiException("Sistem ne može da izmeni " + odo.getClass().getName() + ".");
        }
       
    }

    public OpstiDomenskiObjekat obrisiObjekat(OpstiDomenskiObjekat odo) throws ServerskiException {     
        try {
            String upit;
            if (odo.vratiPK() != null) {
                 upit = String.format("DELETE FROM %s WHERE %s = %s", odo.vratiImeTabele(), odo.vratiPK(), odo.vratiVrednostPK());
            } else {
                 upit = String.format("DELETE FROM %s WHERE %s", odo.vratiImeTabele(), odo.vratiSlozenPK());
            }
            Statement s = konekcija.createStatement();
            s.executeUpdate(upit);
            potvrdiTransakciju();
            s.close();
            return odo;
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
            throw new ServerskiException("Sistem ne može da obriše " + odo.getClass().getName() + ".");
        }
    }

    
    public List<OpstiDomenskiObjekat> vratiObjekte(OpstiDomenskiObjekat odo) throws ServerskiException {
        try {
            String upit = "SELECT "+odo.kolone()+" FROM " + odo.vratiUslovZaJoin()+" WHERE "+odo.vratiAtributPretrazivanja()+odo.vratiVrednostAtributa();
            System.out.println(upit);
            Statement s = konekcija.createStatement();
            ResultSet rs = s.executeQuery(upit);
            List<OpstiDomenskiObjekat> listaObjekata = odo.RSuTabelu(rs);
            s.close();
            return listaObjekata;
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
            throw new ServerskiException("Sistem ne moze da prikaze podatke o " + odo.getClass().getName() + ".");
        }
    }
    
    public List<OpstiDomenskiObjekat> nadjiObjekte(OpstiDomenskiObjekat odo) throws ServerskiException {
        try {
            String upit = "SELECT "+odo.kolone()+" FROM " + odo.vratiUslovZaJoin()+" WHERE "+odo.vratiAtributePretrazivanja();
            System.out.println(upit);
            Statement s = konekcija.createStatement();
            ResultSet rs = s.executeQuery(upit);
            List<OpstiDomenskiObjekat> listaObjekata = odo.RSuTabelu(rs);
            s.close();
            return listaObjekata;
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
            throw new ServerskiException("Sistem ne moze da prikaze podatke o " + odo.getClass().getName() + ".");
        }
    }
    
}
