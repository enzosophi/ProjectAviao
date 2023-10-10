package com.example.projectaviao;

public class Aviao {

    public static final String TAG="Aviao table";



    @Override
    public String toString() {
        return "Aviao{" +
                "mId=" + mId +
                ", mName='" + mName + '\'' +
                ", mKilometer='" + mKilometer + '\'' +
                ", mSits='" + mSits + '\'' +
                '}';
    }
    public Aviao(int Id, String Name, String Kilometer, String Sits) {
        this.mId = Id;
        this.mName = Name;
        this.mKilometer = Kilometer;
        this.mSits = Sits;
    }

    public Aviao(String Name, String Kilometer, String Sits) {
        this.mName = Name;
        this.mKilometer = Kilometer;
        this.mSits = Sits;
    }

    public int getId() {
        return mId;
    }

    public void setId(int mId) {
        this.mId = mId;
    }

    public String getName() {
        return mName;
    }

    public void setName(String mName) {
        this.mName = mName;
    }

    public String getKilometer() {
        return mKilometer;
    }

    public void setKilometer(String mKilometer) {
        this.mKilometer = mKilometer;
    }

    public String getSits() {
        return mSits;
    }

    public void setSits(String mSits) {
        this.mSits = mSits;
    }



    private int mId;
    private String mName;
    private String mKilometer;
    private String mSits;
}
