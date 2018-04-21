package com.javacodegeeks.snippets.enterprise.hibernate.service;

import java.util.List;

import com.javacodegeeks.snippets.enterprise.hibernate.dao.AbstractDao;
import com.javacodegeeks.snippets.enterprise.hibernate.dao.impl.book.impl.BookDaoImpl;
import com.javacodegeeks.snippets.enterprise.hibernate.dao.impl.GenericDao;
import com.javacodegeeks.snippets.enterprise.hibernate.model.BookEntity;

public class BookService {

	private static BookDaoImpl bookDaoImpl;

	public BookService() {
		bookDaoImpl = new BookDaoImpl();
	}

	public void persist(BookEntity entity) {
		bookDaoImpl.openCurrentSessionwithTransaction();
		bookDaoImpl.persist(entity);
		bookDaoImpl.closeCurrentSessionwithTransaction();
	}

	public void update(BookEntity entity) {
		bookDaoImpl.openCurrentSessionwithTransaction();
		bookDaoImpl.update(entity);
		bookDaoImpl.closeCurrentSessionwithTransaction();
	}

	public BookEntity findById(String id) {
		bookDaoImpl.openCurrentSession();
		BookEntity book = bookDaoImpl.findById(id);
		bookDaoImpl.closeCurrentSession();
		return book;
	}

	public void delete(String id) {
		bookDaoImpl.openCurrentSessionwithTransaction();
		BookEntity book = bookDaoImpl.findById(id);
		bookDaoImpl.delete(book);
		bookDaoImpl.closeCurrentSessionwithTransaction();
	}

	public List<BookEntity> findAll() {
		bookDaoImpl.openCurrentSession();
		List<BookEntity> books = bookDaoImpl.findAll();
		bookDaoImpl.closeCurrentSession();
		return books;
	}

	public void deleteAll() {
		bookDaoImpl.openCurrentSessionwithTransaction();
		bookDaoImpl.deleteAll();
		bookDaoImpl.closeCurrentSessionwithTransaction();
	}

	public GenericDao bookDao() {
		return bookDaoImpl;
	}
}
