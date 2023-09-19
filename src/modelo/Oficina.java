
package modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

//criacao da classe
public class Oficina implements Serializable {
    
    //atributo
    private List<ClienteOficina> clientes = new ArrayList<>();

    //metodos getters e setters
    public List<ClienteOficina> getClientes() {
        return clientes;
    }

    public void setClientes(List<ClienteOficina> clientes) {
        this.clientes = clientes;
    }
    
    
    
    
}
