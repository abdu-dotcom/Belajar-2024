package com.subrutin.service;

import com.subrutin.domain.Author;
import com.subrutin.domain.Book;

public class BookService {

	private Book book;

	public BookService() {
		Author author = new Author();
		book = new Book(author);
	}
	
	
}
