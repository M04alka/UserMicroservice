package ua.od.UserService.domain.coreapi;

public class LogOutEvent {


    private final String userId;
    private final State state;

    public LogOutEvent(String userId, State state) {
        this.userId = userId;
        this.state = State.LogedOut;
    }

    public String getUserId() {
        return userId;
    }

    public State getState() {
        return state;
    }
}
