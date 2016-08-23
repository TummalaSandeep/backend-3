package com.niit.ShoppingCartBack3;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.ShoppingCart.DAO.ProductDAO;
import com.niit.ShoppingCart.model.Product;

public class TestCaseProduct {

	@Autowired
	ProductDAO productDAO;

	@Autowired
	Product product;

	AnnotationConfigApplicationContext context;

	@Before
	public void init() {

		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();

		productDAO = (ProductDAO) context.getBean("productDAO");
		product = (Product) context.getBean("product");
	}

	@Test

	public void productListTestCase() {
		List<Product> list = productDAO.list();
		int rowCount = list.size();

		assertEquals("Product List Test Case", rowCount, 5);
	}
 
	@Test
	public void ProductAddTestCase() {
		product.setId("106");
		product.setName("sai");
		product.setDescription("ece");
		product.setPrice(555);

		productDAO.save(product);
	}

	public void productGetTestCase() {
		product = productDAO.get("123");
		System.out.println(product.getDescription());
		System.out.println(product.getName());

		assertEquals(product.getName(), "deepu");

	}
}
