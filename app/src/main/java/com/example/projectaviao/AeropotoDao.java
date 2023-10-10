package com.example.projectaviao;

import android.content.Context;
import android.util.Log;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class AeropotoDao {
    public static final String  TAG="Aeroporto Dao";

    public static int insertAviao(Aeroporto mAeroporto, Context mContext) {
        int vResponse = 0;

        String mSql;
        try {
            mSql = "INSERT  INTO product(Iata, Uf, Icao, NomeAeroporto,  VALUES (?, ?, ?,? )";
            PreparedStatement mPreparedStatement = MSSQLConnectionHelper.getConnection(mContext).prepareStatement(mSql);

            mPreparedStatement.setString(1, mAeroporto.getCodeIata());
            mPreparedStatement.setString(2, mAeroporto.getUf());
            mPreparedStatement.setString(4, mAeroporto.getCodeIcao());
            mPreparedStatement.setString(5, mAeroporto.getNomeAeroporto());


            vResponse = mPreparedStatement.executeUpdate(); //1 se foi com sucesso

        } catch (Exception e) {
            Log.e(TAG, e.getMessage());

        }

        return vResponse;
    }

    public static int updateAviao(Aeroporto mAeroporto, Context mContext) {
        int vResponse = 0;

        String mSql;
        try {
            mSql = "UPDATE Viagem SET name=?, KILOMETER=?, SITS=?, WHERE id=?";
            PreparedStatement mPreparedStatement = MSSQLConnectionHelper.getConnection(mContext).prepareStatement(mSql);
            mPreparedStatement.setInt(1, mAeroporto.getId());
            mPreparedStatement.setString(2, mAeroporto.getCodeIata());
            mPreparedStatement.setString(3, mAeroporto.getUf());
            mPreparedStatement.setString(4, mAeroporto.getCodeIcao());
            mPreparedStatement.setString(5, mAeroporto.getNomeAeroporto());


            vResponse = mPreparedStatement.executeUpdate(); //1 se foi com sucesso

        } catch (Exception e) {
            Log.e(TAG, e.getMessage());

        }

        return vResponse;
    }

    public static int DeleteAeroporto(Aeroporto mAeroporto, Context mContext) {
        int vResponse = 0;

        String mSql;
        try {
            mSql = "DELETE FROM AEROPORTO WHERE id=?";
            PreparedStatement mPreparedStatement = MSSQLConnectionHelper.getConnection(mContext).prepareStatement(mSql);

            mPreparedStatement.setInt(1, mAeroporto.getId());

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
            mSql = "DELETE FROM AEROPORTO";
            PreparedStatement mPreparedStatement = MSSQLConnectionHelper.getConnection(mContext).prepareStatement(mSql);

            vResponse = mPreparedStatement.executeUpdate(); //1 se foi com sucesso

        } catch (Exception e) {
            Log.e(TAG, e.getMessage());

        }

        return vResponse;
    }

    public static List<Aeroporto> listAllAeroporto(Context mContext) {
        List<Aeroporto> mAeroportoList = null;
        String mSql;

        try {
            mSql = "SELECT ID, NAME, KILOMETER, SITS, FROM AVIAO ORDER BY CHEGADA ASC";
            PreparedStatement mPreparedStatement = MSSQLConnectionHelper.getConnection(mContext).prepareStatement(mSql);
            ResultSet mResultSet = mPreparedStatement.executeQuery();
            mAeroportoList = new ArrayList<Aeroporto>();
            while(mResultSet.next()){
                mAeroportoList.add(new Aeroporto(
                        mResultSet.getInt(1),
                        mResultSet.getString(2),
                        mResultSet.getString(3),
                        mResultSet.getString(4),
                        mResultSet.getString(5)

                ));
            }

        } catch (Exception e) {
            Log.e(TAG, e.getMessage());


        }
        return mAeroportoList;

    }
    public static List<Aeroporto> listAllAeroportoByName(int vName,Context mContext) {
        List<Aeroporto> mAeroportoList = null;
        String mSql;

        try {
            mSql = "SELECT ID, NAME, KILOMETER, SITS, FROM AVIAO WHERE STATUS="+ vName +" ORDER BY CHEGADA ASC";
            PreparedStatement mPreparedStatement = MSSQLConnectionHelper.getConnection(mContext).prepareStatement(mSql);
            ResultSet mResultSet = mPreparedStatement.executeQuery();
            mAeroportoList = new ArrayList<Aeroporto>();
            while(mResultSet.next()){
                mAeroportoList.add(new Aeroporto(
                        mResultSet.getInt(1),
                        mResultSet.getString(2),
                        mResultSet.getString(3),
                        mResultSet.getString(4),
                        mResultSet.getString(5)


                ));
            }

        } catch (Exception e) {
            Log.e(TAG, e.getMessage());


        }
        return mAeroportoList;

    }
    public static List<Aeroporto> listAllAeroportoById(int vId,Context mContext) {
        List<Aeroporto> mAeroportoList = null;
        String mSql;

        try {
            mSql = "SELECT ID, NAME, KILOMETER, SITS WHERE ID="+ vId +" ORDER BY NAME ASC";
            PreparedStatement mPreparedStatement = MSSQLConnectionHelper.getConnection(mContext).prepareStatement(mSql);
            ResultSet mResultSet = mPreparedStatement.executeQuery();
            mAeroportoList = new ArrayList<Aeroporto>();
            while(mResultSet.next()){
                mAeroportoList.add(new Aeroporto(
                        mResultSet.getInt(1),
                        mResultSet.getString(2),
                        mResultSet.getString(3),
                        mResultSet.getString(4),
                        mResultSet.getString(5)




                ));
            }

        } catch (Exception e) {
            Log.e(TAG, e.getMessage());


        }
        return mAeroportoList;

    }
    public static List<Aeroporto> SearchAviaoByNomeAeroporto(String vNomeAeroporto,Context mContext) {
        List<Aeroporto> mAeroportoList = null;
        String mSql;

        try {
            mSql = "SELECT ID, NAME, KILOMETER, SITS, FROM AVIAO WHERE NAME LIKE'%="+ vNomeAeroporto +"%' ORDER BY NAME ASC";
            PreparedStatement mPreparedStatement = MSSQLConnectionHelper.getConnection(mContext).prepareStatement(mSql);
            ResultSet mResultSet = mPreparedStatement.executeQuery();
            mAeroportoList = new ArrayList<Aeroporto>();
            while(mResultSet.next()){
                mAeroportoList.add(new Aeroporto(
                        mResultSet.getInt(1),
                        mResultSet.getString(2),
                        mResultSet.getString(3),
                        mResultSet.getString(4),
                        mResultSet.getString(5)

                ));
            }

        } catch (Exception e) {
            Log.e(TAG, e.getMessage());


        }
        return mAeroportoList;

    }
    public static  String authenticateAviao(Aviao mAviao, Context mContext){
        String mResponse="";
        String mSql="SELECT id,name, kilometer, sits FROM aviao WHERE name LIKE? AND kilometer LIKE?";
        try{
            PreparedStatement mPreparedStatement =MSSQLConnectionHelper.getConnection(mContext).prepareStatement(mSql);
            mPreparedStatement.setString(1, mAviao.getName());
            mPreparedStatement.setString(2, mAviao.getKilometer());
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
 