package com.mobile.cleverpost.rest.client.test;

import java.util.List;

import com.mobile.cleverpost.rest.client.RestClient;
import com.mobile.cleverpost.rest.constants.Path;
import com.mobile.cleverpost.rest.persistence.entities.ProductCategory;

public class TestCategory {
	public static void main(String[] args) {
		RestClient rest = new RestClient(Path.URI);
		List<ProductCategory> list = rest.getAll(ProductCategory.class);
		for (ProductCategory o : list) {
			System.out.println(o);
		}

		ProductCategory c = new ProductCategory();
		c.setName("Category1");
		rest.insert(c);
		System.out.println("______________________________");
		list = rest.getAll(ProductCategory.class);
		for (ProductCategory o : list) {
			System.out.println(o);
		}
	}
}
