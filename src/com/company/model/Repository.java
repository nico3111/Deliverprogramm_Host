package com.company.model;

import java.util.List;

public interface Repository<T> {
    public List<T> findAll();
    public T findOne(int id);
    /** TODO: return T */
    public T create();
}