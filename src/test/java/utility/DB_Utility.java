package utility;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DB_Utility {

    public static Connection connection;
    public static Statement statement;


    // Connection bağlantı için eklendi
    @BeforeClass
    public void DBConnectionOpen()
    {
        String hostUrl = "jdbc:mysql://db-technostudy.ckr1jisflxpv.us-east-1.rds.amazonaws.com:3306/sakila";
        String username = "root";
        String password = "'\"-LhCB'.%k[4S]z";

        try {
            connection = DriverManager.getConnection(hostUrl, username, password); // bağlantıya click
            statement = connection.createStatement(); // sorguları çalıştırmak için sorgu gönderme ortamı
        }catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }


    // Connection işlem sonrası kapatılması için eklendi
    @AfterClass
    public void DBConnectionClose(){
        try {
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
