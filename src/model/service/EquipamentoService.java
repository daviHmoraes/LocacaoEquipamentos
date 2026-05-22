package model.service;

import model.entity.Equipamento;
import model.repository.EquipamentoRepository;

import java.util.HashMap;

public class EquipamentoService {

    private EquipamentoRepository equipamentoRepository;

    public EquipamentoService(EquipamentoRepository equipamentoRepository) {
        this.equipamentoRepository = equipamentoRepository;
    }

    public void cadastrar(Equipamento equipamento) {
        equipamentoRepository.salvar(equipamento);
    }

    public Equipamento buscarPorId(int id) {
        return equipamentoRepository.buscarID(id);
    }

    public void atualizar(Equipamento equipamento) {

        if (equipamentoRepository.buscarID(equipamento.getId()) == null) {
            throw new RuntimeException("ERRO: ID não encontrado.");
        }

        equipamentoRepository.atualizar(equipamento);
    }

    public void deletar(int id) {

        if (equipamentoRepository.buscarID(id) == null) {
            throw new RuntimeException("ERRO: ID não encontrado.");
        }

        equipamentoRepository.removerEquipamento(id);
    }

    public HashMap<Integer, Equipamento> listar() {
        return equipamentoRepository.listarEquipamento();
    }
}