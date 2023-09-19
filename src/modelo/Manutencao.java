
package modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

//criacao da classe
public class Manutencao implements Serializable {
    
    //atributo
    private List<Celular> celulares = new ArrayList<>();

    //metodo getters e setters
    public List<Celular> getCelulares() {
        return celulares;
    }

    public void setCelulares(List<Celular> celulares) {
        this.celulares = celulares;
    }
    
    
    
}
