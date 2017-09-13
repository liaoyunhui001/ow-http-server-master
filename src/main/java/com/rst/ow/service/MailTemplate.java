package com.rst.ow.service;

/**
 * Created by hujia on 2017/4/1.
 */
public interface MailTemplate {
    String getContent();
    String getSubject();
    String[] getCc();
    String[] getTo();
    MailTemplate fill(Object data);
}
