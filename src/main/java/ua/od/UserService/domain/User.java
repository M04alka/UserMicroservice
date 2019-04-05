package ua.od.UserService.domain;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.spring.stereotype.Aggregate;
import ua.od.UserService.application.DtoBuilder.DtoCreator;
import ua.od.UserService.domain.coreapi.*;
import ua.od.UserService.infostructure.repository.UserRepository;
import ua.od.UserService.infostructure.service.UserService;

import static org.axonframework.modelling.command.AggregateLifecycle.apply;

//User Aggregate

@Aggregate
public class User {

    private UserRepository userRepository;
    private DtoCreator dtoCreator;
    private UserService userService;

    @AggregateIdentifier
    private String userId;

    private String login;
    private String password;
    private Double balance;
    private State state;

    public void User(){
    }

    //Create new user command

    @CommandHandler
    public void User(CreateNewUserCommand command){
        UserService userService = new UserService();
        if(userService.ifUserExist(command)){
            throw new IllegalStateException("User with this login already exist!");
        }
        else apply(new UserCreatedEvent(command.getUserId(), command.getLogin(),command.getPassword(), command.getBalance(),command.getState()));
    }

    //New user created event

    @EventSourcingHandler
    public void on(UserCreatedEvent event){
        this.userId = event.getUserId();
        this.login = event.getLogin();
        this.password = event.getPassword();
        this.balance = event.getBalance();
        this.state = event.getState();
        DtoCreator dtoCreator = new DtoCreator();
        UserRepository userRepository = new UserRepository();
        userRepository.saveNewUser(dtoCreator.createDto(event));
        LogInCommand logIn = new LogInCommand(event.getUserId(),event.getLogin(),event.getPassword(),event.getState());
    }

    //Comand for LogInCommand

    @CommandHandler
    public void handle(LogInCommand command){
        UserService userService = new UserService();
        if(userService.verification(command)){
            apply(new LogedInEvent(command.getUserId(),command.getState()));
        }
        else throw new IllegalStateException("Wrong credentials!");

    }

    //Even for someone LogedIn

    @EventSourcingHandler
    public void on(LogedInEvent event) {
        this.userId = event.getUserId();
        this.state = event.getState();
        UserService userService = new UserService();
        userService.updateUser(this.userId,this.state);
    }

    //Comand for LogOutCommand

    @CommandHandler
    public void handle(LogOutCommand command){
        if(command.getState().equals(State.LogedIn)){
        apply(new LogOutEvent(command.getUserId(),command.getState()));
        }
        else throw new IllegalStateException("You can't lo out when you not log in!");
    }

    //Even for someone LogedOut

    @EventSourcingHandler
    public void on(LogOutEvent event) {
        this.userId = event.getUserId();
        this.state = event.getState();
        UserService userService = new UserService();
        userService.updateUser(this.userId,this.state);
    }

    //Comand ot add money

    @CommandHandler
    public void handle(AddMoneyOnBalanceCommand command) {
        apply(new MoneyAddedOnBalanceEvent(command.getUserId(),command.getBalance()));
    }

    //Event for added money

    @EventSourcingHandler
    public void on(MoneyAddedOnBalanceEvent event) {
        this.balance = event.getBalance();
        this.userId = event.getUserId();

    }

    //TODO BUY BOOK

    public String getUserId() {
        return userId;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public Double getBalance() {
        return balance;
    }

    public State getState() {
        return state;
    }
}
