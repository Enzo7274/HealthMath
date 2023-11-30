/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.healthmath.backend.javarestapplication.resources;

import br.healthmath.backend.javarestapplication.controller.PacienteBC;
import br.healthmath.backend.javarestapplication.model.Paciente;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;

/**
 *
 * @author enzo7274
 */
@Path("/")
public class PacienteResource {
    private final PacienteBC bc = new PacienteBC();
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Paciente> obterPacientes(){
        return bc.obterPacientes();
    }
    
    @Autorizar
    @GET
    @Path("/{cpf_paciente}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Paciente> obterPacientePorCpf(@PathParam("cpf_paciente")String cpf_paciente){
        return bc.obterPacientesPorCpf(cpf_paciente);
    }
    
    @Autorizar
    @GET
    @Path("/bycpf")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Paciente> obterPacientePorCpfComQueryParam(@QueryParam("cpf_paciente") String cpf_paciente) {
        return bc.obterPacientesPorCpf(cpf_paciente);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response salvar(Paciente paciente){
        boolean salvou = bc.salvar(paciente);
        if(salvou){
            return Response
            .ok("Paciente salvo com sucesso")
            .build();
        }
        return Response
            .ok("Já existe um paciente com esse cpf")
            .build();
    }
}
