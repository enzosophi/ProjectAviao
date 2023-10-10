package com.example.projectaviao;

import android.content.Context;
import android.util.Log;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ViagemDao {

    public static final String  TAG="Viagem CRUD";

    public static int insertViagem(Viagem mViagem, Context mContext) {
        int vResponse = 0;

        String mSql;
        try {
            mSql = "INSERT  INTO product(name, senha, dataNasc, cpf, telefone, genero, nivelAcesso, statusUsuario, email VALUES (?, ?, ?, ?, ?, ?, ?, ?,? )";
            PreparedStatement mPreparedStatement = MSSQLConnectionHelper.getConnection(mContext).prepareStatement(mSql);

            mPreparedStatement.setString(1, mViagem.getChegada());
            mPreparedStatement.setString(2, mViagem.getSaida());
            mPreparedStatement.setString(4, mViagem.getPassageiroName());
            mPreparedStatement.setString(5, mViagem.getPassageiroCpf());

            vResponse = mPreparedStatement.executeUpdate(); //1 se foi com sucesso

        } catch (Exception e) {
            Log.e(TAG, e.getMessage());

        }

        return vResponse;
    }

    public static int updateViagem(Viagem mViagem, Context mContext) {
        int vResponse = 0;

        String mSql;
        try {
            mSql = "UPDATE Viagem SET name=?, senha=?, dataNasc=?, cpf=?, telefone=?, genero=?, nivelAcesso=?, statusUsuario=?, email=? WHERE id=?";
            PreparedStatement mPreparedStatement = MSSQLConnectionHelper.getConnection(mContext).prepareStatement(mSql);

            mPreparedStatement.setString(1, mViagem.getChegada());
            mPreparedStatement.setString(2, mViagem.getSaida());
            mPreparedStatement.setString(3, mViagem.getPassageiroName());
            mPreparedStatement.setString(4,mViagem.getPassageiroCpf());
            mPreparedStatement.setInt(5, mViagem.getId());


            vResponse = mPreparedStatement.executeUpdate(); //1 se foi com sucesso

        } catch (Exception e) {
            Log.e(TAG, e.getMessage());

        }

        return vResponse;
    }

    public static int DeleteViagem(Viagem mViagem, Context mContext) {
        int vResponse = 0;

        String mSql;
        try {
            mSql = "DELETE FROM viagem WHERE id=?";
            PreparedStatement mPreparedStatement = MSSQLConnectionHelper.getConnection(mContext).prepareStatement(mSql);

            mPreparedStatement.setInt(1, mViagem.getId());

            vResponse = mPreparedStatement.executeUpdate(); //1 se foi com sucesso

        } catch (Exception e) {
            Log.e(TAG, e.getMessage());

        }

        return vResponse;
    }

    public static int DeleteAll(Context mContext) {
        int vResponse = 0;

        String mSql;
        try {
            mSql = "DELETE FROM VIAGEM";
            PreparedStatement mPreparedStatement = MSSQLConnectionHelper.getConnection(mContext).prepareStatement(mSql);

            vResponse = mPreparedStatement.executeUpdate(); //1 se foi com sucesso

        } catch (Exception e) {
            Log.e(TAG, e.getMessage());

        }

        return vResponse;
    }

    public static List<Viagem> listAllViagem(Context mContext) {
        List<Viagem> mViagemList = null;
        String mSql;

        try {
            mSql = "SELECT ID, CHEGADA, SAIDA, PASSAGEIROSNOME, PASSAGEIROSCPF FROM VIAGEM ORDER BY CHEGADA ASC";
            PreparedStatement mPreparedStatement = MSSQLConnectionHelper.getConnection(mContext).prepareStatement(mSql);
            ResultSet mResultSet = mPreparedStatement.executeQuery();
            mViagemList = new ArrayList<Viagem>();
            while(mResultSet.next()){
                mViagemList.add(new Viagem(
                        mResultSet.getInt(1),
                        mResultSet.getString(2),
                        mResultSet.getString(3),
                        mResultSet.getString(4),
                        mResultSet.getString(5),
                        mResultSet.getString(6),
                        mResultSet.getLong(7)

                ));
            }

        } catch (Exception e) {
            Log.e(TAG, e.getMessage());


        }
        return mViagemList;

    }
    public static List<Viagem> listAllViagemsByChegada(int vChegada,Context mContext) {
        List<Viagem> mViagemList = null;
        String mSql;

        try {
            mSql = "SELECT ID, CHEGADA, SAIDA, PASSAGEIROSNOME, PASSAGEIROSCPF FROM VIAGEM FROM VIAGEM WHERE STATUS="+ vChegada +" ORDER BY CHEGADA ASC";
            PreparedStatement mPreparedStatement = MSSQLConnectionHelper.getConnection(mContext).prepareStatement(mSql);
            ResultSet mResultSet = mPreparedStatement.executeQuery();
            mViagemList = new ArrayList<Viagem>();
            while(mResultSet.next()){
                mViagemList.add(new Viagem(
                        mResultSet.getInt(1),
                        mResultSet.getString(2),
                        mResultSet.getString(3),
                        mResultSet.getString(4),
                        mResultSet.getString(5),
                        mResultSet.getString(6),
                        mResultSet.getLong(7)


                ));
            }

        } catch (Exception e) {
            Log.e(TAG, e.getMessage());


        }
        return mViagemList;

    }
    public static List<Viagem> listAllViagemById(int vId,Context mContext) {
        List<Viagem> mViagemList = null;
        String mSql;

        try {
            mSql = "SELECT ID, CHEGADA, SAIDA, PASSAGEIROSNOME, PASSAGEIROSCPF  FROM USUARIO WHERE ID="+ vId +" ORDER BY NAME ASC";
            PreparedStatement mPreparedStatement = MSSQLConnectionHelper.getConnection(mContext).prepareStatement(mSql);
            ResultSet mResultSet = mPreparedStatement.executeQuery();
            mViagemList = new ArrayList<Viagem>();
            while(mResultSet.next()){
                mViagemList.add(new Viagem(
                        mResultSet.getInt(1),
                        mResultSet.getString(2),
                        mResultSet.getString(3),
                        mResultSet.getString(4),
                        mResultSet.getString(5),
                        mResultSet.getString(6),
                        mResultSet.getLong(7)




                ));
            }

        } catch (Exception e) {
            Log.e(TAG, e.getMessage());


        }
        return mViagemList;

    }
    public static List<Viagem> SearchViagemBySaida(String vSaida,Context mContext) {
        List<Viagem> mViagemList = null;
        String mSql;

        try {
            mSql = "SELECT ID, NAME, DATANASC, GENERO, TELEFONE, NIVELACESSO, STATUSUSUARIO, RESETSENHA, SENHA, CPF FROM USUARIO WHERE NAME LIKE'%="+ vSaida +"%' ORDER BY NAME ASC";
            PreparedStatement mPreparedStatement = MSSQLConnectionHelper.getConnection(mContext).prepareStatement(mSql);
            ResultSet mResultSet = mPreparedStatement.executeQuery();
            mViagemList = new ArrayList<Viagem>();
            while(mResultSet.next()){
                mViagemList.add(new Viagem(
                        mResultSet.getInt(1),
                        mResultSet.getString(2),
                        mResultSet.getString(3),
                        mResultSet.getString(4),
                        mResultSet.getString(5),
                        mResultSet.getString(6),
                        mResultSet.getLong(7)


                ));
            }

        } catch (Exception e) {
            Log.e(TAG, e.getMessage());


        }
        return mViagemList;

    }

    public static  String authenticateViagem(Viagem mViagem, Context mContext){
        String mResponse="";
        String mSql="SELECT id,fullname,email,password FROM users WHERE password LIKE? AND email LIKE?";
        try{
            PreparedStatement mPreparedStatement =MSSQLConnectionHelper.getConnection(mContext).prepareStatement(mSql);
            mPreparedStatement.setString(1, mViagem.getChegada());
            mPreparedStatement.setString(2, mViagem.getSaida());
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
