package br.edu.ifal.sicovi.controller;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;

import br.edu.ifal.sicovi.dao.UsuarioDAO;
import br.edu.ifal.sicovi.domain.Usuario;

@ManagedBean
@RequestScoped
public class UsuarioController {

	private List<Usuario> usuarios;
	private UsuarioDAO dao;
	
	public UsuarioController(){
		EntityManager em = (EntityManager) FacesContext.getCurrentInstance()
				.getExternalContext().getRequestMap().get("EntityManager");
		this.dao = new UsuarioDAO(em);
	}
	
	public List<Usuario> getUsuarios() {

		if (this.usuarios == null) {
			this.usuarios = dao.findAll();
		}
		return usuarios;
	}
	
}
