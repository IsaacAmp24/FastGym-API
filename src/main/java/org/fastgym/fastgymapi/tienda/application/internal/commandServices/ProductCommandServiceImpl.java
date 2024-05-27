package org.fastgym.fastgymapi.tienda.application.internal.commandServices;

import org.fastgym.fastgymapi.tienda.domain.model.aggregates.Product;
import org.fastgym.fastgymapi.tienda.domain.model.commands.CreateProductCommand;
import org.fastgym.fastgymapi.tienda.domain.model.valueobjects.ProductName;
import org.fastgym.fastgymapi.tienda.domain.model.valueobjects.ProductPrice;
import org.fastgym.fastgymapi.tienda.domain.services.ProductCommandService;
import org.fastgym.fastgymapi.tienda.infrastructure.persistence.jpa.repositories.ProductRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductCommandServiceImpl implements ProductCommandService {

    private final ProductRepository productRepository;

    public ProductCommandServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Long handle(CreateProductCommand command) {

        // valida que no se ingrese un producto con el mismo nombre y precio
        var productName = new ProductName(command.name());
        var productPrice = new ProductPrice(command.price());
        productRepository.findProductByProductName(productName).map(product -> {
            throw new IllegalArgumentException("Product with name " + command.name() + " already exists");
        });

        productRepository.findProductByProductPrice(productPrice).map(product -> {
            throw new IllegalArgumentException("Product with price " + command.price() + " already exists");
        });


        // create product
        var product = new Product(command.name(), command.price());
        productRepository.save(product);
        return product.getId();
    }

    /*@Override
    public Long handle(CreateAdviceCommand command) {
        // validate if advice have a equal description
        var adviceDescription = new AdviceDescription(command.adviceDescription());
        adviceRepository.findAdviceByAdviceDescription(adviceDescription).map(advice -> {
            throw new IllegalArgumentException("Advice with description " + command.adviceDescription() + " already exists");
        });


        // create advice
        var advice = new Advice(command.adviceName(), command.adviceDescription());
        adviceRepository.save(advice);
        return advice.getId();
    }*/
}

