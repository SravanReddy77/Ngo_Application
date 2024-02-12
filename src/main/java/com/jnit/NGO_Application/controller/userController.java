package com.jnit.NGO_Application.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jnit.NGO_Application.model.user;
import com.jnit.NGO_Application.repository.userRepository;

import com.jnit.NGO_Application.service.userService;

@RestController
public class userController implements userService {
 private userRepository userRepository;

 public userController(userRepository userRepository) {
     this.userRepository = userRepository;
 }
@PostMapping("/saveUser")
 public user createUser(String first_name, String last_name, String email, String password, String role) {
     user newUser = new user();
     return userRepository.save(newUser);
 }
@GetMapping("/getUser")
 public user getUserById(int userId) {
     return userRepository.findById(userId);
 }
@GetMapping("/users")
public List<user> getUser() {
	return userRepository.findAll();
	}
//@PutMapping("/userId")
// public void updateUser(user user) {
//     userRepository.update(user);
// }
//@DeleteMapping("/deleteId")
// public void deleteUser(int userId) {
//     userRepository.delete(userId);
// }
}
