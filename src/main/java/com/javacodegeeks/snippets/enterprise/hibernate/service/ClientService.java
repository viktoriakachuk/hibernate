package com.javacodegeeks.snippets.enterprise.hibernate.service;

import com.javacodegeeks.snippets.enterprise.hibernate.dao.impl.client.impl.ClientDaoImpl;
import com.javacodegeeks.snippets.enterprise.hibernate.model.ClientEntity;

import java.util.List;

public class ClientService {
    private static ClientDaoImpl clientDaoImpl;

    public ClientService() {
        clientDaoImpl = new ClientDaoImpl();
    }

    public void persist(ClientEntity entity) {
        clientDaoImpl.openCurrentSessionwithTransaction();
        clientDaoImpl.persist(entity);
        clientDaoImpl.closeCurrentSessionwithTransaction();
    }

    public void update(ClientEntity entity) {
        clientDaoImpl.openCurrentSessionwithTransaction();
        clientDaoImpl.update(entity);
        clientDaoImpl.closeCurrentSessionwithTransaction();
    }

    public ClientEntity findById(String id) {
        clientDaoImpl.openCurrentSession();
        ClientEntity client = clientDaoImpl.findById(id);
        clientDaoImpl.closeCurrentSession();
        return client;
    }

    public void delete(String id) {
        clientDaoImpl.openCurrentSessionwithTransaction();
        ClientEntity client = clientDaoImpl.findById(id);
        clientDaoImpl.delete(client);
        clientDaoImpl.closeCurrentSessionwithTransaction();
    }

    public List<ClientEntity> findAll() {
        clientDaoImpl.openCurrentSession();
        List<ClientEntity> clients = clientDaoImpl.findAll();
        clientDaoImpl.closeCurrentSession();
        return clients;
    }

    public void deleteAll() {
        clientDaoImpl.openCurrentSessionwithTransaction();
        clientDaoImpl.deleteAll();
        clientDaoImpl.closeCurrentSessionwithTransaction();
    }

    public ClientDaoImpl clientDao() {
        return clientDaoImpl;
    }
}

