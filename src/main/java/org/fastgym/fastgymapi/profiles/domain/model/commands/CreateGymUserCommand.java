package org.fastgym.fastgymapi.profiles.domain.model.commands;

public record CreateGymUserCommand(String name, String email, String planType) {
}
