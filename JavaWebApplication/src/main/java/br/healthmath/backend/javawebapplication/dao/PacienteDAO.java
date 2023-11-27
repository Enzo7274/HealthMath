/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.healthmath.backend.javawebapplication.dao;
import br.healthmath.backend.javawebapplication.model.Paciente;
import java.util.ArrayList;

/**
 *
 * @author enzob
 */
public class PacienteDAO {
    
    private static final ArrayList<Paciente> pacientes = new ArrayList();
    
    public void salvar(Paciente paciente){
        PacienteDAO.pacientes.add(paciente);
    }
    
    public ArrayList<Paciente> obterPacientes(){
        return PacienteDAO.pacientes;
    }
}
