package fr.istic.taa.yeoman.dao;

import java.io.Serializable;

public interface GenericDao<T, PK extends Serializable> {
	T create(T t);
	T read(PK id);
	T update(T t);
	void delete(PK id);
}
