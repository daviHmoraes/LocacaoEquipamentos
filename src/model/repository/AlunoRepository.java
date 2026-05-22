package model.repository;

import model.entity.Aluno;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Collections;
import java.util.List;

public class AlunoRepository {

    private HashMap<Integer, Aluno> listaAlunos = new HashMap<>();

    public void salvar(Aluno aluno){
        listaAlunos.put(aluno.getId(), aluno);
    }

    public Aluno buscarPorId(int id){
        return listaAlunos.get(id);
    }

    public List<Aluno> listar() {
        return new ArrayList<>(listaAlunos.values());
    }

}