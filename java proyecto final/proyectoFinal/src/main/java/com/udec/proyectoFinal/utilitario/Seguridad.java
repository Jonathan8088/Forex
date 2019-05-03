/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udec.proyectoFinal.utilitario;

import com.udec.proyectoFinal.clase.Datos;
import com.udec.proyectoFinal.clase.Usuario;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import java.security.Key;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author David
 */
public class Seguridad {
     
    
       public static String JwtConvert(String usuario, String contraseña){
        Key KEY = Keys.secretKeyFor(SignatureAlgorithm.HS256);
        Datos dat = new Datos();
        ArrayList<Usuario> listauser = new ArrayList<Usuario>();
        listauser = dat.traerInfo();
        if(listauser.isEmpty()){
            String jwt = "no hay datos";
            return jwt;
        }else{
            for (Usuario userL : listauser) {
                    if(userL.getEmail().equals(usuario) && userL.getPass().equals(contraseña)){
                        String jwt = Jwts.builder()
                                        .signWith(KEY)
                                        .setSubject(usuario)
                                        .setIssuedAt(creacion())
                                        .setExpiration(expiracion())
                                        .claim("Correo", userL.getEmail())
                                        .claim("Contraseña", userL.getPass())
                                        .compact();
                        dat.updateToken(userL,jwt);
                        return jwt;
                    }
                }
        }
        String jwt = "Datos no coinciden";
        return jwt;
    }
    
     private static Date creacion(){
        long tiempo = System.currentTimeMillis();
        return new Date(tiempo);
    }
    
    private  static Date expiracion(){
        long tiempo = System.currentTimeMillis();
        long expiraTiempo = TimeUnit.MINUTES.toMillis(30);
        return new Date(tiempo+expiraTiempo);
    }
}
    

