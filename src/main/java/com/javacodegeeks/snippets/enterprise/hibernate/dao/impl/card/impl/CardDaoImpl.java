package com.javacodegeeks.snippets.enterprise.hibernate.dao.impl.card.impl;

import com.javacodegeeks.snippets.enterprise.hibernate.dao.impl.GenericDao;
import com.javacodegeeks.snippets.enterprise.hibernate.dao.impl.card.CardDao;
import com.javacodegeeks.snippets.enterprise.hibernate.model.BookEntity;
import com.javacodegeeks.snippets.enterprise.hibernate.model.CardEntity;
import com.javacodegeeks.snippets.enterprise.hibernate.model.ClientEntity;
import org.hibernate.Query;

import javax.persistence.TemporalType;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public class CardDaoImpl extends GenericDao<CardEntity, String> implements CardDao {

    @SuppressWarnings("unchecked")
    public List<CardEntity> findAll() {
        List<CardEntity> cards = (List<CardEntity>) getCurrentSession().createQuery("from CardEntity").list();
        return cards;
    }

    @SuppressWarnings("unchecked")
    public List<Object[]> findExpiredDate() {
        Query query = getCurrentSession().createQuery("from CardEntity c inner join c.bookByBookId b where c.date<:paramDate");
        Date date = new Date();
        System.out.println(date);
        query.setParameter("paramDate", date );
        List<Object[]> res = query.list();
        return res;
    }

    @SuppressWarnings("unchecked")
    public List<Object[]> findClientsBooksActualDate(String name) {
        Query query = getCurrentSession().createQuery("from CardEntity c inner join c.bookByBookId b inner join c.clientByClientId cl where c.date>:paramDate and cl.name=:paramName");
        Date date = new Date();
        System.out.println(date);
        query.setParameter("paramDate", date );
        query.setParameter("paramName", name );
        List<Object[]> res = query.list();
        return res;
    }

    public void deleteAll() {
        List<CardEntity> entityList = findAll();
        for (CardEntity entity : entityList) {
            delete(entity);
        }
    }
    public CardEntity findById(String id) {
        CardEntity card = (CardEntity) getCurrentSession().get(CardEntity.class, id);
        return card;
    }
}
