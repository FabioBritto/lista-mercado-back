package br.com.fabiobritto.applistamercado.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.fabiobritto.applistamercado.model.enums.Status;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_itemlista")
public class ItemLista {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "num_sequencia")
	private Integer numSequencia;
	
	@Column(name = "quantidade")
	private Double quantidade;
	
	@Column(name = "preco_total")
	private Double precoTotal;
	
	@Column(name = "status")
	@Enumerated(EnumType.ORDINAL)
	private Status status;
	
	
	/*
	 * Eu preciso especificar o nome que referencia "Produto" na tb_itemlista.
	 */
	@ManyToOne
	@JoinColumn(name = "tb_produto_id_produto")
	private Produto produto;
	
	@ManyToOne
	@JoinColumn(name = "tb_lista_id_lista")
	private Lista lista;

	public Integer getNumSequencia() {
		return numSequencia;
	}

	public void setNumSequencia(Integer numSequencia) {
		this.numSequencia = numSequencia;
	}

	public Double getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Double quantidade) {
		this.quantidade = quantidade;
	}

	public Double getPrecoTotal() {
		return precoTotal;
	}

	public void setPrecoTotal(Double precoTotal) {
		this.precoTotal = precoTotal;
	}

	public Status getConcluido() {
		return status;
	}

	public void setConcluido(Status status) {
		this.status = status;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public Lista getLista() {
		return lista;
	}

	public void setStatus(Status status) {
		if(status != null) {
			this.status = status;
		}
	}

	/*
	 * Para o caso HashCode e Equals, preciso entender como será feita a comparação
	 */
	
	
	@Override
	public String toString() {
		return "ItemLista [numSequencia=" + numSequencia + ", quantidade=" + quantidade + ", precoTotal=" + precoTotal
				+ ", status=" + status + ", produto=" + produto + ", lista=" + lista + "]";
	}
	
	
}
