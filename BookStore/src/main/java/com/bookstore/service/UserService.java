package com.bookstore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookstore.dao.UserDAO;
import com.bookstore.entity.User;

@Service
public class UserService {
	@Autowired
	private UserDAO userDAO;

	public boolean checkLogin(String email, String password) {
		User user = userDAO.findByEmail(email);
		if (user != null && user.getPassword().equals(password)) {
			return true;
		}
		return false;
	}

	public List<User> findAll() {
		return userDAO.findAll();
	}

	public User findByEmail(String email) {
		return userDAO.findByEmail(email);
	}

	public void create(User user) {
		userDAO.create(user);
	}

	public void update(User user) {
		userDAO.update(user);
	}

	public void delete(Long idUser) {
		userDAO.delete(idUser);

	}
}
