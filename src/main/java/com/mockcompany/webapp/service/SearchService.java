package com.mockcompany.webapp.service;

import com.mockcompany.webapp.model.ProductItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Handles searching / filtering for products based on a query string.
 *
 * @author TheDerpGamer
 */
@Service
public class SearchService {
	
	public List<ProductItem> searchProducts(List<ProductItem> allProducts, String query) {
		List<ProductItem> filteredProducts = new ArrayList<>();
		query = query.trim().toLowerCase();
		for(ProductItem product : allProducts) {
			boolean exactMatch = query.startsWith("\"") && query.endsWith("\"");
			boolean nameMatches;
			boolean descriptionMatches;
			if(exactMatch) {
				nameMatches = product.getName().trim().equalsIgnoreCase(query.substring(1, query.length() - 1));
				descriptionMatches = product.getDescription().trim().equalsIgnoreCase(query.substring(1, query.length() - 1));
			} else {
				nameMatches = product.getName().trim().toLowerCase().contains(query.toLowerCase());
				descriptionMatches = product.getDescription().trim().toLowerCase().contains(query.toLowerCase());
			}
			if(nameMatches || descriptionMatches) filteredProducts.add(product);
		}
		return filteredProducts;
	}
}
