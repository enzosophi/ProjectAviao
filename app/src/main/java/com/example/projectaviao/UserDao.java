package com.example.projectaviao;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Base64;

public class UserDao {
    public static final String TAG = "CRUD USER";

    //nome, email, senha, dataNasc, cpf, telefone,genero, nivelAcesso, statusUsuario
    public static int insertUser(User mUser, Context mContext) {
        int vResponse = 0;

        String mSql;
        try {
            mSql = "INSERT  INTO Usuario(nome, senha, dataNasc, cpf, telefone, genero, email VALUES (?, ?, ?, ?, ?, ?, ? )";
            PreparedStatement mPreparedStatement = MSSQLConnectionHelper.getConnection(mContext).prepareStatement(mSql);

            mPreparedStatement.setString(1, mUser.getNome());
            mPreparedStatement.setString(2, mUser.getSenha());
            mPreparedStatement.setString(3, mUser.getDataNasc());
            mPreparedStatement.setString(4, mUser.getCpf());
            mPreparedStatement.setString(5, mUser.getTelefone());
            mPreparedStatement.setString(6, mUser.getGenero());
            mPreparedStatement.setString(7, mUser.getEmail());

            vResponse = mPreparedStatement.executeUpdate(); //1 se foi com sucesso

        } catch (Exception e) {
            Log.e(TAG, e.getMessage());

        }

        return vResponse;
    }

    public int getUserIdByEmail(String email, Context mContext) {
        int userId = -1;  // Valor padrão caso o email não seja encontrado

        String mSql = "SELECT id FROM Usuario WHERE email = ?";
        try (PreparedStatement mPreparedStatement = MSSQLConnectionHelper.getConnection(mContext).prepareStatement(mSql);) {
            mPreparedStatement.setString(1, email);
            ResultSet resultSet = mPreparedStatement.executeQuery();

            if (resultSet.next()) {
                userId = resultSet.getInt("id");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userId;
    }

    public void saveUserIdByEmailInSharedPreferences(String email, Context mContext) {
        int userId = getUserIdByEmail(email, mContext); // Obtém o ID do usuário

        if (userId != -1) {
            // ID do usuário válido, armazene-o nas SharedPreferences
            SharedPreferences sharedPreferences = mContext.getSharedPreferences("MyPreferences", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putInt("UserId", userId);
            editor.apply();
        } else {

        }
    }

    public static int updateUser(User mUser, Context mContext) {
        int vResponse = 0;

        String mSql;
        try {
            mSql = "UPDATE Usuario SET nome=?, senha=?, dataNasc=?, cpf=?, telefone=?, genero=?, email=? WHERE id=?";
            PreparedStatement mPreparedStatement = MSSQLConnectionHelper.getConnection(mContext).prepareStatement(mSql);

            mPreparedStatement.setString(1, mUser.getNome());
            mPreparedStatement.setString(2, mUser.getSenha());
            mPreparedStatement.setString(3, mUser.getDataNasc());
            mPreparedStatement.setString(4, mUser.getCpf());
            mPreparedStatement.setString(5, mUser.getTelefone());
            mPreparedStatement.setString(6, mUser.getGenero());
            mPreparedStatement.setString(7, mUser.getEmail());
            mPreparedStatement.setInt(8, mUser.getId());

            vResponse = mPreparedStatement.executeUpdate(); //1 se foi com sucesso

        } catch (Exception e) {
            Log.e(TAG, e.getMessage());

        }

        return vResponse;
    }








    public static String authenticateUser(User mUser, Context mContext) {
        String mResponse = "";
        String mSql = "SELECT id,nome,email,senha FROM Usuario WHERE senha = ? AND email = ?";
        String userId = ""; // Variável para armazenar o ID do usuário

        try {
            String codedPassword = Base64.getEncoder().encodeToString(mUser.getSenha().getBytes("utf-8"));
            PreparedStatement mPreparedStatement = MSSQLConnectionHelper.getConnection(mContext).prepareStatement(mSql);
            mPreparedStatement.setString(1, codedPassword);
            mPreparedStatement.setString(2, mUser.getEmail());
            ResultSet mResultSet = mPreparedStatement.executeQuery();
            while (mResultSet.next()) {
                mResponse = mResultSet.getString(2);
            }
        } catch (Exception e) {
            mResponse = "Exception";
            Log.e(TAG, e.getMessage());
            e.printStackTrace();
        }

        // Agora, você pode retornar o ID do usuário junto com a resposta
        return userId + "," + mResponse;
    }



    public static User getUserByEmail(String userEmail, Context context) {
        User user = null;
        String sql = "SELECT id, nome, senha, dataNasc, cpf, telefone, genero FROM Usuario WHERE email = ?";

        try {
            PreparedStatement preparedStatement = MSSQLConnectionHelper.getConnection(context).prepareStatement(sql);
            preparedStatement.setString(1, userEmail);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                // Obtenha os dados do usuário a partir do ResultSet
                int id = resultSet.getInt("id");
                String nome = resultSet.getString("nome");
                String senha = resultSet.getString("senha");
                String dataNasc = resultSet.getString("dataNasc");
                String cpf = resultSet.getString("cpf");
                String telefone = resultSet.getString("telefone");
                String genero = resultSet.getString("genero");
                String email = userEmail;

                // Crie uma instância de User com os dados obtidos
                user = new User(id, nome, email, senha, dataNasc, cpf, telefone, null, genero);

            }

        } catch (Exception e) {
            Log.e(TAG, e.getMessage());
        }

        return user;
    }
}
