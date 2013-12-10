package br.edu.ifal.sicovi.controller;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.edu.ifal.sicovi.dao.PatenteDAO;
import br.edu.ifal.sicovi.domain.Patente;

@ManagedBean
@RequestScoped
public class PatenteController {
	private List<Patente> patentes;
	private PatenteDAO dao;

	public PatenteController() {
		this.dao = new PatenteDAO();
	}

	/**
	 * @return the patentes
	 */
	public List<Patente> getPatentes() {

		if (this.patentes == null) {
			this.patentes = dao.findAll();
		}
		return patentes;
	}

	/**
	 * @param patentes
	 *            the patentes to set
	 */
	public void setPatentes(List<Patente> patentes) {
		this.patentes = patentes;
	}

}
