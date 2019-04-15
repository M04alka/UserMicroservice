package ua.od.UserService.application.DtoBuilder;

public class BalanceDto {
    private final Double balance;

    public BalanceDto(Double balance) {
        this.balance = balance;
    }

    public Double getBalance() {
        return balance;
    }
}
