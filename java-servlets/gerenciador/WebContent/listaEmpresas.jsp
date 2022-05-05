<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List, br.com.alura.gerenciador.servlet.Empresa"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

		<c:if test="${not empty empresa}">
			Empresa ${empresa} cadastrada com sucesso!
		</c:if>
		
    Lista de empresas: <br />
    
    <ul>
    	<c:forEach items="${empresas}" var="empresa">
    		<li>${empresa.nome} - <fmt:formatDate value="${empresa.dataAbertura}" pattern="dd/MM/yyyy"/>
    		<a href="removerEmpresa?id=${empresa.id}">Remover</a>
    		<a href="mostrarEmpresa?id=${empresa.id}">Alterar</a>
    		</li>
    	</c:forEach>
    </ul>
</body>
</html>