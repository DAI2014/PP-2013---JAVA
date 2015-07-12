package ui;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.text.ParseException;
import javax.swing.JOptionPane;
import pg.EFactur;


public class Piloto {      
    
    public static void main(String[] args){
        EFactur sistema = EFactur.lerDoFicheiro();
        
        //sistema.inicializa();
        //sistema.gravar();
        /*
        
        try {                                                
            //Inicializa o sistema
           //sistema.inicializa();
            
            //Grava o objecto
            //sistema.gravar();
            
            //inicia o objecto gravado anteriormente
            
            ObjectInputStream ooin = new ObjectInputStream(new FileInputStream("GRAVA.OBJ"));
            sistema = (EFactur) ooin.readObject();
            ooin.close();
            
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, 
                    String.format("Ocorreu um erro ao inicializar o sistema: %s.\nO programa será encerrado.",
                        ex.getMessage()), 
                    "Erro fatal", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
        */
        //Uma vez que a JanelaLogin é modal, este método irá bloquear até que a janela seja fechada.
        //A janela só fecha quando os dados de login são válidos.                
        
        //JanelaLogin login = new JanelaLogin(sistema);               
        //login.setVisible(true);
    
        //JanelaPrincipal principal = new JanelaPrincipal(sistema);
        //principal.setVisible(true);
        Login login = new Login(sistema);
        login.setVisible(true);
        
    }

    
}
