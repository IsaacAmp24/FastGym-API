package org.fastgym.fastgymapi.store.interfaces.rest;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.fastgym.fastgymapi.store.domain.model.queries.GetProductByIdQuery;
import org.fastgym.fastgymapi.store.domain.model.queries.GetProductByNameQuery;
import org.fastgym.fastgymapi.store.domain.model.valueobjects.ProductName;
import org.fastgym.fastgymapi.store.domain.services.ProductCommandService;
import org.fastgym.fastgymapi.store.domain.services.ProductQueryService;
import org.fastgym.fastgymapi.store.interfaces.rest.resources.CreateProductResource;
import org.fastgym.fastgymapi.store.interfaces.rest.resources.ProductResource;
import org.fastgym.fastgymapi.store.interfaces.rest.transform.CreateProductCommandFromResourceAssembler;
import org.fastgym.fastgymapi.store.interfaces.rest.transform.ProductResourceFromEntityAssembler;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/api/v1/products", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "Products", description = "Products Management Endpoints")
public class ProductController {

    private final ProductQueryService productQueryService;

    private final ProductCommandService productCommandService;

    public ProductController(ProductQueryService productQueryService, ProductCommandService productCommandService) {
        this.productQueryService = productQueryService;
        this.productCommandService = productCommandService;
    }

    //add a product
    @PostMapping
    public ResponseEntity<ProductResource> createProduct(@RequestBody CreateProductResource resource) {
        var createProductCommand = CreateProductCommandFromResourceAssembler.toCommandFromResource(resource);
        var productId = productCommandService.handle(createProductCommand);
        if (productId == 0L) {
            return ResponseEntity.badRequest().build();
        }
        var getProductByIdQuery = new GetProductByIdQuery(productId);
        var product = productQueryService.handle(getProductByIdQuery);
        if (product.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        var productResource = ProductResourceFromEntityAssembler.toResourceFromEntity(product.get());
        return new ResponseEntity<>(productResource, HttpStatus.CREATED);
    }

    // obtengo un producto por id
    @GetMapping("/{productId}")
    public ResponseEntity<ProductResource> getProductById(@PathVariable Long productId) {
        var getProductByIdQuery = new GetProductByIdQuery(productId);
        var product = productQueryService.handle(getProductByIdQuery);
        if (product.isEmpty()) return ResponseEntity.badRequest().build();
        var productResource = ProductResourceFromEntityAssembler.toResourceFromEntity(product.get());
        return ResponseEntity.ok(productResource);
    }

    // obtengo un producto por nombre
    @GetMapping("/name/{productName}")
    public ResponseEntity<ProductResource> getProductByName(@PathVariable String productName) {
        var getProductByNameQuery = new GetProductByNameQuery(new ProductName(productName));
        var product = productQueryService.handle(getProductByNameQuery);
        if (product.isEmpty()) return ResponseEntity.badRequest().build();
        var productResource = ProductResourceFromEntityAssembler.toResourceFromEntity(product.get());
        return ResponseEntity.ok(productResource);
    }


    // elimino un producto


}
