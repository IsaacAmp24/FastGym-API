package org.fastgym.fastgymapi.store.domain.model.queries;

import org.fastgym.fastgymapi.store.domain.model.valueobjects.ProductName;

public record GetProductByNameQuery(ProductName productName) {
}
