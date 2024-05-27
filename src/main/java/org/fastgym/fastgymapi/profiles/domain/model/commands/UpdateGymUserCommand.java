package org.fastgym.fastgymapi.profiles.domain.model.commands;

public record UpdateGymUserCommand (
        Long id,
        String name,
        String email,
        String planType
) {
}
