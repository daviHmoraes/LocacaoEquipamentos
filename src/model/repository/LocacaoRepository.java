package model.repository;

import model.entity.Locacao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LocacaoRepository {

    private final HashMap<Integer, Locacao> mapa = new HashMap<>();

    public void salvar(Locacao locacao) { mapa.put(locacao.getId(), locacao); }

    public Locacao buscarPorId(int id) { return mapa.get(id); }

    public List<Locacao> listar() { return new ArrayList<>(mapa.values()); }

    public void atualizar(Locacao locacao) { mapa.put(locacao.getId(), locacao); }

    public void remover(Locacao locacao) { mapa.remove(locacao.getId()); }

}