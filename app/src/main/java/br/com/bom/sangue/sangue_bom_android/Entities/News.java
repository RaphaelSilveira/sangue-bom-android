package br.com.bom.sangue.sangue_bom_android.Entities;

import java.util.Date;

/**
 * Created by paulo on 14/11/16.
 */

public class News {
    private Long id;
    private String title;
    private String text;
    private Date createdAt;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }
    public void setText(String text) {
        this.text = text;
    }

    public Date getCreatedAt() {
        return createdAt;
    }
    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}
