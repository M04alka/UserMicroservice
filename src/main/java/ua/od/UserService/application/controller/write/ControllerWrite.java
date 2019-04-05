package ua.od.UserService.application.controller.write;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.od.UserService.application.DtoBuilder.UserDto;
import ua.od.UserService.domain.coreapi.*;

import java.util.UUID;

@RestController
@RequestMapping("user/write")
public class ControllerWrite {


    private CommandGateway commandGateway;
    private QueryGateway queryGateway;

    @PostMapping("/newuser")
    public void createNewUser(UserDto credentials){
        String userId = UUID.randomUUID().toString();
        commandGateway.send(new CreateNewUserCommand(userId,credentials.getLogin(),credentials.getPassword(), State.Undefined));
    }

    @PostMapping("/login/{login}/{password}")
    public void logIntoAccount(UserDto credentials){
        String userId = UUID.randomUUID().toString();
        commandGateway.send(new LogInCommand(userId,credentials.getLogin(),credentials.getPassword(),State.Created));
    }

    @PostMapping("/logout")
    public void logOutOfAccount(UserDto credentials){
        String userId = UUID.randomUUID().toString();
        commandGateway.send(new LogOutCommand(userId,State.LogedIn));
    }

    @PostMapping("/add/{id}/{ammount}")
    public void addMoneyToTheBalance(@PathVariable String userId,@PathVariable Double ammount){
        commandGateway.send(new AddMoneyOnBalanceCommand(userId,ammount));
    }
}
