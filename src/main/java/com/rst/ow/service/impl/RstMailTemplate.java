package com.rst.ow.service.impl;

/**
 * Created by hujia on 2017/4/1.
 */
public class RstMailTemplate extends OWMailTemplate {

    @Override
    public String getContent() {
        return "这是一封来自于贷后客的咨询邮件，请尽快处理\n"
                + "姓名：" + data.getName() + "\n电话："
                + data.getPhone()
                + "\n行业：" + data.getIndustry()
                + "\n来源：" + data.getFrom();
    }

    @Override
    public String getSubject() {
        return "融数通咨询："
                + data.getName() + "_" + data.getPhone() + "_" + data.getIndustry();
    }
}
