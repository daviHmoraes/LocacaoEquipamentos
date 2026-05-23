package controller;

import model.entity.Equipamento;
import model.service.EquipamentoService;

import java.util.HashMap;
import java.util.List;

public class EquipamentoController {

    private EquipamentoService equipamentoService;

    public EquipamentoController(EquipamentoService equipamentoService) {
        this.equipamentoService = equipamentoService;
    }

    public void salvar(Equipamento equipamento) {
        try {
            equipamentoService.salvar(equipamento);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }

    public Equipamento buscarPorId(int id) {
        try {
            return equipamentoService.buscarPorId(id);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public List<Equipamento> listar() {
       try {
           return equipamentoService.listar();
       }catch (RuntimeException e){
           System.out.println(e.getMessage());
           return null;
       }
    }
}