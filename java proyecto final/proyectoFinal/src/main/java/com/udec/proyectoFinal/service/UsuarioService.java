/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udec.proyectoFinal.service;

import com.udec.proyectoFinal.clase.Datos;
import com.udec.proyectoFinal.clase.Usuario;
import com.udec.proyectoFinal.controller.UsuarioController;
import com.udec.proyectoFinal.utilitario.Seguridad;
import javax.ejb.Stateless;
import javax.json.Json;
import javax.json.JsonObject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author David
 */
@javax.enterprise.context.RequestScoped
@Path("Logica")
public class UsuarioService {
  UsuarioController us = new UsuarioController(); 
    
 @POST
 @Produces(MediaType.APPLICATION_JSON)
 @Consumes(MediaType.APPLICATION_JSON)
 public Response recargaDinero(Usuario user){
     try{
          JsonObject json = Json.createObjectBuilder()
                 .add("saldo",us.recargaDinero(user))
                 .build();
        return Response.ok(json).build();
     }catch (Exception ex){
         return Response.status(Response.Status.NOT_IMPLEMENTED).build();
         
     }         
   } 
 
 
 @POST
 @Produces(MediaType.APPLICATION_JSON)
 @Consumes(MediaType.APPLICATION_JSON)
 @Path("/consultaDinero")
 public Response ConsultaDinero(Usuario user){
     try{
          JsonObject json = Json.createObjectBuilder()
                 .add("saldoOriginal",us.consultarDinero(user))
                 .build();
        return Response.ok(json).build();
     }catch (Exception ex){
         return Response.status(Response.Status.NOT_IMPLEMENTED).build();
         
     }         
   } 
 
 
    
}
