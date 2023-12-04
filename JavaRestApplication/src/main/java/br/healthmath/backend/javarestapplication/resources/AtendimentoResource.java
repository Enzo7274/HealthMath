/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.healthmath.backend.javarestapplication.resources;

/**
 *
 * @author enzob
 */

import br.healthmath.backend.javarestapplication.controller.AtendimentoBC;
import br.healthmath.backend.javarestapplication.model.Atendimento;
import br.healthmath.backend.javarestapplication.security.Autorizar;
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

@Path("/atendimento")
public class AtendimentoResource {

    private final AtendimentoBC bc = new AtendimentoBC();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Atendimento> obterAtendimentos() {
        return bc.obterAtendimentos();
    }

    @Autorizar
    @GET
    @Path("/{numero_aten}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Atendimento> obterAtendimentoPorNum(@PathParam("numero_aten") int numero_aten) {
        return bc.obterAtendimentosPorNum(numero_aten);
    }

    @Autorizar
    @GET
    @Path("/bynum")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Atendimento> obterAtendimentoPorNumComQueryParam(@QueryParam("numero_aten") int numero_aten) {
        return bc.obterAtendimentosPorNum(numero_aten);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response salvar(Atendimento atendimento) {
        boolean salvou = bc.salvar(atendimento);
        if (salvou) {
            return Response
                    .ok("Atendimento salvo com sucesso")
                    .build();
        }
        return Response
                .ok("Já existe um atendimento com esse número")
                .build();
    }
}

