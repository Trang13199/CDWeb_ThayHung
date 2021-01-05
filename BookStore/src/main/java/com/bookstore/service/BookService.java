package com.bookstore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookstore.dao.BookDAO;
import com.bookstore.entity.Sach;

@Service
public class BookService {
	@Autowired
	private BookDAO bookDAO;

	public List<Sach> newBooks() {
		return bookDAO.newBooks();
	}

	public List<Sach> findAll() {
		return bookDAO.findAll();
	}

	public Sach findByID(int ids) {
		return bookDAO.findByID(ids);
	}

	public List<Sach> findByCategory(int id) {
		return bookDAO.findByCategory(id);
	}

	public List<Sach> findSameCategory() {
		return bookDAO.findSameCategory();
	}

	public Sach findById(long productId) {
		return bookDAO.findById(productId);
	}

	public void delete(Long maSach) {
		bookDAO.delete(maSach);
	}

	public void createBook(Sach sach) {
		bookDAO.createBook(sach);
	}
}
