package pg;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ListaComerciantes implements Serializable {

    Map<String, Comerciante> listaComerciante = new HashMap<>();

    public void insereComerciante(Comerciante c) {
        listaComerciante.put(c.getNif(), c);
    }

    public void removeComerciante(Comerciante c) {
        listaComerciante.remove(c.getNif());
    }

    // imprime uma lista de todos os comerciantes
    public ArrayList listaComerciantes() {
        ArrayList<Comerciante> lista = new ArrayList<>(listaComerciante.values());
        return lista;
    }

    // retorna uma lista de comerciantes pelo CAE inserido
    public ArrayList<Comerciante> comerciantesPorCAE(String cae) {
        ArrayList<Comerciante> comerciantes = new ArrayList<>();

        for (Comerciante comerciante : listaComerciante.values()) {
            if (comerciante.getCAE().equals(cae)) {
                comerciantes.add(comerciante);
            }
        }

        return comerciantes;
    }

    public Comerciante devolveComerciante(String nif) {
        return listaComerciante.get(nif);
    }
}
