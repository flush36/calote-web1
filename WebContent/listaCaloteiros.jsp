<%@ include file="/includes.jsp" %>


<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Lista de Caloteiros</title>
</head>
<body>
<c:import url="cabecalho.jsp" /> </br>
	Lista de Caloteiros:
	</br>


	<table border="1">
		<tr>
			<td>ID</td>
			<td>Nome</td>
			<td>E-mail</td>
			<td>Devendo</td>
			<td>Data da Dívida</td>
			<td>Ações</td>
		</tr>
		<c:forEach var="caloteiro" items="${lista}" varStatus="id">
			<tr bgcolor="#${id.count % 2 == 0 ? 'ff0000' : 'ffffff' }">
				<td>${id.count}</td>
				<td>${caloteiro.nome}</td>

				<c:choose>
					<c:when test="${not empty caloteiro.email}">
						<td><a href="mailto:${caloteiro.email}">${caloteiro.email}</a></td>
					</c:when>
					<c:otherwise>
						<td>E-mail não preenchido.</td>
					</c:otherwise>
				</c:choose>
				
				<td>${caloteiro.devendo}</td>
				<td><fmt:formatDate value="${caloteiro.dataDivida.time}" pattern="dd/MM/yyyy" /></td>
				<td><a href="sistema?logica=DeletarCaloteiro&id=${caloteiro.id}">Apagar</a></td>
			</tr>
		</c:forEach>
	</table>

<c:import url="rodape.jsp" />
</body>
</html>