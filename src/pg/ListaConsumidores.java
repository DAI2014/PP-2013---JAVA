package pg;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ListaConsumidores implements Serializable {

    Map<String, Consumidor> listaConsumidor = new HashMap<>();

    public void insereConsumidor(Consumidor c) {

        listaConsumidor.put(c.getNif(), c);
    }

    public void removeConsumidor(Consumidor c) {
        listaConsumidor.remove(c.getNif());
    }

// imprime uma lista com todos os consumidores
    public ArrayList listaConsumidores() {
        ArrayList<Consumidor> lista = new ArrayList<>(listaConsumidor.values());
        return lista;

    }

    public Consumidor devolveConsumidor(String nif) {

        return listaConsumidor.get(nif);


    }
}
