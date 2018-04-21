package com.javacodegeeks.snippets.enterprise.hibernate.dao.impl.client;

import com.javacodegeeks.snippets.enterprise.hibernate.dao.AbstractDao;
import com.javacodegeeks.snippets.enterprise.hibernate.model.ClientEntity;

import java.util.List;

public interface ClientDao extends AbstractDao<ClientEntity,String> {
    public List<ClientEntity> findAll();
    public void deleteAll();
    public ClientEntity findById(String id);
}
