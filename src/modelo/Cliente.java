
package modelo;

import java.io.Serializable;

//criacao da classe
public class Cliente implements Serializable {
    
    //atributos
    private String nome;
    private String telefone;
    private String celular;
    private String dataConsulta;
    private String especialidade;

    
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

    public String getDataConsulta() {
        return dataConsulta;
    }

    public void setDataConsulta(String dataConsulta) {
        this.dataConsulta = dataConsulta;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    //metodo toString
    @Override
    public String toString() {
        return  "\nnome: " + nome + 
                "\nTelefone: " + telefone + 
                "\nCelular: " + celular + 
                "\nData de Consulta: " + dataConsulta + 
                "\nEspecialidade: " + especialidade;
    }
    
    
    
    
}
