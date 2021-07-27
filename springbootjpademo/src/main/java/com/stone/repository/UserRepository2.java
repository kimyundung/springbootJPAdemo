package com.stone.repository;

import com.stone.entity.User;
import com.stone.entity.UserOnlyNameEmailDto;
import com.stone.pojo.UserOnlyName;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository2 extends JpaRepository<User,Long> {

    List<UserOnlyNameEmailDto> findByEmail(String email);

    List<UserOnlyName> findByAddress(String address);
}
