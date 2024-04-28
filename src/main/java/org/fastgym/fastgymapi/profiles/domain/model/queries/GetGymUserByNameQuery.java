package org.fastgym.fastgymapi.profiles.domain.model.queries;

import org.fastgym.fastgymapi.profiles.domain.model.valueobjects.GymUserName;

public record GetGymUserByNameQuery(GymUserName gymUserName) {
}
