package com.rst.ow.controller;

import com.rst.ow.config.InitMailSetting;
import com.rst.ow.dao.UserDao;
import com.rst.ow.dto.JsonResult;
import com.rst.ow.dto.MailConfig;
import com.rst.ow.dto.OWRequest;
import com.rst.ow.service.MailDispatchService;
import com.rst.ow.service.MailTemplate;
import com.rst.ow.service.MailTemplateFactory;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.Callable;

/**
 * Created by hujia on 2016/11/16.
 */
@Api(tags = "官网注册体验接口")
@RestController
public class UserController {

    @Autowired
    private UserDao userDao;

    @Autowired
    private MailDispatchService mailDispatchService;

    @Autowired
    private InitMailSetting initMailSetting;

    @Autowired
    private MailTemplateFactory mailTemplateFactory;

    @ApiOperation(value = "配置邮件发送规则", response = JsonResult.class)
    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/config/mail/{type}", method = RequestMethod.POST)
    public JsonResult configMail(@RequestBody MailConfig configCell, @PathVariable("type") String type) {
        initMailSetting.setConfig(type, configCell);
        return new JsonResult();
    }

    @ApiOperation(value = "提交注册体验", response = JsonResult.class)
    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/counsel", method = RequestMethod.POST)
    public Callable<JsonResult> counsel(@RequestBody OWRequest request) {
        return () -> {
            boolean ret = userDao.insertUser(request.getName(),
                    request.getEmail(),
                    request.getPhone(),
                    request.getIndustry(),
                    request.getType());

            if (request.getConfig() == null) {
                request.setConfig(initMailSetting.getConfig(request.getType()));
            }

            MailTemplate template = mailTemplateFactory.get(request.getType(), request);

            if (template == null) {
                return new JsonResult("type只能为dike(贷后客)或rst(融数通)");
            }


            mailDispatchService.dispatchMail(template);
            return new JsonResult();
        };
    }

}
