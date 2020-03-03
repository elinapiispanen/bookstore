package hh.swd20.bookstore.webcontroller;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import hh.swd20.bookstore.domain.Book;
import hh.swd20.bookstore.domain.BookRepository;
import hh.swd20.bookstore.domain.categoryRepository;

@Controller
public class BookController {
	
	@Autowired
	private BookRepository BookRepository;
	
	@Autowired
	private categoryRepository categoryRepository;
	
@RequestMapping(value="/booklist", method=RequestMethod.GET)
public String showBooks(Model model) {
	List<Book> books = (List<Book>) BookRepository.findAll();
	model.addAttribute("book", new Book());
	model.addAttribute("books", books);
	return "booklist";
}
@RequestMapping(value = "/newbook", method = RequestMethod.GET)
public String addNewBook(Model model) {
	model.addAttribute("book", new Book());
	model.addAttribute("categories", categoryRepository.findAll());
	return "addbook";
}

@RequestMapping(value = "/newbook", method = RequestMethod.POST)
public String saveBook(@ModelAttribute Book book) {
	
	BookRepository.save(book);
	return "redirect:/booklist";
}

@RequestMapping(value = "/deletebook/{id}", method = RequestMethod.GET)
public String deleteBook(@PathVariable("id") Long bookId) {
	BookRepository.deleteById(bookId);
	return "redirect:../booklist";
}

@GetMapping(value = "/editbook/{id}")
public String editBook(@PathVariable("id") Long bookId, Model model) {
	Optional<Book> book = BookRepository.findById(bookId);
	model.addAttribute("book", book);
	
	return "editbook";
}

@RequestMapping(value = "/editbook/{id}", method = RequestMethod.POST)
public String save(@ModelAttribute Book book) {
	
	BookRepository.save(book);
	return "redirect:/booklist";
}
}
