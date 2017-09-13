package com.rst.ow.entity;

/**
 * Created by hujia on 2016/11/16.
 */
public class User {
    private long id;
    private String name;
    private String email;
    private String phone;
    private String industry;
    private String type;


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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    @Override
    public String toString() {
        return "User Object:\n{\n\tid:" + id + "\n\tname:" + name + "\n\tphone:"
                + phone + "\n\temail:" + email + "\n\tindustry" + industry + "\n\ttype" + type + "\n}";
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
