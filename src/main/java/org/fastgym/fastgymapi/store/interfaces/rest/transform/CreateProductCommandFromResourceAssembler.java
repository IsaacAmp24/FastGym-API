package org.fastgym.fastgymapi.store.interfaces.rest.transform;

import org.fastgym.fastgymapi.store.domain.model.commands.CreateProductCommand;
import org.fastgym.fastgymapi.store.interfaces.rest.resources.CreateProductResource;

// esta clase es para transformar un recurso en un comando
public class CreateProductCommandFromResourceAssembler {
    public static CreateProductCommand toCommandFromResource(CreateProductResource resource) {
        return new CreateProductCommand(resource.productName(), resource.productPrice());
    }
}
