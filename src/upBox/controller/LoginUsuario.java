package upBox.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import upBox.DAO.UsuarioDAO;

@WebServlet("/Login")
public class LoginUsuario extends HttpServlet {
	private static final long serialVersionUID = 122123L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String email = request.getParameter("txtEmail");
		String senha = request.getParameter("pwSenha");

		UsuarioDAO dao = new UsuarioDAO();

		if (dao.validarLogin(email, senha)) {
			RequestDispatcher rd = request.getRequestDispatcher("logado.jsp");
			rd.forward(request, response);
		}else{
			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
			rd.forward(request, response);
		}
	}

}
