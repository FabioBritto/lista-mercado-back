package br.com.fabiobritto.applistamercado.services;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
public class ProdutoAPITests {

	/*
	 * O MockMvc pra fazer uma espécie de Postman FAKE
	 * Consigo simular uma requisição
	 */
	@Autowired
	private MockMvc mvc;
	
	/*
	 * Aqui eu simulo uma solitação/Requisição real pra API via MockMvc
	 * Expect/Espere um determinado resultado e PRINTE o resultado
	 */
	@Test
	public void deveriaRetornarProdutoPorId() throws Exception {
		mvc.perform(MockMvcRequestBuilders.get("/produtos/4"))
					.andExpect(MockMvcResultMatchers.status().isOk())
					.andDo(MockMvcResultHandlers.print());
		
	}
	
	@Test
	public void naoDeveriaAcharProduto() throws Exception {
		mvc.perform(MockMvcRequestBuilders.get("/produtos/100"))
					.andExpect(MockMvcResultMatchers.status().isNotFound())
					.andReturn();
		
	}
}
