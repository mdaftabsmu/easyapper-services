package com.easyapper.emailservices.bo.impl;

import com.easyapper.emailservices.bo.SendEmailBo;
import com.easyapper.emailservices.model.EmailTopic;
import org.springframework.stereotype.Service;

@Service
public class SendEmailBoImpl implements SendEmailBo {
    @Override
    public EmailTopic create(EmailTopic emailTopic) {
        return null;
    }

    @Override
    public EmailTopic read(String id) {
        return null;
    }

    @Override
    public EmailTopic update(EmailTopic emailTopic) {
        return null;
    }

    @Override
    public void delete(EmailTopic emailTopic) {

    }

    @Override
    public void sendEmail(EmailTopic emailTopic) {

    }
}
