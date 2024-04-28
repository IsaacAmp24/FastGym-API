package org.fastgym.fastgymapi.store.domain.model.commands;

public record DeleteProductCommand(Long productId, String productName, String productPrice) {
}
