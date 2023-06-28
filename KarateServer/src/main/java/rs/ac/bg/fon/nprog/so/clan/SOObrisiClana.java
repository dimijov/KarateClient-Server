/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.bg.fon.nprog.so.clan;

import rs.ac.bg.fon.nprog.domen.OpstiDomenskiObjekat;
import rs.ac.bg.fon.nprog.exception.ServerskiException;
import rs.ac.bg.fon.nprog.so.OpstaSO;

/**
 *
 * @author HP
 */
public class SOObrisiClana extends OpstaSO{
    
    private OpstiDomenskiObjekat param;
    private OpstiDomenskiObjekat obrisan;
    
    public SOObrisiClana(OpstiDomenskiObjekat param) {
        this.param = param;
    }
    
    @Override
    protected void izvrsiKonkretnuOperaciju() throws ServerskiException {
        obrisan = dbb.obrisiObjekat(param);
       
    }

    public OpstiDomenskiObjekat getObrisan() {
        return obrisan;
    }
    
    @Override
    protected void proveriPreduslov() throws ServerskiException {
    }
    
}
