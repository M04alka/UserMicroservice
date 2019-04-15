package ua.od.UserService.domain.domainrepositoryinterface;

import ua.od.UserService.domain.coreapi.State;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class UserEntity {
    @Id
    private String userId;
    private String login;
    private String password;
    private Double balance;
    private State state;

    public UserEntity(String userId, String login, String password, Double balance, State state) {
        this.userId = userId;
        this.login = login;
        this.password = password;
        this.balance = balance;
        this.state = state;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }
}
