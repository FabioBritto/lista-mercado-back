package br.com.fabiobritto.applistamercado.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.fabiobritto.applistamercado.model.ItemLista;
import br.com.fabiobritto.applistamercado.repository.ItemListaRepository;

@Component
public class ItemListaServiceImpl implements IItemListaService {

	@Autowired
	private ItemListaRepository repository;

	/* 
	 * O que diferencia um save do outro, é justamente a ausência ou não de um ID.
	 * Se houver um ID junto com o item, então ele já existe no Banco de Dados
	 */
	
	@Override
	public ItemLista inserirItem(ItemLista novoItem) {
		return repository.save(novoItem);
	}

	@Override
	public ItemLista alterarItem(ItemLista item) {
		return repository.save(item);	
	}

	@Override
	public void removerItem(Integer numSequencia) {
		repository.deleteById(numSequencia);
		
	}

}
