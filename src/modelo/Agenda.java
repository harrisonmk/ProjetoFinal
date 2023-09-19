
package modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

//cricao da calsse
public class Agenda implements Serializable {
    
    //cricao do atributo
     private List<Contato> contatos = new ArrayList<>();

     //criacao getters setters
    public List<Contato> getContatos() {
        return contatos;
    }

    public void setContatos(List<Contato> contatos) {
        this.contatos = contatos;
    }
     
     
    
    
}
