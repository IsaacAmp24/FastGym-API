package org.fastgym.fastgymapi.profiles.application.internal.commandservices;

import org.fastgym.fastgymapi.profiles.domain.model.aggregates.SportUser;
import org.fastgym.fastgymapi.profiles.domain.model.commands.CreateSportUserCommand;
import org.fastgym.fastgymapi.profiles.domain.model.commands.UpdateSportUserCommand;
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

    @Override
    public Long handle(UpdateSportUserCommand command) {
        var sportUser = sportUserRepository.findById(command.id()).orElseThrow(() -> new IllegalArgumentException("SportUser with id " + command.id() + " does not exist"));

        // Update the name if it is different from null, "string" and not empty
        if (command.name() != null && !command.name().equals("string") && !command.name().isEmpty()) {
            sportUser.setName(command.name());
        }

        // Update the email if it is different from null, "string" and not empty
        if (command.email() != null && !command.email().equals("string") && !command.email().isEmpty()) {
            sportUser.setEmail(command.email());
        }

        // Update the sport name if it is different from null, "string" and not empty
        if (command.sportName() != null && !command.sportName().equals("string") && !command.sportName().isEmpty()) {
            sportUser.setSportName(command.sportName());
        }

        sportUserRepository.save(sportUser);


        return sportUser.getId();
    }
}
