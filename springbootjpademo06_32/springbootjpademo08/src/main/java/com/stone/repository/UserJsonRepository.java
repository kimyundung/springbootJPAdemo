package com.stone.repository;

import com.stone.entity.UserJson;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserJsonRepository extends JpaRepository<UserJson, Long> {
}
