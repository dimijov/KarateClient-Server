/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.bg.fon.nprog.modeli;


import java.util.ArrayList;
import java.util.List;
import javax.swing.JTextField;
import javax.swing.table.AbstractTableModel;
import rs.ac.bg.fon.nprog.domen.OpstiDomenskiObjekat;
import rs.ac.bg.fon.nprog.domen.StavkaTreninga;
import rs.ac.bg.fon.nprog.domen.Trening;
import rs.ac.bg.fon.nprog.domen.Vezba;
import rs.ac.bg.fon.nprog.exception.ValidacijaException;

/**
 *
 * @author HP
 */
public class ModelTabeleStavka extends AbstractTableModel {
    
    List<OpstiDomenskiObjekat> lista = new ArrayList<>();
    
    JTextField txtTrajanje;
    String tezina;
    int brojPonavljanja;
    
    String[] kolone = {"RB","Naziv vežbe", "Broj ponavljanja", "Trajanje"};
    
    public ModelTabeleStavka(List<OpstiDomenskiObjekat> lista) {
        this.lista = lista;
        
       
    }

    public ModelTabeleStavka() {
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
        StavkaTreninga st = (StavkaTreninga) lista.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return st.getRbStavke();
            case 1:
                return st.getVezba().getNaziv();
            case 2:
                return st.getBrojPonavljanja();
            case 3:
                return st.getTrajanje();
            default:
                return "-";
        }
    }
    
    @Override
    public String getColumnName(int column) {
        return kolone[column];
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        StavkaTreninga stavka = (StavkaTreninga) lista.get(rowIndex);
        String brojPonavljanjaStr = (String) aValue;
        try {
            int brojPonavljanja = Integer.parseInt(brojPonavljanjaStr);
            stavka.setBrojPonavljanja(brojPonavljanja);
            int tezina=vratiIntTezine(this.tezina);
            stavka.setTrajanje((stavka.getVezba().getDuzina()+tezina)* brojPonavljanja);
            postaviTrajanjeTxT();
            fireTableDataChanged();
        } catch (NumberFormatException nfe) {
            return;
        }
    }
    
    
    /*
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        if (columnIndex == 2) {
            return true;
        }
        return false;
    }
    */
    
    public void dodajStavku(Vezba vezba, Trening trening) throws ValidacijaException {
        StavkaTreninga stavka = daLiPostoji(vezba);
        if (stavka != null) {
            //AKO VEC POSTOJI
            int brojPonavljanja = getBrojPonavljanja();
            int tezina=vratiIntTezine(this.tezina);
            int trajanje=stavka.getTrajanje()+(stavka.getVezba().getDuzina()+tezina)* brojPonavljanja;
            stavka.setBrojPonavljanja(brojPonavljanja+stavka.getBrojPonavljanja());
            stavka.setTrajanje(trajanje);
            stavka.setTezina(this.tezina);
            
        } else {
            //AKO JE NOV
            stavka=new StavkaTreninga(lista.size()+1, trening,getBrojPonavljanja(), getTezina(), (vezba.getDuzina()+vratiIntTezine(tezina))*getBrojPonavljanja(), vezba);
            lista.add(stavka);
        }
        postaviTrajanjeTxT();
        fireTableDataChanged();
    }

  

    private int vratiIntTezine(String tezina) {
            if(tezina.trim().toLowerCase().equals("lako")){
                return -2;
            }
            if(tezina.trim().toLowerCase().equals("srednje")){
                return 0;
            }
            if(tezina.trim().toLowerCase().equals("tesko")){
                return 2;
            }
            return 5;
    }

    private void postaviTrajanjeTxT() {
        int trajanjeN = 0;
        for (OpstiDomenskiObjekat odo : lista) {
            StavkaTreninga stavka = (StavkaTreninga) odo;
            trajanjeN += stavka.getTrajanje();
        }
        this.txtTrajanje.setText(trajanjeN + "");
    }

    private StavkaTreninga daLiPostoji(Vezba vezba) throws ValidacijaException {
        for (OpstiDomenskiObjekat odo : lista) {
            StavkaTreninga st = (StavkaTreninga) odo;
            if (st.getVezba().equals(vezba)) {
                if(st.getTezina().equals(getTezina())){
                    return st;    
                }else{
                    throw new ValidacijaException("Stavka je već dodata pod određenom težinom: "+st.getTezina());
                }
            }
        }
        return null;
    }
    
    public void izbaciStavku(int red) {
        lista.remove(red);
        postaviTrajanjeTxT();
    }

    public void postaviRB() {
        int rb = 1;
        for (OpstiDomenskiObjekat odo : lista) {
            StavkaTreninga str = (StavkaTreninga) odo;
            str.setRbStavke(rb);
            rb++;
        }
        fireTableDataChanged();
    }

    public void setTxtTrajanje(JTextField txtTrajanje) {
        this.txtTrajanje = txtTrajanje;
    }

    public void setLista(List<OpstiDomenskiObjekat> lista) {
        this.lista = lista;
    }

    public void setTezina(String tezina) {
        this.tezina = tezina;
    }

    public String getTezina() {
        return tezina.trim();
    }

    
    public void setBrojPonavljanja(int brojPonavljanja) {
        this.brojPonavljanja = brojPonavljanja;
    }

    public int getBrojPonavljanja() {
        return brojPonavljanja;
    }

    public List<OpstiDomenskiObjekat> getLista() {
        return lista;
    }
    
    
    
    
    
    
    
    
    
}
