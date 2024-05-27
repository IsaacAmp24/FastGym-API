package org.fastgym.fastgymapi.profiles.interfaces.rest.transform;

import org.fastgym.fastgymapi.profiles.domain.model.aggregates.SportUser;
import org.fastgym.fastgymapi.profiles.interfaces.rest.resources.SportUserResource;

public class SportUserResourceFromEntityAssembler {
    public static SportUserResource toResourceFromEntity(SportUser sportUser) {
        return new SportUserResource(
                sportUser.getId(),
                sportUser.getName(),
                sportUser.getEmail(),
                sportUser.getSportName());
    }
}
