package br.com.cervejaria.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.NumberFormat.Style;

@Entity
@Table(name="cervejas")
public class CervejaEntity implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message="A cerveja deve possuir um valor de SKU válido")
	private String sku;
	
	@NotBlank(message="O nome da cerveja é obrigatório")
	private String nome;
	
	
	@Size(min=2 , max=100, message="A descrição deve conter entre {min} e {max} caracteres")
	private String descricao;
	
	
	private String foto;
	

	@NotNull(message="O valor da cerveja não pode ser nullo")
	@NumberFormat(style = Style.CURRENCY, pattern="#,##0.00")
	private BigDecimal valor;
	
	@NotNull(message="O valor do teor alcoolico é obrigatório")
	@Column(name="teor_alcoolico")
	private BigDecimal teorAlcoolico;
	
	@NumberFormat(style=Style.CURRENCY, pattern="#,##0.00")
	private BigDecimal comissao;
	
	@NotNull
	@NumberFormat(style=Style.NUMBER)
	@Column(name="quantidade_estoque")
	private Integer quantidadeEstoque;
	
	@NotNull
	@Enumerated(EnumType.STRING)
	private Origem origem;
	
	@NotNull
	@Enumerated(EnumType.STRING)
	private Sabor sabor;
	
	@ManyToOne
	@JoinColumn(name="id_estilo_fk")
	private EstiloCervejaEntity estilo;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}


	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public BigDecimal getTeorAlcoolico() {
		return teorAlcoolico;
	}

	public void setTeorAlcoolico(BigDecimal teorAlcoolico) {
		this.teorAlcoolico = teorAlcoolico;
	}

	public BigDecimal getComissao() {
		return comissao;
	}

	public void setComissao(BigDecimal comissao) {
		this.comissao = comissao;
	}

	public Integer getQuantidadeEstoque() {
		return quantidadeEstoque;
	}

	public void setQuantidadeEstoque(Integer quantidadeEstoque) {
		this.quantidadeEstoque = quantidadeEstoque;
	}

	public Origem getOrigem() {
		return origem;
	}

	public void setOrigem(Origem origem) {
		this.origem = origem;
	}

	public Sabor getSabor() {
		return sabor;
	}

	public void setSabor(Sabor sabor) {
		this.sabor = sabor;
	}

	public EstiloCervejaEntity getEstilo() {
		return estilo;
	}

	public void setEstilo(EstiloCervejaEntity estilo) {
		this.estilo = estilo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CervejaEntity other = (CervejaEntity) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	
	
}
