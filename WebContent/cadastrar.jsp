<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Login - UpBox</title>
	</head>
	<body>
		<h2 align="center">Cadastaro de Usuário</h2>
		<form action="Cadastrar" method="post">
			<p align="center">
			Nome:<input type="text" name="txtNome"/><br>
			Sobrenome:<input type="text" name="txtSobrenome"/><br>
			Email:<input type="text" name="txtEmail"/><br>
			Senha:<input type="password" name="pwSenha"/><br>
			<br>
			<input type="submit" value="Cadastrar"/><a href="login.jsp">Fazer Login</a>
			</p>
		</form>
	</body>
</html>