package model.repository;

import model.entity.Equipamento;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class EquipamentoRepository {

    private HashMap<Integer, Equipamento> equipamentoHashMap = new HashMap<>();

    //buscar ID
    public Equipamento buscarID(int id) {
        return equipamentoHashMap.get(id);
    }
    //salvar
    public void salvar(Equipamento equipamento) {
        equipamentoHashMap.put(equipamento.getId(), equipamento);
    }
    //listar
    public List<Equipamento> listarEquipamento() {
        return new ArrayList<>(equipamentoHashMap.values());
    }
    //remover
    public void removerEquipamento(int id) {
        equipamentoHashMap.remove(id);
    }
    //atualizar
    public void atualizar(Equipamento equipamento) {
        equipamentoHashMap.put(equipamento.getId(), equipamento);
    }

}
