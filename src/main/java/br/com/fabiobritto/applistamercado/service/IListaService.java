package br.com.fabiobritto.applistamercado.service;

import java.util.List;

import br.com.fabiobritto.applistamercado.model.Lista;

public interface IListaService {

	public Lista criarNovaLista(Lista novaLista);
	public void removerLista(Integer id);
	public Lista fecharLista(Integer id);
	public Lista buscarPeloId(Integer id);
	public List<Lista> buscarTodas();
}
