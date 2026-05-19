package model.repository;

import model.entity.Aluno;
import java.util.HashMap;
import java.util.Collections;

public class AlunoRepository {

    private HashMap<Integer, Aluno> listaAlunos = new HashMap<>();

    public void salvar(Aluno aluno){
        listaAlunos.put(aluno.getId(), aluno);
    }

    public Aluno buscarPorId(int id){
        return listaAlunos.get(id);
    }

    public void atualizar(Aluno aluno){
        listaAlunos.put(aluno.getId(), aluno);
    }

    public void deletar(int id){
        listaAlunos.remove(id);
    }

    public HashMap<Integer, Aluno> listar() {
        return listaAlunos;
    }

}