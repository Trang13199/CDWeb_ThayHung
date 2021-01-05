package com.bookstore.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bookstore.entity.Sach;

public interface BookRepository extends JpaRepository<Sach, Long> {
	@Query(value = "SELECT c FROM Sach c WHERE c.maSach =:ids")
	public abstract Sach findByName(@Param("ids") long ids);

	@Query(value = "select b from Sach b join b.theloaisach c where c.maTheLoai =:catId")
	public abstract List<Sach> findByCategory(@Param("catId") long id);

	@Query(value = "select b from Sach b join b.theloaisach c where c.maTheLoai = b.theloaisach.maTheLoai")
	public abstract List<Sach> findSameCategory();

	@Query(value = "SELECT s FROM Sach s ORDER BY RAND()")
	public abstract List<Sach> newBooks();
}
