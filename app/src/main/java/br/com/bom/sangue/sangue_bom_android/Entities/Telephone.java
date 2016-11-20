package br.com.bom.sangue.sangue_bom_android.Entities;

/**
 * Created by Raphael on 13/11/2016.
 */
public class Telephone {

    private Long id;
    private int ddi;
    private int ddd;
    private String number;
    private String type;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public int getDdi() {
        return ddi;
    }
    public void setDdi(int ddi) {
        this.ddi = ddi;
    }

    public int getDdd() {
        return ddd;
    }
    public void setDdd(int ddd) {
        this.ddd = ddd;
    }

    public String getNumber() {
        return number;
    }
    public void setNumber(String number) {
        this.number = number;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
