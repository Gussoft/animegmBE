package com.gussoft.animegm.service;

import java.util.List;

public interface CRUD<T> {

    List<T> findAll();

    T findById(Long id);

    T saved(T obj);

    T updated(T obj, Long id);

    void deleted(Long id);

}
