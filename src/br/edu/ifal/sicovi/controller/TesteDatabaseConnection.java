package br.edu.ifal.sicovi.controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@ManagedBean(name = "testeDB")
@RequestScoped
public class TesteDatabaseConnection {
	public void getEntityManager() {
		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("SICOVI_DB");
		EntityManager manager = factory.createEntityManager();
		System.out.println("Entity Manager criado");
	}
}
