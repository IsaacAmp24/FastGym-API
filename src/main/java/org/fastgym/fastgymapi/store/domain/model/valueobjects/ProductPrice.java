package org.fastgym.fastgymapi.store.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

@Embeddable
public record ProductPrice(String productPrice) {
    public String productPrice() {
        return productPrice;
    }
}
