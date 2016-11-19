package br.com.bom.sangue.sangue_bom_android.Entities;

import br.com.bom.sangue.sangue_bom_android.Entities.User;

public class Administrator extends User {
    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
