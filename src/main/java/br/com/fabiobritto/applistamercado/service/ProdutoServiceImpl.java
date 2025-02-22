package br.com.fabiobritto.applistamercado.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.fabiobritto.applistamercado.model.Produto;
import br.com.fabiobritto.applistamercado.repository.ProdutoRepository;

/*
 * Com @Component, posso injetar a implementação de ProdutoServiceImpl em qualquer chamada. Preciso
 * do @AutoWired na outra ponta
 */
@Component
public class ProdutoServiceImpl implements IProdutoService {
	
	@Autowired
	private ProdutoRepository repository;

	@Override
	public Produto criarNovoProduto(Produto produto) {
		if(produto.getNome() == null || produto.getNome() == "") {
			return null;
		}
		return repository.save(produto);
	}

	@Override
	public Produto alterarProduto(Produto produto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removerProduto(Produto produto) {
		repository.delete(produto);
	}

	@Override
	public List<Produto> listarTodos() {
		return (List<Produto>) repository.findAll();
}

	@Override
	public List<Produto> buscarPorPalavraChave(String palavraChave) {
		return repository.findAllByNomeContaining(palavraChave);
	}

	@Override
	public Produto buscarPorID(Integer id) {
		return repository.findById(id).orElse(null);
	}

}
