package br.com.fabiobritto.applistamercado.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.fabiobritto.applistamercado.model.Lista;
import br.com.fabiobritto.applistamercado.service.IListaService;

/*
 * @CrossOrigin("*") me permite receber requisições de outras origens
 */
@RestController
@CrossOrigin("*")
public class ListaController {

	@Autowired
	private IListaService service;
	//private ListaServiceImpl service;
	
	@GetMapping("/listas")
	public ResponseEntity<List<Lista>> recuperarTodas(){
		return ResponseEntity.ok(service.buscarTodas());
	}
	
	@GetMapping("/listas/{id}")
	public ResponseEntity<Lista> recuperarPeloId(@PathVariable Integer id){
		Lista lista = service.buscarPeloId(id);
		if(lista != null) {
			return ResponseEntity.ok(lista);
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}
	
	@PostMapping("/lista")
	public ResponseEntity<Lista> criarLista(@RequestBody Lista lista){
		lista = service.criarNovaLista(lista);	
		if(lista != null) {
			return ResponseEntity.status(HttpStatus.CREATED).body(lista);
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();		
	}
	
	
	@PutMapping("/listas/{id}")
	public ResponseEntity<Lista> alterarLista(@PathVariable Integer id){
		Lista lista = service.fecharLista(id);	
		if(lista != null) {
			return ResponseEntity.status(HttpStatus.OK).build();
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		
	}
	
	@DeleteMapping("/listas/{id}")
	public ResponseEntity<?> removerLista(@PathVariable Integer id){
		service.removerLista(id);
		return ResponseEntity.ok("Lista removida!");
	}
	
}
