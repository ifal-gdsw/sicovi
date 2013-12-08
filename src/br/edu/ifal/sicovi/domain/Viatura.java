package br.edu.ifal.sicovi.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "viatura")
public class Viatura implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@SequenceGenerator(name = "id", sequenceName = "seq_viatura_id")
	@GeneratedValue(generator = "id", strategy = GenerationType.IDENTITY)
	private Integer id;
	private String descricao;

	@OneToOne
	@JoinColumn(name = "comandante_id")
	private Militar comandante;

	@OneToOne
	@JoinColumn(name = "condutor_id")
	private Militar condutor;

	@OneToOne
	@JoinColumn(name = "localizacao_id")
	private Localizacao localizacao;

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the descricao
	 */
	public String getDescricao() {
		return descricao;
	}

	/**
	 * @param descricao
	 *            the descricao to set
	 */
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	/**
	 * @return the comandante
	 */
	public Militar getComandante() {
		return comandante;
	}

	/**
	 * @param comandante
	 *            the comandante to set
	 */
	public void setComandante(Militar comandante) {
		this.comandante = comandante;
	}

	/**
	 * @return the condutor
	 */
	public Militar getCondutor() {
		return condutor;
	}

	/**
	 * @param condutor
	 *            the condutor to set
	 */
	public void setCondutor(Militar condutor) {
		this.condutor = condutor;
	}

	/**
	 * @return the localizacao
	 */
	public Localizacao getLocalizacao() {
		return localizacao;
	}

	/**
	 * @param localizacao
	 *            the localizacao to set
	 */
	public void setLocalizacao(Localizacao localizacao) {
		this.localizacao = localizacao;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((comandante == null) ? 0 : comandante.hashCode());
		result = prime * result
				+ ((condutor == null) ? 0 : condutor.hashCode());
		result = prime * result
				+ ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((localizacao == null) ? 0 : localizacao.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Viatura other = (Viatura) obj;
		if (comandante == null) {
			if (other.comandante != null)
				return false;
		} else if (!comandante.equals(other.comandante))
			return false;
		if (condutor == null) {
			if (other.condutor != null)
				return false;
		} else if (!condutor.equals(other.condutor))
			return false;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (localizacao == null) {
			if (other.localizacao != null)
				return false;
		} else if (!localizacao.equals(other.localizacao))
			return false;
		return true;
	}

}
