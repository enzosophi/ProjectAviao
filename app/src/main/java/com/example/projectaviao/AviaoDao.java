package com.example.projectaviao;

import android.content.Context;
import android.util.Log;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class AviaoDao {
    public static final String  TAG="Aviao CRUD";

    public static int insertAviao(Aviao mAviao, Context mContext) {
        int vResponse = 0;

        String mSql;
        try {
            mSql = "INSERT  INTO product(name, kilometer, sits,  VALUES (?, ?, ? )";
            PreparedStatement mPreparedStatement = MSSQLConnectionHelper.getConnection(mContext).prepareStatement(mSql);

            mPreparedStatement.setString(1, mAviao.getName());
            mPreparedStatement.setString(2, mAviao.getKilometer());
            mPreparedStatement.setString(4, mAviao.getSits());


            vResponse = mPreparedStatement.executeUpdate(); //1 se foi com sucesso

        } catch (Exception e) {
            Log.e(TAG, e.getMessage());

        }

        return vResponse;
    }

    public static int updateAviao(Aviao mAviao, Context mContext) {
        int vResponse = 0;

        String mSql;
        try {
            mSql = "UPDATE Viagem SET name=?, KILOMETER=?, SITS=?, WHERE id=?";
            PreparedStatement mPreparedStatement = MSSQLConnectionHelper.getConnection(mContext).prepareStatement(mSql);

            mPreparedStatement.setString(1, mAviao.getName());
            mPreparedStatement.setString(2, mAviao.getKilometer());
            mPreparedStatement.setString(4, mAviao.getSits());


            vResponse = mPreparedStatement.executeUpdate(); //1 se foi com sucesso

        } catch (Exception e) {
            Log.e(TAG, e.getMessage());

        }

        return vResponse;
    }

    public static int DeleteAviao(Aviao mAviao, Context mContext) {
        int vResponse = 0;

        String mSql;
        try {
            mSql = "DELETE FROM AVIAO WHERE id=?";
            PreparedStatement mPreparedStatement = MSSQLConnectionHelper.getConnection(mContext).prepareStatement(mSql);

            mPreparedStatement.setInt(1, mAviao.getId());

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
            mSql = "DELETE FROM AVIAO";
            PreparedStatement mPreparedStatement = MSSQLConnectionHelper.getConnection(mContext).prepareStatement(mSql);

            vResponse = mPreparedStatement.executeUpdate(); //1 se foi com sucesso

        } catch (Exception e) {
            Log.e(TAG, e.getMessage());

        }

        return vResponse;
    }

    public static List<Aviao> listAllAviao(Context mContext) {
        List<Aviao> mAviaoList = null;
        String mSql;

        try {
            mSql = "SELECT ID, NAME, KILOMETER, SITS, FROM AVIAO ORDER BY CHEGADA ASC";
            PreparedStatement mPreparedStatement = MSSQLConnectionHelper.getConnection(mContext).prepareStatement(mSql);
            ResultSet mResultSet = mPreparedStatement.executeQuery();
            mAviaoList = new ArrayList<Aviao>();
            while(mResultSet.next()){
                mAviaoList.add(new Aviao(
                        mResultSet.getInt(1),
                        mResultSet.getString(2),
                        mResultSet.getString(3),
                        mResultSet.getString(4)

                ));
            }

        } catch (Exception e) {
            Log.e(TAG, e.getMessage());


        }
        return mAviaoList;

    }
    public static List<Aviao> listAllAviaoByName(int vName,Context mContext) {
        List<Aviao> mAviaoList = null;
        String mSql;

        try {
            mSql = "SELECT ID, NAME, KILOMETER, SITS, FROM AVIAO WHERE STATUS="+ vName +" ORDER BY CHEGADA ASC";
            PreparedStatement mPreparedStatement = MSSQLConnectionHelper.getConnection(mContext).prepareStatement(mSql);
            ResultSet mResultSet = mPreparedStatement.executeQuery();
            mAviaoList = new ArrayList<Aviao>();
            while(mResultSet.next()){
                mAviaoList.add(new Aviao(
                        mResultSet.getInt(1),
                        mResultSet.getString(2),
                        mResultSet.getString(3),
                        mResultSet.getString(4)


                ));
            }

        } catch (Exception e) {
            Log.e(TAG, e.getMessage());


        }
        return mAviaoList;

    }
    public static List<Aviao> listAllAviaoById(int vId,Context mContext) {
        List<Aviao> mAviaoList = null;
        String mSql;

        try {
            mSql = "SELECT ID, NAME, KILOMETER, SITS WHERE ID="+ vId +" ORDER BY NAME ASC";
            PreparedStatement mPreparedStatement = MSSQLConnectionHelper.getConnection(mContext).prepareStatement(mSql);
            ResultSet mResultSet = mPreparedStatement.executeQuery();
            mAviaoList = new ArrayList<Aviao>();
            while(mResultSet.next()){
                mAviaoList.add(new Aviao(
                        mResultSet.getInt(1),
                        mResultSet.getString(2),
                        mResultSet.getString(3),
                        mResultSet.getString(4)




                ));
            }

        } catch (Exception e) {
            Log.e(TAG, e.getMessage());


        }
        return mAviaoList;

    }
    public static List<Aviao> SearchAviaoByKilometer(String vKilometer,Context mContext) {
        List<Aviao> mAviaoList = null;
        String mSql;

        try {
            mSql = "SELECT ID, NAME, KILOMETER, SITS, FROM AVIAO WHERE NAME LIKE'%="+ vKilometer +"%' ORDER BY NAME ASC";
            PreparedStatement mPreparedStatement = MSSQLConnectionHelper.getConnection(mContext).prepareStatement(mSql);
            ResultSet mResultSet = mPreparedStatement.executeQuery();
            mAviaoList = new ArrayList<Aviao>();
            while(mResultSet.next()){
                mAviaoList.add(new Aviao(
                        mResultSet.getInt(1),
                        mResultSet.getString(2),
                        mResultSet.getString(3),
                        mResultSet.getString(4)

                ));
            }

        } catch (Exception e) {
            Log.e(TAG, e.getMessage());


        }
        return mAviaoList;

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
