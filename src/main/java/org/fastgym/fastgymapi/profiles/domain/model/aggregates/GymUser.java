package org.fastgym.fastgymapi.profiles.domain.model.aggregates;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.fastgym.fastgymapi.profiles.domain.model.valueobjects.GymUserEmail;
import org.fastgym.fastgymapi.profiles.domain.model.valueobjects.GymUserName;
import org.fastgym.fastgymapi.profiles.domain.model.valueobjects.GymUserPlanType;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.domain.AbstractAggregateRoot;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@EntityListeners(AuditingEntityListener.class)
@Entity
public class GymUser extends AbstractAggregateRoot<GymUser> {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Getter
    private Long id;

    @Embedded
    @Setter
    private GymUserName gymUserName;

    @Embedded
    @Setter
    private GymUserEmail email;

    @Embedded
    @Setter
    private GymUserPlanType planType;

    @CreatedDate
    private String createdAt;

    @LastModifiedDate
    private String updatedAt;

    public GymUser (String name, String email, String planType){
        this.gymUserName = new GymUserName(name);
        this.email = new GymUserEmail(email);
        this.planType = new GymUserPlanType(planType);
    }

    public GymUser(){

    }

    public String getName(){
        return this.gymUserName.getFullName();
    }

    public String getEmail(){
        return this.email.email();
    }

    public String getPlanType(){
        return this.planType.gymUserPlanType();
    }

    // setters
    public void setName(String name) {
        this.gymUserName = new GymUserName(name);
    }

    public void setEmail(String email) {
        this.email = new GymUserEmail(email);
    }

    public void setPlanType(String planType) {
        this.planType = new GymUserPlanType(planType);
    }


    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
