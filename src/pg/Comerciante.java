package pg;

import java.io.Serializable;

public class Comerciante extends Utilizador implements Serializable {

    public String CAE;

    public Comerciante(String nif, String nome, String morada, String telefone, String telemovel, String cc, String password, String CAE) {

        super(nif, nome, morada, telefone, telemovel, cc, password);
        this.CAE = CAE;
    }

    public void Comerciante() {
    }

    public String getCAE() {
        return CAE;
    }

    public void setCae(String cae) {
        this.CAE = cae;
    }

    public String toString() {
        StringBuilder novaString = new StringBuilder();
        novaString.append("---------Comerciante------------\n");
        novaString.append("   Nome: " + super.getNome() + "\n");
        novaString.append("   NIF: " + super.getNif() + "\n");
        novaString.append("   CAE: " + getCAE() + "\n");
        novaString.append("----------------------------------");
        return novaString.toString();
    }
}
