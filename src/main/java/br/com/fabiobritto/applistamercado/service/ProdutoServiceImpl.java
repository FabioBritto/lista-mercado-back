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
		return repository.save(produto);
	}

	@Override
	public Produto alterarProduto(Produto produto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removerProduto(Produto produto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Produto> listarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Produto> buscarPorPalavraChave(String palavraChave) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Produto buscarPorID(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

}
