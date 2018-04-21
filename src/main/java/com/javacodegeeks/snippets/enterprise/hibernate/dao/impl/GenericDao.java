package com.javacodegeeks.snippets.enterprise.hibernate.dao.impl;

import java.io.Serializable;
import java.util.List;

import com.javacodegeeks.snippets.enterprise.hibernate.dao.AbstractDao;
import com.javacodegeeks.snippets.enterprise.hibernate.model.BookEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public abstract class GenericDao<T, Id extends Serializable> implements AbstractDao<T, Id> {

	private Session currentSession;
	
	private Transaction currentTransaction;

	public GenericDao() {
	}

	public Session openCurrentSession() {
		currentSession = getSessionFactory().openSession();
		return currentSession;
	}

	public Session openCurrentSessionwithTransaction() {
		currentSession = getSessionFactory().openSession();
		currentTransaction = currentSession.beginTransaction();
		return currentSession;
	}
	
	public void closeCurrentSession() {
		currentSession.close();
	}
	
	public void closeCurrentSessionwithTransaction() {
		currentTransaction.commit();
		currentSession.close();
	}
	
	private static SessionFactory getSessionFactory() {
		Configuration configuration = new Configuration().configure();
		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties());
		SessionFactory sessionFactory = configuration.buildSessionFactory(builder.build());
		return sessionFactory;
	}

	public Session getCurrentSession() {
		return currentSession;
	}

	public void setCurrentSession(Session currentSession) {
		this.currentSession = currentSession;
	}

	public Transaction getCurrentTransaction() {
		return currentTransaction;
	}

	public void setCurrentTransaction(Transaction currentTransaction) {
		this.currentTransaction = currentTransaction;
	}

	public void persist(T entity) {
		getCurrentSession().save(entity);
	}

	public void update(T entity) {
		getCurrentSession().update(entity);
	}


	public void delete(T entity) {
		getCurrentSession().delete(entity);
	}


}
