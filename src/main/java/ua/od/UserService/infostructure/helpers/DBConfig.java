package ua.od.UserService.infostructure.helpers;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class DBConfig {
    public static final String ABSOLUTE_CLASSPATH = Thread.currentThread().getContextClassLoader().getResource("").getPath();

    private static final Properties dbProperties = new Properties() {{
        try {
            load(new FileInputStream(ABSOLUTE_CLASSPATH + "config/db.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }};

    public static final String DB_USER = dbProperties.getProperty("db.user");
    public static final String DB_PASSWORD = dbProperties.getProperty("db.password");
    public static final String USER_PASSWORD = "?user=" + DB_USER + "&password=" + DB_PASSWORD;
    public static final String DB_NAME = dbProperties.getProperty("db.name");
    public static final String DB_DRIVER = dbProperties.getProperty("db.driver");
    public static final String DB_HOST = dbProperties.getProperty("db.host");
    public static final String DB_CONNECTION_URL = DB_HOST + USER_PASSWORD;
    public static final String DB_DATABASE_URL = DB_HOST + DB_NAME + USER_PASSWORD;
    public static final String DB_SCRIPTS_FOLDER = ABSOLUTE_CLASSPATH + dbProperties.getProperty("db.scripts.folder");
}
