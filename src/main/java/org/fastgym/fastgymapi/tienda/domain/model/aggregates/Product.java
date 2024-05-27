package org.fastgym.fastgymapi.tienda.domain.model.aggregates;

import jakarta.persistence.*;
import lombok.Getter;
import org.fastgym.fastgymapi.tienda.domain.model.valueobjects.ProductName;
import org.fastgym.fastgymapi.tienda.domain.model.valueobjects.ProductPrice;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.domain.AbstractAggregateRoot;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDate;

@EntityListeners(AuditingEntityListener.class)
@Entity
public class Product extends AbstractAggregateRoot<Product> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private Long id;

    @Embedded
    private ProductName productName;

    @Embedded
    private ProductPrice productPrice;

    @CreatedDate
    private LocalDate createdAt;

    @LastModifiedDate
    private LocalDate updatedAt;

    public Product(String name, Double price) {
        this.productName = new ProductName(name);
        this.productPrice = new ProductPrice(price);
    }

    public Product() {

    }

    public String getProductName() {
        return this.productName.name();
    }

    public Double getProductPrice() {
        return this.productPrice.price();
    }
}
