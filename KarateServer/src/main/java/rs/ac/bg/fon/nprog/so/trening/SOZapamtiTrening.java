/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.bg.fon.nprog.so.trening;


import java.util.Calendar;
import java.util.Date;
import java.util.List;

import rs.ac.bg.fon.nprog.db.DBBroker;
import rs.ac.bg.fon.nprog.domen.OpstiDomenskiObjekat;
import rs.ac.bg.fon.nprog.domen.StavkaTreninga;
import rs.ac.bg.fon.nprog.domen.Trening;
import rs.ac.bg.fon.nprog.exception.ServerskiException;
import rs.ac.bg.fon.nprog.so.OpstaSO;

/**
 * Klasa koja predstavlja sistemsku operaciju za pamćenje treninga karate kluba.
 * 
 * Klasa nasleđuje OpstaSO koja predstavlja apstraktnu sistemsku operaciju.
 * 
 * @author HP
 * @version 1.1.0
 */
public class SOZapamtiTrening extends OpstaSO {
	
	/**
     * Parametar koji predstavlja trening karate kluba koji treba sačuvati.
     */
    OpstiDomenskiObjekat param;
    
    /**
     * Sačuvani trening kao rezultat upita.
     */
    OpstiDomenskiObjekat trening;

    
    /**
     * Konstruktor koji prima parametar kao objekat klase OpstiDomenskiObjekat.
     * 
     * @param param Parametar koji predstavlja trening karate kluba koji treba sačuvati.
     */
    public SOZapamtiTrening(OpstiDomenskiObjekat param) {
    	super();
    	setParam(param);
    }
    
    
    /**
     * Konstruktor koji prima objekat klase DBBroker.
     * 
     * @param dbb Objekat klase DBBroker za komunikaciju sa bazom podataka.
     */
    public SOZapamtiTrening(DBBroker dbb) {
    	super(dbb);
    }
    
    
    /**
     * Metoda u kojoj se izvršava operacija pamćenja treninga karate kluba.
     * Rezultat operacije je objekat klase OpstiDomenskiObjekat koji predstavlja sačuvani trening.
     * 
     * @throws ServerskiException Ukoliko dođe do greške prilikom izvršavanja operacije.
     */
    @Override
    protected void izvrsiKonkretnuOperaciju() throws ServerskiException {
        trening = dbb.sacuvajObjekat((Trening) param);
        sacuvajStavke();
    }

    
    /**
     * Metoda koja vraća trening karate kluba koji treba sačuvati.
     * 
     * @return Parametar koji predstavlja trening karate kluba koji treba sačuvati.
     */
    public OpstiDomenskiObjekat getParam() {
        return param;
    }

    
    /**
     * Metoda koja vraća sačuvani trening karate kluba.
     * 
     * @return Objekat klase OpstiDomenskiObjekat koji predstavlja sačuvani trening karate kluba.
     */
    public OpstiDomenskiObjekat getTrening() {
        return trening;
    }
    
    
    /**
     * Metoda koja postavlja prosledjeni trening karate kluba koji treba sačuvati.
     * 
     * @param param Parametar koji predstavlja trening karate kluba koji treba sačuvati.
     */
    public void setParam(OpstiDomenskiObjekat param) {
		this.param = param;
	}

    
    /**
     * Privatna metoda koja vrši čuvanje stavki treninga.
     * 
     * @throws ServerskiException Ukoliko dođe do greške prilikom čuvanja stavki treninga.
     */
    private void sacuvajStavke() throws ServerskiException {
        Trening tren = (Trening) param;
        List<OpstiDomenskiObjekat> stavke = tren.getListaStavki();
        for (OpstiDomenskiObjekat odo : stavke) {
            StavkaTreninga st = (StavkaTreninga) odo;
            dbb.sacuvajObjekat(st);
        }
    }
    
    
    /**
     * Metoda koja proverava preduslove za izvršavanje operacije pamćenja treninga.
     * 
     * @throws ServerskiException Ukoliko preduslovi za izvršavanje operacije nisu ispunjeni.
     * Vreme treninga se preklapa sa vremenom nekog drugog treninga.
     */
    @Override
    protected void proveriPreduslov() throws ServerskiException {      
                List<OpstiDomenskiObjekat> treninzi=dbb.vratiSveObjekte(new Trening());                       
                //ucitajDetalje(treninzi);
                Trening zaProveru=(Trening) param;
                for (OpstiDomenskiObjekat o : treninzi) {
                        Trening izBaze=(Trening) o;

                        Date datumPocetka = izBaze.getDatumVreme();
                        
                        Calendar kalendar = Calendar.getInstance();
                        kalendar.setTime(datumPocetka);
                        kalendar.add(Calendar.MINUTE,izBaze.getTrajanje());
                        Date datumKraja=kalendar.getTime();
                        
                        
                        Date datumPocetkaParam = zaProveru.getDatumVreme();
                        
                        Calendar kalendarP = Calendar.getInstance();
                        kalendarP.setTime(datumPocetkaParam);
                        kalendarP.add(Calendar.MINUTE, (zaProveru.getTrajanje()));
                        Date datumKrajaParam=kalendarP.getTime();
                       
                       
                        if(datumPocetkaParam.before(datumKraja) && datumKrajaParam.after(datumPocetka) ){
                            if(zaProveru.getTrener().getTrenerID()==izBaze.getTrener().getTrenerID()){       
                                throw new ServerskiException("Ne mogu 2 razlicita treninga da budu u isto vreme za trenera!");
                            }else{
                                if (zaProveru.getSala().getSalaID()==izBaze.getSala().getSalaID())  throw new ServerskiException("Ne mogu 2 razlicita treninga da budu u isto vreme u istoj sali!");
                                else{
                                if (zaProveru.getGrupa().getGrupaID()==izBaze.getGrupa().getGrupaID())  throw new ServerskiException("Grupa vec ima trening u tom vremenu!");
                                }
                            }
                        }
                }
    	}

    
    }
    
    

