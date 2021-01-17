package com.bookstore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.bookstore.entity.Sach;
import com.bookstore.repository.PageRepository;

@Service
public class PageService {
	@Autowired
	private PageRepository repos;

	public Page<Sach> listAll(int pageNumber) {
//		pageNumber -1 : là trang hiện tại là trang máy ròi -1 
		Pageable pageable = new PageRequest(pageNumber - 1, 12);
		return repos.findAll(pageable);

// @formatter:on

// @formatter:on

	}
}
