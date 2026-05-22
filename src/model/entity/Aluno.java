package model.entity;

public class Aluno {

    private int id;
    private static int idPlus = 1;
    private String nome;
    private String matricula;

    public Aluno(String nome, String matricula) {
        this.id = idPlus++;
        this.nome = nome;
        this.matricula = matricula;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString(){
        return "\nInformações do aluno: \nID: " + id + "\nNome: " + "\nMatrícula: " + matricula;
    }

}