    package model.service;

    import java.util.HashMap;

    import model.entity.Equipamento;
    import model.repository.EquipamentoRepository;

    public class EquipamentoService {

        private EquipamentoRepository equipamentoRepository;

        public EquipamentoService() {


            equipamentoRepository = new EquipamentoRepository();

        }

        public boolean cadastrarEquipamento(Equipamento equipamento) {

            //validar ID
            if (equipamento.getId() <= 0) {

                System.out.println("ID inválido. ");
                return false;
            }

            //validar nome
            if (equipamento.getNome() == null || equipamento.getNome().trim().isEmpty()) {

                System.out.println("Nome inválido. ");
                return false;

            }

            //validar tipo

            if (equipamento.getTipo() == null || equipamento.getTipo().trim().isEmpty()) {

                System.out.println("Tipo inválido. ");
                return false;
            }

            //validar ID existente

            if (equipamentoRepository.buscarID(equipamento.getId()) != null) {

                System.out.println("Esse equipamento já existe. ");
                return false;

            }

            //equipamento começa disponível

            equipamento.setDisponivel(true);

            equipamentoRepository.salvar(equipamento);

            System.out.println("Equipamento cadastrado com sucesso.");
            return true;
        }

        //Listar equipamento
        public HashMap<Integer, Equipamento> listarEquipamento() {

            return equipamentoRepository.listarEquipamento();

        }

        //Buscar equipamento
        public Equipamento buscarEquipamento(int id) {

            if (id <= 0) {

                System.out.println("ID inválido");
                return null;

            }

            Equipamento equipamento = equipamentoRepository.buscarID(id);

            if (equipamento == null) {

                System.out.println("Equipamento não encontrado. ");
            }

            return equipamento;

        }

        //Atualizar equipamento
        public boolean atualizarEquipamento(Equipamento equipamentoAtualizado) {

            Equipamento equipamento = equipamentoRepository.buscarID(equipamentoAtualizado.getId());

            //verificar se existe
            if (equipamento == null) {

                System.out.println("Equipamento não encontrado.");
                return false;
            }

            //validar nome
            if (equipamentoAtualizado.getNome() == null || equipamentoAtualizado.getNome().trim().isEmpty()) {

                System.out.println("Nome inválido.");
                return false;
            }

            //validar tipo
            if (equipamentoAtualizado.getTipo() == null || equipamentoAtualizado.getTipo().trim().isEmpty()) {

                System.out.println("Tipo inválido.");
                return false;
            }
            equipamento.setNome(equipamentoAtualizado.getNome());

            equipamento.setTipo(equipamentoAtualizado.getTipo());

            equipamentoRepository.salvar(equipamento);

            System.out.println("Equipamento atualizado com sucesso.");

            return true;
        }


        //remover equipamento
        public boolean removerEquipamento(int id) {

            Equipamento equipamento = buscarEquipamento(id);

            if (equipamento == null) {

                return false;

            }

            equipamentoRepository.removerEquipamento(id);

            System.out.println("Equipamento removido. ");
            return true;

        }

    }
