package pg;

import java.io.Serializable;

public class Consumidor extends Utilizador implements Serializable{

    public float totalBeneficios;

    public Consumidor(String nif, String nome,String morada, String telefone, String telemovel,String cc, String password) {

        super(nif, nome,morada,telefone,telemovel,cc, password);
        totalBeneficios = 0;

    }

    public void setTotalBeneficios(float beneficios) {
        totalBeneficios = beneficios;
    }

    public float getTotalBeneficios() {
        return totalBeneficios;
    }



    public String toString() {
        StringBuilder novaString = new StringBuilder();
        novaString.append("---------Consumidor------------\n");
        novaString.append("   Nome: " + super.getNome() + "\n");
        novaString.append("   NIF: " + super.getNif() + "\n");
        novaString.append("   Total de Beneficios: " + totalBeneficios + " €\n");
        novaString.append("----------------------------------");
        return novaString.toString();
    }
}
