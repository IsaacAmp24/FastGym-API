package org.fastgym.fastgymapi.advice.domain.model.valueobjects;

public record AdviceName(String adviceName) {

    // Validate the advice name is not null or blank
    public AdviceName {
        if (adviceName == null || adviceName.isBlank()) {
            throw new IllegalArgumentException("Advice name cannot be null or blank");
        }
    }

    public String getAdviceName() {
        return adviceName;
    }

}
