<%-- 
    Document   : paciente
    Created on : 27 de nov. de 2023, 01:01:27
    Author     : enzob
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pacientes</title>
    </head>
    <body>
        <c:if test="${pacientes.size()==0}">   
            <h1>Não existem contatos para serem exibidos</h1>
        </c:if>
        <c:if test="${contatos.size() > 0}">
            <CENTER><h1><b>Lista de Pacientes</b></h1></CENTER>
            <table>
                <thead><td>Nome</td><td>E-mail</td><td>Telefone</td></thead>
                <c:forEach items="${contatos}" var="contato">
                    <tr>
                        <td>${contato.nome}</td><td>${contato.email}</td><td>${contato.telefone}</td>
                    </tr>
                </c:forEach>
            </table>
        </c:if>
    </body>
</html>
