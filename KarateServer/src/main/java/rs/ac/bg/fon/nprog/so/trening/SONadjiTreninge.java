/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.bg.fon.nprog.so.trening;



import java.util.List;

import rs.ac.bg.fon.nprog.domen.OpstiDomenskiObjekat;
import rs.ac.bg.fon.nprog.domen.Trening;
import rs.ac.bg.fon.nprog.exception.ServerskiException;
import rs.ac.bg.fon.nprog.so.OpstaSO;

/**
 *
 * @author HP
 */
public class SONadjiTreninge extends OpstaSO {
    
    private Trening trening;
    private List<OpstiDomenskiObjekat> listaNadjenih;

    public SONadjiTreninge(Trening trening) {
        this.trening = trening;
    }

    @Override
    protected void izvrsiKonkretnuOperaciju() throws ServerskiException {
        
    	listaNadjenih=dbb.nadjiObjekte(trening);
        
    }

    public List<OpstiDomenskiObjekat> getListaNadjenih() {
        return listaNadjenih;
    }
    
    @Override
    protected void proveriPreduslov() throws ServerskiException {
    }
}