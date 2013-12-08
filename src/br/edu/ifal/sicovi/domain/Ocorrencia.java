package br.edu.ifal.sicovi.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "ocorrencia")
public class Ocorrencia implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "id", sequenceName = "seq_ocorrencia_id")
	@GeneratedValue(generator = "id", strategy = GenerationType.IDENTITY)
	private Integer id;

	@ManyToOne
	@JoinColumn(name = "localizacao_id")
	private Localizacao localizacao;

	@Column(nullable = false, columnDefinition = "TEXT")
	private String descricao;

	private Viatura viatura;
	private Date dataHora;

	@ManyToMany(mappedBy = "ocorrencias")
	private List<Vitima> vitimas;

	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private StatusOcorrencia status = StatusOcorrencia.EM_ANDAMENTO;

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
	 * @return the viatura
	 */
	public Viatura getViatura() {
		return viatura;
	}

	/**
	 * @param viatura
	 *            the viatura to set
	 */
	public void setViatura(Viatura viatura) {
		this.viatura = viatura;
	}

	/**
	 * @return the dataHora
	 */
	public Date getDataHora() {
		return dataHora;
	}

	/**
	 * @param dataHora
	 *            the dataHora to set
	 */
	public void setDataHora(Date dataHora) {
		this.dataHora = dataHora;
	}

	/**
	 * @return the vitimas
	 */
	public List<Vitima> getVitimas() {
		return vitimas;
	}

	/**
	 * @param vitimas
	 *            the vitimas to set
	 */
	public void setVitimas(List<Vitima> vitimas) {
		this.vitimas = vitimas;
	}

	/**
	 * @return the status
	 */
	public StatusOcorrencia getStatus() {
		return status;
	}

	/**
	 * @param status
	 *            the status to set
	 */
	public void setStatus(StatusOcorrencia status) {
		this.status = status;
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
				+ ((dataHora == null) ? 0 : dataHora.hashCode());
		result = prime * result
				+ ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((localizacao == null) ? 0 : localizacao.hashCode());
		result = prime * result + ((viatura == null) ? 0 : viatura.hashCode());
		result = prime * result + ((vitimas == null) ? 0 : vitimas.hashCode());
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
		Ocorrencia other = (Ocorrencia) obj;
		if (dataHora == null) {
			if (other.dataHora != null)
				return false;
		} else if (!dataHora.equals(other.dataHora))
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
		if (viatura == null) {
			if (other.viatura != null)
				return false;
		} else if (!viatura.equals(other.viatura))
			return false;
		if (vitimas == null) {
			if (other.vitimas != null)
				return false;
		} else if (!vitimas.equals(other.vitimas))
			return false;
		return true;
	}

}
