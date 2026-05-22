package controller;

import model.entity.Equipamento;
import model.service.EquipamentoService;

import java.util.HashMap;

public class EquipamentoController {

    private EquipamentoService equipamentoService;

    public EquipamentoController(EquipamentoService equipamentoService) {
        this.equipamentoService = equipamentoService;
    }

    public void cadastrar(String nome, String tipo) {

        Equipamento equipamento = new Equipamento(nome, tipo);

        equipamentoService.cadastrar(equipamento);
    }

    public Equipamento buscarPorId(int id) {

        if (id < 0) {
            throw new RuntimeException("ERRO: ID inválido.");
        }

        Equipamento equipamento = equipamentoService.buscarPorId(id);

        if (equipamento == null) {
            throw new RuntimeException("ERRO: Equipamento não encontrado.");
        }

        return equipamento;
    }

    public void atualizar(int id, String nome, String tipo, Boolean disponivel) {

        if (id < 0) {
            throw new RuntimeException("ERRO: ID inválido.");
        }

        Equipamento equipamento = equipamentoService.buscarPorId(id);

        if (equipamento == null) {
            throw new RuntimeException("ERRO: Equipamento não encontrado.");
        }

        equipamento.setNome(nome);
        equipamento.setTipo(tipo);
        equipamento.setDisponivel(disponivel);

        equipamentoService.atualizar(equipamento);
    }

    public void deletar(int id) {

        if (id < 0) {
            throw new RuntimeException("ERRO: ID inválido.");
        }

        equipamentoService.deletar(id);
    }

    public HashMap<Integer, Equipamento> listar() {

        return equipamentoService.listar();
    }
}