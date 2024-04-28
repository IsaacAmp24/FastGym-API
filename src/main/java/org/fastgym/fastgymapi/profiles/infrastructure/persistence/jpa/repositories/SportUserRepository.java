package org.fastgym.fastgymapi.profiles.infrastructure.persistence.jpa.repositories;

import org.fastgym.fastgymapi.profiles.domain.model.aggregates.SportUser;
import org.fastgym.fastgymapi.profiles.domain.model.valueobjects.Email;
import org.fastgym.fastgymapi.profiles.domain.model.valueobjects.SportName;
import org.fastgym.fastgymapi.profiles.domain.model.valueobjects.SportUserName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SportUserRepository extends JpaRepository<SportUser, Long> {

    Optional<SportUser> findSportUsersByName(SportUserName name);
    Optional<SportUser> findSportUsersByEmail(Email email);
    Optional<SportUser> findSportUsersBySportName(SportName sportName);

}
