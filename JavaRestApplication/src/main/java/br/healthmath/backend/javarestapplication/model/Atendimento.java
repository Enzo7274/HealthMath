/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.healthmath.backend.javarestapplication.model;

/**
 *
 * @author enzob
 */
public class Atendimento {
    
    public int numero_aten;
    public String cpf_paciente, cpf_usuario, descr_aten, data_aten, tipo_aten;
    public float valor_aten;

    public Atendimento(int numero_aten, String cpf_paciente, String cpf_usuario, String descr_aten, String data_aten, String tipo_aten, float valor_aten) {
        this.numero_aten = numero_aten;
        this.cpf_paciente = cpf_paciente;
        this.cpf_usuario = cpf_usuario;
        this.descr_aten = descr_aten;
        this.data_aten = data_aten;
        this.tipo_aten = tipo_aten;
        this.valor_aten = valor_aten;
    }

    public int getNumero_aten() {
        return numero_aten;
    }

    public String getCpf_paciente() {
        return cpf_paciente;
    }

    public String getCpf_usuario() {
        return cpf_usuario;
    }

    public String getDescr_aten() {
        return descr_aten;
    }

    public String getData_aten() {
        return data_aten;
    }

    public String getTipo_aten() {
        return tipo_aten;
    }

    public float getValor_aten() {
        return valor_aten;
    }
    
}
