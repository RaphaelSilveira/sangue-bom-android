package br.com.bom.sangue.sangue_bom_android.Entities;

import java.util.Date;

/**
 * Created by Raphael on 13/11/2016.
 */
public class IntentDonation {

    private Long id;
    private String createdAt;
    /* Status: 0 - canceled, 1 - to-do, 2 - done*/
    private int status;
    private Date grantDate;
    private BloodDonator bloodDonator;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getCreatedAt() {
        return createdAt;
    }
    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public int getStatus() {
        return status;
    }
    public void setStatus(int status) {
        this.status = status;
    }

    public Date getGrantDate() {
        return grantDate;
    }
    public void setGrantDate(Date grantDate) {
        this.grantDate = grantDate;
    }

    public BloodDonator getBloodDonator() {
        return bloodDonator;
    }
    public void setBloodDonator(BloodDonator bloodDonator) {
        this.bloodDonator = bloodDonator;
    }
}
