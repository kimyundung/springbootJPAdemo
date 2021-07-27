package com.stone.repository;

import com.stone.entity.User;
import com.stone.entity.UserOnlyNameEmailEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserOnlyNameEmailEntityRepository extends JpaRepository<UserOnlyNameEmailEntity,Long> {
}
