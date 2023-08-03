package com.productmanager.productmanager.service;

import com.productmanager.productmanager.model.User;
import com.productmanager.productmanager.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;




@Service
public class UserService
{
    @Autowired
    UserRepository userRepository;
    BCryptPasswordEncoder bCryptPasswordEncoder ;

    public UserService(UserRepository userRepository)
    {
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = new BCryptPasswordEncoder();
    }

    public User save(User user)
    {
        //        String encodePassword = this.bCryptPasswordEncoder.encode(user.getPassword());
        //        user.setPassword(encodePassword);
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        return this.userRepository.save(user);
    }

    public boolean login(String login, String password) {
        User user = userRepository.findUserByLogin(login);
        if (user == null)
        {
            return false;
        }
        String encryptedPassword = user.getPassword();
        return bCryptPasswordEncoder.matches(password, encryptedPassword);
    }

}
