package com.example.shirodemo.model.dao;

import java.util.Date;

public class Role {
    private Integer id;

    private String name;

    private Date updatedat;

    public Role(Integer id, String name, Date updatedat) {
        this.id = id;
        this.name = name;
        this.updatedat = updatedat;
    }

    public Role() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Date getUpdatedat() {
        return updatedat;
    }

    public void setUpdatedat(Date updatedat) {
        this.updatedat = updatedat;
    }
}