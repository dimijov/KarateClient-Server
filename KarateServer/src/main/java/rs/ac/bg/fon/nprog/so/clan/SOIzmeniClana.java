/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.bg.fon.nprog.so.clan;

import rs.ac.bg.fon.nprog.db.DBBroker;
import rs.ac.bg.fon.nprog.domen.Clan;
import rs.ac.bg.fon.nprog.domen.OpstiDomenskiObjekat;
import rs.ac.bg.fon.nprog.exception.ServerskiException;
import rs.ac.bg.fon.nprog.so.OpstaSO;

/**
 *
 * @author HP
 */
public class SOIzmeniClana extends OpstaSO {
    
    private OpstiDomenskiObjekat param;
    private OpstiDomenskiObjekat clan;

    public SOIzmeniClana(OpstiDomenskiObjekat param) {
    	super();
        this.param = param;
    }
    
    public SOIzmeniClana(DBBroker dbb) {
        super(dbb);
    }

    @Override
    protected void izvrsiKonkretnuOperaciju() throws ServerskiException {
        clan = dbb.izmeniObjekat(param);
        
    }

    public OpstiDomenskiObjekat getParam() {
        return param;
    }

    public void setParam(OpstiDomenskiObjekat param) {
        this.param = param;
    }

    public OpstiDomenskiObjekat getClan() {
        return clan;
    }

    @Override
    protected void proveriPreduslov() throws ServerskiException {
    	if(!(param instanceof Clan) && param!=null) {
    		throw new ServerskiException("Poslati objekat nije odogvarajuce klase");
    	}
    }
    
    
}
