package com.niit.ShoppingCartBack3;


import org.springframework.context.annotation.AnnotationConfigApplicationContext;


import com.niit.ShoppingCart.DAO.SupplierDAO;

import com.niit.ShoppingCart.model.Supplier;

public class SupplierTest {
	public static void main(String [] args)
	{
		AnnotationConfigApplicationContext context= new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		SupplierDAO supplierDAO=(SupplierDAO)context.getBean("supplierDAO");
		Supplier supplier=(Supplier) context.getBean("supplier");
		
		supplier.setId("1234 ");
		supplier.setName("deepu");
		supplier.setAddress("hyd");
		supplier.setDescription("this is sup");
		if(supplierDAO.save(supplier)==true)
			
		{
			System.out.println("supplier created successfully");
			
		}
		else
		{
			System.out.println("not able to create product");
		}
	}
	}
	
	




