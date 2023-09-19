
package modelo;

import java.io.Serializable;

//cricao da classe
public class Bolo implements Serializable {
    
    //atributos
    private String nome;
    private String tipo;
    private String recheio;
    private Double preco;

    //metodos getters e setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getRecheio() {
        return recheio;
    }

    public void setRecheio(String recheio) {
        this.recheio = recheio;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    //metodo toString
    @Override
    public String toString() {
        return "\nNome: " + nome + 
                "\nTipo: " + tipo + 
                "\nRecheio: " + recheio + 
                "\nPreco: " + preco;
    }
    
    
    
}
