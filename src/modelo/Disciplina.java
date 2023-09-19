
package modelo;

import java.io.Serializable;
import java.util.Arrays;

//criacao da classe
public class Disciplina implements Serializable {
    
    //atributos
    private String nome;
    public Double[] nota;

    
    //metodos getters e setters
    public Disciplina(String nome, Double[] nota) {
        this.nome = nome;
        this.nota = nota;
    }

    public Disciplina() {
    }

    
    
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double[] getNota() {
        return nota;
    }

    public void setNota(Double[] nota) {
        this.nota = nota;
         
        
    }

    //metodo para calcular a media
    public Double calculaMedia() {

        Double media = null;
        Double total = 0.0;
        int i;
       
        try {

        for (i = 0; i < this.nota.length; i++) {

            total += this.nota[i];

        }

      
            media = total / i;
        }catch(Exception e){
            System.out.println(e);
        }
      

        return media;

    }
    

    

  

    //metodo toString
    @Override
    public String toString() {
        return "\nNome:" + nome + 
              "\nNotas: " + Arrays.toString(nota).replace("[","").replace("]","").replace(",","")+
              "\nMedia: "+this.calculaMedia();
    }
    
    
    
    
    
}
