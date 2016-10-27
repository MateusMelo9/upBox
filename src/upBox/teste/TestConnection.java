package upBox.teste;

import java.sql.Connection;
import java.sql.SQLException;

import upBox.connection.ConnectionFactory;

public class TestConnection {

	public static void main(String[] args) throws SQLException {
		
		Connection con = new ConnectionFactory().getConnection();
		System.out.println("Conexão Aberta!");
		con.close();
	}

}
