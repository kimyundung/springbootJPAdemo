package com.stone.springbootjpademo06.repository;

import com.stone.springbootjpademo06.entity.RedBook;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RedBookRepository extends JpaRepository<RedBook, Long> {
}
