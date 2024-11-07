package com.mockcompany.webapp.data;

import com.mockcompany.webapp.model.ProductItem;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * This Spring pattern is Java/Spring magic.  At runtime, spring will generate an implementation of this class based on
 * the name/arguments of the method signatures defined in the interface.  See this link for details on doing data access:
 * <p>
 * <a href="https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.query-methods">...</a>
 * <p>
 * It's also possible to do specific queries using the @Query annotation:
 * <p>
 * <a href="https://www.baeldung.com/spring-data-jpa-query">...</a>
 */
@Repository
public interface ProductItemRepository extends CrudRepository<ProductItem, Long> {

}
