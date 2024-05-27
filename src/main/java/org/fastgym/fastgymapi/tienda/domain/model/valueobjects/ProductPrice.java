package org.fastgym.fastgymapi.tienda.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

@Embeddable
public record ProductPrice(Double price) {


    public Double getProductPrice() {
        return price;
    }
}
