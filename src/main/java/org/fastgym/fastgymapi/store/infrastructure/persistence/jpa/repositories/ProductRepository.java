package org.fastgym.fastgymapi.store.infrastructure.persistence.jpa.repositories;

import org.fastgym.fastgymapi.store.domain.model.aggregates.Product;
import org.fastgym.fastgymapi.store.domain.model.valueobjects.ProductName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    Optional<Product> findProductByProductName (ProductName productName);


}
