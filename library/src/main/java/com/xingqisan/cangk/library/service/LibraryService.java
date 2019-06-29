package com.xingqisan.cangk.library.service;

import org.springframework.data.domain.Page;

import com.xingqisan.cangk.library.domain.Book;
import com.xingqisan.cangk.library.domain.DebitList;

public interface LibraryService {

	Page<Book> search(String keyword, int pageNumber);

	void add(String id, DebitList list);

	void remove(String id, DebitList list);

}
