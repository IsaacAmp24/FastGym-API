package org.fastgym.fastgymapi.advice.application.commandServices;

import org.fastgym.fastgymapi.advice.domain.model.aggregates.Advice;
import org.fastgym.fastgymapi.advice.domain.model.commands.CreateAdviceCommand;
import org.fastgym.fastgymapi.advice.domain.model.valueobjects.AdviceDescription;
import org.fastgym.fastgymapi.advice.domain.model.valueobjects.AdviceName;
import org.fastgym.fastgymapi.advice.domain.services.AdviceCommandService;
import org.fastgym.fastgymapi.advice.infrastructure.jpa.repositories.AdviceRepository;
import org.springframework.stereotype.Service;

@Service
public class AdviceCommandServiceImpl implements AdviceCommandService {

    private final AdviceRepository adviceRepository;

    public AdviceCommandServiceImpl(AdviceRepository adviceRepository){
        this.adviceRepository = adviceRepository;
    }

    @Override
    public Long handle(CreateAdviceCommand command) {
        // validate if advice have a equal description
        var adviceDescription = new AdviceDescription(command.adviceDescription());
        adviceRepository.findAdviceByAdviceDescription(adviceDescription).map(advice -> {
            throw new IllegalArgumentException("Advice with description " + command.adviceDescription() + " already exists");
        });


        // create advice
        var advice = new Advice(command.adviceName(), command.adviceDescription());
        adviceRepository.save(advice);
        return advice.getId();
    }
}
