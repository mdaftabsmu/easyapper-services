package com.easyapper.emailservices.controller;

import com.easyapper.emailservices.bo.UserEmailBo;
import com.easyapper.emailservices.exception.UserAlreadyExistException;
import com.easyapper.emailservices.model.UserEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "user")
public class EmailController {
    private Logger logger = LoggerFactory.getLogger(EmailController.class);

    @Autowired
    private UserEmailBo userEmailBo;

    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<String> addUserDetails(@RequestBody UserEvent userEvent) {
        try {
            userEmailBo.create(userEvent);
            return ResponseEntity.ok("User details added");
        } catch (UserAlreadyExistException e) {
            e.printStackTrace();
            return ResponseEntity.ok(e.getMessage());
        }

    }

    @GetMapping(path = "/monitors/{monitorId}/emails",
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<List<String>> getUserList() {
        List<String> emails = userEmailBo.getAllEmailIds();
        logger.info(String.valueOf(emails));
        return ResponseEntity.ok(emails);
    }

    @DeleteMapping(path = "/monitors/{monitorId}/emails/{emailId}")
    public ResponseEntity<String> deleteUser(@PathVariable("emailId") String emailId) {
        logger.info(emailId);
        userEmailBo.delete(emailId);
        return ResponseEntity.ok("Email id has been Unsubscribed");
    }

}
