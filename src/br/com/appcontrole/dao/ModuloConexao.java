/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.appcontrole.dao;

import java.sql.*;

/**
 *
 * @author lenovo
 */
public class ModuloConexao {
    //Conexão com o banco

    public static Connection conector() {
        java.sql.Connection conexao = null;

        //Chamar o driver de conexão
        String driver = "com.mysql.jdbc.Driver";

        String url = "jdbc:mysql://localhost:3306/dbmataboi?useTimezone=true&serverTimezone=UTC&useSSL=false";

        String user = "root";

        String password = "";

        //Estabelecer conexão com o banco
        try {
            Class.forName(driver);
            conexao = DriverManager.getConnection(url, user, password);
            return conexao;
        } catch (Exception e) {
            //System.out.println("conexao");
            
            
            
            
        }
        return null;

    }
}
