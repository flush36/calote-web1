<%@ include file="/includes.jsp" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Adiciona Caloteiro</title>
</head>
<body>
<c:import url="cabecalho.jsp" /> </br>

	<hr>
		Usuário logado: ${usuarioLogado.nome}
	</hr>
	
	<form action = "sistema" method = "post">
		<input type = "hidden" name = "logica" value = "AdicionaCaloteiro"/>
		Nome: <input type = "text" name = "nome"/> <br>
		E-mail: <input type = "text" name = "email"/> <br>
		Devendo: <input type = "text" name = "devendo"/> <br>
		Data: <input type = "text" name = "dataDivida"/> <br>
		
		<input type = "submit" value = "Salvar"/>
	</form>
	
<c:import url="rodape.jsp" />	
</body>
</html>