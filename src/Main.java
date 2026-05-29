import controller.*;
import model.repository.*;
import model.service.*;
import view.View;

public class Main {

    public static void main(String[] args) {

        AlunoRepository alunoRepository = new AlunoRepository();
        EquipamentoRepository equipamentoRepository = new EquipamentoRepository();
        LocacaoRepository locacaoRepository = new LocacaoRepository();

        AlunoService alunoService = new AlunoService(alunoRepository);

        EquipamentoService equipamentoService = new EquipamentoService(equipamentoRepository);

        LocacaoService locacaoService = new LocacaoService(locacaoRepository, alunoService, equipamentoService);

        AlunoController alunoController = new AlunoController(alunoService);

        EquipamentoController equipamentoController = new EquipamentoController(equipamentoService);

        LocacaoController locacaoController = new LocacaoController(locacaoService);

        View view = new View(alunoController, equipamentoController, locacaoController);

        view.exibirMenu();
    }
}