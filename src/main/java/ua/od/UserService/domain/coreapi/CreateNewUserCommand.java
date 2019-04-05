package ua.od.UserService.domain.coreapi;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

public class CreateNewUserCommand {

    @TargetAggregateIdentifier
    private final String userId;

    private final String login;
    private final String password;
    private final Double balance;
    private final State state;

    public CreateNewUserCommand(String userId, String login, String password, State state) {
        this.userId = userId;
        this.login = login;
        this.password = password;
        this.balance = 0.d;
        this.state = state;
    }

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

    public State getState(){
        return  state;
    }
}
