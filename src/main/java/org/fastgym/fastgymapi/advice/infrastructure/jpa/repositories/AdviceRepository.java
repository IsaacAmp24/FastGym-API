package org.fastgym.fastgymapi.advice.infrastructure.jpa.repositories;

import org.fastgym.fastgymapi.advice.domain.model.aggregates.Advice;
import org.fastgym.fastgymapi.advice.domain.model.queries.GetAdviceByNameQuery;
import org.fastgym.fastgymapi.advice.domain.model.valueobjects.AdviceDescription;
import org.fastgym.fastgymapi.advice.domain.model.valueobjects.AdviceName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AdviceRepository extends JpaRepository<Advice, Long> {

    Optional<Advice> findAdviceByAdviceName(AdviceName name);
    Optional <Advice> findAdviceByAdviceDescription(AdviceDescription description);

}
