package br.edu.ifal.sicovi.domain;

public enum TipoUsuario {
	ROLE_ADMINISTRADOR("ROLE_ADMINISTRADOR"), ROLE_ATENDENTE("ROLE_ATENDENTE"), ROLE_SUPERVISOR(
			"ROLE_SUPERVISOR"), ROLE_COORDENADOR("ROLE_COORDENADOR"), ROLE_COMANDANTE("ROLE_COMANDANTE");

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
