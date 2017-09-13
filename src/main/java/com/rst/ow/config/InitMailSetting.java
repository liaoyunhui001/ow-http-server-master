package com.rst.ow.config;

import com.rst.ow.dto.MailConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by hujia on 2016/11/17.
 */
@Configuration
public class InitMailSetting {
    @Value("${rst-mail.rst.to}")
    private String toRstMailUri;
    @Value("${rst-mail.rst.cc}")
    private String ccRstMailUri;
    @Value("${rst-mail.dike.to}")
    private String toDikeMailUri;
    @Value("${rst-mail.dike.cc}")
    private String ccDikeMailUri;
    @Value("${rst-mail.other.to}")
    private String toOtherMailUri;
    @Value("${rst-mail.other.cc}")
    private String ccOtherMailUri;

    private Map<String, MailConfig> type2Config = new HashMap<>();

    public MailConfig getConfig(String type) {
        return type2Config.get(type);
    }

    public void setConfig(String type, MailConfig config) {
        type2Config.put(type, config);
    }

    @PostConstruct
    void init() {
        initMailConfig(MailType.OW_DIKE);
        initMailConfig(MailType.OW_RST);
    }

    private String toUriFrom(String type) {
        if (MailType.OW_DIKE.equalsIgnoreCase(type)) {
            return toDikeMailUri;
        } else if (MailType.OW_RST.equalsIgnoreCase(type)) {
            return toRstMailUri;
        }
        return toOtherMailUri;
    }

    private String ccUriFrom(String type) {
        if (MailType.OW_DIKE.equalsIgnoreCase(type)) {
            return ccDikeMailUri;
        } else if (MailType.OW_RST.equalsIgnoreCase(type)) {
            return ccRstMailUri;
        }
        return ccOtherMailUri;
    }

    private void initMailConfig(String type) {
        MailConfig mailConfig = new MailConfig();
        for (String s : ccUriFrom(type).split(",")) {
            mailConfig.getCcMails().add(s);
        }

        List<MailConfig.ToMail> toMails = new ArrayList<>();
        for (String s : toUriFrom(type).split(",")) {
            mailConfig.getToMails().add(MailConfig.from(s.split(":")));
        }

        type2Config.put(type, mailConfig);
    }
}
