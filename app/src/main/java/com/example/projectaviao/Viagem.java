package com.example.projectaviao;

public class Viagem {

    public static final String TAG="Viagem Table";

    public Viagem(int anInt, String string, String string1, String string2, String string3, String string4, Long anlong) {
    }

    @Override
    public String toString() {
        return "Viagem{" +
                "mId=" + mId +
                ", mChegada='" + mChegada + '\'' +
                ", mSaida='" + mSaida + '\'' +
                ", mPassageiroName='" + mPassageiroName + '\'' +
                ", mPassageiroCpf='" + mPassageiroCpf + '\'' +
                ", mData='" + mData + '\'' +
                '}';
    }

    public Viagem(int Id, String Chegada, String Saida, String PassageiroName, String PassageiroCpf, Long Data) {
        this.mId = Id;
        this.mChegada = Chegada;
        this.mSaida = Saida;
        this.mPassageiroName = PassageiroName;
        this.mPassageiroCpf = PassageiroCpf;
        this.mData= Data;
    }

    public Viagem(String Chegada, String Saida, String PassageiroName, String PassageiroCpf, Long Data) {
        this.mChegada = Chegada;
        this.mSaida = Saida;
        this.mPassageiroName = PassageiroName;
        this.mPassageiroCpf = PassageiroCpf;
        this.mData= Data;
    }

    public int getId() {
        return mId;
    }

    public void setId(int mId) {
        this.mId = mId;
    }

    public String getChegada() {
        return mChegada;
    }

    public void setChegada(String mChegada) {
        this.mChegada = mChegada;
    }

    public String getSaida() {
        return mSaida;
    }

    public void setSaida(String mSaida) {
        this.mSaida = mSaida;
    }

    public String getPassageiroName() {
        return mPassageiroName;
    }

    public void setPassageiroName(String mPassageiroName) {
        this.mPassageiroName = mPassageiroName;
    }

    public String getPassageiroCpf() {
        return mPassageiroCpf;
    }

    public void setPassageiroCpf(String mPassageiroCpf) {
        this.mPassageiroCpf = mPassageiroCpf;
    }

    public Long getData() {
        return mData;
    }

    public void setData(Long mData) {
        this.mData = mData;
    }

    private int mId;
    private String mChegada;
    private String mSaida;
    private String mPassageiroName;
    private String mPassageiroCpf;
    private Long mData;


}
