package br.edu.ifal.sicovi.dao;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;

import br.edu.ifal.sicovi.utils.JPAUtil;

@SuppressWarnings("unchecked")
public class GenericDAO<PK, T> {
	private EntityManager entityManager;

	private void beginTransaction() {
		this.entityManager = JPAUtil.getEntityManager();
		this.entityManager.getTransaction().begin();
	}

	private void commit() {
		JPAUtil.closeEntityManager();
	}

	public T getById(PK pk) {
		try {
			beginTransaction();
			return (T) entityManager.find(getTypeClass(), pk);
		} finally {
			commit();
		}
	}

	public void save(T entity) {
		beginTransaction();
		entityManager.persist(entity);
		commit();
	}

	public void update(T entity) {
		beginTransaction();
		entityManager.merge(entity);
		commit();
	}

	public void delete(T entity) {
		beginTransaction();
		entityManager.remove(entity);
		commit();
	}

	public List<T> findAll() {
		try {
			beginTransaction();

			return entityManager.createQuery(
					("FROM " + getTypeClass().getName())).getResultList();
		} finally {
			commit();
		}
	}

	private Class<?> getTypeClass() {
		Class<?> clazz = (Class<?>) ((ParameterizedType) this.getClass()
				.getGenericSuperclass()).getActualTypeArguments()[1];
		return clazz;
	}
}
