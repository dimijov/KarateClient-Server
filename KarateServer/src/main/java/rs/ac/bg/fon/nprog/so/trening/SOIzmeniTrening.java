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
 * Klasa koja predstavlja sistemsku operaciju za izmenu treninga karate kluba.
 * 
 * Klasa nasleđuje OpstaSO koja predstavlja apstraktnu sistemsku operaciju.
 * 
 * @author HP
 * @version 1.1.0
 */
public class SOIzmeniTrening extends OpstaSO {
   
	
	/**
     * Parametar koji predstavlja trening karate kluba koji treba izmeniti.
     */
    private OpstiDomenskiObjekat param;
    
    /**
     * Izmenjeni trening kao rezultat upita.
     */
    private OpstiDomenskiObjekat trening;
    
    /**
     * Konstruktor koji prima parametar kao objekat klase OpstiDomenskiObjekat.
     * 
     * @param param Parametar koji predstavlja trening karate kluba koji treba izmeniti.
     */
    public SOIzmeniTrening(OpstiDomenskiObjekat param) {
    	super();
        this.param = param;
        
    }
    
    /**
     * Konstruktor koji prima objekat klase DBBroker.
     * 
     * @param dbb Objekat klase DBBroker za komunikaciju sa bazom podataka.
     */
    public SOIzmeniTrening(DBBroker dbb) {
    	super(dbb);
    }

    /**
     * Metoda u kojoj se vrši izvršavanje operacije izmene treninga karate kluba.
     * Rezultat operacije je objekat klase OpstiDomenskiObjekat koji predstavlja izmenjeni trening.
     * Stavke treninga se prvo brisu a zatim dodaju nove.
     * 
     * @throws ServerskiException Ukoliko dođe do greške prilikom izvršavanja operacije.
     */
    @Override
    protected void izvrsiKonkretnuOperaciju() throws ServerskiException {
        
            trening = dbb.izmeniObjekat(param);
            obrisiStavke(trening);
            postaviStavke(trening);
          
       
    }

    /**
     * Metoda koja vraća trening karate kluba koji treba izmeniti.
     * 
     * @return Parametar koji predstavlja trening karate kluba koji treba izmeniti.
     */
    public OpstiDomenskiObjekat getParam() {
        return param;
    }

    
    /**
     * Metoda koja postavlja prosledjeni trening karate kluba koji treba izmeniti.
     * 
     * @param param Parametar koji predstavlja trening karate kluba koji treba izmeniti.
     */
    public void setParam(OpstiDomenskiObjekat param) {
        this.param = param;
    }

    
    /**
     * Metoda koja vraća izmenjeni trening karate kluba.
     * 
     * @return Objekat klase OpstiDomenskiObjekat koji predstavlja izmenjeni trening karate kluba.
     */
    public OpstiDomenskiObjekat getTrening() {
        return trening;
    }

    
    /**
     * Privatna metoda koja vrši brisanje stavki treninga.
     * 
     * @param trening Objekat klase OpstiDomenskiObjekat koji predstavlja trening karate kluba.
     * @throws ServerskiException Ukoliko dođe do greške prilikom brisanja stavki treninga.
     */
    private void obrisiStavke(OpstiDomenskiObjekat trening) throws ServerskiException {
        Trening tr=(Trening) trening;
        List<OpstiDomenskiObjekat> stavkeBrisanje = dbb.vratiObjekte(new StavkaTreninga(tr));
        for (OpstiDomenskiObjekat odo : stavkeBrisanje) {
            StavkaTreninga st = (StavkaTreninga) odo;
            dbb.obrisiObjekat(st);
        }
    }
    
    /**
     * Privatna metoda koja postavlja stavke treninga.
     * 
     * @param izmenjeniTrening Objekat klase OpstiDomenskiObjekat koji predstavlja izmenjeni trening karate kluba.
     * @throws ServerskiException Ukoliko dođe do greške prilikom postavljanja stavki treninga.
     */
    private void postaviStavke(OpstiDomenskiObjekat izmenjeniTrening) throws ServerskiException {
        Trening t=(Trening) param;
        for (OpstiDomenskiObjekat odo : t.getListaStavki()) {
            StavkaTreninga st = (StavkaTreninga) odo;
            dbb.sacuvajObjekat(st);
        }
        Trening izmenjen=(Trening) izmenjeniTrening;
        izmenjen.setListaStavki(dbb.vratiObjekte(new StavkaTreninga(izmenjen)));
    }

    
    /**
     * Metoda koja proverava preduslove za izvršavanje operacije izmene treninga.
     * 
     * @throws ServerskiException Ukoliko preduslovi za izvršavanje operacije nisu ispunjeni.
     * Vreme treninga se preklapa sa vremenom nekog drugog treninga.
     */
    @Override
    protected void proveriPreduslov() throws ServerskiException { 
                List<OpstiDomenskiObjekat> treninzi=dbb.vratiSveObjekte(new Trening());                       
                Trening zaProveru=(Trening) param;
                for (OpstiDomenskiObjekat o : treninzi) {
                        Trening izBaze=(Trening) o;
                        Date datumPocetka = izBaze.getDatumVreme();
                       // System.out.println(datumPocetka);
                        Calendar kalendar = Calendar.getInstance();
                        kalendar.setTime(datumPocetka);
                        kalendar.add(Calendar.MINUTE,izBaze.getTrajanje());
                        Date datumKraja=kalendar.getTime();
                       // System.out.println(datumKraja);
                        
                        Date datumPocetkaParam = zaProveru.getDatumVreme();
                        //System.out.println(datumPocetkaParam);
                        Calendar kalendarP = Calendar.getInstance();
                        kalendarP.setTime(datumPocetkaParam);
                        kalendarP.add(Calendar.MINUTE, (zaProveru.getTrajanje()));
                        Date datumKrajaParam=kalendarP.getTime();
                        //System.out.println(datumKrajaParam);
                       
                        if(datumPocetkaParam.before(datumKraja) && datumKrajaParam.after(datumPocetka) ){
                            if(zaProveru.getTreningID()==izBaze.getTreningID()){                            
                            }else if(zaProveru.getTrener().getTrenerID()==izBaze.getTrener().getTrenerID() && izBaze.getTreningID()!=zaProveru.getTreningID()){       
                                throw new ServerskiException("Trener ima drugi trening u tom terminu");
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
