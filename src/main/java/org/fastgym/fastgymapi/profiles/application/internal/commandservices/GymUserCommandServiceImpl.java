package org.fastgym.fastgymapi.profiles.application.internal.commandservices;

import org.fastgym.fastgymapi.profiles.domain.model.aggregates.GymUser;
import org.fastgym.fastgymapi.profiles.domain.model.commands.CreateGymUserCommand;
import org.fastgym.fastgymapi.profiles.domain.model.valueobjects.GymUserEmail;
import org.fastgym.fastgymapi.profiles.domain.services.GymUserCommandService;
import org.fastgym.fastgymapi.profiles.infrastructure.persistence.jpa.repositories.GymUserRepository;
import org.springframework.stereotype.Service;

@Service
public class GymUserCommandServiceImpl implements GymUserCommandService {

    private final GymUserRepository gymUserRepository;

    public GymUserCommandServiceImpl(GymUserRepository gymUserRepository){
        this.gymUserRepository = gymUserRepository;
    }

    @Override
    public Long handle(CreateGymUserCommand command) {

        // solo se regustran usuarios con planes validos (Grueso, Delgado, Medio) admite mayusculas y minusculas
        var planType = command.planType().toUpperCase();
        if (!planType.equals("GRUESO") && !planType.equals("DELGADO") && !planType.equals("MEDIO")) {
            throw new IllegalArgumentException("Invalid plan type, valid values are: Grueso, Delgado, Medio");
        }

        // verifica si el email ya esta registrado
        GymUserEmail gymUserEmail = new GymUserEmail(command.email()); // creao una instancia de la clase GymUserEmail
        gymUserRepository.findUserGymByEmail(gymUserEmail).map(gymUser -> {
            throw new IllegalArgumentException("GymUser with email " + command.email() + " already exists");
        });


        // crea un nuevo GymUser y lo guarda
        var gymUser = new GymUser(command.name(), command.email(), command.planType());
        gymUserRepository.save(gymUser);
        return gymUser.getId();
    }

}
