package org.fastgym.fastgymapi.profiles.interfaces.acl;

import org.fastgym.fastgymapi.profiles.domain.model.aggregates.GymUser;
import org.fastgym.fastgymapi.profiles.domain.model.aggregates.SportUser;
import org.fastgym.fastgymapi.profiles.domain.model.commands.CreateGymUserCommand;
import org.fastgym.fastgymapi.profiles.domain.model.commands.CreateSportUserCommand;
import org.fastgym.fastgymapi.profiles.domain.model.queries.GetGymUserByIdQuery;
import org.fastgym.fastgymapi.profiles.domain.model.queries.GetGymUserByNameQuery;
import org.fastgym.fastgymapi.profiles.domain.model.queries.GetSportUserByIdQuery;
import org.fastgym.fastgymapi.profiles.domain.model.queries.GetSportUserByNameQuery;
import org.fastgym.fastgymapi.profiles.domain.model.valueobjects.GymUserName;
import org.fastgym.fastgymapi.profiles.domain.model.valueobjects.SportUserName;
import org.fastgym.fastgymapi.profiles.domain.services.GymUserCommandService;
import org.fastgym.fastgymapi.profiles.domain.services.GymUserQueryService;
import org.fastgym.fastgymapi.profiles.domain.services.SportUserCommandService;
import org.fastgym.fastgymapi.profiles.domain.services.SportUserQueryService;

import java.util.Optional;

public class UsersContextFacade {
    // GymUser
    private final GymUserCommandService gymUserCommandService;
    private final GymUserQueryService gymUserQueryService;

    // SportUser
    private final SportUserCommandService sportUserCommandService;
    private final SportUserQueryService sportUserQueryService;

    public UsersContextFacade(GymUserCommandService gymUserCommandService, GymUserQueryService gymUserQueryService, SportUserCommandService sportUserCommandService, SportUserQueryService sportUserQueryService) {
        // GymUser
        this.gymUserCommandService = gymUserCommandService;
        this.gymUserQueryService = gymUserQueryService;
        // SportUser
        this.sportUserCommandService = sportUserCommandService;
        this.sportUserQueryService = sportUserQueryService;
    }

    // GymUser
    public Long createGymUser(String name, String email, String planType) {
        CreateGymUserCommand CreateGymUserCommand = new CreateGymUserCommand(name, email, planType );
        return gymUserCommandService.handle(CreateGymUserCommand);
    }

    public Long getGymUserIdByName(String name) {
        var getGymUserByNameQuery = new GetGymUserByNameQuery(new GymUserName(name));
        var gymUser = gymUserQueryService.handle(getGymUserByNameQuery);
        if (gymUser.isEmpty()) return 0L;
        return gymUser.get().getId();
    }

    public Optional<GymUser> getGymUserById(Long id) {
        var getGymUserByIdQuery = new GetGymUserByIdQuery(id);
        return gymUserQueryService.handle(getGymUserByIdQuery);
    }

    public Optional<GymUser> getGymUserByEmail(String email) {
        var getGymUserByEmailQuery = new GetGymUserByNameQuery(new GymUserName(email));
        return gymUserQueryService.handle(getGymUserByEmailQuery);
    }

    public Optional<GymUser> getGymUserByPlanType(String planType) {
        var getGymUserByPlanTypeQuery = new GetGymUserByNameQuery(new GymUserName(planType));
        return gymUserQueryService.handle(getGymUserByPlanTypeQuery);
    }


    // SportUser
    public Long createSportUser(String name, String email, String sportName) {
        CreateSportUserCommand CreateSportUserCommand = new CreateSportUserCommand(name, email, sportName);
        return sportUserCommandService.handle(CreateSportUserCommand);
    }

    public Long getSportUserIdByName(String name) {
        var getSportUserByNameQuery = new GetSportUserByNameQuery(new SportUserName(name));
        var sportUser = sportUserQueryService.handle(getSportUserByNameQuery);
        if (sportUser.isEmpty()) return 0L;
        return sportUser.get().getId();
    }

    public Optional<SportUser> getSportUserById(Long id) {
        var getSportUserByIdQuery = new GetSportUserByIdQuery(id);
        return sportUserQueryService.handle(getSportUserByIdQuery);
    }


}
