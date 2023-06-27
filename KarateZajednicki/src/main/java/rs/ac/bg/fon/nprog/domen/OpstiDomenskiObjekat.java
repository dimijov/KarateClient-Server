/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package rs.ac.bg.fon.nprog.domen;

import java.io.Serializable;
import java.sql.ResultSet;
import java.util.List;

/**
 *
 * @author HP
 */
public interface OpstiDomenskiObjekat extends Serializable {
    
    public String vratiImeTabele();
    public String vratiParametre();
    public String vratiPK();
    public int vratiVrednostPK();
    public String vratiSlozenPK();
    public List<OpstiDomenskiObjekat> RSuTabelu(ResultSet rs);
    public String vratiUpdate();
    public void postaviVrednostPK(int pk);
    public String kolone();
    public String vratiUslovZaJoin();
    public String vratiAtributPretrazivanja();
    public String vratiVrednostAtributa();
    public String vratiAtributePretrazivanja();
    
}
