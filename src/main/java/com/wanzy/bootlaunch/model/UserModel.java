package com.wanzy.bootlaunch.model;

import lombok.Data;

@Data
public class UserModel {
    public int ID;
    public String UserName;
    public String Password;

    public String FirstNameEn;
    public String LastNameEn;

    public String FirstNameCn;
    public String LastNameCn;

    public String CompanyName;
    public String Title;
    public String Mobile;
    public String Phone;
    public String Fax;
    public String Address;
    public String Email;
    public String wechat;
    public String QqNumber;
    public String CardId;

    public String UserNameCn(){
        return this.FirstNameCn + this.LastNameCn;
    }

    public String UserNameEn(){
        return this.LastNameEn +" "+ this.FirstNameEn;
    }
}
