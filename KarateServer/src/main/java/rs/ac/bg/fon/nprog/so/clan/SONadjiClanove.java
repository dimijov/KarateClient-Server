/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.bg.fon.nprog.so.clan;


import java.util.ArrayList;
import java.util.List;

import rs.ac.bg.fon.nprog.domen.Clan;
import rs.ac.bg.fon.nprog.domen.OpstiDomenskiObjekat;
import rs.ac.bg.fon.nprog.exception.ServerskiException;
import rs.ac.bg.fon.nprog.so.OpstaSO;

/**
 *
 * @author HP
 */
public class SONadjiClanove extends OpstaSO {
    
    List<OpstiDomenskiObjekat> lista = new ArrayList<>();
    Clan clan;

    public SONadjiClanove(Clan clan) {
        this.clan = clan;
    }

    @Override
    protected void izvrsiKonkretnuOperaciju() throws ServerskiException {
        
        if(clan.getGrupa().getNaziv().equals("Sve grupe")) {
            List<OpstiDomenskiObjekat> clanovi = dbb.vratiSveObjekte(new Clan());
            lista.addAll(clanovi);
        } else {
            List<OpstiDomenskiObjekat> clanovi=dbb.vratiObjekte(clan);
            lista.addAll(clanovi);           
          
        }
    }

    public List<OpstiDomenskiObjekat> getLista() {
        return lista;
    }
    
    @Override
    protected void proveriPreduslov() throws ServerskiException {
    }
    
    
    
    
}
