
package modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

//criacao da classe
public class Clinica implements Serializable {
    
    //atributo
    private List<Cliente> clientes = new ArrayList<>();

    
    //metodos getters e setters
    public List<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }
    
    
    
}
