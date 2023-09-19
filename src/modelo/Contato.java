
package modelo;

import java.io.Serializable;

//criacao da classe
public class Contato implements Serializable {
    
    //atributos
    private String nome;
    private String telefone;
    private String celular;
    private String email;

    
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    //metodo toString
    @Override
    public String toString() {
        return  "\nNome: " + nome + 
                "\nTelefone: " + telefone + 
                "\nCelular: " + celular + 
                "\nEmail: " + email;
    }
    
    
    
}
