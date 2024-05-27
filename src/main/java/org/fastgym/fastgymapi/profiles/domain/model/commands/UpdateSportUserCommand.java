package org.fastgym.fastgymapi.profiles.domain.model.commands;

public record UpdateSportUserCommand(
        Long id,
        String name,
        String email,
        String sportName
) {
}
