package ua.od.UserService.infostructure.repository;


import ua.od.UserService.domain.coreapi.*;
import ua.od.UserService.infostructure.helpers.SQLHelper;

public class EventRepository {

    private final String LOGED_IN_EVENT = "INSERT INTO LogedInEvent(userId,userState) values(?,?);";

    public String writeLogedInEvent(LogedInEvent event){
        return SQLHelper.prepareStatement(LOGED_IN_EVENT, statement->{
            statement.setString(1,event.getUserId());
            statement.setString(2,event.getState().toString());
            return statement.executeUpdate();
        });
    }

    private final String LOG_OUT_EVENT = "INSERT INTO LogOutEvent(userId,userState) values(?,?);";

    public String writeLogOutEvent(LogOutEvent event){
        return SQLHelper.prepareStatement(LOG_OUT_EVENT, statement->{
            statement.setString(1,event.getUserId());
            statement.setString(2,event.getState().toString());
            return statement.executeUpdate();
        });
    }

    private final String SAVE_USER_EVENT ="INSERT INTO UserCreatedEvent(userId,userLogin, userPassword, userBalance,userState) values(?,?,?,?,?);";

    public String writeUserCreatedEvent(UserCreatedEvent event) {
        return SQLHelper.prepareStatement( SAVE_USER_EVENT, statement->{
            statement.setString(1,event.getUserId());
            statement.setString(2,event.getLogin());
            statement.setString(3,event.getPassword());
            statement.setDouble(4,0);
            statement.setString(5,event.getState().toString());
            return statement.executeUpdate();
        });
    }

    private final String MONEY_ADDED_ON_BALANCE_EVENT = "INSERT INTO MoneyAddedOnBalanceEvent(userId,userBalance) values(?,?);";

    public String writeMoneyAddedOnBalanceEvent(MoneyAddedOnBalanceEvent event){
        return SQLHelper.prepareStatement(MONEY_ADDED_ON_BALANCE_EVENT, statement->{
            statement.setString(1,event.getUserId());
            statement.setDouble(2,event.getBalance());
            return statement.executeUpdate();
        });
    }

    private final String BOOK_PURCHASED_EVENT = "INSERT INTO BookPurchasedEvent(userId,bookId) values(?,?);";

    public String writeBookPurchasedEvent(BookPurchasedEvent event){
        return SQLHelper.prepareStatement(LOGED_IN_EVENT, statement->{
            statement.setString(1,event.getUserId());
            statement.setString(2,event.getBookId());
            return statement.executeUpdate();
        });
    }

}
