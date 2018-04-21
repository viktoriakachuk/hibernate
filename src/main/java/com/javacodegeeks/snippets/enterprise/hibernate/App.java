package com.javacodegeeks.snippets.enterprise.hibernate;

import java.util.List;

import com.javacodegeeks.snippets.enterprise.hibernate.model.BookEntity;
import com.javacodegeeks.snippets.enterprise.hibernate.model.CardEntity;
import com.javacodegeeks.snippets.enterprise.hibernate.model.ClientEntity;
import com.javacodegeeks.snippets.enterprise.hibernate.service.BookService;
import com.javacodegeeks.snippets.enterprise.hibernate.service.CardService;
import com.javacodegeeks.snippets.enterprise.hibernate.service.ClientService;

public class App {

	public static void main(String[] args) {
		BookService bookService = new BookService();
		List<BookEntity> books1 = bookService.findAll();
		System.out.println("Books Persisted are :");
		for (BookEntity b : books1) {
			System.out.println("-" + b.toString());
		}

		CardService cardService = new CardService();
		List<CardEntity> cards1 = cardService.findAll();
		System.out.println("Cards Persisted are :");
		for (CardEntity c : cards1) {
			System.out.println("-" + c.toString());
		}

		ClientService clService = new ClientService();
		List<ClientEntity> cl1 = clService.findAll();
		System.out.println("Clients Persisted are :");
		for (ClientEntity cl : cl1) {
			System.out.println("-" + cl.toString());
		}

		List<Object[]> cardsExp = cardService.findExpiredDate();
		System.out.println("Card with expired date :");
		for (Object[] c : cardsExp) {
			BookEntity book1 = (BookEntity) c[1];
			CardEntity card1 = (CardEntity) c[0];
			System.out.println("-title: "+book1.getTitle()+" author: "+book1.getAuthor()+" expdate: "+card1.getDate());
		}

		String name="Vasya Pupkin";

		List<Object[]> booksActual = cardService.findClientsBooksActualDate(name);
		System.out.println("Books with actual date that client "+name+" has:");
		for (Object[] c : booksActual) {
			BookEntity book1 = (BookEntity) c[1];
			CardEntity card1 = (CardEntity) c[0];
			ClientEntity client1 = (ClientEntity) c[2];
			System.out.println("-client: "+client1.getName()+" title: "+book1.getTitle()+" author: "+book1.getAuthor()+" date: "+card1.getDate());
		}
		System.exit(0);
	}
}
