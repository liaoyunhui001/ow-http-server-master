package com.rst.ow.service.impl;

import com.rst.ow.dto.MailConfig;
import com.rst.ow.dto.OWRequest;
import com.rst.ow.service.MailTemplate;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hujia on 2017/4/1.
 */
public abstract class OWMailTemplate implements MailTemplate {
    protected OWRequest data;

    private String[] cc;
    private String[] to;

    @Override
    public String[] getCc() {
        return cc;
    }

    @Override
    public String[] getTo() {
        return to;
    }

    private void apply(MailConfig config) {
        int rand = (int)(Math.random()*100);
        int start = 0;
        to = new String[1];
        List<String> ccList = new ArrayList<>();
        boolean stop = false;
        for (MailConfig.ToMail toMail : config.getToMails()) {
            if (stop) {
                ccList.add(toMail.getMail());
                continue;
            }

            int rate = toMail.getRate();
            int end = start + rate;
            if (rand >= start && rand < end) {
                to[0] = toMail.getMail();
                stop = true;
            }
            start = end;
        }
        cc = new String[ccList.size()];
        cc = ccList.toArray(cc);
    }

    @Override
    public MailTemplate fill(Object data) {
        if (data instanceof OWRequest) {
            this.data = (OWRequest)data;
            apply(this.data.getConfig());
        }

        return this;
    }
}
