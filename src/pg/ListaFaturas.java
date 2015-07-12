package pg;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

public class ListaFaturas implements Serializable {

    ArrayList<Fatura> faturas = new ArrayList<>();
    Fatura f;
    // imprime uma lista de todas as faturas

    public String listaFactur() {

        String lista = "";
        StringBuilder sb = new StringBuilder(lista);
        for (Iterator<Fatura> iter = faturas.iterator(); iter.hasNext();) {
            Fatura fatura = (Fatura) iter.next();
            sb.append(fatura.toString());
            sb.append(fatura.imprimeLinha());
        }

        return lista = sb.toString();
    }

    public void insereFatura(Fatura f) {
        faturas.add(f);
    }

    public void removeFatura(Fatura f) {

        faturas.remove(f);
    }

    public boolean verificaFatura(Fatura f) {
        boolean encontrou = false;
        for (Iterator<Fatura> iter = faturas.iterator(); iter.hasNext();) {
            Fatura fatura = (Fatura) iter.next();
            if (fatura.getNifEmissor().equals(f.getNifEmissor()) && fatura.getnFatura().equals(f.getnFatura()) && fatura.getIntrodPor().equals(f.getIntrodPor())) {
                encontrou = true;
            }
        }
        return encontrou;
    }

    // imprime as faturas inseridas por um dado utilizador atraves do nif
    public ArrayList listaPorNif(String nif) {
        ArrayList<Fatura> lista = new ArrayList<>();
        for (Iterator<Fatura> iter = faturas.iterator(); iter.hasNext();) {
            Fatura fatura = (Fatura) iter.next();
            if (fatura.getIntrodPor().equals(nif)) {
                lista.add(fatura);

            }
        }

        return lista;
    }
}
