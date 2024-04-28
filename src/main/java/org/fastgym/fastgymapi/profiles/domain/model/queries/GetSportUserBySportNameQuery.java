package org.fastgym.fastgymapi.profiles.domain.model.queries;

import org.fastgym.fastgymapi.profiles.domain.model.valueobjects.SportName;

public record GetSportUserBySportNameQuery(SportName sportName) {
}
