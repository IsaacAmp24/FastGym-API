package org.fastgym.fastgymapi.store.interfaces.rest.transform;

import org.fastgym.fastgymapi.store.domain.model.aggregates.Product;
import org.fastgym.fastgymapi.store.interfaces.rest.resources.ProductResource;

// esta clase es para transformar una entidad en un recurso
public class ProductResourceFromEntityAssembler {
    public static ProductResource toResourceFromEntity(Product entity) {
        return new ProductResource(
                entity.getId(),
                entity.getName(),
                entity.getPrice());
    }
}
