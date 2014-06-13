/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package AcessoBanco;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dayan
 */
public class AcessoMysql {
    
    private static AcessoMysql instancia = null;
    
    public static final AcessoMysql getInstance(){
        if(instancia == null){
            instancia = new AcessoMysql();
        }
        return instancia;
    }
    
    private Connection con;
    
    private AcessoMysql(){
        conectar();
    }
    
    public final Connection conectar(){
        try{
        Class.forName("com.mysql.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/carteirinhas","root","root");
        } catch(ClassNotFoundException ex){
            System.out.println("Não foi possível encontrar o Driver!");
        } catch(SQLException ex){
             System.out.println("Não foi possível conectar ao banco!");
        }
        return con;
    }
    
    public void desconectar() {
        try {
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(AcessoMysql.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            con = null;
        }
    }
        
}
