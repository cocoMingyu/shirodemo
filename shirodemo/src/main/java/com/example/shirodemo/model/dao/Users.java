package com.example.shirodemo.model.dao;

import lombok.ToString;

import java.util.Date;

@ToString
public class Users {
    private Integer id;

    private String useridnet;

    private String businessid;

    private String name;

    private String nickname;

    private String headimgurl;

    private String idcard;

    private String mobile;

    private String wxUnionid;

    private Byte isrealname;

    private Date createdat;

    private Date updatedat;

    private String years;

    private String signature;

    private String constellation;

    private String address;

    private String themeurl;

    private String password;

    public Users(Integer id, String useridnet, String businessid, String name, String nickname, String headimgurl, String idcard, String mobile, String wxUnionid, Byte isrealname, Date createdat, Date updatedat, String years, String signature, String constellation, String address, String themeurl, String password) {
        this.id = id;
        this.useridnet = useridnet;
        this.businessid = businessid;
        this.name = name;
        this.nickname = nickname;
        this.headimgurl = headimgurl;
        this.idcard = idcard;
        this.mobile = mobile;
        this.wxUnionid = wxUnionid;
        this.isrealname = isrealname;
        this.createdat = createdat;
        this.updatedat = updatedat;
        this.years = years;
        this.signature = signature;
        this.constellation = constellation;
        this.address = address;
        this.themeurl = themeurl;
        this.password = password;
    }

    public Users() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUseridnet() {
        return useridnet;
    }

    public void setUseridnet(String useridnet) {
        this.useridnet = useridnet == null ? null : useridnet.trim();
    }

    public String getBusinessid() {
        return businessid;
    }

    public void setBusinessid(String businessid) {
        this.businessid = businessid == null ? null : businessid.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname == null ? null : nickname.trim();
    }

    public String getHeadimgurl() {
        return headimgurl;
    }

    public void setHeadimgurl(String headimgurl) {
        this.headimgurl = headimgurl == null ? null : headimgurl.trim();
    }

    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard == null ? null : idcard.trim();
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    public String getWxUnionid() {
        return wxUnionid;
    }

    public void setWxUnionid(String wxUnionid) {
        this.wxUnionid = wxUnionid == null ? null : wxUnionid.trim();
    }

    public Byte getIsrealname() {
        return isrealname;
    }

    public void setIsrealname(Byte isrealname) {
        this.isrealname = isrealname;
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

    public String getYears() {
        return years;
    }

    public void setYears(String years) {
        this.years = years == null ? null : years.trim();
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature == null ? null : signature.trim();
    }

    public String getConstellation() {
        return constellation;
    }

    public void setConstellation(String constellation) {
        this.constellation = constellation == null ? null : constellation.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getThemeurl() {
        return themeurl;
    }

    public void setThemeurl(String themeurl) {
        this.themeurl = themeurl == null ? null : themeurl.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }
}