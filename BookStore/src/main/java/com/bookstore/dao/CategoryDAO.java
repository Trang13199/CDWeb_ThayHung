package com.bookstore.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bookstore.entity.Theloaisach;
import com.bookstore.repository.CategoryRepository;

@Repository
@Transactional
public class CategoryDAO {
	@Autowired
	private CategoryRepository cRepository;

	public List<Theloaisach> findAll() {
		return cRepository.findAll();
	}

	public void delete(Long maTheLoai) {
		cRepository.delete(maTheLoai);
	}

	public void create(Theloaisach theloaisach) {
		cRepository.saveAndFlush(theloaisach);

	}

}
