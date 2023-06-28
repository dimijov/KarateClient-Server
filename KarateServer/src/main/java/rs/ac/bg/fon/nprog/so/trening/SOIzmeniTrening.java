/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.bg.fon.nprog.so.trening;


import java.util.Calendar;
import java.util.Date;
import java.util.List;

import rs.ac.bg.fon.nprog.domen.OpstiDomenskiObjekat;
import rs.ac.bg.fon.nprog.domen.StavkaTreninga;
import rs.ac.bg.fon.nprog.domen.Trening;
import rs.ac.bg.fon.nprog.exception.ServerskiException;
import rs.ac.bg.fon.nprog.so.OpstaSO;

/**
 *
 * @author HP
 */
public class SOIzmeniTrening extends OpstaSO {
   
    private OpstiDomenskiObjekat param;
    private OpstiDomenskiObjekat trening;
    
    
    public SOIzmeniTrening(OpstiDomenskiObjekat param) {
        this.param = param;
        
    }

    @Override
    protected void izvrsiKonkretnuOperaciju() throws ServerskiException {
        
            trening = dbb.izmeniObjekat(param);
            obrisiStavke(trening);
            postaviStavke(trening);
          
       
    }

    public OpstiDomenskiObjekat getParam() {
        return param;
    }

    public void setParam(OpstiDomenskiObjekat param) {
        this.param = param;
    }

    public OpstiDomenskiObjekat getTrening() {
        return trening;
    }

    private void obrisiStavke(OpstiDomenskiObjekat trening) throws ServerskiException {
        Trening tr=(Trening) trening;
        List<OpstiDomenskiObjekat> stavkeBrisanje = dbb.vratiObjekte(new StavkaTreninga(tr));
        for (OpstiDomenskiObjekat odo : stavkeBrisanje) {
            StavkaTreninga st = (StavkaTreninga) odo;
            dbb.obrisiObjekat(st);
        }
    }
    
    private void postaviStavke(OpstiDomenskiObjekat izmenjeniTrening) throws ServerskiException {
        Trening t=(Trening) param;
        for (OpstiDomenskiObjekat odo : t.getListaStavki()) {
            StavkaTreninga st = (StavkaTreninga) odo;
            dbb.sacuvajObjekat(st);
        }
        Trening izmenjen=(Trening) izmenjeniTrening;
        izmenjen.setListaStavki(dbb.vratiObjekte(new StavkaTreninga(izmenjen)));
    }

    
    @Override
    protected void proveriPreduslov() throws ServerskiException { 
                List<OpstiDomenskiObjekat> treninzi=dbb.vratiSveObjekte(new Trening());                       
                //ucitajDetalje(treninzi);
                Trening zaProveru=(Trening) param;
                for (OpstiDomenskiObjekat o : treninzi) {
                        Trening izBaze=(Trening) o;
                        
                        //System.out.println(izBaze.toString());
                        
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
/*
    private void ucitajDetalje(List<OpstiDomenskiObjekat> treninzi) throws ServerskiException {
        for (OpstiDomenskiObjekat tr : treninzi) {
            Trening trening = (Trening) tr;
            Grupa grupa = (Grupa) dbb.vratiObjekatPoKljucu(trening.getGrupa());
            Sala sala = (Sala) dbb.vratiObjekatPoKljucu(trening.getSala());
            Trener trener = (Trener) dbb.vratiObjekatPoKljucu(trening.getTrener());
            trening.setSala(sala);
            trening.setGrupa(grupa);
            trening.setTrener(trener);
        }
    }
*/
    
    
}
