
package modelo;

import java.io.Serializable;

//criacao da classe
public class Pet implements Serializable {
    
    //atributos
    private String nome;
    private String tipo;
    private String raca;
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

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
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
        return "\nNome:" + nome + 
                "\nTipo: " + tipo + 
                "\nRaca: " + raca + 
                "\npreco: " + preco;
    }
    
    
    
    
    
}
