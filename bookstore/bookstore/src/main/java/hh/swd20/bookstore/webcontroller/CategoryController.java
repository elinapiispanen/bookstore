package hh.swd20.bookstore.webcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import hh.swd20.bookstore.domain.Category;
import hh.swd20.bookstore.domain.categoryRepository;


@Controller
public class CategoryController {
	
@Autowired
categoryRepository categoryRepository;

@RequestMapping(value="/categorylist", method=RequestMethod.GET)
public String showCategories(Model model) {
	List<Category> categories = (List<Category>) categoryRepository.findAll();
	model.addAttribute("category", new Category());
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
