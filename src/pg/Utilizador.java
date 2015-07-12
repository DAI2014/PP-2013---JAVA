package pg;

import java.io.Serializable;

public class Utilizador implements Serializable {

    private String nome;
    private String nif;
    private String password;
    private String morada;
    private String telefone;
    private String telemovel;
    private String cc;

    public Utilizador(String nif, String nome, String morada, String telefone, String telemovel, String cc, String password) {

        this.nome = nome;
        this.nif = nif;
        this.password = password;
        this.morada = morada;
        this.telefone = telefone;
        this.telemovel = telemovel;
        this.cc = cc;

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMorada() {
        return morada;
    }

    public void setMorada(String morada) {
        this.morada = morada;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getTelemovel() {
        return telemovel;
    }

    public void setTelemovel(String telemovel) {
        this.telemovel = telemovel;
    }

    public String getCc() {
        return cc;
    }

    public void setCc(String cc) {
        this.cc = cc;
    }
}
