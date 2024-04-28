package org.fastgym.fastgymapi.advice.interfaces.rest.transform;

import org.fastgym.fastgymapi.advice.domain.model.aggregates.Advice;
import org.fastgym.fastgymapi.advice.interfaces.rest.resources.AdviceResource;

public class AdviceResourceFromEntityAssembler {

    public static AdviceResource toResourceFromEntity(Advice entity) {
        return new AdviceResource(entity.getId(), entity.getName(), entity.getDescription());
    }
}
