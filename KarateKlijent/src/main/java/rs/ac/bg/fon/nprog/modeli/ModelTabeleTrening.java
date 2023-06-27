/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.bg.fon.nprog.modeli;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import rs.ac.bg.fon.nprog.domen.OpstiDomenskiObjekat;
import rs.ac.bg.fon.nprog.domen.Trening;

/**
 *
 * @author HP
 */
public class ModelTabeleTrening extends AbstractTableModel {
    
    List<OpstiDomenskiObjekat> lista = new ArrayList<>();
    String[] kolone ={"Trener","Datum i vreme","Trajanje","Grupa","Sala"};

    public ModelTabeleTrening(List<OpstiDomenskiObjekat> lista) {
        this.lista = lista;
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
    public Object getValueAt(int rowIndex, int columnIndex) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
        Trening tr = (Trening) lista.get(rowIndex);
        switch(columnIndex){
            
            case 0:
                return tr.getTrener().getIme()+" "+tr.getTrener().getPrezime();
            case 1:
                return sdf.format(tr.getDatumVreme());
            case 2:
                return tr.getTrajanje()+" min";
            case 3:
                return tr.getGrupa().toString();
            case 4:
                return tr.getSala().toString();
            default:
                return "";
        }
    }

    public List<OpstiDomenskiObjekat> getLista() {
        return lista;
    }
    
    @Override
    public String getColumnName(int column) {
        return kolone[column];
    }
    
    public void postaviStavke(List<OpstiDomenskiObjekat> stavke){
        //TREBA MI OVO VEROVATNO
    }
    
    
}
