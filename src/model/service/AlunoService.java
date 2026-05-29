package model.service;

import model.repository.AlunoRepository;
import model.entity.Aluno;

import java.util.HashMap;
import java.util.List;

public class AlunoService {

    private AlunoRepository alunoRepository;

    public AlunoService(AlunoRepository alunoRepository) { this.alunoRepository = alunoRepository; }

    public void cadastrar(Aluno aluno){
        if (alunoRepository.listar().stream()
                .anyMatch(a -> a.getMatricula().equalsIgnoreCase(aluno.getMatricula()))) {
            throw new RuntimeException("ERRO: Essa matrícula já está cadastrada.");
        }
        alunoRepository.salvar(aluno);
    }

    public Aluno buscarPorId(int id){
        Aluno aluno = alunoRepository.buscarPorId(id);
        if (aluno == null) {
            throw new RuntimeException("ERRO: Aluno não encontrado.");
        }
        return aluno;
    }

    public List<Aluno> listar(){
        List<Aluno> list = alunoRepository.listar();
        if(list.isEmpty()) {
            throw new RuntimeException("ERRO: A lista está vazia.");
        }
        return list;
    }
}