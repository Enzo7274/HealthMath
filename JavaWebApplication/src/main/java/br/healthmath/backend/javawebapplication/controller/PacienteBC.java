/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.healthmath.backend.javawebapplication.controller;
import br.healthmath.backend.javawebapplication.dao.PacienteDAO;
import br.healthmath.backend.javawebapplication.model.Paciente;
import java.util.ArrayList;
/**
 *
 * @author enzob
 */
public class PacienteBC {
    
    private final PacienteDAO dao = new PacienteDAO();
    
    public void salvar(Paciente paciente){
        this.dao.salvar(paciente);
    }
    
    public ArrayList<Paciente> obterPacientes(){
        return this.dao.obterPacientes();
    }
}
