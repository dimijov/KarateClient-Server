/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.bg.fon.nprog.modeli;


import java.util.List;
import javax.swing.table.AbstractTableModel;

import rs.ac.bg.fon.nprog.domen.OpstiDomenskiObjekat;
import rs.ac.bg.fon.nprog.domen.Vezba;

/**
 *
 * @author HP
 */
public class ModelTabeleVezba extends AbstractTableModel {
    
    List<OpstiDomenskiObjekat> lista;
    String[] kolone = {"Naziv","Opis", "Minuta"};
    
    public ModelTabeleVezba(List<OpstiDomenskiObjekat> vezbe) {
        this.lista = vezbe;
    }

    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return kolone.length;
    }
    
    @Override
    public String getColumnName(int column) {
        return kolone[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Vezba v = (Vezba) lista.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return v.getNaziv();
            case 1:
                return v.getOpis();
            case 2:
                return v.getDuzina();
            default:
                return " ";
        }  
    }

    public List<OpstiDomenskiObjekat> getLista() {
        return lista;
    }

    public void setLista(List<OpstiDomenskiObjekat> lista) {
        this.lista = lista;
    }
    
    
    
}
