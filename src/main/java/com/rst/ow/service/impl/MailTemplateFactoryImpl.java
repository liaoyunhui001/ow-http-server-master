package com.rst.ow.service.impl;

import com.rst.ow.config.MailType;
import com.rst.ow.service.MailTemplate;
import com.rst.ow.service.MailTemplateFactory;
import org.springframework.stereotype.Service;

/**
 * Created by hujia on 2017/4/1.
 */
@Service
public class MailTemplateFactoryImpl implements MailTemplateFactory {

    @Override
    public MailTemplate get(String type, Object data) {
        if (type.equalsIgnoreCase(MailType.OW_DIKE)) {
            return new DikeMailTemplate().fill(data);
        } else if (type.equalsIgnoreCase(MailType.OW_RST)) {
            return new RstMailTemplate().fill(data);
        }

        return null;
    }
}
