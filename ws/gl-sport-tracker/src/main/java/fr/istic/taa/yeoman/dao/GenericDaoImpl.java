package fr.istic.taa.yeoman.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.hibernate.JDBCException;
import org.hibernate.exception.ConstraintViolationException;


public abstract class GenericDaoImpl<T, PK extends Serializable> implements GenericDao<T, PK> {
	
	private Class<T> entityClass;
	protected EntityManager entityManager;
	
	@SuppressWarnings("unchecked")
	public GenericDaoImpl(){
		entityManager = new LocalEntityManagerFactory().createEntityManager();
		ParameterizedType genericSuperclass = (ParameterizedType) getClass().getGenericSuperclass();
		entityClass = (Class<T>) genericSuperclass.getActualTypeArguments()[0];
	}

	@Override
	public T create(T t) {
		EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
		entityManager.persist(t);
		tx.commit();
		return t;
	}

	@Override
	public T read(PK id) {
		EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
		T obj = entityManager.find(entityClass, id);
		tx.commit();
		return obj;
	}

	@Override
	public T update(T t) {
		EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
		T obj = entityManager.merge(t);
		tx.commit();
		return obj;
	}

	@Override
	public void delete(PK id) {
		EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
		T t = entityManager.find(entityClass, id);
		entityManager.remove(t);
		tx.commit();
	}

}
