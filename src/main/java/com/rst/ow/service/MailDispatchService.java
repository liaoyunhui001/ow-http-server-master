package com.rst.ow.service;

/**
 * Created by hujia on 2016/11/23.
 */
public interface MailDispatchService {
    /**
     * 自动选择合适的收件人和抄送人以及合适的内容发送此邮件
     * @return 无
     */
    void dispatchMail(MailTemplate template);
}
