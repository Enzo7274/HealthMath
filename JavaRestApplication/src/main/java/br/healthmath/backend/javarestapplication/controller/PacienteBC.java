/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.healthmath.backend.javarestapplication.controller;
import br.healthmath.backend.javarestapplication.model.Paciente;
import br.healthmath.backend.javarestapplication.dao.PacienteDAO;
import java.util.List;
/**
 *
 * @author enzob
 */
public class PacienteBC {
    private final PacienteDAO dao = new PacienteDAO();
    /*
    public void salvar(Paciente paciente) {
        this.dao.salvar(paciente);
    }
*/
    public boolean salvar(Paciente paciente){
        if(!this.dao.obterPacientesPorCpf(paciente.getCpf_paciente()).isEmpty())
            return false;
        this.dao.salvar(paciente);
        return true;
    }

    public List<Paciente> obterPacientes() {
        return this.dao.obterPacientes();
    }

    public List<Paciente> obterPacientesPorCpf(String cpf_paciente) {
        return this.dao.obterPacientesPorCpf(cpf_paciente);
    }
}
