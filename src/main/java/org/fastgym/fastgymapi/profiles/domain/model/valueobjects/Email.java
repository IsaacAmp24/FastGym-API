package org.fastgym.fastgymapi.profiles.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

@Embeddable
public record Email(
        @jakarta.validation.constraints.Email
        String email
) {
    public Email(){this(null);}
}
