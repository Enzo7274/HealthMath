/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.healthmath.backend.javarestapplication.dao;

/**
 *
 * @author enzob
 */
import br.healthmath.backend.javarestapplication.model.Atendimento;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AtendimentoDAO {

    private String url = "jdbc:postgresql://localhost:5432/healthmath_database";
    private String username = "pgsqlUser";
    private String password = "postpassword";
    private Connection connection;

    private void conectar() {
        try {
            this.connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean salvar(Atendimento atendimento) {
        try {
            conectar();
            PreparedStatement pstmt = this.connection.prepareStatement("Insert into atendimento(numero_aten, cpf_paciente, cpf_usuario, descr_aten, data_aten, tipo_aten, valor_aten) values (?, ?, ?, ?, ?, ?, ?)");
            pstmt.setInt(1, atendimento.getNumero_aten());
            pstmt.setString(2, atendimento.getCpf_paciente());
            pstmt.setString(3, atendimento.getCpf_usuario());
            pstmt.setString(4, atendimento.getDescr_aten());
            pstmt.setString(5, atendimento.getData_aten());
            pstmt.setString(6, atendimento.getTipo_aten());
            pstmt.setFloat(7, atendimento.getValor_aten());
            pstmt.executeUpdate();
            pstmt.close();
            this.connection.close();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    private List<Atendimento> obterAtendimentos(String sql, String numAten) {
        List<Atendimento> atendimentos = new ArrayList();
        try {
            this.conectar();
            PreparedStatement pstmt = this.connection.prepareStatement(sql);
            if (numAten != null) {
                pstmt.setString(1, numAten);
            }
            ResultSet resultSet = pstmt.executeQuery();
            Atendimento novoAtendimento;
            while (resultSet.next()) {
                novoAtendimento = new Atendimento();
                novoAtendimento.setNumero_aten(resultSet.getInt("numero_aten"));
                novoAtendimento.setCpf_paciente(resultSet.getString("cpf_paciente"));
                novoAtendimento.setCpf_usuario(resultSet.getString("cpf_usuario"));
                novoAtendimento.setDescr_aten(resultSet.getString("descr_aten"));
                novoAtendimento.setData_aten(resultSet.getString("data_aten"));
                novoAtendimento.setTipo_aten(resultSet.getString("tipo_aten"));
                novoAtendimento.setValor_aten(resultSet.getFloat("valor_aten"));
                atendimentos.add(novoAtendimento);
            }
            resultSet.close();
            pstmt.close();
            this.connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return atendimentos;
    }

    public List<Atendimento> obterAtendimentos() {
        return this.obterAtendimentos("SELECT * FROM atendimento", null);
    }

    public List<Atendimento> obterAtendimentosPorNum(int numero_aten) {
        return this.obterAtendimentos("SELECT * FROM atendimento where numero_aten=?", String.valueOf(numero_aten));
    }
}
