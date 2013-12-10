package br.edu.ifal.sicovi.controller;

import java.io.IOException;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

@ManagedBean
@RequestScoped
public class LoginBean {
	// managed properties for the login page, username/password/etc...
	private String senha;
	private String usuario;

	// This is the action method called when the user clicks the "login" button
	public String login() throws IOException, ServletException {

		FacesContext facesContext = FacesContext.getCurrentInstance();
		ExternalContext externalContext = facesContext.getExternalContext();

		RequestDispatcher dispatcher = ((ServletRequest) externalContext
				.getRequest()).getRequestDispatcher("/j_spring_security_check");
		dispatcher.forward(((ServletRequest) externalContext.getRequest()),
				(ServletResponse) externalContext.getResponse());
		FacesContext.getCurrentInstance().responseComplete();

		return null;
	}

	/**
	 * @return the senha
	 */
	public String getSenha() {
		return senha;
	}

	/**
	 * @param senha
	 *            the senha to set
	 */
	public void setSenha(String senha) {
		this.senha = senha;
	}

	/**
	 * @return the usuario
	 */
	public String getUsuario() {
		return usuario;
	}

	/**
	 * @param usuario
	 *            the usuario to set
	 */
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

}