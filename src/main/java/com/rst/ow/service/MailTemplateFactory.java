package com.rst.ow.service;

/**
 * Created by hujia on 2017/4/1.
 */
public interface MailTemplateFactory {
    MailTemplate get(String type, Object data);
}
