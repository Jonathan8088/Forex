/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udec.proyectoFinal.clase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 
 * @author Jonathan
 */
public class Datos {
    
    static Connection con =null;
    static Statement stnt =null;
    String server;
    String user;
    String pass;

    public Datos() {
        
        server = "jdbc:postgresql://localhost:5432/Proyecto_final";
        user = "postgres";
        pass = "1234";
        
        Conexion c = new Conexion();
        if(c.indica_1()==1 && c.indica_2()==1){
            stnt=c.stamt();
            con =c.con();
        }
    }
    
    
    
     public static void envio(Usuario usuario){
            String qry = "Insert into usuario(nombre,apellido,correo,contrasena) values ("+"'" + usuario.getNombre()+ "'"+","+"'" + usuario.getApellido() + "'"+","+"'" + usuario.getEmail()+ "'"+","+"'" + usuario.getPass()+ "'"+")";
            try {
                stnt.executeUpdate(qry);
            } catch (SQLException e) {
                System.out.println("fallo");
            }
        
    }
     

public void connect() {
        try {
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection(server, user, pass);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("ConnectDB " + e.getMessage());
        }
    }
public void disconnet() {
        if (con != null) {
            try {
                con.close();
            } catch (SQLException ex) {
                System.out.println("ConnectDB " + ex.getMessage());
            }
        }
    }
 
    public Connection getConnect() {
        return con;
    }
}
