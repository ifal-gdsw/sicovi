package br.edu.ifal.sicovi.filter;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class PersistenceFilter implements Filter {

	private EntityManager em;
	private EntityManagerFactory emf;

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		em = this.emf.createEntityManager();
		request.setAttribute("EntityManager", em);
		em.getTransaction().begin();
		
		chain.doFilter(request, response);

		try {
			em.getTransaction().commit();
		} catch (Exception e) {
			if (em.getTransaction().isActive())
				em.getTransaction().rollback();
		} finally {
			if (this.em.isOpen())
				this.em.close();
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		emf = Persistence.createEntityManagerFactory("SICOVI_DB");
	}

	@Override
	public void destroy() {
		this.emf.close();
	}

}
