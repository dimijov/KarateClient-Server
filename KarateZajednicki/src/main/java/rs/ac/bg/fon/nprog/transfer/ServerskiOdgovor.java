/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.bg.fon.nprog.transfer;

import java.io.Serializable;

/**
 *
 * @author HP
 */
public class ServerskiOdgovor implements Serializable {
    
    private Object podaci;
    private int uspesnost; // 1 - uspesno :) else neuspesno :(
    private Exception exception;

    public Object getPodaci() {
        return podaci;
    }

    public void setPodaci(Object podaci) {
        this.podaci = podaci;
    }

    public int getUspesnost() {
        return uspesnost;
    }

    public void setUspesnost(int uspesnost) {
        this.uspesnost = uspesnost;
    }

    public Exception getException() {
        return exception;
    }

    public void setException(Exception exception) {
        this.exception = exception;
    }
    
}
