package org.fastgym.fastgymapi.profiles.infrastructure.persistence.jpa.repositories;

import org.fastgym.fastgymapi.profiles.domain.model.aggregates.GymUser;
import org.fastgym.fastgymapi.profiles.domain.model.valueobjects.GymUserEmail;
import org.fastgym.fastgymapi.profiles.domain.model.valueobjects.GymUserName;
import org.fastgym.fastgymapi.profiles.domain.model.valueobjects.GymUserPlanType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GymUserRepository extends JpaRepository<GymUser, Long> {

    Optional<GymUser> findUserGymByGymUserName(GymUserName gymUserName);
    Optional<GymUser> findUserGymByEmail(GymUserEmail email);
    Optional<GymUser> findGymUsersByPlanType(GymUserPlanType planType);

}
