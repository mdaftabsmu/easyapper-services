package com.easyapper.emailservices.bo;

import com.easyapper.emailservices.model.UserEvent;

import java.util.List;

public interface UserEmailBo extends GenericBo<UserEvent,String>{

    UserEvent delete(String emailId);

    List<String> getAllEmailIds();

}
