
package modelo;

import java.io.Serializable;

//criacao da classe
public class Carro implements Serializable {
    
    //atributos
    private String fabricante;
    private String modelo;
    private String ano;
    private Double quilometragem;
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

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public Double getQuilometragem() {
        return quilometragem;
    }

    public void setQuilometragem(Double quilometragem) {
        this.quilometragem = quilometragem;
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
        return  "\nFabricante: " + fabricante + 
                "\nModelo: " + modelo + 
                "\nAno: " + ano + 
                "\nQuilometragem: " + quilometragem + 
                "\nPreco: " + preco;
    }
    
    
    
    
    
}
