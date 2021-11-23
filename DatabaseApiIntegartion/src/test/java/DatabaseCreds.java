import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

//Database connectivity and accessing data 

public class DatabaseCreds {
	public static final String db_username = "root";
	public static final String db_password= "root";
	public static final String db_url= "jdbc:mysql://localhost:3306/empdata"; // database 
	public static final String query= "select * from empdata"; // table 
}
