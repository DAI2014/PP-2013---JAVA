package pg;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class ListaAdministrador implements Serializable {

    Map<String, Administrador> listaAdministrador = new HashMap<>();

    public void insereAdmin(Administrador a) {

        listaAdministrador.put(a.getUserName(), a);
    }

    public void removeAdmin(Administrador a) {

        listaAdministrador.remove(a.getUserName());

    }
}
