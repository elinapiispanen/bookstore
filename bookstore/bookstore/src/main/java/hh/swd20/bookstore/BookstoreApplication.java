package hh.swd20.bookstore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import hh.swd20.bookstore.domain.Book;
import hh.swd20.bookstore.domain.BookRepository;
import hh.swd20.bookstore.domain.Category;
import hh.swd20.bookstore.domain.User;
import hh.swd20.bookstore.domain.categoryRepository;
import hh.swd20.bookstore.domain.UserRepository;


@SpringBootApplication
public class BookstoreApplication {

	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner bookDemo(BookRepository bookRepository, categoryRepository categoryRepository, UserRepository userRepository) {
		return (args) -> {
			log.info("save a couple of books");
			categoryRepository.save(new Category("Scifi"));
			categoryRepository.save(new Category("Crime"));
			categoryRepository.save(new Category("Comic"));
			
			bookRepository.save(new Book("Scifikirja", "Kirjoittaja", 2000, "1912121-12", categoryRepository.findByName("Scifi").get(0)));
			bookRepository.save(new Book("Rikoskirja", "Kirjailija", 3030, "2321212-21", categoryRepository.findByName("Crime").get(0)));
			bookRepository.save(new Book("Hauska kirja", "Hauskus", 2010, "1913441-12", categoryRepository.findByName("Comic").get(0)));

			userRepository.save(new User("user", "$2a$10$7RtUmxxp1YWC1SGdoYyltudyUhNbDEWuadgaKZAXQwm7bpJrXcSe.", "USER"));
			userRepository.save(new User("admin", "$2a$10$7RtUmxxp1YWC1SGdoYyltudyUhNbDEWuadgaKZAXQwm7bpJrXcSe.", "ADMIN"));
			log.info("fetch all books");
			for (Book book : bookRepository.findAll()) {
				log.info(book.toString());
			}

		};
	}
}
