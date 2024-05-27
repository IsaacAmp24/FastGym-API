package org.fastgym.fastgymapi.profiles.interfaces.rest.transform;

import org.fastgym.fastgymapi.profiles.domain.model.aggregates.GymUser;
import org.fastgym.fastgymapi.profiles.interfaces.rest.resources.GymUserResource;

public class GymUserResourceFromEntityAssembler {
    public static GymUserResource toResourceFromEntity(GymUser gymUser) {
        return new GymUserResource(
                gymUser.getId(),
                gymUser.getName(),
                gymUser.getEmail(),
                gymUser.getPlanType());
    }
}
