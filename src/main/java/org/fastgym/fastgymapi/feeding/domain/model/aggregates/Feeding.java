package org.fastgym.fastgymapi.feeding.domain.model.aggregates;

import jakarta.persistence.*;
import lombok.Getter;
import org.fastgym.fastgymapi.feeding.domain.model.valueobjects.FeedingDescription;
import org.fastgym.fastgymapi.feeding.domain.model.valueobjects.FeedingName;
import org.springframework.data.domain.AbstractAggregateRoot;

@Entity
public class Feeding extends AbstractAggregateRoot<Feeding> {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private Long id;

    @Embedded
    private FeedingName feedingName; // desayuno | almuerzo | cena

    @Embedded
    private FeedingDescription feedingDescription;

    public Feeding(String feedingName, String feedingDescription){
        this.feedingName = new FeedingName(feedingName);
        this.feedingDescription = new FeedingDescription(feedingDescription);
    }

    public Feeding(){

    }

    public String getName(){
        return this.feedingName.feedingName();
    }

    public String getDescription(){
        return this.feedingDescription.feedingDescription();
    }


    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
