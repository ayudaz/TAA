package fr.istic.taa.yeoman;

import java.util.List;

import fr.istic.taa.yeoman.dao.BookDAO;
import fr.istic.taa.yeoman.dao.GenericDAO;
import fr.istic.taa.yeoman.entities.Book;

public class BookTest {
	/**
     * @param args
     */
    public static void main(String[] args) {
    	BookDAO dao = new BookDAO();
    	
    	Book tt = new Book(1, "Test", "Toto", 7);
    	
    	dao.persistBook(tt);
    	
    	List<Book> allBooks = dao.getAllBooks();
    	
    	for (Book book : allBooks) {
			System.out.println(book);
		}
    	
    	GenericDAO.closeEntityManager();
    }
}
