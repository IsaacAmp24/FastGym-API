package org.fastgym.fastgymapi.store.application.internal.commandServices;

import org.fastgym.fastgymapi.store.domain.model.aggregates.Product;
import org.fastgym.fastgymapi.store.domain.model.commands.CreateProductCommand;
import org.fastgym.fastgymapi.store.domain.model.commands.DeleteProductCommand;
import org.fastgym.fastgymapi.store.domain.services.ProductCommandService;
import org.fastgym.fastgymapi.store.infrastructure.persistence.jpa.repositories.ProductRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductCommandServiceImpl implements ProductCommandService {

    private final ProductRepository productRepository;

    public ProductCommandServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Long handle(CreateProductCommand command) {
        // create a new product and save it
        var product = new Product(
                command.productName(),
                command.productPrice()
        );

        productRepository.save(product);
        return product.getId();
    }

    @Override
    public Long handle(DeleteProductCommand command) {
        // validate that the product exists
        var product = productRepository.findById(command.productId())
                .orElseThrow(() -> new IllegalArgumentException("Product does not exist"));

        // delete the product
        productRepository.delete(product);
        return product.getId();
    }



}
