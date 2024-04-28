package org.fastgym.fastgymapi.profiles.domain.model.queries;

import org.fastgym.fastgymapi.profiles.domain.model.valueobjects.GymUserEmail;

public record GetGymUserByEmailQuery(GymUserEmail email) {
}
