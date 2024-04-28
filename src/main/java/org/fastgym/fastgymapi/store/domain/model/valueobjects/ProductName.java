package org.fastgym.fastgymapi.store.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

@Embeddable
public record ProductName(String productName) {

    public String productName() {
        return productName;
    }
}
