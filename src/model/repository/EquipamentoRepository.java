package model.repository;

import model.entity.Equipamento;

import java.util.HashMap;

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
    public HashMap<Integer, Equipamento> listarEquipamento() {
        return equipamentoHashMap;
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
