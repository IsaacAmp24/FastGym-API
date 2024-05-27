package org.fastgym.fastgymapi.tienda.interfaces.rest.transform;


import org.fastgym.fastgymapi.tienda.domain.model.aggregates.Product;
import org.fastgym.fastgymapi.tienda.interfaces.rest.resources.ProductResource;

public class ProductResourceFromEntityAssembler {

    public static ProductResource toResourceFromEntity(Product product){
        return new ProductResource(
                product.getId(),
                product.getProductName(),
                product.getProductPrice()
        );
    }
}
