/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.bg.fon.nprog.so;

import rs.ac.bg.fon.nprog.db.DBBroker;
import rs.ac.bg.fon.nprog.exception.ServerskiException;

/**
 *
 * @author HP
 */
public abstract class OpstaSO {
    
    
    protected DBBroker dbb;

    public OpstaSO() {
        this.dbb = new DBBroker();
    }
    
    public OpstaSO(DBBroker dbb) {
    	this.dbb=dbb;
    }

    synchronized public void izvrsiOperaciju() throws ServerskiException {
        otvoriKonekciju();
        try {
            proveriPreduslov();
            izvrsiKonkretnuOperaciju();
            potvrdiTransakciju();
        } catch (ServerskiException e) {
            ponistiTransakciju();
            throw e;
        } finally {
            zatvoriKonekciju();
        }
    }

    private void potvrdiTransakciju() throws ServerskiException {
        dbb.potvrdiTransakciju();
    }

    private void ponistiTransakciju() {
        dbb.ponistiTransakciju();
    }

    private void zatvoriKonekciju() throws ServerskiException {
        dbb.raskiniKonekciju();
    }

    private void otvoriKonekciju() throws ServerskiException {
        dbb.uspostaviKonekciju();
    }

    protected abstract void proveriPreduslov() throws ServerskiException;
    
    protected abstract void izvrsiKonkretnuOperaciju() throws ServerskiException;
}
