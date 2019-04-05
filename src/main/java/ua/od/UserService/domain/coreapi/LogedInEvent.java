package ua.od.UserService.domain.coreapi;

public class LogedInEvent {

    private final String userId;
    private final State state;

    public LogedInEvent(String userId, State state) {
        this.userId = userId;
        this.state = State.LogedIn;
    }

    public String getUserId() {
        return userId;
    }

    public State getState() {
        return state;
    }
}
