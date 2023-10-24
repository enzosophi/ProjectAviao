package com.example.projectaviao;

import android.content.Context;
import android.util.Log;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ViagemDao {

    public static final String  TAG="Viagem CRUD";


    public Viagem getViagemDetails(int viagemId, Context context) {
        Viagem viagem = null;

        String sql = "SELECT * FROM Viagem WHERE id = ?";

        try (PreparedStatement preparedStatement = MSSQLConnectionHelper.getConnection(context).prepareStatement(sql);) {
            preparedStatement.setInt(1, viagemId);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                int id = resultSet.getInt("id");
                String partida = resultSet.getString("partida");
                String destino = resultSet.getString("destino");
                String situacao = resultSet.getString("situacao");
                String dataViagem = resultSet.getString("dataViagem");
                String horarioViagem = resultSet.getString("horarioViagem");
                int idAero = resultSet.getInt("idAero");
                int idUsuario = resultSet.getInt("idUsuario");
                int quantidadePassageiros = resultSet.getInt("quantidadePassageiros");


                viagem = new Viagem(id, partida, destino, situacao, dataViagem, horarioViagem, idAero, idUsuario, quantidadePassageiros);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return viagem;
    }

    public List<Viagem> obterViagensDoUsuario(int idUsuario) {
        List<Viagem> viagens = new ArrayList<>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {

            // Crie a consulta SQL para obter as viagens do usuário com base no idUsuario
            String sql = "SELECT id,partida, destino, dataViagem, horarioViagem, idAero FROM Viagem WHERE idUsuario = ?";

            // Prepare a consulta
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, idUsuario);

            // Execute a consulta
            resultSet = preparedStatement.executeQuery();

            // Preencha a lista de viagens com os resultados da consulta
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String partida = resultSet.getString("partida");
                String destino = resultSet.getString("destino");
                String data = resultSet.getString("dataViagem");
                String horario = resultSet.getString("horario");
                String aeronave = resultSet.getString("aeronave");

                Viagem viagem = new Viagem(id,partida, destino, data, horario, aeronave);
                viagens.add(viagem);
            }
        } catch (SQLException e) {
            // Lide com exceções de banco de dados aqui
            e.printStackTrace();
        } finally {
            // Feche as conexões, declarações e resultados
        }

        return viagens;
    }



    public static  String authenticateViagem(Viagem mViagem, Context mContext){
        String mResponse="";
        String mSql="SELECT id,fullname,email,password FROM users WHERE password LIKE? AND email LIKE?";
        try{
            PreparedStatement mPreparedStatement =MSSQLConnectionHelper.getConnection(mContext).prepareStatement(mSql);
            mPreparedStatement.setString(1, mViagem.getPartida());
            mPreparedStatement.setString(2, mViagem.getDestino());
            ResultSet mResultSet= mPreparedStatement.executeQuery();
            while (mResultSet.next()){
                mResponse = mResultSet.getString(2);



            }
        }catch (Exception e){
            mResponse ="Exception";
            Log.e(TAG, e.getMessage());
            e.printStackTrace();
        }
        return mResponse;
    }
}
