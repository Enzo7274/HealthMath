/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.healthmath.backend.javarestapplication.model;

/**
 *
 * @author enzob
 */
public class Paciente {
    public String cpf_paciente, nome, dt_nascimento, endereco, email, nome_plano_saude;
    public int num_carteirinha;
    
    public Paciente(String cpf_paciente, String nome, String dt_nascimento, String endereco, String email, String nome_plano_saude, int num_carteirinha){
        this.cpf_paciente = cpf_paciente;
        this.nome = nome;
        this.dt_nascimento = dt_nascimento;
        this.endereco = endereco;
        this.email = email;
        this.nome_plano_saude = nome_plano_saude;
        this.num_carteirinha = num_carteirinha;
    }

    public String getCpf_paciente() {
        return cpf_paciente;
    }

    public String getNome() {
        return nome;
    }

    public String getDt_nascimento() {
        return dt_nascimento;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getEmail() {
        return email;
    }

    public String getNome_plano_saude() {
        return nome_plano_saude;
    }

    public int getNum_carteirinha() {
        return num_carteirinha;
    }
}
