/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.bg.fon.nprog.so.trening;

import rs.ac.bg.fon.nprog.exception.ServerskiException;
import rs.ac.bg.fon.nprog.so.OpstaSO;

import java.util.ArrayList;
import java.util.List;

import rs.ac.bg.fon.nprog.db.DBBroker;
import rs.ac.bg.fon.nprog.domen.OpstiDomenskiObjekat;

/**
 *
 * @author HP
 */
public class SOVratiTreninge extends OpstaSO {
    
    private List<OpstiDomenskiObjekat> listaTreninga;
    private OpstiDomenskiObjekat ulogovani;
    
    public SOVratiTreninge(OpstiDomenskiObjekat ulogovani) {
    	super();
        listaTreninga = new ArrayList<>();
        this.ulogovani=ulogovani;
    }
    
    public SOVratiTreninge(DBBroker dbb) {
    	super(dbb);
    }

    public List<OpstiDomenskiObjekat> getListaTreninga() {
        return listaTreninga;
    }
    
    public OpstiDomenskiObjekat getUlogovani() {
		return ulogovani;
	}
    
    public void setUlogovani(OpstiDomenskiObjekat ulogovani) {
		this.ulogovani = ulogovani;
	}

    @Override
    protected void izvrsiKonkretnuOperaciju() throws ServerskiException {
        listaTreninga = dbb.vratiObjekte(ulogovani);
       
    }
    
    @Override
    protected void proveriPreduslov() throws ServerskiException {
    }

}
