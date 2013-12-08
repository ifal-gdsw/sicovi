package br.du.ifal.sicovi.controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class TesteBean {
	public String teste = "Testinho Brasil";

	/**
	 * @return the teste
	 */
	public String getTeste() {
		return teste;
	}

	/**
	 * @param teste
	 *            the teste to set
	 */
	public void setTeste(String teste) {
		this.teste = teste;
	}

}
