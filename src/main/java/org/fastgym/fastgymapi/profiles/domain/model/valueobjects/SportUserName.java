package org.fastgym.fastgymapi.profiles.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

@Embeddable
public record SportUserName(String name) {
    public SportUserName {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Sport user name cannot be null or empty");
        }
    }

    public String fullName() {
        return name;
    }
}
