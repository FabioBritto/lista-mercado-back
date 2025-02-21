package br.com.fabiobritto.applistamercado.service;

import java.util.List;

import br.com.fabiobritto.applistamercado.model.Produto;

public interface IProdutoService {

	public Produto criarNovoProduto(Produto produto);
	public Produto alterarProduto(Produto produto);
	public void removerProduto(Produto produto);
	public List<Produto> listarTodos();
	public List<Produto> buscarPorPalavraChave(String palavraChave);
	public Produto buscarPorID(Integer id);
}
