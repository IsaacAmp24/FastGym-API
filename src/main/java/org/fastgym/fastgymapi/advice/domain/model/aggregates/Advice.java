package org.fastgym.fastgymapi.advice.domain.model.aggregates;

import jakarta.persistence.*;
import lombok.Getter;
import org.fastgym.fastgymapi.advice.domain.model.valueobjects.AdviceDescription;
import org.fastgym.fastgymapi.advice.domain.model.valueobjects.AdviceName;
import org.springframework.data.domain.AbstractAggregateRoot;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@EntityListeners(AuditingEntityListener.class)
@Entity
public class Advice extends AbstractAggregateRoot<Advice> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private Long id;

    @Embedded
    private AdviceName adviceName; // desayuno | almuerzo | cena

    @Embedded
    private AdviceDescription adviceDescription;

    public Advice(String adviceName, String adviceDescription){
        this.adviceName = new AdviceName(adviceName);
        this.adviceDescription = new AdviceDescription(adviceDescription);
    }

    public Advice(){

    }

    public String getName(){
        return this.adviceName.adviceName();
    }

    public String getDescription(){
        return this.adviceDescription.adviceDescription();
    }


}
