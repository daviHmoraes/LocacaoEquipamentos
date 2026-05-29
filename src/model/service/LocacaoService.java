package model.service;

import model.entity.Aluno;
import model.entity.Equipamento;
import model.entity.Locacao;
import model.entity.Status;
import model.repository.EquipamentoRepository;
import model.service.AlunoService;
import model.service.EquipamentoService;
import model.repository.LocacaoRepository;

import java.time.LocalDate;
import java.util.List;

public class LocacaoService {

    private final LocacaoRepository repo;
    private final AlunoService alunoService;
    private final EquipamentoService equipamentoService;

    public LocacaoService(LocacaoRepository repo, AlunoService alunoService, EquipamentoService equipamentoService) {
        this.repo = repo;
        this.alunoService = alunoService;
        this.equipamentoService = equipamentoService;
    }

    public void salvar(int idAluno, int idEquipamento, LocalDate data, Status status) {
        Aluno aluno = alunoService.buscarPorId(idAluno);

        if(aluno == null) {
            throw new RuntimeException("ERRO: Aluno não encontrado.");
        }

        Equipamento equipamento = equipamentoService.buscarPorId(idEquipamento);

        if(equipamento == null) {
            throw new RuntimeException("ERRO: Equipamento não encontrado.");
        }

        if(!equipamento.isDisponivel()) {
            throw new RuntimeException("ERRO: Equipamento está indisponível.");
        }

        equipamento.setDisponivel(false);
        equipamentoService.atualizar(equipamento);

        repo.salvar(new Locacao(aluno, equipamento, data, status));
    }

    public Locacao buscarPorId(int id) {
        Locacao locacao = repo.buscarPorId(id);
        if (locacao == null) {
            throw new RuntimeException("ERRO: Locação não encontrada.");
        }
        return locacao;
    }

    public List<Locacao> listar() {
        return repo.listar();
    }

    public void finalizar(Locacao locacao) {

        if(locacao.getStatus() == Status.FINALIZADA) {
            throw new RuntimeException("ERRO: A locação já está finalizada.");
        }

        Equipamento equipamento = locacao.getEquipamento();
        equipamento.setDisponivel(true);
        equipamentoService.atualizar(equipamento);

        locacao.setStatus(Status.FINALIZADA);
        repo.atualizar(locacao);
    }

}
