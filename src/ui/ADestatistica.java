
package ui;

import javax.swing.JOptionPane;
import pg.EFactur;


public class ADestatistica extends javax.swing.JFrame {
    EFactur sistema;
    public ADestatistica(EFactur sistema) {
        this.sistema = sistema;
        initComponents();
        pack();
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jCselector = new javax.swing.JComboBox();
        jTnif = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(800, 600));
        setPreferredSize(new java.awt.Dimension(800, 600));
        setResizable(false);

        jCselector.setBackground(new java.awt.Color(204, 204, 255));
        jCselector.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Faturacao Total", "Faturacao Por CAE", "Faturacao Por NIF", "Total de Beneficiarios", "Beneficios por NIF" }));
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

        jScrollPane1.setBackground(new java.awt.Color(204, 204, 255));

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jCselector, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jTnif, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 142, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCselector, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTnif, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(58, 58, 58)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(32, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jCselectorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCselectorActionPerformed
        switch (jCselector.getSelectedItem().toString()) {
            case "Faturacao Total":
                jTnif.setText("");
                jTnif.setVisible(false);
                jTextArea1.setText(sistema.totalFaturacao());
                pack();
                break;
            case "Faturacao Por CAE":
                jTnif.setText("");
                jTnif.setVisible(false);
                StringBuilder sb = new StringBuilder();
                sb.append(sistema.totalFatCAE("Cabeleireiro"));
                sb.append(sistema.totalFatCAE("Mecanico"));
                sb.append(sistema.totalFatCAE("Restauracao"));
                jTextArea1.setText(sb.toString());
                pack();
                break;
            case "Faturacao Por NIF":
                jTnif.setText("");
                jTnif.setVisible(true);
                pack();
                break;
            case "Total de Beneficiarios":
                jTnif.setText("");
                jTextArea1.setText(sistema.totalConsBeneficioMaximo());
                pack();
                break; 
            case "Beneficios por NIF":
                jTnif.setText("");
                jTnif.setVisible(true);       
                pack();
                break;
        }
    }//GEN-LAST:event_jCselectorActionPerformed

    private void jTnifActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTnifActionPerformed
            switch (jCselector.getSelectedItem().toString()) {
                case "Faturacao Por NIF":
                    if(sistema.devolveComerciante(jTnif.getText())!=null){
                    jTextArea1.setText(sistema.faturacaoPorNif(jTnif.getText()));
                    } else { JOptionPane.showMessageDialog(this, "NIF inserido invalido","NIF", JOptionPane.WARNING_MESSAGE);}
                    break;
                case "Beneficios por NIF":
                    if(sistema.devolveConsumidor(jTnif.getText())!=null){
                    jTextArea1.setText(sistema.devolveBenficiosPorNif(jTnif.getText()));
                    } else { JOptionPane.showMessageDialog(this, "NIF inserido invalido","NIF", JOptionPane.WARNING_MESSAGE);}
                    break;
            }
       
    }//GEN-LAST:event_jTnifActionPerformed

    /**
     * @param args the command line arguments
     */
   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox jCselector;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTnif;
    // End of variables declaration//GEN-END:variables
}
