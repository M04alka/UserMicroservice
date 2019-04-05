package ua.od.UserService.domain.coreapi;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

public class LogInCommand {

    @TargetAggregateIdentifier
    private final String userId;
    private final String login;
    private final String password;
    private final State state;

    public LogInCommand(String userId, String login, String password, State state) {
        this.userId = userId;
        this.login = login;
        this.password = password;
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

    public State getState() {
        return state;
    }
}
