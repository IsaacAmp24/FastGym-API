package org.fastgym.fastgymapi.profiles.domain.model.aggregates;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.fastgym.fastgymapi.profiles.domain.model.valueobjects.Email;
import org.fastgym.fastgymapi.profiles.domain.model.valueobjects.SportName;
import org.fastgym.fastgymapi.profiles.domain.model.valueobjects.SportUserName;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.domain.AbstractAggregateRoot;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@EntityListeners(AuditingEntityListener.class)
@Entity
public class SportUser extends AbstractAggregateRoot<SportUser> {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Getter
    private Long id;

    @Embedded
    @Setter
    private SportUserName name;

    @Embedded
    @Setter
    private Email email;

    @Embedded
    @Setter
    private SportName sportName;

    @CreatedDate
    private String createdAt;

    @LastModifiedDate
    private String updatedAt;


    public SportUser(String name, String email, String sportName){
        this.name = new SportUserName(name);
        this.email = new Email(email);
        this.sportName = new SportName(sportName);
    }


    public SportUser(){

    }


    public String getName(){
        return this.name.fullName();
    }

    public String getEmail(){
        return this.email.email();
    }

    public String getSportName(){
        return this.sportName.sportName();
    }

    // setters
    public void setName(String name) {
        this.name = new SportUserName(name);
    }

    public void setEmail(String email) {
        this.email = new Email(email);
    }

    public void setSportName(String sportName) {
        this.sportName = new SportName(sportName);
    }


    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
