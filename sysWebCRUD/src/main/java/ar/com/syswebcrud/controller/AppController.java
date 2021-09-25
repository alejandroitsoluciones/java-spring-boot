package ar.com.syswebcrud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ar.com.syswebcrud.entity.Product;
import ar.com.syswebcrud.service.ProductService;

@Controller
public class AppController {
	
	@Autowired
	private ProductService productService;
	
	@RequestMapping("/")
	public String viewHomePage(Model model) {
		List<Product> listProducts = productService.listAll();
		model.addAttribute("listProducts", listProducts);
		return "index";
	}
	
	@RequestMapping("/new")
	public String viewNewFormProduct(Model model) {
		Product product = new Product();
		model.addAttribute("product", product);
		return "new_product";
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveProduct(@ModelAttribute("product") Product product) {
		productService.saveProduct(product);
		return "redirect:/";
	}
	
	@RequestMapping("/edit/{id}")
	public ModelAndView viewEditFormProduct(@PathVariable(name = "id") Long id) {
		ModelAndView modelAndView = new ModelAndView("edit_product");
		Product product = new Product();
		product = productService.getProduct(id);
		modelAndView.addObject("product", product);
		return modelAndView;
	}
	
	@RequestMapping("/delete/{id}")
	public String deleteProduct(@PathVariable(name = "id") Long id) {
		productService.deleteProduct(id);
		return "redirect:/";
	}	
	
}
