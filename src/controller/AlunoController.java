package controller;

import model.entity.Aluno;
import model.service.AlunoService;

public class AlunoController {

    private AlunoService alunoService;

    public AlunoController(AlunoService alunoService) {
        this.alunoService = alunoService;
    }

    public void cadastrar(String nome, String matricula) {

        try {

            Aluno aluno = new Aluno(nome, matricula);
            boolean sucesso = alunoService.cadastrar(aluno);

            if (sucesso) {
                System.out.println("Aluno cadastrado com sucesso!");
            } else {
                System.out.println("ERRO: Matrícula já cadastrada.");
            }

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public void buscarPorId(int id) {

        try {

            Aluno aluno = alunoService.buscarPorId(id);

            if (aluno != null) {
                System.out.println(aluno);
            } else {
                System.out.println("ERRO: Aluno não encontrado.");
            }

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public void atualizar(int id, String nome, String matricula) {

        try {

            Aluno aluno = alunoService.buscarPorId(id);

            if (aluno == null) {
                throw new IllegalArgumentException("ERRO: Aluno não encontrado.");
            }

            aluno.setNome(nome);
            aluno.setMatricula(matricula);
            alunoService.atualizar(aluno);
            System.out.println("Aluno atualizado com sucesso!");

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public void deletar(int id) {

        try {

            alunoService.deletar(id);
            System.out.println("Aluno removido com sucesso!");

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public void listar() {

        try {

            alunoService.listar();

        } catch (Exception e) {
            System.out.println("ERRO ao listar alunos.");
        }
    }

}