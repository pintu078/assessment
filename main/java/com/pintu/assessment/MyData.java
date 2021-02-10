package com.pintu.assessment;


import java.io.Serializable;

public class MyData  {

    String fNameC, lNameC, mobileC , emailC,genderC, statusC, qualifC;

    public MyData(String fNameC, String lNameC, String genderC,String statusC,String qualifC, String mobileC, String emailC ){
        this.fNameC = fNameC;
        this.lNameC = lNameC;
        this.genderC = genderC;
        this.statusC = statusC;
        this.qualifC = qualifC;
        this.mobileC = mobileC;
        this.emailC = emailC;
    }

    public String getfNameC() {
        return fNameC;
    }

    public void setfNameC(String fNameC) {
        this.fNameC = fNameC;
    }

    public String getlNameC() {
        return lNameC;
    }

    public void setlNameC(String lNameC) {
        this.lNameC = lNameC;
    }

    public String getGenderC() {
        return genderC;
    }

    public void setGenderC(String genderC) {
        this.genderC = genderC;
    }

    public String getStatusC() {
        return statusC;
    }

    public void setStatusC(String statusC) {
        this.statusC = statusC;
    }

    public String getQualifC() {
        return qualifC;
    }

    public void setQualifC(String qualifC) {
        this.qualifC = qualifC;
    }

    public String getMobileC() {
        return mobileC;
    }

    public void setMobileC(String mobileC) {
        this.mobileC = mobileC;
    }

    public String getEmailC() {
        return emailC;
    }

    public void setEmailC(String emailC) {
        this.emailC = emailC;
    }
}
