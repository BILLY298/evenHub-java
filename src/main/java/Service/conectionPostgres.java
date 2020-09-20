package Service;

import DB.Coneccion;

import java.sql.*;

public class conectionPostgres {

    public Connection getConectionPostgres(Coneccion data){
        Connection con = null;
        try{
            con = DriverManager.getConnection(data.getUrl(),data.getUser(),data.getPassword());
            return con;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return con;
    }
}
