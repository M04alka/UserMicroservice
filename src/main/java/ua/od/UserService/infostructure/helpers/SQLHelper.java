package ua.od.UserService.infostructure.helpers;

import java.sql.*;

public class SQLHelper {
    public interface PreparedQuery<T> {
        T execute(PreparedStatement preparedStatement) throws SQLException;
    }
    public interface CallableQuery<T> {
        T execute(CallableStatement statement) throws SQLException;
    }
    public interface Query<T> {
        T execute(Statement statement) throws SQLException;
    }
    private abstract static class CustomStatement<T> {
        protected Statement statement = null;
        protected Connection connection = null;
        private String dbConnectionUrl;
        public CustomStatement(String dbConnectionUrl) {
            this.dbConnectionUrl = dbConnectionUrl;
        }
        abstract T getResult() throws SQLException;
        public T run() {
            T result = null;
            try {
                connection = DriverManager.getConnection(dbConnectionUrl);
                result = getResult();
            } catch(SQLException e) {
                System.err.println(e.getMessage());
            } finally {
                try {
                    if(statement != null) statement.close();
                    if(connection != null) connection.close();
                } catch(SQLException e) {
                    System.err.println(e);
                }
            }
            return result;
        }
    }

    public static <T> T prepareStatement(final String sql, final PreparedQuery query) {
        return new CustomStatement<T>(DBConfig.DB_DATABASE_URL) {
            T getResult() throws SQLException {
                statement = connection.prepareStatement(sql);
                statement.setQueryTimeout(30);  // set timeout to 30 sec.
                return (T) query.execute((PreparedStatement) statement);
            }
        }.run();
    }

    public static <T> T createStatement(Query query) {
        return createStatement(query, DBConfig.DB_DATABASE_URL);
    }

    public static <T> T createStatement(final Query query, String dbConnectionUrl) {
        return new CustomStatement<T>(dbConnectionUrl) {
            T getResult() throws SQLException {
                statement = connection.createStatement();
                statement.setQueryTimeout(30);  // set timeout to 30 sec.
                return (T) query.execute(statement);
            }
        }.run();
    }

    public static <T> T callableStatement(final String sql, final CallableQuery query) {
        return new CustomStatement<T>(DBConfig.DB_DATABASE_URL) {
            T getResult() throws SQLException {
                statement = connection.prepareCall(sql);
                statement.setQueryTimeout(30);  // set timeout to 30 sec.
                return (T) query.execute((CallableStatement) statement);
            }
        }.run();
    }
}
