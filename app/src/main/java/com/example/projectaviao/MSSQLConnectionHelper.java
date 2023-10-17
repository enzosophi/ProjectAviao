package com.example.projectaviao;

//Classe 0

import android.content.Context;
import android.os.StrictMode;
import android.util.Log;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MSSQLConnectionHelper {

    public static final String TAG = "Connection Database";

    private static String mStringConnectionUrl;
    //nome de hospedagem do user
    private static  String mStiStringServerIpName ="VENSCO_EXECUTIVE.mssql.somee.com";
    //nome do usuario do somee
    private static String mStringUserName ="CaiozeraDaMassa_SQLLogin_1";
    //senha do usuario do somee
    private static String mStringPassword ="vensco_exec";
    // nome do banco de dados do sql
    private static String mStringDataBase="VENSCO_EXECUTIVE";

    public static Connection getConnection(Context mContext){

        Connection  mConnection= null;
        try {
            StrictMode.ThreadPolicy mPolicy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(mPolicy);


            Class.forName("net.sourceforge.jtds.jdbc.Driver");

            mStringConnectionUrl ="jdbc:jtds:sqlserver://" + mStiStringServerIpName +
                    ";databaseName=" + mStringDataBase + ";user=" + mStringUserName +
                    ";password=" + mStringPassword +";";
 

            mConnection = DriverManager.getConnection(mStringConnectionUrl);

            Log.i(TAG,"Conexão feita com sucesso");
        }  catch (ClassNotFoundException e){
            String mMessage = "Classe não encontrada" + e.getException();
            Log.e(TAG, mMessage);

        }catch (SQLException e){
            String mMessage = "Falha no Banco" + e.getMessage();
            Log.e(TAG, mMessage);

        }catch (Exception e){
            String mMessage = "Falha desconhecida" + e.getMessage();
            Log.e(TAG, mMessage);

        }
        return mConnection;
    }



}
