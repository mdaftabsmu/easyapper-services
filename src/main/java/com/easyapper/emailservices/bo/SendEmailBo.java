package com.easyapper.emailservices.bo;

import com.easyapper.emailservices.model.EmailTopic;

public interface SendEmailBo extends GenericBo<EmailTopic,String> {
    void sendEmail(EmailTopic emailTopic);
}
