package com.javacodegeeks.snippets.enterprise.hibernate.service;

import com.javacodegeeks.snippets.enterprise.hibernate.dao.impl.card.impl.CardDaoImpl;
import com.javacodegeeks.snippets.enterprise.hibernate.model.CardEntity;

import java.util.List;

public class CardService {
    private static CardDaoImpl cardDaoImpl;

    public CardService() {
        cardDaoImpl = new CardDaoImpl();
    }

    public void persist(CardEntity entity) {
        cardDaoImpl.openCurrentSessionwithTransaction();
        cardDaoImpl.persist(entity);
        cardDaoImpl.closeCurrentSessionwithTransaction();
    }

    public void update(CardEntity entity) {
        cardDaoImpl.openCurrentSessionwithTransaction();
        cardDaoImpl.update(entity);
        cardDaoImpl.closeCurrentSessionwithTransaction();
    }

    public CardEntity findById(String id) {
        cardDaoImpl.openCurrentSession();
        CardEntity card = cardDaoImpl.findById(id);
        cardDaoImpl.closeCurrentSession();
        return card;
    }

    public void delete(String id) {
        cardDaoImpl.openCurrentSessionwithTransaction();
        CardEntity card = cardDaoImpl.findById(id);
        cardDaoImpl.delete(card);
        cardDaoImpl.closeCurrentSessionwithTransaction();
    }

    public List<CardEntity> findAll() {
        cardDaoImpl.openCurrentSession();
        List<CardEntity> cards = cardDaoImpl.findAll();
        cardDaoImpl.closeCurrentSession();
        return cards;
    }

    public List<Object[]> findExpiredDate() {
        cardDaoImpl.openCurrentSession();
        List<Object[]> cards = cardDaoImpl.findExpiredDate();
        cardDaoImpl.closeCurrentSession();
        return cards;
    }
    public List<Object[]> findClientsBooksActualDate(String name) {
        cardDaoImpl.openCurrentSession();
        List<Object[]> cards = cardDaoImpl.findClientsBooksActualDate(name);
        cardDaoImpl.closeCurrentSession();
        return cards;
    }

    public void deleteAll() {
        cardDaoImpl.openCurrentSessionwithTransaction();
        cardDaoImpl.deleteAll();
        cardDaoImpl.closeCurrentSessionwithTransaction();
    }

    public CardDaoImpl cardDao() {
        return cardDaoImpl;
    }
}

