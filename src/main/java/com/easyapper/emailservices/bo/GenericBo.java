package com.easyapper.emailservices.bo;

import java.io.Serializable;

public interface GenericBo<T, PK extends Serializable> {
        T create(T t);
        T read(PK id);
        T update(T t);
        void delete(T t);
}
