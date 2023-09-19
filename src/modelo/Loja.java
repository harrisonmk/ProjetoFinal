
package modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

//criacao da classe
public class Loja implements Serializable {
    
    //atributo
    private List<Carro> carros = new ArrayList<>();

    //metodos getters e setters
    public List<Carro> getCarros() {
        return carros;
    }

    public void setCarros(List<Carro> carros) {
        this.carros = carros;
    }
    
    
    
}
