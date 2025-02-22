package br.com.fabiobritto.applistamercado.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.fabiobritto.applistamercado.model.ItemLista;
import br.com.fabiobritto.applistamercado.model.Lista;
import br.com.fabiobritto.applistamercado.model.enums.Status;
import br.com.fabiobritto.applistamercado.repository.ListaRepository;

@Component
public class ListaServiceImpl implements IListaService {
	
	@Autowired
	private ListaRepository repository;

	@Override
	public Lista criarNovaLista(Lista novaLista) {
		return repository.save(novaLista);
	}

	@Override
	public void removerLista(Integer id) {
		repository.deleteById(id);
	}

	@Override
	public Lista fecharLista(Integer id) {
		Lista lista = repository.findById(id).get();
		List<ItemLista> itens = lista.getItens();
		
//		itens.stream().map((e) -> e.get)
		
		double total = 0.0;
		
		for(ItemLista item : lista.getItens()) {
			total += lista.getValorTotal();
		}
		lista.setValorTotal(total);
		lista.setStatus(Status.CONCLUIDO);
		return lista;
	}

	@Override
	public Lista buscarPeloId(Integer id) {
		return repository.findById(id).orElse(null);
	}

	@Override
	public List<Lista> buscarTodas() {
		return (List<Lista>) repository.findAll();
	}

}
