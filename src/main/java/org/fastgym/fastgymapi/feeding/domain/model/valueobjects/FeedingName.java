package org.fastgym.fastgymapi.feeding.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

@Embeddable
public record FeedingName(String feedingName) {
    // validate the name is null or blank
    public FeedingName {
        if (feedingName == null || feedingName.isBlank()) {
            throw new IllegalArgumentException("The name is required");
        }
    }

    public String feedingName() {
        return feedingName;
    }
}
