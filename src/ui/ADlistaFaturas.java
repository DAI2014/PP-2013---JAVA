
package ui;

import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import pg.EFactur;
import pg.Fatura;
import pg.FaturaLinha;
import pg.Utilizador;


public class ADlistaFaturas extends javax.swing.JFrame {
    EFactur sistema;
    Utilizador ut;
    public ADlistaFaturas(EFactur sistema) {
        this.sistema = sistema;
        initComponents();
        getContentPane().setBackground(Color.WHITE);
        jTfaturas.setForeground(Color.WHITE);
        jTfaturas.setBackground(Color.GRAY);
        jTlinhas.setForeground(Color.WHITE);
        jTlinhas.setBackground(Color.GRAY);
        jScrollPane2.setVisible(false);
        jTnif.setVisible(false);
        jCcae.setVisible(false);
        jCselector.setSelectedIndex(0);
        jLbeneficios.setVisible(false);
        jBeditar.setVisible(false);
        jBremover.setVisible(false);
        pack();
        lista("Todas");
    
    }
    
    private void lista(String parametro){
        
        ArrayList<Fatura> fat = new ArrayList<>();
        switch (jCselector.getSelectedItem().toString()) {
            case "Todas":
                fat = sistema.listaFaturas();
                break;              
            case "Por CAE":
                fat = sistema.listaFaturPorActividade(parametro);
                break;
            case "Por NIF":
                fat = sistema.listaPorNif(parametro); 
                break;
            
            
        }
        
        

            DefaultTableModel model = new DefaultTableModel();
            model.setColumnIdentifiers(new String[] {"Emissor", "Nome", "Receptor", "Tipo de Fatura", "Nº de Fatura", "Data", "Introduzido por", "Total"});
            
            for (Fatura p : fat){
            model.addRow(new String[] {p.getNifEmissor(), p.getNome(), p.getNifReceptor(), p.getTipoFatura(), p.getnFatura().toString(), p.getData().toString(), p.getIntrodPor(),String.valueOf(p.getTotalFatura())});
            }
            
            

            jTfaturas.setCellEditor(null);
            
            jTfaturas.setModel(model);
            
          
  
    }
    
     public boolean isCellEditable(int row, int column) {
       return false;
    }
     
    
    
    
    
    public void recebeNif(String nif){
        jBeditar.setVisible(true);
        jBremover.setVisible(true);
        jCselector.setSelectedIndex(2);
        jTnif.setText(nif);
        lista(nif);
        jCselector.setVisible(false);
        jTnif.setEnabled(false);
        if(sistema.devolveConsumidor(nif)!=null){
            jLbeneficios.setText("Total de Beneficios: " + sistema.devolveBenficiosPorNif(nif));
            jLbeneficios.setVisible(true);
        }
        pack();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTfaturas = new javax.swing.JTable();
        jCselector = new javax.swing.JComboBox();
        jTnif = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTlinhas = new javax.swing.JTable();
        jCcae = new javax.swing.JComboBox();
        jLbeneficios = new javax.swing.JLabel();
        jBeditar = new javax.swing.JButton();
        jBremover = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jScrollPane1.setBackground(new java.awt.Color(204, 204, 255));

        jTfaturas.setModel(new javax.swing.table.DefaultTableModel(
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
        jTfaturas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTfaturasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTfaturas);

        jCselector.setBackground(new java.awt.Color(204, 204, 255));
        jCselector.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Todas", "Por CAE", "Por NIF" }));
        jCselector.setSelectedIndex(-1);
        jCselector.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCselectorActionPerformed(evt);
            }
        });

        jTnif.setBackground(new java.awt.Color(204, 204, 255));
        jTnif.setDisabledTextColor(java.awt.Color.blue);
        jTnif.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTnifActionPerformed(evt);
            }
        });

        jTlinhas.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(jTlinhas);

        jCcae.setBackground(new java.awt.Color(204, 204, 255));
        jCcae.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Cabeleireiro", "Mecanico", "Restauracao" }));
        jCcae.setSelectedIndex(-1);
        jCcae.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCcaeActionPerformed(evt);
            }
        });

        jLbeneficios.setText("jLabel1");

        jBeditar.setText("Editar");
        jBeditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBeditarActionPerformed(evt);
            }
        });

        jBremover.setText("Remover");
        jBremover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBremoverActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jCcae, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jCselector, javax.swing.GroupLayout.Alignment.LEADING, 0, 159, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTnif, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                            .addComponent(jLbeneficios, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jBremover)
                        .addGap(18, 18, 18)
                        .addComponent(jBeditar, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 635, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCselector, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTnif, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(98, 98, 98)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(151, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jCcae, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(3, 3, 3)
                                    .addComponent(jLbeneficios, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jBeditar)
                                .addComponent(jBremover)))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 444, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jTfaturasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTfaturasMouseClicked
        
        
        jScrollPane2.setVisible(true);
        pack();
        ArrayList<Fatura> faturas = sistema.listaFaturas();
        jTfaturas.getSelectedRow();
        
        String nFatura = jTfaturas.getModel().getValueAt(jTfaturas.getSelectedRow(), 4).toString();
        String introPor = jTfaturas.getModel().getValueAt(jTfaturas.getSelectedRow(), 6).toString();
        for (Fatura p : faturas){
            if(p.getnFatura().equals(nFatura) && p.getIntrodPor().equals(introPor)){
                ArrayList<FaturaLinha> fl = p.imprimeLinha();
                DefaultTableModel model2 = new DefaultTableModel();
                model2.setColumnIdentifiers(new String[] {"Total","Taxa","Iva", "Base Tributavel"});
                jTlinhas.setModel(model2);
                for (FaturaLinha l : fl){
                    model2.addRow(new String[] {String.valueOf(l.getTotalLinha()),String.valueOf(l.getTaxa()),String.valueOf(l.getIva()),String.valueOf(l.getBaseTrib())});
                }
                
            }
            
        }

    }//GEN-LAST:event_jTfaturasMouseClicked

    private void jCselectorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCselectorActionPerformed
        switch (jCselector.getSelectedItem().toString()) {
            case "Por CAE":
                jCcae.setVisible(true);
                jTnif.setVisible(false);
                break;
            case "Por NIF":
                jTnif.setVisible(true);
                jCcae.setVisible(false);
                pack();
                break;
            case "Todas":
                jTnif.setVisible(false);
                jCcae.setVisible(false);
                lista("Todas");
                pack();
                break;
        }
    
    }//GEN-LAST:event_jCselectorActionPerformed

    private void jCcaeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCcaeActionPerformed
        switch (jCcae.getSelectedItem().toString()) {
            case "Mecanico":
                lista("Mecanico");
                break;
            case "Cabeleireiro":
                lista("Cabeleireiro");
                break;
            case "Restauracao":
                lista("Restauracao");
                break;
                
        }
    }//GEN-LAST:event_jCcaeActionPerformed

    private void jTnifActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTnifActionPerformed
       if(sistema.devolveComerciante(jTnif.getText())!=null){
           lista(jTnif.getText().toString());
        } else { JOptionPane.showMessageDialog(this, "NIF inserido invalido","NIF", JOptionPane.WARNING_MESSAGE);}
    }//GEN-LAST:event_jTnifActionPerformed

    private void jBeditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBeditarActionPerformed
        String nFatura = jTfaturas.getModel().getValueAt(jTfaturas.getSelectedRow(), 4).toString();
        String introPor = jTfaturas.getModel().getValueAt(jTfaturas.getSelectedRow(), 6).toString();
        ArrayList<Fatura> faturas = sistema.listaFaturas();
        for (Fatura f : faturas){
            if(f.getnFatura().equals(nFatura) && f.getIntrodPor().equals(introPor)){
                InsereFatManual ism = new InsereFatManual(sistema,f);
                ism.setVisible(true);
                
            }
        }
    }//GEN-LAST:event_jBeditarActionPerformed

    private void jBremoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBremoverActionPerformed
        Fatura f2 = null;
        String nFatura = jTfaturas.getModel().getValueAt(jTfaturas.getSelectedRow(), 4).toString();
        String introPor = jTfaturas.getModel().getValueAt(jTfaturas.getSelectedRow(), 6).toString();
        ArrayList<Fatura> faturas = sistema.listaFaturas();
        for (Fatura f : faturas){
            if(f.getnFatura().equals(nFatura) && f.getIntrodPor().equals(introPor)){
                f2 = f;
            }
        }
        sistema.removeFatura(f2);
        recebeNif(f2.getIntrodPor());
    }//GEN-LAST:event_jBremoverActionPerformed

    
   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBeditar;
    private javax.swing.JButton jBremover;
    private javax.swing.JComboBox jCcae;
    private javax.swing.JComboBox jCselector;
    private javax.swing.JLabel jLbeneficios;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTfaturas;
    private javax.swing.JTable jTlinhas;
    private javax.swing.JTextField jTnif;
    // End of variables declaration//GEN-END:variables
}
