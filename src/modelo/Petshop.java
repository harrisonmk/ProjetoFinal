
package modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

//criacao da classe
public class Petshop implements Serializable {
    
    //atributo
    private List<Pet> pets = new ArrayList<>();

    //metodos getters e setters
    public List<Pet> getPets() {
        return pets;
    }

    public void setPets(List<Pet> pets) {
        this.pets = pets;
    }
    
    
    
}
