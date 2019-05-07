package com.easyapper.emailservices.bo.impl;

import com.easyapper.emailservices.bo.EmailBo;
import com.easyapper.emailservices.model.UserEvent;
import com.easyapper.emailservices.repository.UserEventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmailBoImpl implements EmailBo {

    @Autowired
    private UserEventRepository userEventRepository;

    @Override
    public UserEvent create(UserEvent event) {
        return userEventRepository.save(event);
    }

    @Override
    public UserEvent read(String id) {
        return null;
    }

    @Override
    public UserEvent update(UserEvent event) {
        return null;
    }

    @Override
    public void delete(UserEvent event) {

    }
}
