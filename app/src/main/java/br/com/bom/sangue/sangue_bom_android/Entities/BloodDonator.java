package br.com.bom.sangue.sangue_bom_android.Entities;

/**
 * Created by Raphael on 13/11/2016.
 */
public class BloodDonator extends User {

    private String bloodType;
    private String bloodFactor;
    private String CPF;
    private String nickname;

    public String getBloodType() {
        return bloodType;
    }
    public void setBloodType(String bloodType) {
        this.bloodType = bloodType;
    }

    public String getBloodFactor() {
        return bloodFactor;
    }
    public void setBloodFactor(String bloodFactor) {
        this.bloodFactor = bloodFactor;
    }

    public String getCPF() {
        return CPF;
    }
    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String getNickname() {
        return nickname;
    }
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
}
