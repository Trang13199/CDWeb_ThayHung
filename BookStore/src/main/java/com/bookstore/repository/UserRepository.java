package com.bookstore.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bookstore.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
	@Query(value = "SELECT u FROM User u WHERE u.email = :email")
	public abstract List<User> findByEmail(@Param("email") String email);

}
