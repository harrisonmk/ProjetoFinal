
package modelo;

import java.io.Serializable;

//criacao da classe
public class Celular implements Serializable {
    
    //atributos
    private String fabricante;
    private String modelo;
    private String nomeCliente;
    private Double preco;

    
    //metodos getters e setters
    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
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
        return "\nFabricante: " + fabricante + 
                "\nModelo: " + modelo + 
                "\nNome do Cliente: " + nomeCliente + 
                "\nPreco: " + preco;
    }
    
    
    
    
}
