package net.kzn.shoppingbackend.dao;

import java.util.List;

import net.kzn.shoppingbackend.dto.Category;

public interface CategoryDAO {
	
	List<Category> list();
	// for parsing to the controller  public ModelAndView showCategoryProducts
	Category get(int id);
}
