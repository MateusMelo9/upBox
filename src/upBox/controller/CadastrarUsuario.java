package upBox.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import upBox.DAO.UsuarioDAO;
import upBox.model.Usuario;

/**
 * Servlet implementation class CadastrarUsuario
 */
@WebServlet("/Cadastrar")
public class CadastrarUsuario extends HttpServlet {
	private static final long serialVersionUID = 190847L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String nome = request.getParameter("txtNome");
		String sobrenome = request.getParameter("txtSobrenome");
		String email = request.getParameter("txtEmail");
		String senha = request.getParameter("pwSenha");
		
		Usuario usuario = new Usuario();
		usuario.setNome(nome);
		usuario.setSobrenome(sobrenome);
		usuario.setEmail(email);
		usuario.setSenha(senha);
		
		UsuarioDAO dao = new UsuarioDAO();
		dao.adicionar(usuario);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/login.jsp");
		dispatcher.forward(request, response);
	}

}
