
package modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

//criacao da classe
public class Academico implements Serializable {
    
    //atributo
    private List<Disciplina> disciplinas = new ArrayList<>();

    //metodos getters setters
    public List<Disciplina> getDisciplinas() {
        return disciplinas;
    }

    public void setDisciplinas(List<Disciplina> disciplinas) {
        this.disciplinas = disciplinas;
    }

    //metodo toString
    @Override
    public String toString() {
        return  "\nDisciplinas: " + disciplinas.toString().replace("[","").replace("]","");
    }
    
    

    
    
    
    
    
}
