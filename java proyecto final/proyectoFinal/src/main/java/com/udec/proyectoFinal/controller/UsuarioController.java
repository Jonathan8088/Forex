/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udec.proyectoFinal.controller;

import com.udec.proyectoFinal.clase.Datos;
import com.udec.proyectoFinal.clase.ErrorMsg;
import com.udec.proyectoFinal.clase.Usuario;
import java.util.List;

/**
 *
 * @author David
 */
public class UsuarioController {

    
    
    public ErrorMsg anadirUser(Usuario user)  {
        ErrorMsg er = new ErrorMsg();
            if(user.getNombre().isEmpty() || user.getApellido().isEmpty() || user.getEmail().isEmpty() || user.getPass().isEmpty()){
               er.setErrormsg("no se aceptan campos vacios");
               return er;
            }else{
              Datos dat =  new Datos();
              dat.envio(user);
             er.setErrormsg("Registro exitoso");
               return er;
         }    
    }
    
}


