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
 *
 * @author HP
 */
public class SOZapamtiTrening extends OpstaSO {
    OpstiDomenskiObjekat param;
    OpstiDomenskiObjekat trening;

    public SOZapamtiTrening(OpstiDomenskiObjekat param) {
    	super();
        this.param = param;
    }
    
    public SOZapamtiTrening(DBBroker dbb) {
    	super(dbb);
    }
    
    @Override
    protected void izvrsiKonkretnuOperaciju() throws ServerskiException {
        trening = dbb.sacuvajObjekat((Trening) param);
        sacuvajStavke();
    }

    public OpstiDomenskiObjekat getParam() {
        return param;
    }

    public OpstiDomenskiObjekat getTrening() {
        return trening;
    }
    
    public void setParam(OpstiDomenskiObjekat param) {
		this.param = param;
	}

    private void sacuvajStavke() throws ServerskiException {
        Trening tren = (Trening) param;
        List<OpstiDomenskiObjekat> stavke = tren.getListaStavki();
        for (OpstiDomenskiObjekat odo : stavke) {
            StavkaTreninga st = (StavkaTreninga) odo;
            dbb.sacuvajObjekat(st);
        }
    }
    
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
    
    

