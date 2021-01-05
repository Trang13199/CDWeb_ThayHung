package com.bookstore.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bookstore.entity.Sach;
import com.bookstore.repository.BookRepository;

@Repository
@Transactional
public class BookDAO {
	@Autowired
	private BookRepository bRepository;
//	@PersistenceContext
//	private EntityManager entityManager;

	public List<Sach> newBooks() {
//		List<Sach> listNew = entityManager.createNamedQuery("SELECT s FROM Sach s ORDER BY RAND() LIMIT 24", Sach.class)
//				.getResultList();
		return bRepository.newBooks();
	}

	public List<Sach> findAll() {
		return bRepository.findAll();
	}

	public Sach findByID(int ids) {
		return bRepository.findByName(ids);
	}

	public List<Sach> findByCategory(long id) {
		return bRepository.findByCategory(id);
	}

	public List<Sach> findSameCategory() {
		return bRepository.findSameCategory();
	}

	public Sach findById(long productId) {
		return bRepository.findOne(productId);
	}

	public void delete(Long maSach) {
		Sach sach = bRepository.findOne(maSach);
		if (sach != null) {
			bRepository.delete(sach);
		}
	}

	public void createBook(Sach sach) {
		bRepository.saveAndFlush(sach);
	}
}
