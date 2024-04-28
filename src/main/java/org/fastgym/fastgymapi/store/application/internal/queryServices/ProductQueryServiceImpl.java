package org.fastgym.fastgymapi.store.application.internal.queryServices;

import org.fastgym.fastgymapi.store.domain.model.aggregates.Product;
import org.fastgym.fastgymapi.store.domain.model.queries.GetProductByIdQuery;
import org.fastgym.fastgymapi.store.domain.model.queries.GetProductByNameQuery;
import org.fastgym.fastgymapi.store.domain.model.queries.GetProductsQuery;
import org.fastgym.fastgymapi.store.domain.services.ProductQueryService;
import org.fastgym.fastgymapi.store.infrastructure.persistence.jpa.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductQueryServiceImpl implements ProductQueryService {

    private final ProductRepository productRepository;

    public ProductQueryServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Optional<Product> handle(GetProductByIdQuery query) {
        return productRepository.findById(query.productId());
    }

    @Override
    public Optional<Product> handle(GetProductByNameQuery query) {
        return productRepository.findProductByProductName(query.productName());
    }



}
