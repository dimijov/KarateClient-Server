/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.bg.fon.nprog.so;


import java.util.List;

import rs.ac.bg.fon.nprog.domen.Grad;
import rs.ac.bg.fon.nprog.domen.OpstiDomenskiObjekat;
import rs.ac.bg.fon.nprog.exception.ServerskiException;

/**
 *
 * @author HP
 */
public class SOVratiGradove extends OpstaSO {

    
     List<OpstiDomenskiObjekat> lista;
    
    
    @Override
    protected void izvrsiKonkretnuOperaciju() throws ServerskiException {
         lista = dbb.vratiSveObjekte(new Grad());
    }

    public List<OpstiDomenskiObjekat> getLista() {
        return lista;
    }
    
    @Override
    protected void proveriPreduslov() throws ServerskiException {
    }
    
}
