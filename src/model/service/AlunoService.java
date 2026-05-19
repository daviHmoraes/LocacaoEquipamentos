package model.service;

import model.repository.AlunoRepository;
import model.entity.Aluno;

import java.util.HashMap;

public class AlunoService {

    private AlunoRepository alunoRepository;

    public AlunoService(AlunoRepository alunoRepository) { this.alunoRepository = alunoRepository; }

    public boolean cadastrar(Aluno aluno){
        for(Aluno alunos : alunoRepository.listar().values()){
            if(alunos.getMatricula().equalsIgnoreCase(aluno.getMatricula())){
                return false;
            }
        }
        alunoRepository.salvar(aluno);
        return true;
    }

    public Aluno buscarPorId(int id){
        return alunoRepository.buscarPorId(id);
    }

    public void atualizar(Aluno aluno) {
        if (alunoRepository.buscarPorId(aluno.getId()) != null) {
            for (Aluno alunos : alunoRepository.listar().values()) {
                if (alunos.getMatricula().equalsIgnoreCase(aluno.getMatricula()) && alunos.getId() != aluno.getId()) {
                    throw new IllegalArgumentException("ERRO: matrícula já cadastrada.");
                }
                alunoRepository.atualizar(aluno);
            }
        } else {
            throw new IllegalArgumentException("ERRO: ID não encontrado.");
        }
    }

    public void deletar(int id){
        if(alunoRepository.buscarPorId(id) != null) {
            alunoRepository.deletar(id);
        } else {
            throw new IllegalArgumentException("ERRO: ID não encontrado.");
        }
    }

    public void listar(){
        for (Aluno alunos : alunoRepository.listar().values()) {
            alunos.toString();
            System.out.println("------------");
        }
    }
}