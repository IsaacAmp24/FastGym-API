package org.fastgym.fastgymapi.tienda.infrastructure.persistence.jpa.repositories;

import org.fastgym.fastgymapi.tienda.domain.model.aggregates.Product;
import org.fastgym.fastgymapi.tienda.domain.model.valueobjects.ProductName;
import org.fastgym.fastgymapi.tienda.domain.model.valueobjects.ProductPrice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{

    Optional<Product> findProductByProductName(ProductName name);
    Optional<Product> findProductByProductPrice(ProductPrice price);

}
