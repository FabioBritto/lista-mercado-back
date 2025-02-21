package br.com.fabiobritto.applistamercado.services;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import br.com.fabiobritto.applistamercado.model.Produto;
import br.com.fabiobritto.applistamercado.service.IProdutoService;

@SpringBootTest
@ActiveProfiles("test")
public class ProdutoTestes {
	
//	@Autowired
//	private static ProdutoServiceImpl service;
	
	@Autowired
	private IProdutoService service;
	private static Integer id = 1;
	private static Integer idFound = 1;
	private static Integer idNotFound = 100;
	private static Produto novoProduto;
	private static Produto produtoCriado;

	@BeforeAll
	public static void setup() {
		System.out.println("Configurando parâmetros de testes");
		novoProduto = new Produto();
		novoProduto.setNome("Bolacha");
		
		produtoCriado = new Produto();
		produtoCriado.setNome("Bolacha");
		produtoCriado.setId(1);
		
//		service = Mockito.mock(ProdutoServiceImpl.class);
//		Mockito.when(service.criarNovoProduto(novoProduto)).thenReturn(produtoCriado);
//		Mockito.when(service.buscarPorID(idFound)).thenReturn(produtoCriado);
//		Mockito.when(service.buscarPorID(idNotFound)).thenReturn(null);
//		Mockito.when(service.buscarPorPalavraChave("b")).thenReturn(new ArrayList<Produto>());
//		Mockito.when(service.listarTodos()).thenReturn(new ArrayList<Produto>());
//		Mockito.when(service.alterarProduto(produtoCriado)).thenReturn(produtoCriado);
		
	}
	
	@Test
	public void shouldStoreAProduct() {

		System.out.println(novoProduto);
		assertNotNull(service.criarNovoProduto(novoProduto));
		
	}
}
