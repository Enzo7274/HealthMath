/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.healthmath.backend.javarestapplication.security;

/**
 *
 * @author enzob
 */
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.UnsupportedJwtException;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.security.SignatureException;
import jakarta.annotation.Priority;
import jakarta.ws.rs.Priorities;
import jakarta.ws.rs.container.ContainerRequestContext;
import jakarta.ws.rs.container.ContainerRequestFilter;
import jakarta.ws.rs.core.HttpHeaders;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.Provider;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import javax.crypto.SecretKey;

@Provider
@Autorizar
@Priority(Priorities.AUTHENTICATION)
public class InterceptadorAutorizar implements ContainerRequestFilter{
    private final SecretKey CHAVE = Keys.hmacShaKeyFor("minhachavequeprecisaterpelomenos80caracteresporquestoesdeseguranca".getBytes(
            StandardCharsets.UTF_8));
    
    @Override
    public void filter(ContainerRequestContext requestContext) throws IOException {
        String authorizationHeader = requestContext.getHeaderString(HttpHeaders.AUTHORIZATION);
        try {
            String token = authorizationHeader.substring("Bearer".length()).trim();
            Jwts.parserBuilder().setSigningKey(CHAVE).build().parseClaimsJws(token);
        } catch (ExpiredJwtException | MalformedJwtException | UnsupportedJwtException | SignatureException
                | IllegalArgumentException | NullPointerException e) {
            requestContext.abortWith(Response.status(Response.Status.UNAUTHORIZED).build());
        }
    }
}
