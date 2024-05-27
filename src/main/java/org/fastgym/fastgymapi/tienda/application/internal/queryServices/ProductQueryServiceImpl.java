package org.fastgym.fastgymapi.tienda.application.internal.queryServices;

import org.fastgym.fastgymapi.tienda.domain.model.aggregates.Product;
import org.fastgym.fastgymapi.tienda.domain.model.queries.GetProductByIdQuery;
import org.fastgym.fastgymapi.tienda.domain.model.queries.GetProductByNameQuery;
import org.fastgym.fastgymapi.tienda.domain.services.ProductQueryService;
import org.fastgym.fastgymapi.tienda.infrastructure.persistence.jpa.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductQueryServiceImpl implements ProductQueryService {

    private final ProductRepository productRepository;

    public ProductQueryServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    @Override
    public Optional<Product> handle(GetProductByIdQuery query) {
        return productRepository.findById(query.id());
    }

    @Override
    public Optional<Product> handle(GetProductByNameQuery query) {
        return productRepository.findProductByProductName(query.name());
    }
}
