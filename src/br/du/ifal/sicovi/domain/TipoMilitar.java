package br.du.ifal.sicovi.domain;

public enum TipoMilitar {
	COMANDANTE("COMANDANTE"), CONDUTOR("CONDUTOR");

	private String tipo;

	private TipoMilitar(String tipo) {
		this.tipo = tipo;
	}

	/**
	 * @return the tipo
	 */
	public String getTipo() {
		return tipo;
	}

	/**
	 * @param tipo
	 *            the tipo to set
	 */
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

}
