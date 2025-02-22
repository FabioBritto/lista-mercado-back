package br.com.fabiobritto.applistamercado.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import br.com.fabiobritto.applistamercado.model.Produto;
import br.com.fabiobritto.applistamercado.repository.ProdutoRepository;
import br.com.fabiobritto.applistamercado.service.ProdutoServiceImpl;

@SpringBootTest
@ActiveProfiles("test")
public class ProdutoTestes {
	
	/*
	 * Pelo que entendi, uma espécie de @AutoWired, mas também em nível de teste
	 */
	@InjectMocks
	private ProdutoServiceImpl service;
	
	/*
	 * Sinalizando que será um instância de ProdutoRepository para as simulações/testes
	 */
	@Mock
	private ProdutoRepository repository;
	
	private Integer existeId = 1;
	private Integer naoExisteId = 100;
	private String palavra = "bolacha";
	private Produto novoProduto;
	private Produto produtoCriado;
	
	private List<Produto> listaDeVariosProdutos;
	
	@BeforeEach
	public void setup() throws Exception {
		/*
		 * Preciso de duas instâncias diferentes de Produto, pois aqui, estou simulando minha interação com o Banco de Dados.
		 * No Banco de Dados, quando executo um save(), eu retorno um produto criado. São duas instâncias diferentes.
		 * Como eu não preciso lidar com a criação de um ID, eu seto apenas o nome do novoProduto.
		 * Então, quando "mocko" o objeto, eu retorno "produtoCriado" que contém o mesmo dado de nome, porém com um ID fictício gerado
		 */
		novoProduto = new Produto();
		novoProduto.setNome("bolacha");
		
		produtoCriado = new Produto();
		produtoCriado.setId(1);
		produtoCriado.setNome("bolacha");
		
		listaDeVariosProdutos = new ArrayList<>();
		Produto p1, p2;
		p1 = new Produto(2, "Bolacha recheada");
		p2 = new Produto(3, "Bolacha água e sal");
		listaDeVariosProdutos.add(p1);
		listaDeVariosProdutos.add(p2);
		
		Mockito.when(repository.save(novoProduto)).thenReturn(produtoCriado);
		Mockito.when(repository.findById(existeId)).thenReturn(Optional.of(new Produto()));
		Mockito.when(repository.findById(naoExisteId)).thenReturn(Optional.ofNullable(null));
		Mockito.when(repository.findAllByNomeContaining(palavra)).thenReturn(listaDeVariosProdutos);
		Mockito.when(repository.findAllByNomeContaining("biscoito")).thenReturn(new ArrayList<Produto>());
	}
	
	
	@Test
	public void deveriaCadastrarProduto() {
		/*
		 * Como eu fiz uma lista de implementações com o Mockito acima, quando eu chamar o "service.criarNovoProduto()" que
		 * implementa o "repository.save()", não será o do Banco a ser chamado, e sim o do Mockito
		 */
		//assertNotNull(service.criarNovoProduto(novoProduto));
		/*
		 * Confiro se os dois são iguais
		 */
		assertEquals(service.criarNovoProduto(novoProduto), produtoCriado);
	}
	
	@Test
	public void deveriaRetornarPeloId() {
		assertNotNull(service.buscarPorID(existeId));
	}
	
	@Test
	public void deveriaNaoEncontrarId() {
		assertNull(service.buscarPorID(naoExisteId));
	}
	
	@Test
	public void deveriaRetornarListaComPalavraChave() {
		//Estou conferindo se quando eu passo palavra como parâmetro a lista me retorna vazia
		assertTrue(service.buscarPorPalavraChave(palavra).size() > 0);
	}
	
	@Test
	public void deveriaRetornarListaVazia() {
		assertTrue(service.buscarPorPalavraChave("biscoito").size() == 0);
	}
}
