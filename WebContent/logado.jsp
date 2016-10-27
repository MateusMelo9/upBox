<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <!DOCTYPE html>
<html>
<head>
<style>
*{
	margin:0;
	padding:0;
	box-sizing: border-box;
}
html, body{
	width:100%;
	height:100%;
	display:table;
	font-family:Arial, Tahoma, Verdana;
}
.bar-input{
	background: rgba(255,255,255,.95);
	box-shadow:0 2px 20px rgba(0,0,0,.2);
	padding:1rem 0;
	position:fixed;
	width:100%;
}
.align-input{
	position:relative;
	margin:0 auto;
	display:table;
	margin-top:1.4rem;
	padding:.9rem 1.5rem;
	border:1px solid rgba(0,0,0,.1);
}
.sessao{
	position:absolute;
	right:0;
	top:-25px;
	font-size:80%;
	color:rgba(0,0,0,.4);
}
.sessao a{
	font-weight:bold;
	text-decoration:none;
	color:rgba(0,0,0,.4);
	margin-left:10px;
}
.conteudo{
  margin:0 auto;
	width:70%;
	height:100%;
	padding-top:110px;
	display:table;
}
</style>
</head>

<body>
	<!-- Barra com o input -->
	<div class="bar-input">
		<div class="align-input">
			<span class="sessao">email@servidor.com.br <a class="sair" href="">logout</a></span>
			<input type="file" name=""> <input type="submit">
		</div>
	</div>

	<div class="conteudo">
		<!-- Aqui vai o conteudo -->
		asdhaisudhsakjdhaskjdhasldakkkkkkkkkkkkodhaisdhasiudausidgasjdgasiudagduaisgdajksgdaiysdgausidgasduagsdashgaiysdgausdgajskdgasdyagduagsdiagsdjkasgdaiusdgauisdgasjdagdyasdgaisudgasdakjsdgi
	</div>
</body>
</html>