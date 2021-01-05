package com.bookstore.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bookstore.entity.User;
import com.bookstore.repository.UserRepository;

@Repository
@Transactional
public class UserDAO {
	@Autowired
	private UserRepository uRepository;

	public User findByEmail(String email) {
		List<User> listUser = uRepository.findByEmail(email);
		if (listUser != null && listUser.size() > 0) {
			return listUser.get(0);
		}
		return null;
	}

	public void create(User user) {
		uRepository.saveAndFlush(user);
	}

	public void update(User user) {
		User u = (User) uRepository.findByEmail(user.getEmail());
		u.setUsername(user.getUsername());
		u.setEmail(user.getEmail());
		u.setPassword(user.getPassword());
		u.setCode(user.getCode());
		u.setAddress(user.getAddress());
		u.setDateOfBirth(user.getDateOfBirth());
		u.setGender(user.getGender());
		u.setPhone(user.getPhone());
		uRepository.save(u);
	}

	public List<User> findAll() {
		return uRepository.findAll();
	}

	public void delete(Long idUser) {
		uRepository.delete(idUser);

	}
}
