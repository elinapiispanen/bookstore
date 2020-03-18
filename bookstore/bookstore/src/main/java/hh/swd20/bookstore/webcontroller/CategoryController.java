package hh.swd20.bookstore.webcontroller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import hh.swd20.bookstore.domain.BookRepository;
import hh.swd20.bookstore.domain.Category;
import hh.swd20.bookstore.domain.categoryRepository;


@Controller
public class CategoryController {
	
@Autowired
categoryRepository categoryRepository;

@Autowired
BookRepository BookRepository;

@RequestMapping(value="/categorylist", method=RequestMethod.GET)
public String showCategories(Model model) {
	model.addAttribute("categories", categoryRepository.findAll());
	return "categorylist";

}
@RequestMapping(value = "/addcategory", method = RequestMethod.GET)
public String addCategory(Model model) {
	model.addAttribute("category", new Category());
	return "addcategory";
}

@RequestMapping(value = "/addcategory", method = RequestMethod.POST)
public String saveBook(@ModelAttribute Category category) {
	
	categoryRepository.save(category);
	return "redirect:/categorylist";
}
}
