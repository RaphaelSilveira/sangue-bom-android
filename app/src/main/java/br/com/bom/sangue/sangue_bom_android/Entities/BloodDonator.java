package br.com.bom.sangue.sangue_bom_android.Entities;

/**
 * Created by Raphael on 13/11/2016.
 */
public class BloodDonator extends User {

    private String bloodType;
    private String bloodFactor;
    private String cpf;
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

    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNickname() {
        return nickname;
    }
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
}
