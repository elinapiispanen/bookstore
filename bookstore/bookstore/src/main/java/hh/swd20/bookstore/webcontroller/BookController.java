package hh.swd20.bookstore.webcontroller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import hh.swd20.bookstore.domain.Book;

@Controller
public class BookController {
	List<Book> books = new ArrayList<Book>();
@RequestMapping(value="/index", method=RequestMethod.GET)
public String showBooks(Model model) {
	model.addAttribute("book", new Book());
	model.addAttribute("books", books);
	return "booklist";
}
}
