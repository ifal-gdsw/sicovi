package br.edu.ifal.sicovi.domain;

public enum TipoUsuario {
	ADMINISTRADOR("ADMINISTRADOR"), ATENDENTE("ATENDENTE"), SUPERVISOR(
			"SUPERVISOR"), COORDENADOR("COORDENADOR"), COMANDANTE("COMANDANTE");

	private String tipo;

	TipoUsuario(String tipo) {
		this.setTipo(tipo);
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
}
