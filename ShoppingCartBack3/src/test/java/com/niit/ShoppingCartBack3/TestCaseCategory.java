package com.niit.ShoppingCartBack3;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.ShoppingCart.DAO.CategoryDAO;
import com.niit.ShoppingCart.model.Category;

public class TestCaseCategory {

	@Autowired
	CategoryDAO categoryDAO;

	@Autowired
	Category category;

	AnnotationConfigApplicationContext context;

	@Before
	public void init() {

		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();

		categoryDAO = (CategoryDAO) context.getBean("categoryDAO");
		category = (Category) context.getBean("category");
	}

	@Test

	public void categoryListTestCase() {
		List<Category> list = categoryDAO.list();
		int rowCount = list.size();

		assertEquals("Category List Test Case", rowCount, 5);
	}
 
	@Test
	public void CategoryAddTestCase() {
		category.setId("007");
		category.setName("YOGI");
		category.setDescription("TECH MENTOR");

		categoryDAO.save(category);
	}

	public void categoryGetTestCase() {
		category = categoryDAO.get("123");
		System.out.println(category.getDescription());
		System.out.println(category.getName());

		assertEquals(category.getName(), "deepu");

	}
}
