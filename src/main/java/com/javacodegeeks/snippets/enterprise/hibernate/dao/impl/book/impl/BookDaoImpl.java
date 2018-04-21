package com.javacodegeeks.snippets.enterprise.hibernate.dao.impl.book.impl;

import com.javacodegeeks.snippets.enterprise.hibernate.dao.impl.GenericDao;
import com.javacodegeeks.snippets.enterprise.hibernate.dao.impl.book.BookDao;
import com.javacodegeeks.snippets.enterprise.hibernate.model.BookEntity;
import com.javacodegeeks.snippets.enterprise.hibernate.model.CardEntity;

import java.io.Serializable;
import java.util.List;

public class BookDaoImpl extends GenericDao<BookEntity, String> implements BookDao {

    @SuppressWarnings("unchecked")
    public List<BookEntity> findAll() {
        List<BookEntity> books = (List<BookEntity>) getCurrentSession().createQuery("from BookEntity").list();
        return books;
    }

    public void deleteAll() {
        List<BookEntity> entityList = findAll();
        for (BookEntity entity : entityList) {
            delete(entity);
        }
    }
    public BookEntity findById(String id) {
        BookEntity book = (BookEntity) getCurrentSession().get(BookEntity.class, id);
        return book;
    }
}
