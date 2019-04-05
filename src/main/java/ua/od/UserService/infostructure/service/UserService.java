package ua.od.UserService.infostructure.service;

import ua.od.UserService.domain.coreapi.CreateNewUserCommand;
import ua.od.UserService.domain.coreapi.LogInCommand;
import ua.od.UserService.domain.coreapi.State;
import ua.od.UserService.infostructure.repository.UserRepository;

public class UserService {

    private UserRepository userRepository;

    public Boolean verification(LogInCommand command){
        String login = command.getLogin();
        String password = command.getPassword();
        UserRepository userRepository = new UserRepository();
        if(userRepository.verifyLogin(login) && userRepository.verifyPassword(password)){
            return true;
        }
        else return false;
    }

    public boolean ifUserExist(CreateNewUserCommand user){
        String login = user.getLogin();
        UserRepository userRepository = new UserRepository();
        return userRepository.verifyLogin(login);

    }

    public void updateUser(String userId, State state){
        UserRepository userRepository = new UserRepository();
        userRepository.updateUser(userId,state);
    }

    public void addToBalance(String userId, Double balance){
        UserRepository userRepository = new UserRepository();
        userRepository.updateBalance(userId,balance);
    }
}
