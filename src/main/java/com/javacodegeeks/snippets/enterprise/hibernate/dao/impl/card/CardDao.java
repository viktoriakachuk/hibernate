package com.javacodegeeks.snippets.enterprise.hibernate.dao.impl.card;

import com.javacodegeeks.snippets.enterprise.hibernate.dao.AbstractDao;
import com.javacodegeeks.snippets.enterprise.hibernate.model.CardEntity;
import com.javacodegeeks.snippets.enterprise.hibernate.model.ClientEntity;

import java.util.List;

public interface CardDao extends AbstractDao<CardEntity,String> {
    public List<CardEntity> findAll();
    public void deleteAll();
    public CardEntity findById(String id);
    public List<Object[]> findExpiredDate();
}
