package com.example.projectaviao;

public class User {
    private int id;
    private String nome;
    private String email;
    private String senha;
    private String dataNasc;
    private String cpf;
    private String telefone;
    private byte[] foto; // Para campos de tipo varbinary (neste caso, a foto)
    private String genero;

    public User(String mStringEmail, String mStringPassword) {
        this.email = mStringEmail;
        this.senha = mStringPassword;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(String dataNasc) {
        this.dataNasc = dataNasc;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public User(int id, String nome, String email, String senha, String dataNasc, String cpf, String telefone, byte[] foto, String genero) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.dataNasc = dataNasc;
        this.cpf = cpf;
        this.telefone = telefone;
        this.foto = foto;
        this.genero = genero;
    }

}
