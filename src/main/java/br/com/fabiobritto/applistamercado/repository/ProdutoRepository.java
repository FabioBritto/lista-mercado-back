package br.com.fabiobritto.applistamercado.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.com.fabiobritto.applistamercado.model.Produto;

public interface ProdutoRepository extends CrudRepository<Produto, Integer>{

	public List<Produto> findAllByNomeContaining(String palavraChave);
}
