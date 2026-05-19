package model.repository;

import model.entity.Equipamento;

import java.util.HashMap;

public class EquipamentoRepository {

private HashMap<Integer, Equipamento> equipamentoHashMap;


public EquipamentoRepository(){

    equipamentoHashMap = new HashMap<>();

}

public Equipamento buscarID(int id){

    return equipamentoHashMap.get(id);

}

public  void salvar (Equipamento equipamento){

    equipamentoHashMap.put(equipamento.getId(), equipamento);

}

public HashMap<Integer, Equipamento> listarEquipamento(){

    return equipamentoHashMap;

}

public void removerEquipamento(int id){

    equipamentoHashMap.remove(id);

}

public void atualizar (Equipamento equipamento){

equipamentoHashMap.put(equipamento.getId(), equipamento);


}

}
