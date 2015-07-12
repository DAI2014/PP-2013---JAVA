
package ui;
import java.awt.Color;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import static javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE;
import pg.EFactur;
import pg.Utilizador;

public class Login extends javax.swing.JDialog {

    private EFactur sistema;
    String nif;
   public Login(EFactur sistema) {
       this.sistema = sistema;
        initComponents();
        
        getContentPane().setBackground(Color.DARK_GRAY);
       

        //Indica que a janela deve ser modal ou seja,
        //bloqueia a execução do programa até que a janela seja fechada
        this.setModal(true);           
        
        //Não permite o redimensionamento da janela
        this.setResizable(false);
        
        //Mostra a centralização da janela
        this.setLocationRelativeTo(null);
        
        //O processo de fecho da janela será controlado pelo programa
        this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);                                
        
        this.sistema = sistema;
        
        
   
  
      
        jTlogin.requestFocus();
    }   
    
    private void autenticar() {     
  
        String autenticar;
    
        //btnOk.addActionListener((ActionListener) this);
        //btnCancelar.addActionListener((ActionListener) this);
        if (jTlogin.getText().isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "Introduza p.f. o login!");            
            jTlogin.requestFocus();
            return;
        }
        
        if (jTpassword.getPassword().length == 0) {
            JOptionPane.showMessageDialog(rootPane, "Introduza p.f. a sua password!");
            jTpassword.requestFocus();
            return;
        }
        
        if(buttonGroup1.isSelected(null)){
            JOptionPane.showMessageDialog(rootPane, "Por favor selecione uma das opcoes de login!");
            return;
        } else { 
            if (rbAdministrador.isSelected()==true){
                autenticar = "Administrador";
            } else if(rbComerciante.isSelected()==true){
                autenticar = "Comerciante";
               } else { autenticar = "Consumidor";
        }
        
        if (sistema.login(jTlogin.getText(), new String(jTpassword.getPassword()),autenticar)==false){
            JOptionPane.showMessageDialog(this, "As credenciais introduzidas não correspondem a um utilizador válido.",
                     "Autenticação", JOptionPane.WARNING_MESSAGE);
            jTlogin.requestFocus();            
        }else{
            JOptionPane.showMessageDialog(this, "Autenticação efectuada com sucesso","Autenticação", JOptionPane.WARNING_MESSAGE);      
            
            if("Administrador".equals(autenticar)){
                MenuAdmin ma = new MenuAdmin(sistema);
                ma.setVisible(true);
                dispose();
               
            }else { if("Comerciante".equals(autenticar)){
                Utilizador ut = sistema.devolveComerciante(jTlogin.getText());                
                MenuComerciante mcm = new MenuComerciante(ut, sistema);
                mcm.setVisible(true);
                dispose();
            
        } else if("Consumidor".equals(autenticar)){
                Utilizador ut = sistema.devolveConsumidor(jTlogin.getText());
                MenuConsumidor mcn = new MenuConsumidor(sistema, ut);
                mcn.setVisible(true);
                dispose();               
    }
            }
    }
        }
        
    }
    @SuppressWarnings("unchecked")
    
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        buttonGroup4 = new javax.swing.ButtonGroup();
        buttonGroup5 = new javax.swing.ButtonGroup();
        buttonGroup6 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jTlogin = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTpassword = new javax.swing.JPasswordField();
        jBok = new javax.swing.JButton();
        jBCancelar = new javax.swing.JButton();
        rbConsumidor = new javax.swing.JRadioButton();
        rbComerciante = new javax.swing.JRadioButton();
        rbAdministrador = new javax.swing.JRadioButton();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(0, 0, 255));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jLabel1.setBackground(new java.awt.Color(204, 204, 255));
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Login:");

        jTlogin.setBackground(new java.awt.Color(204, 204, 255));
        jTlogin.setDisabledTextColor(java.awt.Color.blue);
        jTlogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTloginActionPerformed(evt);
            }
        });

        jLabel2.setBackground(new java.awt.Color(204, 204, 255));
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Password:");

        jTpassword.setBackground(new java.awt.Color(204, 204, 255));
        jTpassword.setDisabledTextColor(java.awt.Color.blue);

        jBok.setBackground(new java.awt.Color(204, 204, 255));
        jBok.setText("OK");
        jBok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBokActionPerformed(evt);
            }
        });

        jBCancelar.setBackground(new java.awt.Color(204, 204, 255));
        jBCancelar.setText("Cancelar");
        jBCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBCancelarActionPerformed(evt);
            }
        });

        rbConsumidor.setBackground(new java.awt.Color(204, 204, 255));
        buttonGroup1.add(rbConsumidor);
        rbConsumidor.setText("Consumidor");

        rbComerciante.setBackground(new java.awt.Color(204, 204, 255));
        buttonGroup1.add(rbComerciante);
        rbComerciante.setText("Comerciante");

        rbAdministrador.setBackground(new java.awt.Color(204, 204, 255));
        buttonGroup1.add(rbAdministrador);
        rbAdministrador.setText("Administador");
        rbAdministrador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbAdministradorActionPerformed(evt);
            }
        });

        jLabel3.setBackground(new java.awt.Color(204, 204, 255));
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ui/imagens/EFactur.png"))); // NOI18N

        jButton1.setText("jButton1");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(68, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTlogin, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)
                            .addComponent(jTpassword)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(139, 139, 139)
                        .addComponent(jBCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jBok, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(65, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(101, 101, 101)
                        .addComponent(jLabel3))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(rbConsumidor, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(rbComerciante, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(rbAdministrador, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jButton1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel1, jLabel2});

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jTlogin, jTpassword});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTlogin, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTpassword, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbAdministrador)
                    .addComponent(rbConsumidor)
                    .addComponent(rbComerciante))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBok, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jLabel1, jLabel2});

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {rbAdministrador, rbComerciante, rbConsumidor});

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jTlogin, jTpassword});

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jTloginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTloginActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTloginActionPerformed

    private void rbAdministradorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbAdministradorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbAdministradorActionPerformed

    private void jBokActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBokActionPerformed
    this.autenticar();
        
    }//GEN-LAST:event_jBokActionPerformed
    
    private void jBCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBCancelarActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jBCancelarActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
       System.exit(0);
    }//GEN-LAST:event_formWindowClosing
   
 
    
   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.ButtonGroup buttonGroup4;
    private javax.swing.ButtonGroup buttonGroup5;
    private javax.swing.ButtonGroup buttonGroup6;
    private javax.swing.JButton jBCancelar;
    private javax.swing.JButton jBok;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField jTlogin;
    private javax.swing.JPasswordField jTpassword;
    private javax.swing.JRadioButton rbAdministrador;
    private javax.swing.JRadioButton rbComerciante;
    private javax.swing.JRadioButton rbConsumidor;
    // End of variables declaration//GEN-END:variables
}
