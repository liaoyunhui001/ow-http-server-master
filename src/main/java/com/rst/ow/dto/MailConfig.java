package com.rst.ow.dto;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hujia on 2016/11/23.
 */
public class MailConfig {

    public List<ToMail> getToMails() {
        return toMails;
    }

    public void setToMails(List<ToMail> toMails) {
        this.toMails = toMails;
    }

    public List<String> getCcMails() {
        return ccMails;
    }

    public void setCcMails(List<String> ccMails) {
        this.ccMails = ccMails;
    }

    public static class ToMail {
        private String mail;
        private int rate;

        public String getMail() {
            return mail;
        }

        public void setMail(String mail) {
            this.mail = mail;
        }

        public int getRate() {
            return rate;
        }

        public void setRate(int rate) {
            this.rate = rate;
        }

    }

    public static ToMail from(String[] values) {
        if (values == null || values.length < 2) {
            return null;
        }
        ToMail toMail = new ToMail();
        toMail.setMail(values[0]);
        try {
            toMail.setRate(Integer.parseInt(values[1]));
        } catch (Exception e) {
            return null;
        }

        return toMail;
    }

    private List<ToMail> toMails = new ArrayList<>();

    private List<String> ccMails = new ArrayList<>();
}
