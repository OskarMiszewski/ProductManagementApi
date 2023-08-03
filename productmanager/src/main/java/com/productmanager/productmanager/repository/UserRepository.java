package com.productmanager.productmanager.repository;

import com.productmanager.productmanager.model.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, String>
{
    User findUserById(Long id);
    User findUserByLogin(String login);

}
