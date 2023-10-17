package com.example.projectaviao;

import android.content.Context;
import android.util.Log;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
            mSql = "INSERT  INTO Usuario(nome, senha, dataNasc, cpf, telefone, genero, nivelAcesso, statusUsuario, email VALUES (?, ?, ?, ?, ?, ?, ?, ?,? )";
            PreparedStatement mPreparedStatement = MSSQLConnectionHelper.getConnection(mContext).prepareStatement(mSql);

            mPreparedStatement.setString(1, mUser.getUsername());
            mPreparedStatement.setString(2, mUser.getPassword());
            mPreparedStatement.setLong(3, mUser.getDatenasc());
            mPreparedStatement.setString(4, mUser.getCpf());
            mPreparedStatement.setString(5, mUser.getUsertel());
            mPreparedStatement.setString(6, mUser.getUsergender());
            mPreparedStatement.setString(7, mUser.getUserAccess());
            mPreparedStatement.setString(8, mUser.getResetPassword());
            mPreparedStatement.setString(9, mUser.getmEmail());

            vResponse = mPreparedStatement.executeUpdate(); //1 se foi com sucesso

        } catch (Exception e) {
            Log.e(TAG, e.getMessage());

        }

        return vResponse;
    }

    public static int updateUser(User mUser, Context mContext) {
        int vResponse = 0;

        String mSql;
        try {
            mSql = "UPDATE usuario SET NOME=?, senha=?, dataNasc=?, cpf=?, telefone=?, genero=?, nivelAcesso=?, statusUsuario=?, email=? WHERE id=?";
            PreparedStatement mPreparedStatement = MSSQLConnectionHelper.getConnection(mContext).prepareStatement(mSql);

            mPreparedStatement.setString(1, mUser.getUsername());
            mPreparedStatement.setString(2, mUser.getPassword());
            mPreparedStatement.setLong(3, mUser.getDatenasc());
            mPreparedStatement.setString(4, mUser.getCpf());
            mPreparedStatement.setString(5, mUser.getUsertel());
            mPreparedStatement.setString(6, mUser.getUsergender());
            mPreparedStatement.setString(7, mUser.getUserAccess());
            mPreparedStatement.setString(8, mUser.getResetPassword());
            mPreparedStatement.setInt(8, mUser.getId());
            mPreparedStatement.setString(8, mUser.getmEmail());

            vResponse = mPreparedStatement.executeUpdate(); //1 se foi com sucesso

        } catch (Exception e) {
            Log.e(TAG, e.getMessage());

        }

        return vResponse;
    }

    public static int DeleteUser(User mUser, Context mContext) {
        int vResponse = 0;

        String mSql;
        try {
            mSql = "DELETE FROM usuario WHERE id=?";
            PreparedStatement mPreparedStatement = MSSQLConnectionHelper.getConnection(mContext).prepareStatement(mSql);

            mPreparedStatement.setInt(1, mUser.getId());

            vResponse = mPreparedStatement.executeUpdate(); //1 se foi com sucesso

        } catch (Exception e) {
            Log.e(TAG, e.getMessage());

        }

        return vResponse;
    }

    public static int DeleteAllUser(Context mContext) {
        int vResponse = 0;

        String mSql;
        try {
            mSql = "DELETE FROM usuario";
            PreparedStatement mPreparedStatement = MSSQLConnectionHelper.getConnection(mContext).prepareStatement(mSql);

            vResponse = mPreparedStatement.executeUpdate(); //1 se foi com sucesso

        } catch (Exception e) {
            Log.e(TAG, e.getMessage());

        }

        return vResponse;
    }

    public static List<User> listAllUsers(Context mContext) {
        List<User> mUserList = null;
        String mSql;

        try {
            mSql = "SELECT ID, NOME, DATANASC, GENERO, TELEFONE, NIVELACESSO, STATUSUSUARIO, RESETSENHA, SENHA, EMAIL, CPF FROM USUARIO ORDER BY NOME ASC";
            PreparedStatement mPreparedStatement = MSSQLConnectionHelper.getConnection(mContext).prepareStatement(mSql);
            ResultSet mResultSet = mPreparedStatement.executeQuery();
            mUserList = new ArrayList<User>();
        while(mResultSet.next()){
            mUserList.add(new User(
                    mResultSet.getInt(1),
                    mResultSet.getString(2),
                    mResultSet.getString(3),
                    mResultSet.getString(4),
                    mResultSet.getString(5),
                    mResultSet.getString(6),
                    mResultSet.getString(7),
                    mResultSet.getString(8),
                    mResultSet.getString(9),
                    mResultSet.getString(10)



            ));
        }

        } catch (Exception e) {
            Log.e(TAG, e.getMessage());


        }
        return mUserList;

}
    public static List<User> listAllUsersByStatus(int vStatus,Context mContext) {
        List<User> mUserList = null;
        String mSql;

        try {
            mSql = "SELECT ID, NOME, DATANASC, GENERO, TELEFONE, NIVELACESSO, STATUSUSUARIO, RESETSENHA, SENHA, EMAIL, CPF FROM USUARIO WHERE STATUS="+ vStatus +" ORDER BY NOME ASC";
            PreparedStatement mPreparedStatement = MSSQLConnectionHelper.getConnection(mContext).prepareStatement(mSql);
            ResultSet mResultSet = mPreparedStatement.executeQuery();
            mUserList = new ArrayList<User>();
        while(mResultSet.next()){
            mUserList.add(new User(
                    mResultSet.getInt(1),
                    mResultSet.getString(2),
                    mResultSet.getString(3),
                    mResultSet.getString(4),
                    mResultSet.getString(5),
                    mResultSet.getString(6),
                    mResultSet.getString(7),
                    mResultSet.getString(8),
                    mResultSet.getString(9),
                    mResultSet.getString(10)



            ));
        }

        } catch (Exception e) {
            Log.e(TAG, e.getMessage());


        }
        return mUserList;

}
    public static List<User> listAllUsersById(int vId,Context mContext) {
        List<User> mUserList = null;
        String mSql;

        try {
            mSql = "SELECT ID, NOME, DATANASC, GENERO, TELEFONE, NIVELACESSO, STATUSUSUARIO, RESETSENHA, SENHA, EMAIL, CPF FROM USUARIO WHERE ID="+ vId +" ORDER BY NOME ASC";
            PreparedStatement mPreparedStatement = MSSQLConnectionHelper.getConnection(mContext).prepareStatement(mSql);
            ResultSet mResultSet = mPreparedStatement.executeQuery();
            mUserList = new ArrayList<User>();
        while(mResultSet.next()){
            mUserList.add(new User(
                    mResultSet.getInt(1),
                    mResultSet.getString(2),
                    mResultSet.getString(3),
                    mResultSet.getString(4),
                    mResultSet.getString(5),
                    mResultSet.getString(6),
                    mResultSet.getString(7),
                    mResultSet.getString(8),
                    mResultSet.getString(9),
                    mResultSet.getString(10)



            ));
        }

        } catch (Exception e) {
            Log.e(TAG, e.getMessage());


        }
        return mUserList;

}
    public static List<User> SearchUsersByName(String mName,Context mContext) {
        List<User> mUserList = null;
        String mSql;

        try {
            mSql = "SELECT ID, NOME, DATANASC, GENERO, TELEFONE, NIVELACESSO, STATUSUSUARIO, RESETSENHA, SENHA, CPF FROM USUARIO WHERE NOME LIKE'%="+ mName +"%' ORDER BY NOME ASC";
            PreparedStatement mPreparedStatement = MSSQLConnectionHelper.getConnection(mContext).prepareStatement(mSql);
            ResultSet mResultSet = mPreparedStatement.executeQuery();
            mUserList = new ArrayList<User>();
        while(mResultSet.next()){
            mUserList.add(new User(
                    mResultSet.getInt(1),
                    mResultSet.getString(2),
                    mResultSet.getString(3),
                    mResultSet.getString(4),
                    mResultSet.getString(5),
                    mResultSet.getString(6),
                    mResultSet.getString(7),
                    mResultSet.getString(8),
                    mResultSet.getString(9),
                    mResultSet.getString(10)



            ));
        }

        } catch (Exception e) {
            Log.e(TAG, e.getMessage());


        }
        return mUserList;

}

    public static String authenticateUser(User mUser, Context mContext) {
        String mResponse = "";
        String mSql = "SELECT id,nome,email,senha FROM usuario WHERE senha = ? AND email = ?";
        String userId = ""; // Variável para armazenar o ID do usuário

        try {
            String codedPassword = Base64.getEncoder().encodeToString(mUser.getPassword().getBytes("utf-8"));
            PreparedStatement mPreparedStatement = MSSQLConnectionHelper.getConnection(mContext).prepareStatement(mSql);
            mPreparedStatement.setString(1, codedPassword);
            mPreparedStatement.setString(2, mUser.getmEmail());
            ResultSet mResultSet = mPreparedStatement.executeQuery();
            while (mResultSet.next()) {
                mResponse = mResultSet.getString(2);
                userId = mResultSet.getString(1); // ID do usuário
            }
        } catch (Exception e) {
            mResponse = "Exception";
            Log.e(TAG, e.getMessage());
            e.printStackTrace();
        }

        // Agora, você pode retornar o ID do usuário junto com a resposta
        return userId + "," + mResponse;
    }

    public static User getUserById(int userId, Context mContext) {
        User user = null;
        String mSql = "SELECT nome, email, cpf, telefone, genero FROM Usuario WHERE id = ?";

        try {
            PreparedStatement mPreparedStatement = MSSQLConnectionHelper.getConnection(mContext).prepareStatement(mSql);
            mPreparedStatement.setInt(1, userId);

            ResultSet mResultSet = mPreparedStatement.executeQuery();

            if (mResultSet.next()) {
                // Preencha o objeto User com os dados do usuário
                user = new User(
                        mResultSet.getString("nome"),
                        mResultSet.getString("email"),
                        mResultSet.getString("cpf"),
                        mResultSet.getString("telefone"),
                        mResultSet.getString("genero")
                );
            }
        } catch (Exception e) {
            Log.e(TAG, e.getMessage());
        }

        return user;
    }
}
