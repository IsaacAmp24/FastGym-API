package org.fastgym.fastgymapi.advice.domain.model.valueobjects;

public record AdviceDescription(String adviceDescription) {

        // Validate the advice description is not null or blank
        public AdviceDescription {
            if (adviceDescription == null || adviceDescription.isBlank()) {
                throw new IllegalArgumentException("Advice description cannot be null or blank");
            }
        }

        public String getAdviceDescription() {
            return adviceDescription;
        }
}
