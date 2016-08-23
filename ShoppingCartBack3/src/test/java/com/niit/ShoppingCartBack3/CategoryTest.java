package com.niit.ShoppingCartBack3;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.ShoppingCart.DAO.CategoryDAO;
import com.niit.ShoppingCart.model.Category;

public class CategoryTest {
	
	public static void main(String[] args){
	
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		
		
       CategoryDAO categoryDAO= (CategoryDAO) context.getBean("categoryDAO");	
		Category category= (Category) context.getBean("category");
		
		category.setId("1239");
		category.setName("SANDY");
		category.setDescription("This is");
		
		 if (categoryDAO.save(category)== true)
		 {
			 System.out.println("Category created successfully");
			 
		 }
		 else 
		 {
			 System.out.println("Not able to create the category");
		 }
		
	}

}
