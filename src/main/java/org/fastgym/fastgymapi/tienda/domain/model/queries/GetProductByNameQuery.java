package org.fastgym.fastgymapi.tienda.domain.model.queries;

import org.fastgym.fastgymapi.tienda.domain.model.valueobjects.ProductName;

public record GetProductByNameQuery(ProductName name) {
}
