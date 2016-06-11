package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.SQLException;

public class ConeccionBD {
    private static final String SERVIDOR = "localhost";
    private static final String PUERTO = "1507";//se rellena cuando den la base de datos
    private static final String NOMBRE_BD = "YuGiOhDB";//se rellena cuando den la base de datos
    private static final String USUARIO = "Dados";//se rellena cuando den la base de datos
    private static final String PASSWORD = "dados";//se rellena cuando den la base de datos
    public static final String URL_CONEXION = "jdbc:derby://" + SERVIDOR + ":"+ PUERTO +"/"+ NOMBRE_BD +";user="+ USUARIO +";password=" + PASSWORD;
    private Connection conexion= null;
    
    public boolean conectar() throws SQLException{
        this.conexion=DriverManager.getConnection(URL_CONEXION);
        return this.conexion != null;
    }
    
    public void desconectar() throws SQLException{
        if (this.conexion != null){
            this.conexion.close();
        }
    }
    
    public Statement crearConsulta() throws SQLException{
        if (this.conexion!= null){
            return this.conexion.createStatement();
        }
        else{
            return null;
        }
    }
}
