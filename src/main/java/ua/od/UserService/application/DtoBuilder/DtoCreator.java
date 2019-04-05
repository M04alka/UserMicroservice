package ua.od.UserService.application.DtoBuilder;

import ua.od.UserService.domain.coreapi.UserCreatedEvent;

public class DtoCreator {

    public UserDto createDto(UserCreatedEvent event){
        UserDto userSave = new UserDto();
        userSave.setUserId(event.getUserId());
        userSave.setLogin(event.getLogin());
        userSave.setPassword(event.getPassword());
        userSave.setBalance(event.getBalance());
        userSave.setState(event.getState());
        return userSave;
    }

}
