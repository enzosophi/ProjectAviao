package com.example.projectaviao;

public class User {

    public static final String TAG="User Table";

    public User(int anInt, String string, String string1, String string2, String string3, String string4, String string5, String String6, String string7, String string8) {
    }

    public User(String mStringEmail, String mStringPassword) {
        mEmail=mStringEmail;
        mPassword=mStringPassword;

    }




//nome, email, senha, dataNasc, cpf, telefone,genero, nivelAcesso, statusUsuario

    @Override
    public String toString() {
        return "User{" +
                "mId=" + mId +
                ", mUsername='" + mUsername + '\'' +
                ", mDatenasc='" + mDatenasc + '\'' +
                ", mCpf='" + mCpf + '\'' +
                ", mUsertel='" + mUsertel + '\'' +
                ", mUsergender=" + mUsergender +
                ", mUserAccess='" + mUserAccess + '\'' +
                ", mUserStatus='" + mUserStatus + '\'' +
                ", mResetPassword=" + mResetPassword +
                ", mPassword" + mPassword + '\'' +
                ", mEmail='" + mEmail + '\'' +
                '}';
    }

    public User(String nome, String email, String cpf, String telefone, String genero) {
        this.mUsername = nome;
        this.mEmail = email;
        this.mCpf = cpf;
        this.mUsertel = telefone;
        this.mUsergender = genero;
    }

    public User(int id, String username, Long datenasc, String cpf, String usertel, String usergender, String userAccess, String userStatus, String resetPassword, String password, String email) {
        this.mId = id;
        this.mUsername = username;
        this.mDatenasc = datenasc;
        this.mCpf = cpf;
        this.mUsertel = usertel;
        this.mUsergender = usergender;
        this.mUserAccess = userAccess;
        this.mUserStatus = userStatus;
        this.mResetPassword = resetPassword;
        this.mPassword = password;
        this.mEmail = email;

    }

    //colunas
    private int mId;

    public int getId() {
        return mId;
    }

    public void setId(int id) {
        this.mId = id;
    }

    public String getUsername() {
        return mUsername;
    }

    public void setUsername(String mUsername) {
        this.mUsername = mUsername;
    }

    public Long getDatenasc() {
        return mDatenasc;
    }

    public void setDatenasc(Long mDatenasc) {
        this.mDatenasc = mDatenasc;
    }

    public String getmPassword() {
//        return Classe.transf(mPassword);

        return mPassword;
    }

    public void setmPassword(String mPassword) {
//        String senhaCrip = Classe.transf(mPassword);
//        this.mPassword = senhaCrip;

        this.mPassword = mPassword;
    }

    public String getCpf() {
        return mCpf;
    }

    public void setCpf(String mCpf) {
        this.mCpf = mCpf;
    }

    public String getUsertel() {
        return mUsertel;
    }

    public String getmEmail() {
        return mEmail;
    }

    public void setmEmail(String mEmail) {
        this.mEmail = mEmail;
    }

    public void setUsertel(String mUsertel) {
        this.mUsertel = mUsertel;
    }

    public String getUsergender() {
        return mUsergender;
    }

    public void setUsergender(String mUsergender) {
        this.mUsergender = mUsergender;
    }

    public String getUserAccess() {
        return mUserAccess;
    }

    public void setUserAccess(String mUserAccess) {
        this.mUserAccess = mUserAccess;
    }

    public String getUserStatus() {
        return mUserStatus;
    }

    public void setUserStatus(String mUserStatus) {
        this.mUserStatus = mUserStatus;
    }

    public String getmUsername() {
        return mUsername;
    }

    public void setmUsername(String mUsername) {
        this.mUsername = mUsername;
    }

    public String getResetPassword() {
        return mResetPassword;
    }

    public void setResetPassword(String mResetPassword) {this.mResetPassword = mResetPassword;}

    public String getPassword() {
        return mPassword;
    }

    public void setPassword( String mPassword) {
        this.mPassword = mPassword;
    }


    private Long mDatenasc;
    private String mCpf;
    private String mUsertel;
    private String mUsergender;
    private String mUserAccess;
    private String mUserStatus;
    private String mResetPassword;
    private String mUsername;
    private String mPassword;
    private String mEmail;



}
