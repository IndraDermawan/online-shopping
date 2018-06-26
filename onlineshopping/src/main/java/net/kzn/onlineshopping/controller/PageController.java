package net.kzn.onlineshopping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import net.kzn.shoppingbackend.dao.CategoryDAO;
import net.kzn.shoppingbackend.dto.Category;

@Controller
public class PageController {
	
	//for call dao in back end
	@Autowired
	private CategoryDAO categoryDAO;
	
	@RequestMapping(value = {"/", "/home", "/index"})
	public ModelAndView index(){
		ModelAndView mv = new ModelAndView("page");
		// mv.addObject("greeting", "Hallo there :* ");
		mv.addObject("title", "Home");
		//passing the list of categories
		mv.addObject("categories", categoryDAO.list());
		mv.addObject("userClickHome", true);
		return mv;
	}
	
	@RequestMapping(value = "/about") //this from navbar.jsp contextRoot
	public ModelAndView about(){
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "About Us");
		mv.addObject("userClickAbout", true);
		return mv;
	}
	
	@RequestMapping(value = "/contact")
	public ModelAndView contact(){
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Contact Us");
		mv.addObject("userClickContact", true);
		return mv;
	}
	
	/*
	 * Methods to load all products based on category
	 * */
	
	@RequestMapping(value = "/show/all/products")
	public ModelAndView showAllProducts(){
		ModelAndView mv = new ModelAndView("page");
		// mv.addObject("greeting", "Hallo there :* ");
		mv.addObject("title", "All Products");
		//passing the list of categories //this for shoe side bar
		mv.addObject("categories", categoryDAO.list());
		mv.addObject("userClickAllProducts", true);
		return mv;
	}
	
	@RequestMapping(value = "/show/category/{id}/products")
	public ModelAndView showCategoryProducts(@PathVariable("id") int id){
		ModelAndView mv = new ModelAndView("page");
		// mv.addObject("greeting", "Hallo there :* ");
		//mv.addObject("title", "Home");
		
		//categoryDAO to fetch a single category
		Category category = null; 
		
		category = categoryDAO.get(id);
		// passing to the name product in categoryDAOImpl
		mv.addObject("title", category.getName());
		
		//passing the list of categories
		mv.addObject("categories", categoryDAO.list());
		
		//passing to the single category object
		mv.addObject("category", category);
		
		mv.addObject("userClickCategoryProducts", true);
		return mv;
	}
	
	
	
	
	
//	@RequestMapping(value="/test")
//	public ModelAndView test(@RequestParam(value="greeting", required=false)String greeting){ // if you want call this http://localhost:8080/onlineshopping/test?greeting=Hai indra
//		if (greeting == null){
//			greeting = "Hai, handsome";
//		} // if you want call this http://localhost:8080/onlineshopping/test
//		ModelAndView mv = new ModelAndView("page");
//		mv.addObject("greeting", greeting);
//		return mv;
//	}
//	
	
//	@RequestMapping(value="/test/{greeting}")
// 	for making clean url
//	public ModelAndView test(@PathVariable("greeting")String greeting){ 
// if you want call this http://localhost:8080/onlineshopping/test/hello
//		if (greeting == null){
//			greeting = "Hai, handsome";
//		} 
//		ModelAndView mv = new ModelAndView("page");
//		mv.addObject("greeting", greeting);
//		return mv;
//	}
//	
		
	

	
}
