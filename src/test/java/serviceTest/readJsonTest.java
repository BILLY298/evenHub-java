/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serviceTest;

import DB.Coneccion;
import Service.jsontoConeccion;

/**
 *
 * @author valde
 */
public class readJsonTest {
    public static void main(String args[]) throws java.io.IOException {
        Coneccion c = jsontoConeccion.getCon();
        System.out.println("Host:"+c.getHost()+"\nPort:"+c.getPort()+"\nUser:"+c.getUser()+"\npass:"+c.getPassword()+"\nBaseDatos:"+c.getBasedatos());
    }
}
