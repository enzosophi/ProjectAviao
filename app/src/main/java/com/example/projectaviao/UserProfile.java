package com.example.projectaviao;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class UserProfile extends AppCompatActivity {

    private TextView mTextViewNome;
    private TextView mTextViewEmail;
    private TextView mTextViewCpf;
    private TextView mTextViewTelefone;
    private TextView mTextViewGenero;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_fragment);

         mTextViewNome = (TextView) findViewById(R.id.username);
         mTextViewEmail = (TextView) findViewById(R.id.email);
         mTextViewCpf = (TextView) findViewById(R.id.cpf);
         mTextViewTelefone = (TextView) findViewById(R.id.telefone);
         mTextViewGenero = (TextView) findViewById(R.id.genero);

        mTextViewNome = findViewById(R.id.username);
        mTextViewEmail = findViewById(R.id.email);
        mTextViewCpf = findViewById(R.id.cpf);
        mTextViewTelefone = findViewById(R.id.telefone);
        mTextViewGenero = findViewById(R.id.genero);

        // Recupere o ID do usuário das preferências compartilhadas
        SharedPreferences mSharedPreferences = getSharedPreferences("MyAppName", MODE_PRIVATE);
        int userId = Integer.parseInt(mSharedPreferences.getString("UserID", "0"));

        // Chame o método para buscar os dados do usuário pelo ID
        if (userId != 0) {
            User user = UserDao.getUserById(userId, getApplicationContext());

            if (user != null) {
                // Preencha os TextViews com os dados do usuário
                mTextViewNome.setText(user.getUsername());
                mTextViewEmail.setText(user.getmEmail());
                mTextViewCpf.setText(user.getCpf());
                mTextViewTelefone.setText(user.getUsertel());
                mTextViewGenero.setText(user.getUsergender());
            }
        }

    }
}

