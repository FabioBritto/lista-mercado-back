package br.com.fabiobritto.applistamercado.service;

import br.com.fabiobritto.applistamercado.model.ItemLista;
import br.com.fabiobritto.applistamercado.model.Lista;

public interface IListaService {

	public Lista criarNovaLista(Lista novaLista);
	public void removerLista(Integer id);
	public void fecharLista(Integer id);
	public void buscarPeloId(Integer id);
	
}
