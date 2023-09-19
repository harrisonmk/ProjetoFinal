
package modelo;

import java.io.Serializable;

//criacao da classe
public class ClienteOficina implements Serializable {
    
    //atributos
    private String nome;
    private String telefone;
    private String celular;
    private String dataEntrada;
    private String problema;

    
    //metodos getters e setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getDataEntrada() {
        return dataEntrada;
    }

    public void setDataEntrada(String dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    public String getProblema() {
        return problema;
    }

    public void setProblema(String problema) {
        this.problema = problema;
    }

    //metodo toString
    @Override
    public String toString() {
        return  "\nNome: " + nome + 
                "\nTelefone: " + telefone + 
                "\nCelular: " + celular + 
                "\nData De Entrada: " + dataEntrada + 
                "\nProblema: " + problema;
    }
    
    
    
    
}
