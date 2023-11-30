/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.healthmath.backend.javarestapplication.resources;

/**
 *
 * @author enzob
 */
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.nio.charset.StandardCharsets;
import javax.crypto.SecretKey;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

import br.healthmath.backend.javarestapplication.model.Usuario;

@Path("/login")
public class LoginResource {
    
    private final SecretKey CHAVE = Keys.hmacShaKeyFor("minhachavequeprecisaterpelomenos80caracteresporquestoesdeseguranca".getBytes(StandardCharsets.UTF_8));
    
    @POST
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response logar(Usuario usuario) {
        try {
            if (usuario.getLogin().equals("admin@unifan.br") && usuario.getSenha().equals("passwd")) {
                String jwtToken = Jwts.builder().setSubject(usuario.getLogin())
                        .setIssuedAt(new Date()).setExpiration(Date.from(LocalDateTime.now().plusMinutes(15L)
                        .atZone(ZoneId.systemDefault()).toInstant()))
                        .signWith(CHAVE, SignatureAlgorithm.HS512)
                        .compact();
                return Response.status(Response.Status.OK).entity(jwtToken).build();
            } else {
                return Response.status(Response.Status.UNAUTHORIZED).entity("Usuário e/ou senha inválidos").build();
            }
        } catch (InvalidKeyException ex) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(ex.getMessage()).build();
        }

    }
}
