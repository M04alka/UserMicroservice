package ua.od.UserService.domain.coreapi;

public class UserCreatedEvent {

    private final String userId;
    private final String login;
    private final String password;
    private final Double balance;
    private final State state;

    public UserCreatedEvent(String userId, String login, String password, Double balance,State state) {
        this.userId = userId;
        this.login = login;
        this.password = password;
        this.balance = balance;
        this.state = State.Created;
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
