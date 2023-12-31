/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package rs.ac.bg.fon.nprog.forme.clan;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import rs.ac.bg.fon.nprog.domen.Clan;
import rs.ac.bg.fon.nprog.domen.Grad;
import rs.ac.bg.fon.nprog.domen.Grupa;
import rs.ac.bg.fon.nprog.domen.OpstiDomenskiObjekat;
import rs.ac.bg.fon.nprog.exception.ValidacijaException;
import rs.ac.bg.fon.nprog.kontroler.Kontroler;


/**
 *
 * @author HP
 */
public class DodajClana extends javax.swing.JFrame {

    /**
     * Creates new form DodajClana
     */
    
    JFrame glavnaForma;
    Clan clan;
    String status;
    
    public DodajClana() {
        initComponents();
    }

    public DodajClana(JFrame glavna) {
        initComponents();
        this.setTitle("Unos člana");
        popuniCBGrad();
        popuniCBGrupa();
        this.glavnaForma = glavna;
        //clan = new Clan(0, "", "", null, "", "", null, null);
        clan=new Clan(0);
        txtClanID.setEnabled(false);
        this.status= "unos";
    }
    
    
    public DodajClana(JFrame glavna, Clan izabrani) {
        initComponents();
        this.setTitle("Izmena člana");
        popuniCBGrad();
        popuniCBGrupa();
        this.glavnaForma = glavna;
        txtClanID.setEnabled(false);
        this.clan = izabrani;
        popuniPolja();
        this.status = "izmena";
    }

    DodajClana(PretragaClana pretraga, Grupa izabrana) {
        initComponents();
        this.setTitle("Unos člana");
        popuniCBGrad();
        popuniCBGrupa();
        this.glavnaForma = pretraga;
        clan = new Clan(0, "", "", null, "", "", null, null);
        clan.setGrupa(izabrana);
        txtClanID.setEnabled(false);
        cbGrupa.setSelectedItem(izabrana);
        this.status= "unos";
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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtClanID = new javax.swing.JTextField();
        txtIme = new javax.swing.JTextField();
        txtPrezime = new javax.swing.JTextField();
        txtDatumRodjenja = new javax.swing.JTextField();
        txtAdresa = new javax.swing.JTextField();
        cbGrad = new javax.swing.JComboBox();
        cbGrupa = new javax.swing.JComboBox();
        btnOtkazi = new javax.swing.JButton();
        btnDodaj = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtBrojTelefona = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Unos člana", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("članID:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Ime:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Prezime:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Broj telefona:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Datum rođenja:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Adresa:");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("Grupa:");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText("Grad:");

        txtClanID.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        txtIme.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        txtPrezime.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        txtDatumRodjenja.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        txtAdresa.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        cbGrad.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        cbGrad.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cbGrupa.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        cbGrupa.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnOtkazi.setBackground(new java.awt.Color(204, 204, 204));
        btnOtkazi.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnOtkazi.setText("Otkaži");
        btnOtkazi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOtkaziActionPerformed(evt);
            }
        });

        btnDodaj.setBackground(new java.awt.Color(204, 204, 204));
        btnDodaj.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnDodaj.setText("Sačuvaj člana");
        btnDodaj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDodajActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setText("(dd.mm.yyyy)");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel10.setText("(+381)");

        txtBrojTelefona.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtClanID)
                            .addComponent(txtIme)
                            .addComponent(txtPrezime)
                            .addComponent(txtAdresa, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtDatumRodjenja, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cbGrad, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cbGrupa, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtBrojTelefona))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel10))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnDodaj)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnOtkazi, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtClanID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtIme, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPrezime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDatumRodjenja, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel9))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtAdresa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel10)
                    .addComponent(txtBrojTelefona, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(cbGrad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(cbGrupa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDodaj, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnOtkazi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnOtkaziActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOtkaziActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnOtkaziActionPerformed

    private void btnDodajActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDodajActionPerformed
        try {
            if(txtIme.getText().isEmpty() || txtPrezime.getText().isEmpty() || txtAdresa.getText().isEmpty() || txtBrojTelefona.getText().isEmpty()){
            throw new ValidacijaException("Sva polja su obavezna");
        }     
            String ime=txtIme.getText().trim();
            String prezime=txtPrezime.getText().trim();
            SimpleDateFormat sdf=new SimpleDateFormat("dd.MM.yyyy");
            sdf.setLenient(false);
            Date datumRodjenja=sdf.parse(txtDatumRodjenja.getText());
            String adresa=txtAdresa.getText().trim();
            String brojTelefona=txtBrojTelefona.getText().trim();
            Grad grad=(Grad) cbGrad.getSelectedItem();
            Grupa grupa=(Grupa) cbGrupa.getSelectedItem();
            postaviIproveriVrednosti(ime,prezime,datumRodjenja,adresa,brojTelefona,grad,grupa);
            Clan c;
        if (status.equals("unos")) {
                c=(Clan) Kontroler.vratiInstancu().sacuvajClana(clan);
                JOptionPane.showMessageDialog(this, "Uspešno ste uneli člana: "  + c.toString(),"Uspesno", JOptionPane.INFORMATION_MESSAGE);
            }else{
                c= Kontroler.vratiInstancu().izmeniClana(clan);
                JOptionPane.showMessageDialog(this, "Uspešno ste izmenili člana: "+ c.toString(),"Uspesno", JOptionPane.INFORMATION_MESSAGE);  
        }
            glavnaForma.setVisible(true);
            dispose();
        } catch (ValidacijaException ex) {
            Logger.getLogger(DodajClana.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Greška", JOptionPane.ERROR_MESSAGE);
        } catch (ParseException ex) {
            Logger.getLogger(DodajClana.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this,"Neispravno unet datum","Greška",JOptionPane.ERROR_MESSAGE);
        } catch (Exception ex) {
            Logger.getLogger(DodajClana.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "Sistem ne može da zapamti člana", "Greška", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnDodajActionPerformed
    
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
            java.util.logging.Logger.getLogger(DodajClana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DodajClana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DodajClana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DodajClana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DodajClana().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDodaj;
    private javax.swing.JButton btnOtkazi;
    private javax.swing.JComboBox cbGrad;
    private javax.swing.JComboBox cbGrupa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtAdresa;
    private javax.swing.JTextField txtBrojTelefona;
    private javax.swing.JTextField txtClanID;
    private javax.swing.JTextField txtDatumRodjenja;
    private javax.swing.JTextField txtIme;
    private javax.swing.JTextField txtPrezime;
    // End of variables declaration//GEN-END:variables

    private void popuniCBGrad() {
        try {
            List<OpstiDomenskiObjekat> listaGradova = Kontroler.vratiInstancu().vratiGradove();
            cbGrad.setModel(new DefaultComboBoxModel(listaGradova.toArray()));
            cbGrad.setSelectedItem(null);
        } catch (Exception ex) {
            Logger.getLogger(DodajClana.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }

    private void popuniCBGrupa() {
        try {
            List<OpstiDomenskiObjekat> listaGrupa = Kontroler.vratiInstancu().vratiGrupe();
            cbGrupa.setModel(new DefaultComboBoxModel(listaGrupa.toArray()));
            cbGrupa.setSelectedItem(null);
        } catch (Exception ex) {
            Logger.getLogger(DodajClana.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }

    private void postaviIproveriVrednosti(String ime, String prezime, Date datumRodjenja, String adresa, String brojTelefona, Grad grad, Grupa grupa) throws ValidacijaException {
        if(grad==null){
            throw new ValidacijaException("Morate izabrati grad");
        }
        
        if(grupa==null){
            throw new ValidacijaException("Morate izabrati grupu");
        }
        if(!ime.matches("[A-Z][a-zA-Z]*")){
            throw new ValidacijaException("Ime mora da sadrzi samo slova i pocetno slovo veliko");
        }
        
        if(!prezime.matches("[A-Z][a-zA-Z]*")){
            throw new ValidacijaException("Prezime mora da sadrzi samo slova i pocetno slovo veliko");
        }
        
        if(!datumRodjenja.before(new Date())){
            throw new ValidacijaException("Datum rodjenja nije u prošlosti (ili je trenutni datum)");
        }
        
        if (!brojTelefona.matches("^\\+381\\d{8,9}$")){
            throw new ValidacijaException("Broj telefona nije u formatu za Republiku Srbiju\n Pocinje sa +381 i ima 8 ili 9 cifara");
        }
        
        clan.setIme(ime);
        clan.setPrezime(prezime);
        clan.setDatumRodjenja(datumRodjenja);
        clan.setAdresa(adresa);
        clan.setBrojTelefona(brojTelefona);
        clan.setGrad(grad);
        clan.setGrupa(grupa);
        
    }

    private void popuniPolja() {
        txtIme.setText(clan.getIme());
        txtPrezime.setText(clan.getPrezime());
        txtAdresa.setText(clan.getAdresa());
        SimpleDateFormat sdf=new SimpleDateFormat("dd.MM.yyyy");
        txtDatumRodjenja.setText(sdf.format(clan.getDatumRodjenja()));
        txtBrojTelefona.setText(clan.getBrojTelefona());
        txtClanID.setText(clan.getClanID()+"");
        cbGrupa.setSelectedItem(clan.getGrupa());
        cbGrad.setSelectedItem(clan.getGrad());
    }
    
    
}
