package org.fastgym.fastgymapi.profiles.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

@Embeddable
public record GymUserPlanType(String gymUserPlanType) {
    // el tipo de plan no debe ser nulo o vacío
    public GymUserPlanType {
        if (gymUserPlanType == null || gymUserPlanType.isBlank()) {
            throw new IllegalArgumentException("Gym user plan type cannot be null or empty");
        }
    }

    public String gymUserPlanType() {
        return gymUserPlanType;
    }
}
