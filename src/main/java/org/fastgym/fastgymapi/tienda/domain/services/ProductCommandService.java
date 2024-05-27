package org.fastgym.fastgymapi.tienda.domain.services;

import org.fastgym.fastgymapi.tienda.domain.model.commands.CreateProductCommand;

public interface ProductCommandService {

    Long handle(CreateProductCommand command);

}
