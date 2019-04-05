package ua.od.UserService.infostructure.repository;
import ua.od.UserService.application.DtoBuilder.UserDto;
import ua.od.UserService.domain.coreapi.State;
import ua.od.UserService.infostructure.helpers.SQLHelper;

import java.sql.ResultSet;

public class UserRepository {

    private final String SAVE_USER ="INSERT INTO User(userId,userLogin, userPassword, userBalance,userState) values(?,?,?,?,?);";


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

    private final String CHECK_USER = "SELECT userLogin From USER WHERE userLogin = ?;";

    public Boolean verifyLogin(String login)
    {
        return SQLHelper.prepareStatement(CHECK_USER, statement ->{
            statement.setString(1,login);
            return statement.execute();
        });
    }

    private final String FIND_PASSWORD ="SELECT userPassword From USER WHERE userPassword = ?;";

    public Boolean verifyPassword(String password){
        return SQLHelper.prepareStatement(CHECK_USER, statement ->{
            statement.setString(1,password);
            return statement.execute();
        });
    }

    private final String UPDATE_USER_STATE = "UPDATE USER SET userState = ? WHERE userId = ?;";

    public Object updateUser(String userId, State state){
        return SQLHelper.prepareStatement(SAVE_USER, statement->{
            statement.setString(1,state.toString());
            statement.setString(2,userId);
            return statement.executeUpdate();
        });
    }

    private final String ADD_TO_BALANCE = "UPDATE USER SET userBalance = ? WHERE userId = ?;";

    public Object updateBalance(String userId,Double balance ){
        return SQLHelper.prepareStatement(ADD_TO_BALANCE, statement->{
             Double newBalance =  viewBalance(userId) + balance;
            statement.setDouble(1,newBalance);
            statement.setString(2,userId);
            return statement.executeUpdate();
        });
    }


    private final String USER_BALANCE = "SELECT userBalance From USER WHERE userId = ?;";

    public Double viewBalance(String userId){
        return SQLHelper.prepareStatement(USER_BALANCE, statement ->{
            statement.setString(1,userId);
            ResultSet resultSet = statement.executeQuery();
            UserDto userBalance = new UserDto();
            return userBalance.getBalance();
        });
    }



}
