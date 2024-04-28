package org.fastgym.fastgymapi.profiles.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

@Embeddable
public record GymUserName(String gymUserName) {
    // el nombre del usuario de gym no puede ser nulo o vacío
    public GymUserName {
        if (gymUserName == null || gymUserName.isBlank()) {
            throw new IllegalArgumentException("Gym name cannot be null or empty");
        }
    }

    public String getFullName() {
        return gymUserName;
    }
}
