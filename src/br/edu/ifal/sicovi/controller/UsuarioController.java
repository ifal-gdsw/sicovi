package br.edu.ifal.sicovi.controller;

import java.io.IOException;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import br.edu.ifal.sicovi.dao.UsuarioDAO;
import br.edu.ifal.sicovi.domain.Usuario;

@ManagedBean(name = "usuarioController")
@RequestScoped
public class UsuarioController {

	private List<Usuario> usuarios;
	private UsuarioDAO dao;
	private Usuario usuario = new Usuario();
	private String nomeUsuario;
	private String confirmaSenha;

	public UsuarioController() {
		this.dao = new UsuarioDAO();
	}

	public List<Usuario> getUsuarios() {
		if (this.usuarios == null) {
			this.usuarios = dao.findAll();
		}
		return usuarios;
	}

	public void cadastrarUsuario(ActionEvent event) {
		if (this.confirmaSenha.equals(this.usuario.getSenha())) {

			this.dao.save(this.usuario);
			this.usuario = new Usuario();
			this.confirmaSenha = "";

			ExternalContext externalContext = FacesContext.getCurrentInstance()
					.getExternalContext();
			try {
				externalContext.redirect("index.xhtml");
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			FacesMessage message = new FacesMessage(
					"As senhas devem ser iguais.");
			message.setSeverity(FacesMessage.SEVERITY_ERROR);
			FacesContext.getCurrentInstance().addMessage("txtConfirmaSenha",
					message);
		}
	}

	public String editar() {

		this.confirmaSenha = this.usuario.getSenha();
		return "/usuario/editar";
	}

	/**
	 * @return the usuario
	 */
	public Usuario getUsuario() {
		return usuario;
	}

	/**
	 * @param usuario
	 *            the usuario to set
	 */
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	/**
	 * @return the nomeUsuario
	 */
	public String getNomeUsuario() {
		return nomeUsuario;
	}

	/**
	 * @param nomeUsuario
	 *            the nomeUsuario to set
	 */
	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}

	/**
	 * @param usuarios
	 *            the usuarios to set
	 */
	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	/**
	 * @return the confirmaSenha
	 */
	public String getConfirmaSenha() {
		return confirmaSenha;
	}

	/**
	 * @param confirmaSenha
	 *            the confirmaSenha to set
	 */
	public void setConfirmaSenha(String confirmaSenha) {
		this.confirmaSenha = confirmaSenha;
	}

}
