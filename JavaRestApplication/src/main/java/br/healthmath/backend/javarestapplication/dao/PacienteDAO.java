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
    public List<Paciente> obterPacientesPorCpf(String cpf_paciente){
        Predicate<Paciente> filtro = paciente -> paciente.getCpf_paciente().equals(cpf_paciente);
        List<Paciente> pacientesFiltrados = pacientes.stream().filter(filtro).collect(Collectors.toList());
        return pacientesFiltrados;
    }
}
