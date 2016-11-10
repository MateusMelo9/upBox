package upBox.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import upBox.connection.ConnectionFactory;
import upBox.model.FileEntity;

public class FileDAO {

	private Connection con;
	
	public FileDAO (){
		con = new ConnectionFactory().getConnection();
	}
	
	public void adicionar(FileEntity file){
		
		String sql = "INSERT INTO diretorios (nome,caminho) VALUES (?,?)";
		
		try {
			
			PreparedStatement stmt = con.prepareStatement(sql);
			
			stmt.setString(1, file.getNome());
			stmt.setString(2, file.getCaminho());			
			
			stmt.execute();
			stmt.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
}
