package com.stone.repository;

import com.stone.entity.User;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.Repository;

import java.io.Serializable;

@NoRepositoryBean
public interface MyBaseRepository<T,ID extends Serializable> extends Repository<T,ID> {
    Iterable<T> findAll();
    T getOne(ID id);
    <S extends T> S save(S entity);
}
