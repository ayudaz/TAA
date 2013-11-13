package fr.istic.taa.yeoman.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import fr.istic.taa.yeoman.entities.Book;

public class BookDAO extends GenericDAO {
	
	public void persistBook(Book book) {
        EntityManager em = createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
 
        em.persist(book);
 
        tx.commit();
        em.close();
    }
 
    public List<Book> getAllBooks() {
        EntityManager em = createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
 
        Query allBooksQuery = em.createQuery("select b from Book b");
 
        List<Book> allBooks = allBooksQuery.getResultList();
 
        tx.commit();
        em.close();
 
        return allBooks;
    }
}
