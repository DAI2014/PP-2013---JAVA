package pg;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.swing.JOptionPane;

public class EFactur implements Serializable {
    
    public static final String NOME_DB = "GRAVA.OBJ";

    // mudar de public para private
    public ListaComerciantes lcom = new ListaComerciantes();
    public ListaConsumidores lcon = new ListaConsumidores();
    public ListaFaturas lfat = new ListaFaturas();
    public ListaAdministrador ladmin = new ListaAdministrador();
   
    

    public EFactur() {
        
        
        
       
    }
    
   
    
    
    public void inicializa(){
        
        Consumidor cs1 = new Consumidor("231808569", "Nuno Freitas","Jagas","454545455","","443223333", "Nuno");
        Comerciante cm2 = new Comerciante("123456789", "Paulo Gomes","Lapinha","808808808","686868568","345345345", "Paulo", "Cabeleireiro");
        Comerciante cm3 = new Comerciante("112233445", "Carlos Gomes","Vitoria city", "222333444","333444555","444555666", "Carlos", "Mecanico");
        Consumidor cs2 = new Consumidor("24423142", "John Celeron","Marocos", "111222333","555666777","666777888", "Cele");
        Administrador a1 = new Administrador("Admin", "12345");
        Comerciante cm1 = new Comerciante("456789123", "Pote Rigel","Food land", "777888999","888999000","999000111", "Pote", "Cabeleireiro");
        Comerciante cm4 = new Comerciante("123456784", "Vieira","Amesterdao","000111222","111122222","2222333333", "Schooles", "Cabeleireiro");
        Comerciante cm5 = new Comerciante("123456783", "Facadas","Moveis city","333344444","444455555","5555666666", "Francisco", "Restauracao");
        Comerciante cm6 = new Comerciante("123456782", "Ze Pote","Super moveis city", "666677777","7777888888","888899999", "Costa", "Restauracao");
        
        lcom.insereComerciante(cm1);
        lcon.insereConsumidor(cs1);
        lcom.insereComerciante(cm2);
        lcom.insereComerciante(cm3);
        lcom.insereComerciante(cm4);
        lcom.insereComerciante(cm5);
        lcom.insereComerciante(cm6);
        lcon.insereConsumidor(cs2);
        ladmin.insereAdmin(a1);
        
        Fatura f1 = new Fatura("112233445", cs1.getNome(), "231808569", "tipo", "1", "2013/04/20", "231808569", 0);

        FaturaLinha fl1 = new FaturaLinha(10000, 12);
        FaturaLinha fl2 = new FaturaLinha(20, 23);

        f1.linhas.add(fl1);
        f1.linhas.add(fl2);

        f1.actualizaTotalDeLinhas();
        FaturaLinha fl3 = new FaturaLinha(400, 23);
        f1.linhas.add(fl3);
        f1.actualizaTotalDeLinhas();
        insereFaturaConsumidor(f1);


        Fatura f2 = new Fatura("123456789", cs2.getNome(), "24423142", "tipo", "2", "2013/04/22", "24423142", 0);
        FaturaLinha f21 = new FaturaLinha(30, 12);
        FaturaLinha f22 = new FaturaLinha(5000, 23);
        f2.linhas.add(f21);
        f2.linhas.add(f22);
        f2.actualizaTotalDeLinhas();
        insereFaturaConsumidor(f2);

        Fatura f3 = new Fatura("123456789", cs2.getNome(), "24423142", "tipo", "3", "2013/04/22", "24423142", 0);
        FaturaLinha f31 = new FaturaLinha(56, 12);
        FaturaLinha f32 = new FaturaLinha(34, 23);
        f3.linhas.add(f31);
        f3.linhas.add(f32);
        f3.actualizaTotalDeLinhas();
        insereFaturaConsumidor(f3);

        Fatura f4 = new Fatura("456789123", cs2.getNome(), "24423142", "tipo", "4", "2013/04/22", "24423142", 0);
        FaturaLinha f41 = new FaturaLinha(455, 12);
        FaturaLinha f42 = new FaturaLinha(56, 23);
        f4.linhas.add(f41);
        f4.linhas.add(f42);
        f4.actualizaTotalDeLinhas();
        insereFaturaConsumidor(f4);

        Fatura f9 = new Fatura("123456789", cs2.getNome(), "24423142", "tipo", "5", "2013/04/22", "24423142", 0);
        FaturaLinha f91 = new FaturaLinha(30, 12);
        FaturaLinha f92 = new FaturaLinha(456, 23);
        f9.linhas.add(f91);
        f9.linhas.add(f92);
        f9.actualizaTotalDeLinhas();
        insereFaturaConsumidor(f9);
        
        Fatura f11 = new Fatura("112233445", cs2.getNome(), "24423142", "tipo", "2", "2013/04/22", "24423142", 0);
        FaturaLinha f111 = new FaturaLinha(30, 12);
        FaturaLinha f112 = new FaturaLinha(60, 23);
        f11.linhas.add(f111);
        f11.linhas.add(f112);
        f11.actualizaTotalDeLinhas();
        insereFaturaConsumidor(f11);


        // faturas inseridas por comerciantes
        Fatura f5 = new Fatura("112233445", cs1.getNome(), "231808569", "tipo", "1", "2013/04/22", "112233445", 0);
        FaturaLinha f51 = new FaturaLinha(10000, 12);
        FaturaLinha f52 = new FaturaLinha(20, 23);
        f5.linhas.add(f51);
        f5.linhas.add(f52);
        f5.actualizaTotalDeLinhas();
        FaturaLinha f53 = new FaturaLinha(400, 23);
        f5.linhas.add(f53);
        f5.actualizaTotalDeLinhas();
        insereFaturaComerciante(f5);


        Fatura f6 = new Fatura("123456789", cs2.getNome(), "24423142", "tipo", "2", "2013/04/22", "123456789", 0);
        FaturaLinha f61 = new FaturaLinha(30, 12);
        FaturaLinha f62 = new FaturaLinha(50, 23);
        f6.linhas.add(f61);
        f6.linhas.add(f62);
        f6.actualizaTotalDeLinhas();
        insereFaturaComerciante(f6);

        Fatura f7 = new Fatura("123456789", cs2.getNome(), "24423142", "tipo", "3", "2013/04/22", "123456789", 0);
        FaturaLinha f71 = new FaturaLinha(56, 12);
        FaturaLinha f72 = new FaturaLinha(34, 23);
        f7.linhas.add(f71);
        f7.linhas.add(f72);
        f7.actualizaTotalDeLinhas();
        insereFaturaComerciante(f7);

        Fatura f8 = new Fatura("456789123", cs2.getNome(), "24423142", "tipo", "4", "2013/04/22", "456789123", 0);
        FaturaLinha f81 = new FaturaLinha(40, 12);
        FaturaLinha f82 = new FaturaLinha(56, 23);
        f8.linhas.add(f81);
        f8.linhas.add(f82);
        f8.actualizaTotalDeLinhas();
        insereFaturaComerciante(f8);

        Fatura f10 = new Fatura("456789123", cs2.getNome(), "24423142", "tipo", "6", "2013/04/22", "456789123", 0);
        FaturaLinha f101 = new FaturaLinha(5352, 12);
        FaturaLinha f102 = new FaturaLinha(535, 23);
        f10.linhas.add(f101);
        f10.linhas.add(f102);
        f10.actualizaTotalDeLinhas();
        insereFaturaComerciante(f10);
        
        Fatura f12 = new Fatura("112233445", cs2.getNome(), "24423142", "tipo", "2", "2013/04/22", "112233445", 0);
        FaturaLinha f121 = new FaturaLinha(35, 12);
        FaturaLinha f122 = new FaturaLinha(60, 23);
        f12.linhas.add(f121);
        f12.linhas.add(f122);
        f12.actualizaTotalDeLinhas();
        insereFaturaComerciante(f12);
        
        
        
    }
    
     public void actualizaTotalDeLinhas() {
         lfat.f.actualizaTotalDeLinhas();
     }

    
     public void insereComerciante(Comerciante c) {
        lcom.insereComerciante(c);
    }
    
    public void insereConsumidor(Consumidor c) {
        lcon.insereConsumidor(c);
    }
    
    public void removeComerciante(Comerciante c){
        lcom.removeComerciante(c);
    }
    
    public void removeConsumidor(Consumidor c){
        lcon.removeConsumidor(c);
    }
    

    // verifica o login
    public boolean login(String nif, String password, String tipo) {
        boolean log = false;
        switch (tipo) {


            case "Comerciante":
                for(Comerciante comerciante: lcom.listaComerciante.values()){
                    if (comerciante.getNif().equals(nif) && comerciante.getPassword().equals(password)) {
                        log = true;
                        break;
                    }
                }
                break;

            case "Consumidor":
                for(Consumidor consumidor: lcon.listaConsumidor.values()){
                    if (consumidor.getNif().equals(nif) && consumidor.getPassword().equals(password)) {
                        log = true;
                        break;
                    }

                }
                break;
            case "Administrador":
                for(Administrador administrador: ladmin.listaAdministrador.values()){
                    if (administrador.getUserName().equals(nif) && administrador.getPassword().equals(password)) {
                        log = true;
                        break;
                    }
                }
                break;
        }

        return log;
    }

    // lista facturas por CAE
    public ArrayList listaFaturPorActividade(String cae) {
        List<Comerciante> listaComerciante = new ArrayList<>(lcom.comerciantesPorCAE(cae));
        ArrayList<Fatura> lista = new ArrayList<>();
        for(Comerciante comerciante: listaComerciante) {
            if (comerciante.getCAE().equals(cae)) {
                for (Iterator<Fatura> iterr = lfat.faturas.iterator(); iterr.hasNext();) {
                    Fatura fatura = (Fatura) iterr.next();
                    if (fatura.getNifEmissor().equals(comerciante.getNif()) && fatura.getIntrodPor().equals(fatura.getNifEmissor())) {
                        lista.add(fatura);
                    }
                }
            }

        }
        return lista;
        
    }

    // consulta total de faturacao de um comerciante
    public String faturacaoPorNif(String nif) {

        double totalFaturacao = 0;
        int contador = 0;
        for (Iterator<Fatura> iterr = lfat.faturas.iterator(); iterr.hasNext();) {
            Fatura fatura = (Fatura) iterr.next();
            if (fatura.getNifEmissor().equals(nif) && fatura.getIntrodPor().equals(nif)) {
                totalFaturacao += fatura.getTotalFatura();
                contador++;
            }
        }
        return "O comerciante com o NIF" + nif + "inseriu "+ contador+" faturas com o total de " + totalFaturacao + "€\n";

    }

    public boolean verificaBeneficioMaximo() {
        boolean atingiu = false;
        for(Consumidor consumidor: lcon.listaConsumidor.values()) {
            if (consumidor.getTotalBeneficios() >= 250) {
                atingiu = true;
            }
        }
        return atingiu;
    }

    public String verificaDivergencias() {
        String divergencias = "";
        StringBuilder sb = new StringBuilder(divergencias);
        for (Iterator<Fatura> iter = lfat.faturas.iterator(); iter.hasNext();) {
            Fatura fatura = (Fatura) iter.next();
            boolean encontrou = false;
            for (Iterator<Fatura> iterr = lfat.faturas.iterator(); iterr.hasNext();) {
                Fatura faturA = (Fatura) iterr.next();
                if (faturA.getIntrodPor().equals(fatura.getNifReceptor()) && (faturA.getnFatura().equals(fatura.getnFatura())) && (faturA.getTotalFatura() != fatura.getTotalFatura()) && faturA.getNifEmissor().equals(fatura.getNifEmissor())) {
                    sb.append( "A fatura com o nº " + faturA.getnFatura() + " tem uma divergencia no total \n");
                    sb.append("Total inserido pelo Comerciante com o nif " + fatura.getNifEmissor()+ " na fatura nº " + fatura.getnFatura() + " de " + fatura.getTotalFatura() +"€ é diferente do total inserido pelo Consumidor com o nif " + faturA.getNifReceptor()+" com o total de " + faturA.getTotalFatura() + "€ \n");
                    }
                if (fatura.getnFatura().equals(faturA.getnFatura()) && faturA.getIntrodPor().equals(faturA.getNifEmissor())) {
                    encontrou=true;
                } 
            }
            if (encontrou==false) {
                sb.append("A fatura nº " + fatura.getnFatura() + " tem uma divergencia pois foi apenas introduzida pelo consumidor "+ fatura.getNifReceptor() + " nao sendo introduzida pelo comerciante com o nif "  + fatura.getNifEmissor()+"\n");
            }

        }
        return divergencias = sb.toString();
    }

   

    public String totalFatCAE(String cae) {

        double total = 0;
        int contador = 0;
        for(Comerciante comerciante: lcom.listaComerciante.values()) {
            if (comerciante.getCAE().equals(cae)) {
                for (Iterator<Fatura> iterr = lfat.faturas.iterator(); iterr.hasNext();) {
                    Fatura fatura = (Fatura) iterr.next();
                    if (comerciante.getNif().equals(fatura.getNifEmissor()) && fatura.getIntrodPor().equals(comerciante.getNif())) {
                        total += fatura.getTotalFatura();
                        contador++;
                    }

                }
            }
        }
        return "Foram inseridas "+ contador+" faturas pelo sector de actividade " + cae + " com o total de faturacao de " + total+ "€ \n";
    }

    public String totalConsBeneficioMaximo() {
        int contador = 0;
        for(Consumidor consumidor: lcon.listaConsumidor.values()) {
            if (consumidor.getTotalBeneficios() >= 250) {
                contador++;
                
            }
        }
        return "O total de consumidores que alcançaram o beneficio maximo é de : " + contador + " corresponde a " + (contador/lcon.listaConsumidor.size())*100 + "% dos consumidores" ;
    }
    
    public String listaFactur() {
        
        String lista; 
        lista = lfat.listaFactur();
        return lista;
        
        
    }
    

 
    

  
 public String totalFaturacao() {

        double total = 0;
        int contador = 0;
        for (Iterator<Fatura> iterr = lfat.faturas.iterator(); iterr.hasNext();) {
            Fatura fatura = (Fatura) iterr.next();
                total += fatura.getTotalFatura();
                contador++;

                
            
        }
        return "Foram inseridas "+contador+" facturas no valor total de " + total+"€\n";
    } 
public ArrayList listaConsumidores(){
    return lcon.listaConsumidores();
}

public ArrayList listaComerciantes(){
    return lcom.listaComerciantes();
}
 
public ArrayList listaFaturas(){
    return lfat.faturas;
}
public ArrayList listaPorNif(String nif) {
    return lfat.listaPorNif(nif);
}

public Comerciante devolveComerciante(String nif){
    return lcom.devolveComerciante(nif);
}

public Consumidor devolveConsumidor(String nif){
    return lcon.devolveConsumidor(nif);
}

public String devolveBenficiosPorNif(String nif){
    return "O consumidor com o NIF " + nif+ " tem " + devolveConsumidor(nif).getTotalBeneficios()+ "€ de beneficos";
}

 public void insereFaturaConsumidor(Fatura f) {
        if(lfat.verificaFatura(f)==false){
        lfat.insereFatura(f);
        }
        
        if(f.getIntrodPor().equals(f.getNifReceptor())){
            float beneficios = devolveConsumidor(f.getIntrodPor()).getTotalBeneficios();
            beneficios = (float) (beneficios + (f.getTotalFatura()*0.05));
            devolveConsumidor(f.getIntrodPor()).setTotalBeneficios(beneficios);
        }
         
       
    }
 
 public boolean insereFaturaComerciante(Fatura f){
     boolean entrou = false;
     if(lfat.verificaFatura(f)==false){
        lfat.insereFatura(f);
        entrou = true;
        }
     return entrou;
 }
 
  public void removeFatura(Fatura f) {
        lfat.removeFatura(f);
        if(f.getIntrodPor().equals(f.getNifReceptor())){
            float beneficios = devolveConsumidor(f.getIntrodPor()).getTotalBeneficios();
            beneficios = (float) (beneficios - (f.getTotalFatura()*0.05));
            devolveConsumidor(f.getIntrodPor()).setTotalBeneficios(beneficios);
        }
    }
  
  
  
  public void insereLinha(FaturaLinha fl){
      lfat.f.insereLinha(fl);
  }
  
  public ArrayList<Comerciante> comerciantesPorCAE(String cae) {
      return lcom.comerciantesPorCAE(cae);
  }
 
  public void gravar() {
    try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(NOME_DB))) {
        oos.writeObject(this);
        oos.flush();
    } catch(IOException e) {
        // TODO mostrar janela generica com o erro
        e.printStackTrace();
    }
  }
  
  public static EFactur lerDoFicheiro() {
    EFactur sistema = null;
      
    try {                                                
        

        ObjectInputStream ooin = new ObjectInputStream(new FileInputStream(NOME_DB));
        sistema = (EFactur)ooin.readObject();
        ooin.close();
    } catch (Exception ex) {
        JOptionPane.showMessageDialog(null, 
                String.format("Ocorreu um erro ao inicializar o sistema: %s.\nO programa será encerrado.",
                    ex.getMessage()), 
                "Erro fatal", JOptionPane.ERROR_MESSAGE);
        System.exit(0);
    }             
    return sistema;
  }
}

