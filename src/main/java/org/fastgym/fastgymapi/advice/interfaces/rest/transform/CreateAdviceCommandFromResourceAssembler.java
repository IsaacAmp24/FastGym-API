package org.fastgym.fastgymapi.advice.interfaces.rest.transform;

import org.fastgym.fastgymapi.advice.domain.model.commands.CreateAdviceCommand;
import org.fastgym.fastgymapi.advice.interfaces.rest.resources.CreateAdviceResource;

public class CreateAdviceCommandFromResourceAssembler {

    public static CreateAdviceCommand toCommandFromResource(CreateAdviceResource resource) {
        return new CreateAdviceCommand(resource.name(), resource.description());
    }
}
