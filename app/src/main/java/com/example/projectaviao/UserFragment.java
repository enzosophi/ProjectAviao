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

        // Obtenha as referências dos TextViews no layout XML
        TextView textViewNome = view.findViewById(R.id.username);
        TextView textViewEmail = view.findViewById(R.id.email);
        TextView textViewCpf = view.findViewById(R.id.cpf);
        TextView textViewTelefone = view.findViewById(R.id.telefone);
        TextView textViewGenero = view.findViewById(R.id.genero);

        // Obtenha os dados do usuário das SharedPreferences
        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("MyAppName", Context.MODE_PRIVATE);
        String nome = sharedPreferences.getString("Nome", "Nome Padrão");
        String email = sharedPreferences.getString("Email", "Email Padrão");
        String cpf = sharedPreferences.getString("CPF", "CPF Padrão");
        String telefone = sharedPreferences.getString("Telefone", "Telefone Padrão");
        String genero = sharedPreferences.getString("Gênero", "Gênero Padrão");

        // Defina os textos dos TextViews com os dados do usuário
        textViewNome.setText(nome);
        textViewEmail.setText(email);
        textViewCpf.setText(cpf);
        textViewTelefone.setText(telefone);
        textViewGenero.setText(genero);

        return view;
    }

}




