package br.edu.ifal.sicovi.dao;

import javax.persistence.EntityManager;

import br.edu.ifal.sicovi.domain.Usuario;

public class UsuarioDAO extends GenericDAO<Integer, Usuario> {

	public UsuarioDAO(EntityManager entityManager) {
		super(entityManager);
		// TODO Auto-generated constructor stub
	}

}
