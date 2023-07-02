/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.bg.fon.nprog.exception;

/**
 * Izuzetak koji se koristi za označavanje serverskih grešaka.
 * Nasleđuje klasu Exception.
 * 
 * @author HP
 * @version 1.1.0
 */
public class ServerskiException extends Exception{
    
	/**
     * Konstruktor koji prima poruku izuzetkaa.
     * 
     * @param message Poruka izuzetka koja će se prikazati prilikom bacanja izuzetka.
     */
    public ServerskiException(String message) {
        super(message);
    }
    
}
