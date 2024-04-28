package org.fastgym.fastgymapi.feeding.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

@Embeddable
public record FeedingDescription(String feedingDescription) {
    // validate the description is null or blank
    public FeedingDescription {
        if (feedingDescription == null || feedingDescription.isBlank()) {
            throw new IllegalArgumentException("The description is required");
        }
    }

    public String feedingDescription() {
        return feedingDescription;
    }
}
