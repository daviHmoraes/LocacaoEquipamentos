package model.entity;

import java.time.LocalDate;

public class Locacao {

    private final int id;
    private static int idContador = 1;
    private Aluno aluno;
    private Equipamento equipamento;
    private LocalDate data;
    private Status status;

    public Locacao(Aluno aluno, Equipamento equipamento, LocalDate data, Status status) {
        setAluno(aluno);
        setEquipamento(equipamento);
        setData(data);
        this.status = Status.PENDENTE;
        this.id = idContador++;
    }

    public int getId() {
        return id;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        if (aluno == null) {
            throw new RuntimeException("ERRO: Aluno não pode ser nulo.");
        }
        this.aluno = aluno;
    }

    public Equipamento getEquipamento() {
        return equipamento;
    }

    public void setEquipamento(Equipamento equipamento) {
        if (equipamento == null) {
            throw new RuntimeException("ERRO: Equipamento não pode ser nulo.");
        }
        this.equipamento = equipamento;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        if (data == null) {
            throw new RuntimeException("ERRO: Data não pode ser nula.");
        }
        this.data = data;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        if (status == null) {
            throw new RuntimeException("ERRO: Status não pode ser nulo.");
        }
        this.status = status;
    }
}
