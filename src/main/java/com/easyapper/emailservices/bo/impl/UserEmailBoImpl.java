package com.easyapper.emailservices.bo.impl;

import com.easyapper.emailservices.bo.UserEmailBo;
import com.easyapper.emailservices.exception.UserAlreadyExistException;
import com.easyapper.emailservices.model.UserEvent;
import com.easyapper.emailservices.repository.UserEventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserEmailBoImpl implements UserEmailBo {

    @Autowired
    private UserEventRepository userEventRepository;

    @Override
    public UserEvent create(UserEvent event) throws UserAlreadyExistException {
        UserEvent user = userEventRepository.findByEmail(event.getEmail());
        if (user != null) {
            if (user.getIsActive()) {
                throw new UserAlreadyExistException(" User Already exist in db!");
            } else {
                event.setIsActive(true);
                return userEventRepository.save(event);
            }
        }
        event.setHashCode(event.hashCode());
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

    @Override
    public UserEvent delete(String emailId) {
        UserEvent user = userEventRepository.findByEmail(emailId);
        if (user != null && !user.getIsActive()) {
            user.setIsActive(false);
            userEventRepository.save(user);
        }
        return user;
    }

    @Override
    public List<String> getAllEmailIds() {
        List<String> emailids = new ArrayList<>();
        userEventRepository.findAllByIsActive(true).forEach(email -> emailids.add(email.getEmail()));
        System.out.println(emailids);
        return emailids;// userEventRepository.findByIsActive(true);
    }
}
