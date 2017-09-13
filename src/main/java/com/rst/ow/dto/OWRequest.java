package com.rst.ow.dto;

/**
 * Created by hujia on 2017/4/1.
 */
public class OWRequest {
    private String name;
    private String phone;
    private String email;
    private String from;
    private String industry;
    private String type;
    private MailConfig config;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public MailConfig getConfig() {
        return config;
    }

    public void setConfig(MailConfig config) {
        this.config = config;
    }

    @Override
    public String toString() {
        return "OWRequest("
                + "name: " + getName()
                + ", form: " + getFrom()
                + ", phone: " + getPhone()
                + ", industry: " + getIndustry()
                + ", email: " + getEmail()
                + ", type: " + getType()
                + ", config: " + getConfig() +
                ")";
    }
}
