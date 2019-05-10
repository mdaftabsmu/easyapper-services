package com.easyapper.emailservices.controller;

import com.easyapper.emailservices.bo.SendEmailBo;
import com.easyapper.emailservices.model.EmailTopic;
import com.easyapper.emailservices.model.UserEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "send-email")
public class SendEmailController {

    @Autowired
    private SendEmailBo sendEmailBo;

    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<String> addUserDetails(@RequestBody EmailTopic emailTopic) {
        sendEmailBo.sendEmail(emailTopic);
        return ResponseEntity.ok("Email sent to the user");
    }
}
