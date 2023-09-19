
package modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

//criacao da classe
public class Confeitaria implements Serializable {
    
    //atributo
    private List<Bolo> bolos = new ArrayList<>();

    
    //metodos getters e setters
    public List<Bolo> getBolos() {
        return bolos;
    }

    public void setBolos(List<Bolo> bolos) {
        this.bolos = bolos;
    }
    
    
    
}
