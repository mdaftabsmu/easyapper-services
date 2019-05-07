package com.easyapper.emailservices.controller;

import com.easyapper.emailservices.bo.EmailBo;
import com.easyapper.emailservices.model.UserEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class EmailController {

    @Autowired
    private EmailBo emailBo;

    @RequestMapping(value = "/test")
    public String test(){
        return "Hello world test";
    }

    @PostMapping(path="/user",consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<String> addUserDetails(@RequestBody UserEvent userEvent){
       emailBo.create(userEvent);
        return ResponseEntity.ok("User details added");
    }

   @GetMapping(path="/user",consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
           produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<List<String>> getUserList() {
        return ResponseEntity.ok(new ArrayList<>());
    }

    @DeleteMapping(path="/user",consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<?> deleteUser(@RequestParam String emailId) {
        return ResponseEntity.ok("Email id has been Unsubscribed");
    }

}
