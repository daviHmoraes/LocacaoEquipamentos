package model.entity;

public class Equipamento {

    private static int idContador = 1;
    private final int id;
    private String nome;
    private String tipo;
    private boolean disponivel;

    public Equipamento(String nome, String tipo) {

        setNome(nome);
        setTipo(tipo);
        this.disponivel = true;
        this.id = idContador++;

    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome == null || nome.isBlank()) {
            throw new RuntimeException("ERRO: nome não pode ser vazio");
        }
        this.nome = nome;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        if (tipo == null || tipo.isBlank()) {
            throw new RuntimeException("ERRO: tipo não pode ser vazio");
        }
            this.tipo = tipo;
        }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(Boolean disponivel) {

        if (disponivel == null) {
            throw new RuntimeException("ERRO: não pode ser nulo.");
        }
        this.disponivel = disponivel;

    }
}
