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
            <h1>Não existem pacientes para serem exibidos</h1>
        </c:if>
        <c:if test="${pacientes.size() > 0}">
            <CENTER><h1><b>Lista de Pacientes</b></h1></CENTER>
            <table>
                <thead><td>cpf</td><td>nome</td><td>nascimento</td><td>endereco</td><td>email</td><td>plano-de-saude</td><td>carteirinha</td></thead>
                <c:forEach items="${pacientes}" var="pacientes">
                    <tr>
                        <td>${paciente.cpf_paciente}</td><td>${paciente.nome}</td><td>${paciente.dt_nascimento}</td>
                        <td>${paciente.endereco}</td>
                        <td>${paciente.email}</td>
                        <td>${paciente.nome_plano_saude}</td>
                        <td>${paciente.num_carteirinha}</td>
                    </tr>
                </c:forEach>
            </table>
        </c:if>
    </body>
</html>
