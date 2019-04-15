package ua.od.UserService.application.DtoBuilder;

import ua.od.UserService.domain.coreapi.UserCreatedEvent;

public class DtoCreator {

    public UserDto createDto(UserCreatedEvent event){
        UserDto userSave = new UserDto(
                event.getUserId(),
                event.getLogin(),
                event.getPassword(),
                event.getBalance(),
                event.getState()
        );
        return userSave;
    }

}
