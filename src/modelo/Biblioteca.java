
package modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

//criacao da classe
public class Biblioteca implements Serializable {
   
    //atributo
    private List<Livro> livros = new ArrayList<>();

    
    //metodos getters/setters
    public List<Livro> getLivros() {
        return livros;
    }

    public void setLivros(List<Livro> livros) {
        this.livros = livros;
    }
    
    
    
    
}
