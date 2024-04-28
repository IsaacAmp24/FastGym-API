package org.fastgym.fastgymapi.profiles.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

@Embeddable
public record SportName(String sportName) {
    public SportName {
        if (sportName == null || sportName.isBlank()) {
            throw new IllegalArgumentException("Sport name cannot be null or empty");
        }
    }

    public String sportName() {
        return sportName;
    }
}
