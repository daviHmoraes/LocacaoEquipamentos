package model.service;

import model.entity.Equipamento;
import model.repository.EquipamentoRepository;

import java.util.HashMap;
import java.util.List;

public class EquipamentoService {

    private EquipamentoRepository equipamentoRepository;

    public EquipamentoService(EquipamentoRepository equipamentoRepository) {
        this.equipamentoRepository = equipamentoRepository;
    }

    public void salvar(Equipamento equipamento) {
        equipamentoRepository.salvar(equipamento);
    }

    public Equipamento buscarPorId(int id) {
        Equipamento equipamento = equipamentoRepository.buscarID(id);
        if (equipamento == null) {
            throw new RuntimeException("ERRO: Equipamento não encontrado");
        }
        return equipamentoRepository.buscarID(id);
    }

    public List<Equipamento> listar() {
        List<Equipamento> list = equipamentoRepository.listarEquipamento();
        if (list.isEmpty()) {
            throw new RuntimeException("ERRO: A lista está vazia.");
        }
        return equipamentoRepository.listarEquipamento();
    }
}