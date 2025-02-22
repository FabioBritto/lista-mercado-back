package br.com.fabiobritto.applistamercado.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.fabiobritto.applistamercado.model.Produto;
import br.com.fabiobritto.applistamercado.service.IProdutoService;

@RestController
public class ProdutoController {

	/*
	 * Aqui, o nível de FRACO ACOPLAMENTO é tão alto, que eu não preciso me preocupar nem com
	 * QUAL É A CLASSE que implementa esta interface
	 */
	@Autowired
	private IProdutoService service;
	
	/*
	 * Com ResponseEntity<Produto> como tipo de resposta, tenho como manipular o cabeçalho HTTP das respostas.
	 * A anotação @RequestBody diz pra mim de onde vem o parâmtro que eu preciso, que no caso, vem do Corpo da Requisição
	 * 
	 */
	@PostMapping("/produtos")
	public ResponseEntity<Produto> cadastrarNovo(@RequestBody Produto novoProduto){
		Produto produto = service.criarNovoProduto(novoProduto);
		if(produto != null) {
			return ResponseEntity.status(HttpStatus.CREATED).body(produto);
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
	}
	
	/*
	 * O @RequestParam diz que a PALAVRA CHAVE vem junto com a requisição. Então, eu faço com que a URL fique:
	 * "...URL.../produtos?k=" palavraChave
	 */
	@GetMapping("/produtos/search")
	public ResponseEntity<List<Produto>> recuperarPorPalavraChave(@RequestParam(name="k") String palavraChave) {
		return ResponseEntity.ok(service.buscarPorPalavraChave(palavraChave));
	}
	
	@GetMapping("/produtos/{id}")
	public ResponseEntity<Produto> recuperarPorId(@PathVariable Integer id){
		Produto res = service.buscarPorID(id);
		
		if(res != null) {
			return ResponseEntity.ok(res);
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}
	
	@GetMapping("/produtos")
	public ResponseEntity<List<Produto>> recuperarTodos(){
		return ResponseEntity.ok(service.listarTodos());	
		
	}
	
}
