package br.com.fabiobritto.applistamercado.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.fabiobritto.applistamercado.model.ItemLista;
import br.com.fabiobritto.applistamercado.model.Lista;
import br.com.fabiobritto.applistamercado.service.IItemListaService;

@RestController
public class ItemListaController {

	@Autowired
	private IItemListaService service;
	
	@PostMapping("/itemlista")
	public ResponseEntity<ItemLista> inserirItem(@RequestBody ItemLista item){
		item = service.inserirItem(item);
		if(item != null) {
			return ResponseEntity.status(HttpStatus.CREATED).build();
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
	}
	
	/*
	 * Passar tanto o @RequestBody quanto o @PathVariable me dá uma garantia de que mesmo se
	 * POR UM ACASO o item vier sem um identificador, eu seto a partir do conteúdo do corpo da URL
	 */
	@PutMapping("/itemlista/{numSequencia}")
	public ResponseEntity<ItemLista> alterarItem(@RequestBody ItemLista item, @PathVariable Integer numSequencia){
		item.setNumSequencia(numSequencia);
		item = service.alterarItem(item);
		
		if(item != null) {
			return ResponseEntity.status(HttpStatus.ACCEPTED).build();
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
	}
	
	@DeleteMapping("/itemlista/{numSequencia}")
	public ResponseEntity<?> removerItem(@PathVariable Integer numSequencia){
		service.removerItem(numSequencia);
		return ResponseEntity.ok("Item Removido!");
	}
}
