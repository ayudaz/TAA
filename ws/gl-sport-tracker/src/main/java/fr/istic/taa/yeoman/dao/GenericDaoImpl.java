package fr.istic.taa.yeoman.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;


public class GenericDaoImpl<T, PK extends Serializable> implements GenericDao<T, PK> {
	
	private Class<T> entityClass;
	private EntityManager entityManager;
	
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
	public void delete(T t) {
		EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
		t = this.entityManager.merge(t);
		this.entityManager.remove(t);
		tx.commit();
	}

}
