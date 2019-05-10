package com.easyapper.emailservices.bo;

import com.easyapper.emailservices.exception.UserAlreadyExistException;

import java.io.Serializable;

public interface GenericBo<T, PK extends Serializable> {
        T create(T t) throws UserAlreadyExistException;
        T read(PK id);
        T update(T t);
        void delete(T t);
}
