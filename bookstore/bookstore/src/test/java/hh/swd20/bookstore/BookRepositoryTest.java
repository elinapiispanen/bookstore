package hh.swd20.bookstore;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import hh.swd20.bookstore.domain.Book;
import hh.swd20.bookstore.domain.BookRepository;
import hh.swd20.bookstore.domain.categoryRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class BookRepositoryTest {

    @Autowired
    private BookRepository bookrepository;
    
    @Autowired
    private categoryRepository categoryrepository;
    

    @Test
    public void findByTitleShouldReturnBook() {
        List<Book> books = bookrepository.findByTitle("Rikoskirja");
        
        assertThat(books).hasSize(1);
        assertThat(books.get(0).getAuthor()).isEqualTo("Kirjailija");
    }
    
    @Test
    public void createNewBook() {
    	Book book = bookrepository.save(new Book("Kummituskirja", "Aija Laija", 2021, "1912321-12", categoryrepository.findByName("Scifi").get(0)));
    	bookrepository.save(book);
    	assertThat(book.getId()).isNotNull();
    }    
    
    @Test
    public void deleteBook() {
    	Book book = bookrepository.save(new Book("Kummituskirja", "Aija Laija", 2021, "1912321-12", categoryrepository.findByName("Scifi").get(0)));
    	bookrepository.save(book);
    	bookrepository.deleteById(book.getId());
    	assertThat(bookrepository.count()).isEqualTo(3);
    }    
    @Test
    public void showBooks() {
    	Book book = bookrepository.save(new Book("Kummituskirja", "Aija Laija", 2021, "1912321-12", categoryrepository.findByName("Scifi").get(0)));
    	bookrepository.save(book);
    	bookrepository.deleteById(book.getId());
    	assertThat(bookrepository.count()).isEqualTo(3);
    }  
}