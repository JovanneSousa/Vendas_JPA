package br.com.jsousa.domain.jpa;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "TB_VENDA")
public class VendaJpa implements Persistente {
	
	public enum Status {
		INICIADA, CONCLUIDA, CANCELADA;
		
		public static Status getByName(String value) {
			for (Status status : Status.values()) {
				if (status.name().equals(value)) {
					return status;
				}
			}
			
			return null;
		}
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "venda_sq")
	@SequenceGenerator(name = "venda_sq", sequenceName = "sq_venda", initialValue = 1, allocationSize = 1)
	private Long id;
	
	@Column(name = "CODIGO", nullable = false, unique = true)
	private String codigo;
	
	@ManyToOne
	@JoinColumn(name = "id_cliente_fk",
		foreignKey = @ForeignKey(name = "fk_venda_cliente"),
		referencedColumnName = "id", nullable = false)
	private ClienteJpa cliente;
	
	@OneToMany(mappedBy = "venda", cascade = CascadeType.ALL)
	private Set<ProdutoQuantidadeJpa> produtos;
	
	@Column(name = "VALOR_TOTAL", nullable = false)
	private BigDecimal valorTotal;
	
	@Column(name = "DATA_VENDA", nullable = false)
	private Instant dataVenda;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "STATUS", nullable = false)
	private Status status;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public ClienteJpa getCliente() {
		return cliente;
	}

	public void setCliente(ClienteJpa cliente) {
		this.cliente = cliente;
	}

	public Set<ProdutoQuantidadeJpa> getProdutos() {
		return produtos;
	}

	public void setProdutos(Set<ProdutoQuantidadeJpa> produtos) {
		this.produtos = produtos;
	}

	public BigDecimal getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}

	public Instant getDataVenda() {
		return dataVenda;
	}

	public void setDataVenda(Instant dataVenda) {
		this.dataVenda = dataVenda;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

}
