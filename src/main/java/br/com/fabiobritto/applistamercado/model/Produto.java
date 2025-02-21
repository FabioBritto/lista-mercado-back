package br.com.fabiobritto.applistamercado.model;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_produto")
public class Produto {

	/*
	 * Preciso me atentar a como o Banco de Dados que estou utilizando no projeto lida com o GenerationType
	 * No caso do MySQL, ele usa campos IDENTITY
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_produto")
	private Integer id;
	
	@Column(name = "nome_produto", length = 60, nullable = false)
	private String nome;
	
	
	/*
	 * Como o meu nome não pode ser falso, eu garanto que mesmo em caso de um construtor vazio,
	 * o meu campo "nome" rececerá uma String vazia no lugar de null
	 */
	public Produto() {
		this.nome = "";
	}
	
	public Produto(Integer id, String nome) {
		this.id = id;
		this.nome = nome;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produto other = (Produto) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Produto [id=" + id + ", nome=" + nome + "]";
	}
	
	
}
