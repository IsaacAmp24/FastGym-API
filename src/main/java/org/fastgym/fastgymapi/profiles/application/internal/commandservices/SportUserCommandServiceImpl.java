package org.fastgym.fastgymapi.profiles.application.internal.commandservices;

import org.fastgym.fastgymapi.profiles.domain.model.aggregates.SportUser;
import org.fastgym.fastgymapi.profiles.domain.model.commands.CreateSportUserCommand;
import org.fastgym.fastgymapi.profiles.domain.model.valueobjects.Email;
import org.fastgym.fastgymapi.profiles.domain.services.SportUserCommandService;
import org.fastgym.fastgymapi.profiles.infrastructure.persistence.jpa.repositories.SportUserRepository;
import org.springframework.stereotype.Service;

@Service
public class SportUserCommandServiceImpl implements SportUserCommandService {

    private final SportUserRepository sportUserRepository;

    public SportUserCommandServiceImpl(SportUserRepository sportUserRepository) {
        this.sportUserRepository = sportUserRepository;
    }

    @Override
    public Long handle(CreateSportUserCommand command) {
        var sportUser = new SportUser(command.name(), command.email(), command.sportName());
        var email = new Email(command.email());

        // Check if the email already exists
        sportUserRepository.findSportUsersByEmail(email).map(sportUser1 -> {
            throw new IllegalArgumentException("SportUser with email " + command.email() + " already exists");
        });

        // Check if the sport name already exists
        sportUserRepository.save(sportUser);
        return sportUser.getId();
    }
}
