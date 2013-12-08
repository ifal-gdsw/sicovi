package br.edu.ifal.sicovi.dao;

import javax.persistence.EntityManager;

import br.edu.ifal.sicovi.domain.Patente;

public class PatenteDAO extends GenericDAO<Integer, Patente> {

	public PatenteDAO(EntityManager entityManager) {
		super(entityManager);
	}

}
