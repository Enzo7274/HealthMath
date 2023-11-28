/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */

/**
 *
 * @author jmath
 */


package br.unifan.hellowsdl.services;


import javax.jws.WebService;

@WebService()
public interface HelloService {
 public String hello(String txt);
}