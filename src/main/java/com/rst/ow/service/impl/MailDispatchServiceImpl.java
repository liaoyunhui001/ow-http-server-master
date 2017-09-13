package com.rst.ow.service.impl;

import com.rst.ow.service.MailDispatchService;
import com.rst.ow.service.MailTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

/**
 * Created by hujia on 2016/11/23.
 */
@Service
public class MailDispatchServiceImpl implements MailDispatchService {

    @Autowired
    private JavaMailSender mailSender;

    @Override
    public void dispatchMail(MailTemplate template) {
        SimpleMailMessage message = new SimpleMailMessage();

        message.setFrom("rongshutong@rongshutong.com");
        message.setTo(template.getTo());
        message.setCc(template.getCc());
        message.setSubject(template.getSubject());
        message.setText(template.getContent());

        mailSender.send(message);
    }
}
