/*
 * Java classes are grouped in "packages". This allows them to be referenced and used in other
 * classes using import statements.  Any class in this project is prefixed in the com.mockcompany.webapp
 * package.
 *
 *   https://www.w3schools.com/java/java_packages.asp
 *
 * For general help with Java, see the tutorialspoint tutorial:
 *
 *   https://www.tutorialspoint.com/java/index.htm
 */
package com.mockcompany.webapp.controller;

/*
 * An import statement allows the current class to use the class being imported
 */

import com.mockcompany.webapp.data.ProductItemRepository;
import com.mockcompany.webapp.model.ProductItem;
/* The springframework package allows us to take advantage of the spring capabilities */
import com.mockcompany.webapp.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/* java.util package provides useful utilities */
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * This class is the entrypoint for the /api/products/search API.  It is "annotated" with
 * the "RestController" annotation which tells the spring framework that it will be providing
 * API implementations.
 * <p>
 * <a href="https://docs.spring.io/spring-boot/docs/current/reference/html/features.html#features.developing-web-applications">...</a>
 * <p>
 * An annotation is metadata that provides data about the program.  Annotations can be checked for on a class by other
 * classes.  In this case, we're telling the spring framework that the SearchController provides API capabilities.
 * <p>
 * <a href="https://docs.oracle.com/javase/tutorial/java/annotations/">...</a>
 */
@RestController
public class SearchController {

	private final SearchService SearchService;

	@Autowired
	public SearchController(SearchService SearchService) {
		/**
		 * This is a instance field. It is provided by the spring framework through the constructor because of the
		 *
		 * @Autowired annotation. Autowire tells the spring framework to automatically find and use an instance of
		 * the declared class when creating this class.
		 */
		this.SearchService = SearchService;
	}

	/**
	 * The search method, annotated with @GetMapping telling spring this method should be called
	 * when an HTTP GET on the path /api/products/search is made.  A single query parameter is declared
	 * using the @RequestParam annotation.  The value that is passed when performing a query will be
	 * in the query parameter.
	 *
	 * @param query The query string to search for
	 * @return The filtered products
	 */
	@GetMapping("/api/products/search")
	public Collection<ProductItem> search(@RequestParam("query") String query) {
		return new ArrayList<>(SearchService.search(query));
	}
}