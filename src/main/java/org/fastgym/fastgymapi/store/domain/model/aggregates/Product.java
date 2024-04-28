package org.fastgym.fastgymapi.store.domain.model.aggregates;

import jakarta.persistence.*;
import lombok.Getter;
import org.fastgym.fastgymapi.store.domain.model.valueobjects.ProductName;
import org.fastgym.fastgymapi.store.domain.model.valueobjects.ProductPrice;
import org.springframework.data.domain.AbstractAggregateRoot;

@Entity
public class Product extends AbstractAggregateRoot<Product>{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private Long id;

    @Embedded
    private ProductName productName;

    @Embedded
    private ProductPrice productPrice;

    public Product(String productName, String productPrice){
        this.productName = new ProductName(productName);
        this.productPrice = new ProductPrice(productPrice);
    }

    public Product(){

    }

    public String getName(){
        return this.productName.productName();
    }

    public String getPrice(){
        return this.productPrice.productPrice();
    }



    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
