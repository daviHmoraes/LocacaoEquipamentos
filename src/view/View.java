package view;

import controller.AlunoController;
import controller.EquipamentoController;
import controller.LocacaoController;
import model.entity.Aluno;
import model.entity.Equipamento;
import model.entity.Locacao;
import model.entity.Status;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Scanner;

public class View {

    private AlunoController alunoController;
    private EquipamentoController equipamentoController;
    private LocacaoController locacaoController;

    Scanner sc = new Scanner(System.in);

    public View(AlunoController alunoController, EquipamentoController equipamentoController, LocacaoController locacaoController) {
        this.alunoController = alunoController;
        this.equipamentoController = equipamentoController;
        this.locacaoController = locacaoController;
    }

    public void exibirMenu() {

        int opcao = -1;

        do {

            System.out.println("╔══════════════════════════════════════════════╗");
            System.out.println("║      SISTEMA DE LOCAÇÃO DE EQUIPAMENTOS      ║");
            System.out.println("╠══════════════════════════════════════════════╣");
            System.out.println("║  1 ➜ Cadastrar Aluno                         ║");
            System.out.println("║  2 ➜ Cadastrar Equipamento                   ║");
            System.out.println("║  3 ➜ Gerenciar Locações                      ║");
            System.out.println("║  0 ➜ Sair                                    ║");
            System.out.println("╚══════════════════════════════════════════════╝");
            System.out.print("Escolha uma opção: ");

            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {

                case 1 -> cadastrarAluno();
                case 2 -> cadastrarEquipamento();
                case 3 -> menuLocacoes();
                case 0 -> System.out.println("Encerrando sistema...");
                default -> System.out.println("ERRO: Opção inválida.");

            }

        } while (opcao != 0);
    }

    public void cadastrarAluno() {

        System.out.println("\n===== CADASTRAR ALUNO =====");

        try {

            System.out.print("Nome: ");
            String nome = sc.nextLine();

            if (nome.isBlank()) {
                System.out.println("ERRO: Nome não pode ser vazio.");
                return;
            }

            System.out.print("Matrícula: ");
            String matricula = sc.nextLine();

            if (matricula.isBlank()) {
                System.out.println("ERRO: Matrícula não pode ser vazia.");
                return;
            }

            Aluno aluno = new Aluno(nome, matricula);
            alunoController.cadastrar(aluno);
            System.out.println("Aluno cadastrado com sucesso!");

        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }

    public void cadastrarEquipamento() {

        System.out.println("\n===== CADASTRAR EQUIPAMENTO =====");

        try {

            System.out.print("Nome: ");
            String nome = sc.nextLine();

            if (nome.isBlank()) {
                System.out.println("ERRO: Nome não pode ser vazio.");
                return;
            }

            System.out.print("Tipo: ");
            String tipo = sc.nextLine();

            if (tipo.isBlank()) {
                System.out.println("ERRO: Tipo não pode ser vazio.");
                return;
            }

            Equipamento equipamento = new Equipamento(nome, tipo);
            equipamentoController.salvar(equipamento);
            System.out.println("Equipamento cadastrado com sucesso!");

        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }

    public void menuLocacoes() {

        int opcao = -1;

        do {

            System.out.println("\n===== MENU DE LOCAÇÕES =====");
            System.out.println("1 - Realizar locação");
            System.out.println("2 - Listar locações");
            System.out.println("3 - Atualizar locação");
            System.out.println("4 - Finalizar locação");
            System.out.println("5 - Remover locação");
            System.out.println("0 - Voltar");
            System.out.print("Escolha uma opção: ");

            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {

                case 1 -> realizarLocacao();
                case 2 -> listarLocacoes();
                case 3 -> atualizarDadosLocacao();
                case 4 -> finalizarLocacao();
                case 5 -> removerLocacao();
                case 0 -> System.out.println("Voltando...");
                default -> System.out.println("ERRO: Opção inválida.");

            }

        } while (opcao != 0);
    }

    private void realizarLocacao() {

        System.out.println("\n===== REALIZAR LOCAÇÃO =====");

        try {

            System.out.print("ID do aluno: ");
            int idAluno = sc.nextInt();

            if (idAluno < 0) {
                System.out.println("ERRO: ID não pode ser negativo.");
                return;
            }

            System.out.print("ID do equipamento: ");
            int idEquipamento = sc.nextInt();

            if (idEquipamento < 0) {
                System.out.println("ERRO: ID não pode ser negativo.");
                return;
            }

            sc.nextLine();

            System.out.print("Data da locação (AAAA-MM-DD): ");
            String dataStr = sc.nextLine();

            LocalDate data;

            try {
                data = LocalDate.parse(dataStr);
            } catch (DateTimeParseException e) {
                System.out.println("ERRO: Data inválida.");
                return;
            }

            locacaoController.salvar(idAluno, idEquipamento, data, Status.PENDENTE);
            System.out.println("Locação realizada com sucesso!");

        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }

    private void listarLocacoes() {

        System.out.println("\n===== LISTA DE LOCAÇÕES =====");

        List<Locacao> locacoes = locacaoController.listar();

        if (locacoes == null || locacoes.isEmpty()) {
            System.out.println("Nenhuma locação cadastrada.");
            return;
        }

        for (Locacao locacao : locacoes) {
            System.out.println("ID: " + locacao.getId());
            System.out.println("Aluno: " + locacao.getAluno().getNome());
            System.out.println("Equipamento: " + locacao.getEquipamento().getNome());
            System.out.println("Data: " + locacao.getData());
            System.out.println("Status: " + locacao.getStatus());
            System.out.println("--------------------------------");
        }
    }

    private void atualizarDadosLocacao() {

        System.out.println("\n===== ATUALIZAR LOCAÇÃO =====");

        try {

            System.out.print("ID da locação: ");
            int idLocacao = sc.nextInt();

            if (idLocacao < 0) {
                System.out.println("ERRO: ID não pode ser negativo.");
                return;
            }

            System.out.print("Novo ID do aluno: ");
            int idAluno = sc.nextInt();

            if (idAluno < 0) {
                System.out.println("ERRO: ID não pode ser negativo.");
                return;
            }

            System.out.print("Novo ID do equipamento: ");
            int idEquipamento = sc.nextInt();

            if (idEquipamento < 0) {
                System.out.println("ERRO: ID não pode ser negativo.");
                return;
            }

            sc.nextLine();

            System.out.print("Nova data (AAAA-MM-DD): ");
            LocalDate data = LocalDate.parse(sc.nextLine());

            locacaoController.atualizar(idLocacao, idAluno, idEquipamento, data);
            System.out.println("Locação atualizada com sucesso!");

        } catch (Exception e) {
            System.out.println("ERRO: Dados inválidos.");
        }
    }

    private void finalizarLocacao() {

        System.out.println("\n===== FINALIZAR LOCAÇÃO =====");

        try {

            System.out.print("ID da locação: ");
            int id = sc.nextInt();
            sc.nextLine();

            if (id < 0) {
                System.out.println("ERRO: ID não pode ser negativo.");
                return;
            }

            Locacao locacao = locacaoController.buscarPorId(id);

            if (locacao == null) {
                return;
            }

            locacaoController.finalizar(locacao);
            System.out.println("Locação finalizada com sucesso!");

        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }

    private void removerLocacao() {

        System.out.println("\n===== REMOVER LOCAÇÃO =====");

        try {

            System.out.print("ID da locação: ");
            int id = sc.nextInt();
            sc.nextLine();

            if (id < 0) {
                System.out.println("ERRO: ID não pode ser negativo.");
                return;
            }

            locacaoController.remover(id);
            System.out.println("Locação removida com sucesso!");

        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }
}