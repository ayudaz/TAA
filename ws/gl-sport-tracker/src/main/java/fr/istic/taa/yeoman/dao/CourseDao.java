package fr.istic.taa.yeoman.dao;

import java.util.Collection;
import java.util.List;

import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import fr.istic.yeoman.api.Course;

public class CourseDao extends GenericDaoImpl<Course, Integer> {

	@SuppressWarnings("unchecked")
	public Collection<Course> getAll() {
		EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
 
        Query courseQuery = entityManager.createQuery("select s from CourseImpl s");
        
		List<Course> allCourses = courseQuery.getResultList();
 
        tx.commit();
        return allCourses;
	}

}
