package ua.od.UserService.domain.coreapi;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

public class LogOutCommand {
    @TargetAggregateIdentifier
    private final String userId;

    private final State state;

    public LogOutCommand(String userId, State state) {
        this.userId = userId;
        this.state = state;
    }

    public String getUserId() {
        return userId;
    }

    public State getState() {
        return state;
    }
}
