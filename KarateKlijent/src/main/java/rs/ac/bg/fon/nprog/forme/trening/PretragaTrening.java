/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package rs.ac.bg.fon.nprog.forme.trening;

import com.toedter.calendar.JCalendar;

import rs.ac.bg.fon.nprog.domen.OpstiDomenskiObjekat;
import rs.ac.bg.fon.nprog.domen.Trener;
import rs.ac.bg.fon.nprog.domen.Trening;
import rs.ac.bg.fon.nprog.kontroler.Kontroler;
import rs.ac.bg.fon.nprog.modeli.ModelTabeleTrening;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;


/**
 *
 * @author HP
 */
public class PretragaTrening extends javax.swing.JFrame {

    /**
     * Creates new form PretragaTrening
     */
    
    JFrame glavna;
    ModelTabeleTrening mtt;
    Trener ulogovaniTrener;
    
    
    public PretragaTrening() {
        initComponents();
    }
    
    public PretragaTrening(JFrame glavna, Trener ulogovaniTrener) {
        initComponents();
        this.glavna = glavna;
        this.ulogovaniTrener = ulogovaniTrener;
        srediTabelu();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaTrening = new javax.swing.JTable();
        btnIzmeni = new javax.swing.JButton();
        btnObrisi = new javax.swing.JButton();
        btnOtkazi = new javax.swing.JButton();
        kalendar = new com.toedter.calendar.JCalendar();
        jLabel1 = new javax.swing.JLabel();
        btnPretraga = new javax.swing.JButton();
        btnPretraga1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Pretraga", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N

        tabelaTrening.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tabelaTrening);

        btnIzmeni.setBackground(new java.awt.Color(204, 204, 204));
        btnIzmeni.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnIzmeni.setText("Izmeni trening");
        btnIzmeni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIzmeniActionPerformed(evt);
            }
        });

        btnObrisi.setBackground(new java.awt.Color(204, 204, 204));
        btnObrisi.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnObrisi.setText("Obriši trening");
        btnObrisi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnObrisiActionPerformed(evt);
            }
        });

        btnOtkazi.setBackground(new java.awt.Color(204, 204, 204));
        btnOtkazi.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnOtkazi.setText("Otkaži");
        btnOtkazi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOtkaziActionPerformed(evt);
            }
        });

        kalendar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 102, 0));
        jLabel1.setText("Izaberi datum :");

        btnPretraga.setBackground(new java.awt.Color(204, 204, 204));
        btnPretraga.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnPretraga.setText("Pretraga");
        btnPretraga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPretragaActionPerformed(evt);
            }
        });

        btnPretraga1.setBackground(new java.awt.Color(204, 204, 204));
        btnPretraga1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnPretraga1.setText("Prikaži sve");
        btnPretraga1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPretraga1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnIzmeni)
                                .addGap(18, 18, 18)
                                .addComponent(btnObrisi, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnOtkazi, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 539, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnPretraga, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(btnPretraga1, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addComponent(kalendar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(39, 39, 39))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(kalendar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnPretraga, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnPretraga1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnIzmeni, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnOtkazi, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnObrisi, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 570, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnOtkaziActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOtkaziActionPerformed
        dispose();
    }//GEN-LAST:event_btnOtkaziActionPerformed

    private void btnPretragaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPretragaActionPerformed

        if(!daLiJeSelektovanDatum(kalendar)){
            try {
                Trening zaSlanje=new Trening();
                zaSlanje.setTrener(ulogovaniTrener);
                List<OpstiDomenskiObjekat> listaSve = Kontroler.vratiInstancu().vratiTreninge(zaSlanje);
                mtt = new ModelTabeleTrening(listaSve);
                tabelaTrening.setModel(mtt);
            } catch (Exception ex) {
                Logger.getLogger(PretragaTrening.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(this, ex.getMessage(), "Greška", JOptionPane.ERROR_MESSAGE);
            }
        }else{
            try {
                Date datumPretraga=kalendar.getDate();
                SimpleDateFormat sdf=new SimpleDateFormat("dd.MM.yyyy");
                String datum=sdf.format(datumPretraga);
                Trening tr=new Trening();
                tr.setTrener(ulogovaniTrener);
                tr.setDatumVreme(datumPretraga);
                List<OpstiDomenskiObjekat> listaTogDana = Kontroler.vratiInstancu().nadjiTreninge(tr);
                mtt = new ModelTabeleTrening(listaTogDana);
                tabelaTrening.setModel(mtt);
            } catch (Exception ex) {
                Logger.getLogger(PretragaTrening.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(this, ex.getMessage(), "Greška", JOptionPane.ERROR_MESSAGE);
            }
        }
    
    }//GEN-LAST:event_btnPretragaActionPerformed

    private void btnPretraga1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPretraga1ActionPerformed
        try {
            Trening zaSlanje=new Trening();
            zaSlanje.setTrener(ulogovaniTrener);
            List<OpstiDomenskiObjekat> listaSve = Kontroler.vratiInstancu().vratiTreninge(zaSlanje);
            mtt = new ModelTabeleTrening(listaSve);
            tabelaTrening.setModel(mtt);
        } catch (Exception ex) {
            Logger.getLogger(PretragaTrening.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Greška", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnPretraga1ActionPerformed

    private void btnObrisiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnObrisiActionPerformed
        int red = tabelaTrening.getSelectedRow();
        if (red != -1) {
            Trening trening = (Trening) mtt.getLista().get(red);
            int odluka = JOptionPane.showConfirmDialog(this, "Da li ste sigurni da želite da obrišete trening! " + trening.toString() + "?", "", JOptionPane.WARNING_MESSAGE);
            if (odluka == 0) {
                try {
                    Trening obrisan =(Trening) Kontroler.vratiInstancu().obrisiTrening(trening);
                    JOptionPane.showMessageDialog(this, "Uspešno ste obrisali trening.", "Obaveštenje", JOptionPane.INFORMATION_MESSAGE);
                    srediTabelu();
                } catch (Exception ex) {
                    Logger.getLogger(PretragaTrening.class.getName()).log(Level.SEVERE, null, ex);
                    JOptionPane.showMessageDialog(this, "Došlo je do greške prilikom brisanja treninga!", "Greška", JOptionPane.ERROR_MESSAGE);
                }
            }
        }else{
            JOptionPane.showMessageDialog(this, "Izaberite trening koji želite da obrišete!", "Greška", JOptionPane.ERROR_MESSAGE);
        }   
    }//GEN-LAST:event_btnObrisiActionPerformed

    private void btnIzmeniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIzmeniActionPerformed
       int red = tabelaTrening.getSelectedRow();
        if (red == -1) {
            JOptionPane.showMessageDialog(rootPane, "Izaberite trening koji želite da izmenite!", "Greška", JOptionPane.INFORMATION_MESSAGE);
        } else {
            Trening izabrani = (Trening) mtt.getLista().get(red);    
            DodajTrening dtr = new DodajTrening(this, izabrani);
            dtr.setVisible(true);
            this.setVisible(false);
        }  
    }//GEN-LAST:event_btnIzmeniActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PretragaTrening.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PretragaTrening.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PretragaTrening.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PretragaTrening.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PretragaTrening().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnIzmeni;
    private javax.swing.JButton btnObrisi;
    private javax.swing.JButton btnOtkazi;
    private javax.swing.JButton btnPretraga;
    private javax.swing.JButton btnPretraga1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private com.toedter.calendar.JCalendar kalendar;
    private javax.swing.JTable tabelaTrening;
    // End of variables declaration//GEN-END:variables

    private void srediTabelu() {
        try {
            Trening zaSlanje=new Trening();
            zaSlanje.setTrener(ulogovaniTrener);
            List<OpstiDomenskiObjekat> listaTreninga = Kontroler.vratiInstancu().vratiTreninge(zaSlanje);
            mtt = new ModelTabeleTrening(listaTreninga);
            tabelaTrening.setModel(mtt);
        } catch (Exception ex) {
            Logger.getLogger(PretragaTrening.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "Došlo je do greške kod učitavanja treninga", "Greška", JOptionPane.ERROR_MESSAGE);
        }
            
    }
    
    
    private boolean daLiJeSelektovanDatum(JCalendar kal){
        Date selectedDate = kalendar.getDate();
        return selectedDate != null;
    }

    
}
