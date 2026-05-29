package model.entity;

public class Aluno {

    private final int id;
    private static int idPlus = 1;
    private String nome;
    private String matricula;

    public Aluno(String nome, String matricula) {
        setNome(nome);
        setMatricula(matricula);
        this.id = idPlus++;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        if (!matricula.isBlank()) {
            this.matricula = matricula;
        } else {
            throw new RuntimeException("ERRO: Matrícula não pode ser vazio.");
        }
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (!nome.isBlank()) {
            this.nome = nome;
        } else {
            throw new RuntimeException("ERRO: Nome não pode ser vazio.");
        }
    }

    public int getId() {
        return id;
    }

}