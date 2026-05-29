package controller;

import model.entity.Locacao;
import model.entity.Status;
import model.service.LocacaoService;

import java.time.LocalDate;
import java.util.List;

public class LocacaoController {

    private final LocacaoService locacaoService;

    public LocacaoController(LocacaoService locacaoService) {
        this.locacaoService = locacaoService;
    }

    public void salvar(int idAluno, int idEquipamento, LocalDate data, Status status) {

        try {
            locacaoService.salvar(idAluno, idEquipamento, data, status);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }

    public Locacao buscarPorId(int id) {

        try {
            return locacaoService.buscarPorId(id);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public List<Locacao> listar() {

        try {
            return locacaoService.listar();
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public void finalizar(Locacao locacao) {

        try {
            locacaoService.finalizar(locacao);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }

    public void atualizar(int idLocacao, int idAluno, int idEquipamento, LocalDate data) {

        try {
            locacaoService.atualizar(idLocacao, idAluno, idEquipamento, data);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }

    public void remover(int idLocacao) {

        try {
            locacaoService.remover(idLocacao);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }
}