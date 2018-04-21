package com.javacodegeeks.snippets.enterprise.hibernate.dao.impl.client.impl;

import com.javacodegeeks.snippets.enterprise.hibernate.dao.impl.GenericDao;
import com.javacodegeeks.snippets.enterprise.hibernate.dao.impl.client.ClientDao;
import com.javacodegeeks.snippets.enterprise.hibernate.model.BookEntity;
import com.javacodegeeks.snippets.enterprise.hibernate.model.ClientEntity;

import javax.persistence.Id;
import java.io.Serializable;
import java.util.List;

public class ClientDaoImpl extends GenericDao<ClientEntity, String> implements ClientDao {
    @SuppressWarnings("unchecked")
    public List<ClientEntity> findAll() {
        List<ClientEntity> clients = (List<ClientEntity>) getCurrentSession().createQuery("from ClientEntity").list();
        return clients;
    }

    public void deleteAll() {
        List<ClientEntity> entityList = findAll();
        for (ClientEntity entity : entityList) {
            delete(entity);
        }
    }
    public ClientEntity findById(String id) {
        ClientEntity client = (ClientEntity) getCurrentSession().get(ClientEntity.class, id);
        return client;
    }
}
