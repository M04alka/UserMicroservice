package ua.od.UserService.domain.coreapi;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

public class AddMoneyOnBalanceCommand {

    @TargetAggregateIdentifier
    private final String userId;

    private final Double balance;


    public AddMoneyOnBalanceCommand(String userId, Double balance) {
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
