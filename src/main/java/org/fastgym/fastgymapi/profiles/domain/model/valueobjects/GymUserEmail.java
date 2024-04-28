package org.fastgym.fastgymapi.profiles.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

@Embeddable
public record GymUserEmail(
        @jakarta.validation.constraints.Email
        String email) {

    public GymUserEmail() {
        this(null);
    }
}
