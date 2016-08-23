package com.niit.ShoppingCartBack3;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.ShoppingCart.DAO.ProductDAO;
import com.niit.ShoppingCart.model.Product;

public class ProductTest {
	public static void main(String [] args)
	{
		AnnotationConfigApplicationContext context= new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		ProductDAO productDAO=(ProductDAO)context.getBean("productDAO");
		Product product=(Product) context.getBean("product");
		
		product.setId("100");
		product.setPrice(555);
		product.setDescription("this is  ");
		product.setName("sandy");
		if(productDAO.save(product)==true)
			
		{
			System.out.println("product created successfully");
			
		}
		else
		{
			System.out.println("not able to create product");
		}
	}
	
	}
	
	




