package com.stone.springbootjpademo06.repository;

import com.stone.springbootjpademo06.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book,Long> {
}
