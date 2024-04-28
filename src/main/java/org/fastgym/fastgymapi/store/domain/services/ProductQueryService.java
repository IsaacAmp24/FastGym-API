package org.fastgym.fastgymapi.store.domain.services;

import org.fastgym.fastgymapi.store.domain.model.aggregates.Product;
import org.fastgym.fastgymapi.store.domain.model.queries.GetProductByIdQuery;
import org.fastgym.fastgymapi.store.domain.model.queries.GetProductByNameQuery;

import java.util.Optional;

public interface ProductQueryService {
    Optional<Product> handle(GetProductByIdQuery query);
    Optional<Product> handle(GetProductByNameQuery query);
}
