package upBox.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import upBox.connection.ConnectionFactory;
import upBox.model.Usuario;

public class UsuarioDAO {

	private Connection connection;

	public UsuarioDAO() {
		connection = new ConnectionFactory().getConnection();
	}

	public void adicionar(Usuario usu) {

		String sql = "insert into usuario" + "(nome, sobrenome, email, senha)" + " values (?,?,?,?)";

		try {
			PreparedStatement stmt = connection.prepareStatement(sql);

			stmt.setString(1, usu.getNome());
			stmt.setString(2, usu.getSobrenome());
			stmt.setString(3, usu.getEmail());
			stmt.setString(4, usu.getSenha());

			stmt.execute();
			stmt.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public boolean validarLogin(String email, String senha) {
		PreparedStatement stmt;
		try {
			stmt = connection.prepareStatement("select email,senha from usuario");
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				if (rs.getString("email").equals(email) && rs.getString("senha").equals(senha)) {
					return true;
				}
			}
			return false;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
