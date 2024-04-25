package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
@Controller
public class UserController {
    @Autowired
    private UserRepository userRepository;


    @CrossOrigin
    @PostMapping("/users/register")
    @ResponseBody
    public ResponseEntity<String> addUser(@RequestParam String name, @RequestParam String email, @RequestParam String password) {
        User newUser = new User();
        // check in the database if the user already exists
        if (userRepository.findByEmail(email) != null) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("User already exists!");
        }

        newUser.setName(name);
        newUser.setEmail(email);
        newUser.setPassword(password);
        userRepository.save(newUser);
        return ResponseEntity.ok("User added successfully!");
    }

    @CrossOrigin
    @PostMapping("/users/login")
    @ResponseBody
    public ResponseEntity<String> loginUser(@RequestParam String email, @RequestParam String password) {
        User user = userRepository.findByEmail(email);
        if (user == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found!");
        }
        if (user.getPassword().equals(password)) {
            return ResponseEntity.ok("Login successful!");
        }
        else if (!user.getPassword().equals(password)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Your email or password is incorrect!");
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Login failed please try again!");
    }

    @CrossOrigin
    @GetMapping("/users")
    @ResponseBody
    public Iterable<User> getUsers() {
        return userRepository.findAll();
    }

    // check if the user is logged in
    @CrossOrigin
    @GetMapping("/users/isloggedin")
    @ResponseBody
    public ResponseEntity<String> isLoggedIn(@RequestParam String email) {
        User user = userRepository.findByEmail(email);
        if (user == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found!");
        }
        return ResponseEntity.ok("User is logged in!");
    }

}
