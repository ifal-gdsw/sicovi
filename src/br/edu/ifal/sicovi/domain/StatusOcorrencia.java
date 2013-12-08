package br.edu.ifal.sicovi.domain;

public enum StatusOcorrencia {
	EM_ANDAMENTO("EM ANDAMENTO"), ENCERRADA("ENCERRADA"), FINALIZADA(
			"FINALIZADA");

	private String status;

	StatusOcorrencia(String status) {
		this.status = status;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status
	 *            the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

}
