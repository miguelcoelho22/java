package br.com.alura.screenmatch.bancodedados;

import model.DadosSeries;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ContaDAO {


    Connection conn;
    public ContaDAO(Connection connection){
        this.conn = connection;
    }
    public void salvar(DadosSeries dadosSeries) {
        String sql = "INSERT INTO series (titulo, totalDeTemporadas, avaliacao)" +
                "VALUES (?, ?, ?)";
        try{
        PreparedStatement preparedStatement = conn.prepareStatement(sql);

        preparedStatement.setString(1,dadosSeries.titulo());
        preparedStatement.setInt(2,dadosSeries.totalTemporadas());
        preparedStatement.setString(3,dadosSeries.avaliacao());

        preparedStatement.execute();
        preparedStatement.close();
        conn.close();
    }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
}
