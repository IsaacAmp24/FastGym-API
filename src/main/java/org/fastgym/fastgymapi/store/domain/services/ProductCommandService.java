package org.fastgym.fastgymapi.store.domain.services;

import org.fastgym.fastgymapi.store.domain.model.commands.CreateProductCommand;
import org.fastgym.fastgymapi.store.domain.model.commands.DeleteProductCommand;

public interface ProductCommandService {
    Long handle(CreateProductCommand command);
    Long handle(DeleteProductCommand command);
}
