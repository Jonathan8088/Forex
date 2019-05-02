/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udec.proyectoFinal.controller;

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
            if(user.getNombre().equals(' ')){
               er.setErrormsg("no se aceptan campos vacios");
               return er;
            }else{
            
             er.setErrormsg("Registro exitoso" +" "+"los datos son:"+" "+user.getNombre()+" "+user.getApellido()
             +" "+user.getEmail()+" "+user.getPass());
               return er;
         }    
    }
    
}


