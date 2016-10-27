package upBox.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	
	private Connection connection;
	
	public Connection getConnection(){
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost/db_upbox","root", "123@123");
			return connection;
		} catch (ClassNotFoundException | SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
