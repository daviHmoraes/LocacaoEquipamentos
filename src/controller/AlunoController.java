package controller;

import model.entity.Aluno;
import model.service.AlunoService;

import java.util.List;

public class AlunoController {

    private AlunoService alunoService;

    public AlunoController(AlunoService alunoService) {
        this.alunoService = alunoService;
    }

    public void cadastrar(Aluno aluno) {
        try {
            alunoService.cadastrar(aluno);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }

    public Aluno buscarPorId(int id) {
        try {
            return alunoService.buscarPorId(id);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public List<Aluno> listar() {
        try {
            return alunoService.listar();
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

}