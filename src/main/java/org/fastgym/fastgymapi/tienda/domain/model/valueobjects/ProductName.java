package org.fastgym.fastgymapi.tienda.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

@Embeddable
public record ProductName(String name) {

    public String getProductName() {
        return name;
    }
}
