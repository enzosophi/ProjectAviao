package com.example.projectaviao;

public class Aeroporto {

public static final String TAG="Aeroporto Table";


    @Override
    public String toString() {
        return "Aeroporto{" +
                "mId=" + mId +
                ", mCodeIata='" + mCodeIata + '\'' +
                ", mCodeIcao='" + mCodeIcao + '\'' +
                ", mUf='" + mUf + '\'' +
                ", mNomeAeroporto='" + mNomeAeroporto + '\'' +
                '}';
    }

    public Aeroporto(int Id, String CodeIata, String CodeIcao, String Uf, String NomeAeroporto) {
        this.mId = Id;
        this.mCodeIata = CodeIata;
        this.mCodeIcao = CodeIcao;
        this.mUf = Uf;
        this.mNomeAeroporto =NomeAeroporto;
    }

    public Aeroporto(String CodeIata, String CodeIcao, String Uf, String NomeAeroporto) {
        this.mCodeIata = CodeIata;
        this.mCodeIcao = CodeIcao;
        this.mUf = Uf;
        this.mNomeAeroporto =NomeAeroporto;

    }

    public int getId() {
        return mId;
    }

    public void setId(int mId) {
        this.mId = mId;
    }

    public String getNomeAeroporto() {
        return mNomeAeroporto;
    }

    public void setNomeAeroporto(String mNomeAeroporto) {
        this.mNomeAeroporto = mNomeAeroporto;
    }

    public String getCodeIata() {
        return mCodeIata;
    }

    public void setCodeIata(String mCodeIata) {
        this.mCodeIata = mCodeIata;
    }

    public String getCodeIcao() {
        return mCodeIcao;
    }

    public void setCodeIcao(String mCodeIcao) {
        this.mCodeIcao = mCodeIcao;
    }

    public String getUf() {
        return mUf;
    }

    public void setUf(String mUf) {
        this.mUf = mUf;
    }

    private int mId;
    private String mNomeAeroporto;
    private String mCodeIata;
     private String mCodeIcao;
     private String mUf;


}
