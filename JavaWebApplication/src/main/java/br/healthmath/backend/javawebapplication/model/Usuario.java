/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.healthmath.backend.javawebapplication.model;

/**
 *
 * @author enzob
 */
public class Usuario {
    
    public String cpf_usuario, login, senha;

    public Usuario(String cpf_usuario, String login, String senha) {
        this.cpf_usuario = cpf_usuario;
        this.login = login;
        this.senha = senha;
    }

    public String getCpf_usuario() {
        return cpf_usuario;
    }

    public String getLogin() {
        return login;
    }

    public String getSenha() {
        return senha;
    }
    
}
