package br.com.alura.screenmatch.bancodedados;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DB {
    public Connection recuperarcoenxao(){
        try{
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/screenmacth?user=root&password=2388");

    }catch (SQLException e){
         throw new RuntimeException(e);
        }
}}
