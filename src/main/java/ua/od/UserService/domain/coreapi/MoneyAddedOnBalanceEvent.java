package ua.od.UserService.domain.coreapi;

public class MoneyAddedOnBalanceEvent {

    private final String userId;
    private final Double balance;

    public MoneyAddedOnBalanceEvent(String userId, Double balance) {
        this.userId = userId;
        this.balance = balance;
    }

    public String getUserId() {
        return userId;
    }

    public Double getBalance() {
        return balance;
    }
}
