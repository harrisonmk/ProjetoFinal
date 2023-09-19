
package modelo;

import java.io.Serializable;

//criacao da classe
public class Livro implements Serializable {
    
    //atributos
    private String nome;
    private String editora;
    private Integer edicao;
    private String area;

    
    //metodos getters e setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public Integer getEdicao() {
        return edicao;
    }

    public void setEdicao(Integer edicao) {
        this.edicao = edicao;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    //metodos toString
    @Override
    public String toString() {
        return "\nNome:" + nome + 
                "\nEditora: " + editora + 
                "\nEdicao: " + edicao + 
                "\nArea: " + area;
    }
    
    
    
}
