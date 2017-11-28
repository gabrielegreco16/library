package library;

import java.util.ArrayList;

import org.python.antlr.PythonParser.return_stmt_return;

public class Singleton {
	
	private static Singleton SINGLE_INSTANCE = null;

	private static ArrayList<Book> BOOKS;

	private static Integer ID;
	
	private Singleton() {
		BOOKS = new ArrayList<>();
	}

	public static Singleton singleton() {
		if (SINGLE_INSTANCE == null)
			SINGLE_INSTANCE = new Singleton();

		return SINGLE_INSTANCE;
	}

	public ArrayList<Book> getBooks() {
		return BOOKS;
	}

	public String addBook(Book book) {
		if (BOOKS.size() == 0) {
			ID=0;
			book.setId(ID);
			BOOKS.add(book);
			return "OK";
		} else {
			ID++;
			book.setId(ID);
			BOOKS.add(book);
			return "OK";
		}
	}

	public String updateById(Book book) {
		Book backUp = BOOKS.get(book.getId());
		for (int i = 0; i < BOOKS.size(); i++) {
			if (BOOKS.get(i).getId() == book.getId()) {
				if(book.getAuthor()==null){
					book.setAuthor(backUp.getAuthor());
				}
				
				if(book.getPages()==null){
					book.setPages(backUp.getPages());
				}
				
				if(book.getTitle()==null){
					book.setTitle(backUp.getTitle());
				}
				BOOKS.set(i, book);
				return "Book with id = " + book.getId() + " was updated";
			} 
		}
		return "ERROR: Book with id = " + book.getId() + " does not exist";

	}

	public String deleteById(Integer id) {
		for (int i = 0; i < BOOKS.size(); i++) {
			if (BOOKS.get(i).getId() == id) {
				BOOKS.remove(i);
				return "Book with id ="+id+" deleted";
			} 
		}
		return "ERROR: Book with id = " + id + " does not exist";
	}

	public Book findByName(String name) {
		for (int i = 0; i < BOOKS.size(); i++) {
			if ((BOOKS.get(i).getTitle()).equals(name)) {
				return BOOKS.get(i);
			} 
		}
		return null;
	}
}
