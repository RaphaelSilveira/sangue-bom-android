package br.com.bom.sangue.sangue_bom_android.Entities;

/**
 * Created by Raphael on 19/11/2016.
 */
public class RankingDonations {

    private String bloodDonator;
    private int numberDonations;

    public int getNumberDonations() {
        return numberDonations;
    }
    public void setNumberDonations(int numberDonations) {
        this.numberDonations = numberDonations;
    }

    public String getBloodDonator() {
        return bloodDonator;
    }
    public void setBloodDonator(String bloodDonator) {
        this.bloodDonator = bloodDonator;
    }
}
