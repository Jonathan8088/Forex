/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udec.proyectoFinal.service;

import com.udec.proyectoFinal.clase.Datos;
import com.udec.proyectoFinal.clase.Usuario;
import com.udec.proyectoFinal.utilitario.Seguridad;
import javax.ejb.Stateless;
import javax.json.Json;
import javax.json.JsonObject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author David
 */
@Stateless
@Path("Login")
public class UsuarioLogin {
    Datos dato = new Datos();
    
 @POST
 @Produces(MediaType.APPLICATION_JSON)
 @Consumes(MediaType.APPLICATION_JSON)
 public Response retornUsuariosJwtPrueba(Usuario user ){
            
     if(dato.validacion(user) == true){
         JsonObject json = Json.createObjectBuilder()
                 .add("jwt",Seguridad.JwtConvert(user.getEmail(),user.getPass()))
                 .build();
         return Response.ok(json).build();
     }else{
         JsonObject json = Json.createObjectBuilder()
                 .add("mensaje","Datos Erroneos")
                 .build();
         return Response.status(Response.Status.UNAUTHORIZED).entity(json).build();
     }
           
 }   
}
