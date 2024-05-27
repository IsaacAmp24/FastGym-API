package org.fastgym.fastgymapi.tienda.interfaces.rest.transform;

import org.fastgym.fastgymapi.tienda.domain.model.commands.CreateProductCommand;
import org.fastgym.fastgymapi.tienda.interfaces.rest.resources.CreateProductResource;

public class CreateProductCommandFromResourceAssembler {

    public static CreateProductCommand toCommandFromResource(CreateProductResource resource){
        return new CreateProductCommand(
                resource.name(),
                resource.price()
        );
    }
}
