<%-- 
    Document   : pacientes
    Created on : 27 de nov. de 2023, 01:01:05
    Author     : enzob
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Novo Paciente</title>
    </head>
    <body>
        <h1>Novo Paciente:</h1>
        <form action="./PacienteServlet" method="post">
            <label for="cpf_paciente">Cpf:</label>
            <input type="text" name="cpf" id="cpf" required>
            <label for="nome">Nome:</label>
            <input type="text" name="nome" id="nome" required>
            <label for="dt_nascimento">Nascimento:</label>
            <input type="text" name="nascimento" id="nascimento" required>
            <label for="endereco">Endereco:</label>
            <input type="text" name="endereco" id="endereco" required>
            <label for="email">E-mail:</label>
            <input type="email" name="email" id="email" required>
            <label for="nome_plano_saude">Plano de saude:</label>
            <input type="text" name="plano" id="plano" required>
            <label for="num_carteirinha">Carteirinha:</label>
            <input type="int" name="carteirinha" id="carteirinha" required>
            <input type="submit" value="Salvar">
        </form>
    </body>
</html>
