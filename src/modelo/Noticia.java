
package modelo;

import java.io.Serializable;

//criacao da classe
public class Noticia implements Serializable {
    
    //atributos
    private String titulo;
    private String autor;
    private String data;
    private String conteudo;

    //metodos getters e setters
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    //metodo toString
    @Override
    public String toString() {
        return "\nTitulo: " + titulo + 
                "\nAutor: " + autor + 
                "\nData: " + data + 
                "\nConteudo: " + conteudo;
    }
    
    
    
    
}
