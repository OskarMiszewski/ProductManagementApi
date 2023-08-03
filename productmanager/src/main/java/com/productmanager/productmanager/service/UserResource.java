package com.productmanager.productmanager.service;

import com.productmanager.productmanager.model.User;
import com.productmanager.productmanager.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "http://localhost:4200")
public class UserResource
{
    @Autowired
    UserService userService;

    public UserResource(UserRepository userRepository)
    {
    }

    @PostMapping("/register")
    public User createUser(@RequestBody User user)
    {
        return this.userService.save(user);
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody User user) {
        boolean success = userService.login(user.getLogin(), user.getPassword());

        if (success) {
            return new ResponseEntity<>("Login successful", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Login failed", HttpStatus.UNAUTHORIZED);
        }
    }

//    @PostMapping("/login")
//    public ResponseEntity<User> loginUser(@RequestBody User userData)
//    {
//        System.out.println(userData);
//        User user = userRepository.findUserById(userData.getId());
//        if (user.getPassword().equals(userData.getPassword()))
//            return ResponseEntity.ok(user);
//
//            return (ResponseEntity<User>) ResponseEntity.internalServerError();
//
//    }

}
