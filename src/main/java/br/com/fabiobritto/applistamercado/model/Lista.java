package br.com.fabiobritto.applistamercado.model;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import br.com.fabiobritto.applistamercado.model.enums.Status;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_lista")
public class Lista {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_lista")
	private Integer id;
	
	@Column(name = "data_criacao", nullable = false)
	private LocalDate data;
	
	@Column(name = "nome_mercado", length = 50)
	private String nomeMercado;
	
	@Column(name = "valor_total")
	private Double valorTotal;
	
	@Column(name = "status")
	@Enumerated(EnumType.ORDINAL)
	private Status status;
	
	/*
	 * O "mappedBy" procura dentro de "ItemLista" qual o atributo que referencia Lista
	 * 
	 * O CascadeType.ALL me permite que eu possa, a partir uma lista populada (cheia de itens), dar um 
	 * INSERT (por exemplo), e então, quando, no banco for salvo esta lista, ele salvará também os itens
	 * 
	 * ----------------------
	 * 
	 * Ao recuperar o ItemLista, haverá uma lista. Eu quero que no ato da recuperação, seja ignorado o atributo "lista"
	 */
	@JsonIgnoreProperties("lista")
	@OneToMany(mappedBy = "lista", cascade = CascadeType.ALL)
	private List<ItemLista> itens;
	
	public Lista() {
		
	}

	public Lista(Integer id, LocalDate data, String nomeMercado, Double valorTotal, Status status) {
		this.id = id;
		this.data = data;
		this.nomeMercado = nomeMercado;
		this.valorTotal = valorTotal;
		setStatus(status);
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public String getNomeMercado() {
		return nomeMercado;
	}

	public void setNomeMercado(String nomeMercado) {
		this.nomeMercado = nomeMercado;
	}

	public Double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		if(status != null) {
			this.status = status;
		}
	}
	

	public List<ItemLista> getItens() {
		return itens;
	}

	public void setItens(List<ItemLista> itens) {
		this.itens = itens;
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
		Lista other = (Lista) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Lista [id=" + id + ", data=" + data + ", nomeMercado=" + nomeMercado + ", valorTotal=" + valorTotal
				+ ", status=" + status + "]";
	}
	
	
}
