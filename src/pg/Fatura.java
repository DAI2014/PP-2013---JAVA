package pg;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

public class Fatura implements Serializable {

    private String nifComerciante;
    private String nome;
    private String nifConsumidor;
    private String tipoFatura;
    private String nFatura;
    private String data;
    private double totalFatura;
    private String introdPor;
    ArrayList<FaturaLinha> linhas = new ArrayList<>();

    public Fatura(String nifEmissor, String nome, String nifReceptor, String tipoFatura, String nFatura, String data, String introdPor, double totalFatura) {

        this.nifComerciante = nifEmissor;
        this.nome = nome;
        this.nifConsumidor = nifReceptor;
        this.tipoFatura = tipoFatura;
        this.nFatura = nFatura;
        this.data = data;
        this.introdPor = introdPor;
        this.totalFatura = totalFatura;
    }

    //modificadores
    //public void setNifEmissor(int nifEmissor) {this.nifEmissor = nifEmissor;}
    public void setNifEmissor(String nif) {
        this.nifComerciante = nif;
    }

    public void setNifReceptor(String nif) {
        this.nifConsumidor = nif;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    // public void setNifReceptor(int nifReceptor) {this.nifReceptor = nifReceptor;}
    public void setTipoFatura(String tipoFatura) {
        this.tipoFatura = tipoFatura;
    }

    public void setnFatura(String nFatura) {
        this.nFatura = nFatura;
    }

    public void setData(String data) {
        this.data = data;
    }

    public void setTotal(double totalFactura) {
        this.totalFatura = totalFactura;
    }

    public void setIntrodPor(String introdPor) {
        this.introdPor = introdPor;
    }

    //Seletores
    public String getNifEmissor() {
        return nifComerciante;
    }

    public String getNome() {
        return nome;
    }

    public String getNifReceptor() {
        return nifConsumidor;
    }

    public String getTipoFatura() {
        return tipoFatura;
    }

    public String getnFatura() {
        return nFatura;
    }

    public String getData() {
        return data;
    }

    public String getIntrodPor() {
        return introdPor;
    }

    public double getTotalFatura() {
        return totalFatura;
    }

    // actualiza o total de linhas inserido numa fatura
    public void actualizaTotalDeLinhas() {
        this.totalFatura = 0;
        for (Iterator<FaturaLinha> iter = linhas.iterator(); iter.hasNext();) {
            FaturaLinha fl = (FaturaLinha) iter.next();
            this.totalFatura += fl.getTotalLinha();


        }
    }

    public void insereLinha(FaturaLinha fl) {
        this.linhas.add(fl);
        actualizaTotalDeLinhas();
    }

    // imprime a linha de uma fatura
    public ArrayList imprimeLinha() {
        ArrayList<FaturaLinha> fl1 = new ArrayList<>();
        for (Iterator<FaturaLinha> iter = linhas.iterator(); iter.hasNext();) {
            FaturaLinha fl = (FaturaLinha) iter.next();
            fl1.add(fl);
        }
        return fl1;
    }

    public String toString() {
        StringBuilder novaString = new StringBuilder();
        novaString.append("\n------------------- Registar Fatura ---------------------\n");
        novaString.append("--------------- Idenfificação da Fatura -----------------\n\n");
        novaString.append("       NIF Consumidor: " + getNifReceptor() + "        Nome: " + getNome() + "\n");
        novaString.append("       NIF Comerciante: " + getNifEmissor() + "\n");
        novaString.append("       Tipo de Fatura: " + getTipoFatura() + "      Nº Fatura: " + getnFatura() + "\n\n");
        novaString.append("       Introduzido por: " + getIntrodPor() + "\n");
        novaString.append("--------------------- Dados da Fatura--------------------\n\n");
        novaString.append("       Emitido: " + getData() + "\n");
        return novaString.toString();
    }
}
