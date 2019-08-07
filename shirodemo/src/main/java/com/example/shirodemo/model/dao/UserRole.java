package com.example.shirodemo.model.dao;

import java.util.Date;

public class UserRole {
    private Integer id;

    private Integer userid;

    private Integer roleid;

    private Date startime;

    private Date endtime;

    private Byte status;

    private Date createdat;

    private Date updatedat;

    public UserRole(Integer id, Integer userid, Integer roleid, Date startime, Date endtime, Byte status, Date createdat, Date updatedat) {
        this.id = id;
        this.userid = userid;
        this.roleid = roleid;
        this.startime = startime;
        this.endtime = endtime;
        this.status = status;
        this.createdat = createdat;
        this.updatedat = updatedat;
    }

    public UserRole() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getRoleid() {
        return roleid;
    }

    public void setRoleid(Integer roleid) {
        this.roleid = roleid;
    }

    public Date getStartime() {
        return startime;
    }

    public void setStartime(Date startime) {
        this.startime = startime;
    }

    public Date getEndtime() {
        return endtime;
    }

    public void setEndtime(Date endtime) {
        this.endtime = endtime;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public Date getCreatedat() {
        return createdat;
    }

    public void setCreatedat(Date createdat) {
        this.createdat = createdat;
    }

    public Date getUpdatedat() {
        return updatedat;
    }

    public void setUpdatedat(Date updatedat) {
        this.updatedat = updatedat;
    }
}