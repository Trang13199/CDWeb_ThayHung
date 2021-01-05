package com.bookstore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookstore.dao.CategoryDAO;
import com.bookstore.entity.Theloaisach;

@Service
public class CategoryService {
	@Autowired
	private CategoryDAO categoryDAO;

	public List<Theloaisach> findAll() {
		return categoryDAO.findAll();
	}

	public void delete(Long maTheLoai) {
		categoryDAO.delete(maTheLoai);

	}

	public void create(Theloaisach theloaisach) {
		categoryDAO.create(theloaisach);

	}

}
