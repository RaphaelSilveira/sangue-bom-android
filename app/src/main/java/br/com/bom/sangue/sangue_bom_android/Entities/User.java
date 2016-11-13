package br.com.bom.sangue.sangue_bom_android.Entities;

import java.util.Date;

/**
 * Created by Raphael on 13/11/2016.
 */
public class User {

    private Long id;
    private String name;
    private String email;
    private Date birthDate;
    private Address address;
    private Telephone telephone;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public Date getBirthDate() {
        return birthDate;
    }
    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Address getAddress() {
        return address;
    }
    public void setAddress(Address address) {
        this.address = address;
    }

    public Telephone getTelephone() {
        return telephone;
    }
    public void setTelephone(Telephone telephone) {
        this.telephone = telephone;
    }
}
