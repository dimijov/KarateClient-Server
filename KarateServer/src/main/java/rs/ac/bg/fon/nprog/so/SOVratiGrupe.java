/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.bg.fon.nprog.so;


import java.util.List;

import rs.ac.bg.fon.nprog.db.DBBroker;
import rs.ac.bg.fon.nprog.domen.Grupa;
import rs.ac.bg.fon.nprog.domen.OpstiDomenskiObjekat;
import rs.ac.bg.fon.nprog.exception.ServerskiException;

/**
 *
 * @author HP
 */
public class SOVratiGrupe extends OpstaSO {
    
     List<OpstiDomenskiObjekat> lista;

     public SOVratiGrupe() {
     	super();
     }
     
     public SOVratiGrupe(DBBroker dbb) {
     	super(dbb);
     }
     
     
    @Override
    protected void izvrsiKonkretnuOperaciju() throws ServerskiException {
        lista = dbb.vratiSveObjekte(new Grupa());
    }

    public List<OpstiDomenskiObjekat> getLista() {
        return lista;
    }
    
    @Override
    protected void proveriPreduslov() throws ServerskiException {
    }
    
    
}
