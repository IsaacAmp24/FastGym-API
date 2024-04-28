package org.fastgym.fastgymapi.feeding.infrastructure.persistence.jpa.repositories;

import org.fastgym.fastgymapi.feeding.domain.model.aggregates.Feeding;
import org.fastgym.fastgymapi.feeding.domain.model.valueobjects.FeedingDescription;
import org.fastgym.fastgymapi.feeding.domain.model.valueobjects.FeedingName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FeedingRepository extends JpaRepository<Feeding, Long>{

    Optional<Feeding> findFeedingByFeedingName(FeedingName feedingName);
    Optional<Feeding> findFeedingByFeedingDescription(FeedingDescription feedingDescription);
}
