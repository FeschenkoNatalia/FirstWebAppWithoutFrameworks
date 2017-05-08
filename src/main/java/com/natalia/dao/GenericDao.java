package com.natalia.dao;

public interface GenericDao <T>{

    T save(T t);

    T update(T t);

}
