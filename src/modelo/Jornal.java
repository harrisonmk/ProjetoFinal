
package modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

//criacao da classe
public class Jornal implements Serializable {
    
    //atributo
    private List<Noticia> noticias = new ArrayList<>();

    
    //metodos getters e setters
    public List<Noticia> getNoticias() {
        return noticias;
    }

    public void setNoticias(List<Noticia> noticias) {
        this.noticias = noticias;
    }
    
    
    
}
