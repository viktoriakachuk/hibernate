package com.javacodegeeks.snippets.enterprise.hibernate.dao.impl.book;

import com.javacodegeeks.snippets.enterprise.hibernate.dao.AbstractDao;
import com.javacodegeeks.snippets.enterprise.hibernate.model.BookEntity;
import com.javacodegeeks.snippets.enterprise.hibernate.model.CardEntity;

import java.util.List;

public interface BookDao extends AbstractDao<BookEntity,String> {
    public List<BookEntity> findAll();
    public void deleteAll();
    public BookEntity findById(String id);
}
