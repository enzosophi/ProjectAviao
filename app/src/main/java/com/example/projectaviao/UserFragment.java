package com.example.projectaviao;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.fragment.app.Fragment;


import androidx.fragment.app.Fragment;

public class UserFragment extends Fragment {

    private TextView textViewUserId;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.user_fragment, container, false);

        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("MyAppName", Context.MODE_PRIVATE);


        String userEmail = sharedPreferences.getString("Email", ""); // Substitua pelo email do usuário logado
        UserDao userDao = new UserDao();
        User user = userDao.getUserByEmail(userEmail, getContext());

        if (user != null) {
            // Agora você tem os dados do usuário, exiba-os no frontend
            String nome = user.getNome();
            String email = user.getEmail();
            String cpf = user.getCpf();
            String dataNasc = user.getDataNasc();
            String telefone = user.getTelefone();
            String genero = user.getGenero();

            TextView mTextViewNome = view.findViewById(R.id.username); // Certifique-se de que o ID está correto
            TextView mTextViewEmail = view.findViewById(R.id.email);
            TextView mTextViewCpf = view.findViewById(R.id.cpf);
            TextView mTextViewTelefone = view.findViewById(R.id.telefone);
            TextView mTextViewGenero = view.findViewById(R.id.genero);
            TextView mTextViewDataNasc = view.findViewById(R.id.data);


            // Atualize os TextViews ou elementos do frontend com os dados obtidos
            mTextViewNome.setText(nome);
            mTextViewEmail.setText(email);
            mTextViewCpf.setText(cpf);
            mTextViewTelefone.setText(telefone);
            mTextViewGenero.setText(genero);
            mTextViewDataNasc.setText(dataNasc);

        }

        return view;
    }

}




