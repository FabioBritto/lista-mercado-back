package br.com.fabiobritto.applistamercado.service;

import br.com.fabiobritto.applistamercado.model.ItemLista;

public interface IItemListaService {

	public ItemLista inserirItem(ItemLista novoItem);
	public ItemLista alterarItem(ItemLista item);
	public void removerItem(Integer numSequencia);
}
