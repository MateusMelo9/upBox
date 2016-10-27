<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
	<script type="text/javascript">
	function validarLogin() {
		if (document.formLogin.txtEmail.value == "") {
			alert("Campo email não informado ");
			return false;
		}
		document.formLogin.submit();
	}	
	</script>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Login - UpBox</title>
	</head>
	<body>
		<h2 align="center">Login</h2>
		<form name="formlogin" action="Login" method="post">
			<p align="center">
			Email:<input type="text" name="txtEmail"/><br>			
			Senha:<input type="password" name="pwSenha"/><br>
			<br>
			<input type="submit" value="Entrar" onclick=""/> <a href="cadastrar.jsp">Cadastrar</a>
			</p>		
		</form>		
	</body>
</html>