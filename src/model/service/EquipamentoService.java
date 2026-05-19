package model.service;

import model.entity.Equipamento;
import model.repository.EquipamentoRepository;

public class EquipamentoService {

private EquipamentoRepository equipamentoRepository;

public EquipamentoService(){


equipamentoRepository = new EquipamentoRepository();

}

public boolean cadastrarEquipamento(Equipamento equipamento){

return true;

}


}
