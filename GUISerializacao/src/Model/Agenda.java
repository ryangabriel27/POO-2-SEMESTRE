package Model;

import java.io.Serializable;

public class Agenda implements Serializable {

    // Atributos
    private String usuarioAgenda;
    private String data;
    private String hora;
    private String descricao;

    // Construtor
    public Agenda(String usuarioAgenda, String data, String hora, String descricao) {
        this.usuarioAgenda = usuarioAgenda;
        this.data = data;
        this.hora = hora;
        this.descricao = descricao;
    }

    // Getters and setters
    public String getUsuario() {
        return usuarioAgenda;
    }

    public void setUsuario(String usuarioAgenda) {
        this.usuarioAgenda = usuarioAgenda;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
