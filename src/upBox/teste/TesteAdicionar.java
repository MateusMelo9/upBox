package upBox.teste;

import upBox.DAO.UsuarioDAO;
import upBox.model.Usuario;

public class TesteAdicionar {

	public static void main(String[] args) {
		
		Usuario usuario = new Usuario();
		usuario.setNome("Mateus");		
		usuario.setSobrenome("Melo");
		usuario.setEmail("mateus.melo90@gmail.com");
		usuario.setSenha("123123");
		
		UsuarioDAO dao = new UsuarioDAO();
		dao.adicionar(usuario);
		
		System.out.println("Salvo!");

	}

}
