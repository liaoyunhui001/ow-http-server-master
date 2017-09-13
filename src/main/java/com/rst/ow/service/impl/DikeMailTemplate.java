package com.rst.ow.service.impl;

/**
 * Created by hujia on 2017/4/1.
 */
public class DikeMailTemplate extends OWMailTemplate {
    @Override
    public String getContent() {
        if (data == null) {
            return "None";
        }
        return "这是一封来自于贷后客的咨询邮件，请尽快处理\n"
                + "姓名：" + data.getName()
                + "\n邮箱：" + data.getEmail()
                + "\n电话：" + data.getPhone()
                + "\n来源：" + data.getFrom();
    }

    @Override
    public String getSubject() {
        if (data == null) {
            return "None";
        }
        return "贷后客咨询："
                + data.getName() + "_" + data.getEmail() + "_" + data.getPhone();
    }
}
