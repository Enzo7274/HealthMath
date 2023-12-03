/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.healthmath.backend.javarestapplication.dao;

import br.healthmath.backend.javarestapplication.model.Paciente;
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
/**
 *
 * @author enzob
 */
public class PacienteDAO {
    
    private String url = "jdbc:postgresql://localhost:5432/healthmath_database";
    private String username = "pgsqlUser";
    private String password = "postpassword";
    private Connection connection;
    
    private void conectar() {
        try {
            this.connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
    
    public boolean salvar(Paciente paciente) {
        try {
            conectar();
            PreparedStatement pstmt = this.connection.prepareStatement("Insert into paciente(cpf_paciente, nome, dt_nascimento, endereco, email, nome_plano_saude, num_carteirinha) values (?, ?, ?, ?, ?, ?, ?)");
            pstmt.setString(1, paciente.getCpf_paciente());
            pstmt.setString(2, paciente.getNome());
            pstmt.setString(3, paciente.getDt_nascimento());
            pstmt.setString(4, paciente.getEndereco());
            pstmt.setString(5, paciente.getEmail());
            pstmt.setString(6, paciente.getNome_plano_saude());
            pstmt.setInt(7, paciente.getNum_carteirinha());
            pstmt.executeUpdate();
            pstmt.close();
            this.connection.close();
            return true;
        } catch (SQLException e){
            e.printStackTrace();
            return false;
        }
    }
    
    private List<Paciente> obterPacientes(String sql, String cpf) {
        List<Paciente> pacientes = new ArrayList();
        try {
            this.conectar();
            PreparedStatement pstmt = this.connection.prepareStatement(sql);
            if (cpf != null) {
                pstmt.setString(1, cpf);
            }
            ResultSet resultSet = pstmt.executeQuery();
            Paciente novoPaciente;
            while (resultSet.next()) {
                novoPaciente = new Paciente();
                novoPaciente.setCpf_paciente(resultSet.getString("cpf_paciente"));
                novoPaciente.setNome(resultSet.getString("nome"));
                novoPaciente.setDt_nascimento(resultSet.getString("endereco"));
                novoPaciente.setEmail(resultSet.getString("email"));
                novoPaciente.setNome_plano_saude(resultSet.getString("nome_plano_saude"));
                novoPaciente.setNum_carteirinha(resultSet.getInt("num_carteirinha"));
                pacientes.add(novoPaciente);
            }
            resultSet.close();
            pstmt.close();
            this.connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
             
        return pacientes;
    }
    public List<Paciente> obterPacientes() {
        return this.obterPacientes("SELECT * FROM paciente", null);
    }
    
    public List<Paciente> obterPacientesPorCpf(String cpf) {
        return this.obterPacientes("SELECT * FROM pacientes where cpf_paciente=?", cpf);
    }
}
