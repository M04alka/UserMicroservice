package ua.od.UserService.infostructure.repository;
import ua.od.UserService.application.DtoBuilder.BalanceDto;
import ua.od.UserService.application.DtoBuilder.UserDto;
import ua.od.UserService.domain.coreapi.State;
import ua.od.UserService.infostructure.helpers.SQLHelper;

import java.sql.ResultSet;

public class UserRepository {

    private final String SAVE_USER ="INSERT INTO User(userId,userLogin, userPassword, userBalance,userState) values(?,?,?,?,?);";

    //New User creation

    public String saveNewUser(UserDto user) {
        return SQLHelper.prepareStatement(SAVE_USER, statement->{
            statement.setString(1,user.getUserId());
            statement.setString(2,user.getLogin());
            statement.setString(3,user.getPassword());
            statement.setDouble(4,0);
            statement.setString(5,user.getState().toString());
            return statement.executeUpdate();
        });
    }

    private final String CHECK_USER = "SELECT userLogin, userPassword From USER WHERE userLogin = ? AND userPassword = ?;";

    //User verification

    public Boolean verification(String login, String password)
    {
        return SQLHelper.prepareStatement(CHECK_USER, statement ->{
            statement.setString(1,login);
            statement.setString(2,password);
            return statement.execute();
        });
    }

    private final String CHECK_USER_LOGIN = "SELECT userLogin From USER WHERE userLogin = ?;";

    //Check login

    public Boolean verifyLogin(String login)
    {
        return SQLHelper.prepareStatement(CHECK_USER, statement ->{
            statement.setString(1,login);
            return statement.execute();
        });
    }

    private final String UPDATE_USER_STATE = "UPDATE USER SET userState = ? WHERE userId = ?;";

    //Update user state

    public Object updateUser(String userId, State state){
        return SQLHelper.prepareStatement(SAVE_USER, statement->{
            statement.setString(1,state.toString());
            statement.setString(2,userId);
            return statement.executeUpdate();
        });
    }

    private final String ADD_TO_BALANCE = "UPDATE USER SET userBalance = ? WHERE userId = ?;";

    //Update user balance

    public Object updateBalance(String userId,Double balance ){
        return SQLHelper.prepareStatement(ADD_TO_BALANCE, statement->{
            Double newBalance =  viewBalance(userId) + balance;
            statement.setDouble(1,newBalance);
            statement.setString(2,userId);
            return statement.executeUpdate();
        });
    }

    private final String USER_BALANCE = "SELECT userBalance From USER WHERE userId = ?;";

    //Show user balance

    public Double viewBalance(String userId){
        return SQLHelper.prepareStatement(USER_BALANCE, statement ->{
            statement.setString(1,userId);
            ResultSet resultSet = statement.executeQuery();
            BalanceDto userBalance = new BalanceDto(resultSet.getDouble("userBalance"));
            return userBalance.getBalance();
        });
    }

    private final String PURCHASE_BOOK = "INSERT INTO User_Book(userId, bookId) values(?,?);";

    //Purchase book

    public String purchaseBook(String user, String book){
        return SQLHelper.prepareStatement(PURCHASE_BOOK, statement ->{
            statement.setString(1,user);
            statement.setString(2,book);
            return statement.executeUpdate();
        });
    }

}
