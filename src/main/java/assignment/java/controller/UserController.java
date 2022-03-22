package assignment.java.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import assignment.java.model.FriendRequest;
import assignment.java.model.User;
import assignment.java.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping("/user")
	 
	public List<User> getUsers() {
		List<User> users = userService.getAllUsers();
		return users;
	}

	@GetMapping("/user/{id}")
	 
	public User getUserById(@PathVariable("id") Long id) {
		User user = userService.getUserById(id);
		return user;
	}

	 
	@PostMapping("/user")
	public String addUser(@RequestBody User user) {
		userService.addUser(user);
		return "created";

	}

	 
	@PutMapping("/user/{id}")
	public void updateUserById(@RequestBody User user) {
		userService.updateUserById(user);

	}

	 
	@DeleteMapping("/user/{id}")
	public void deleteUser(@PathVariable("id") Long id) {
		userService.deleteUserById(id);
	}

	 
	@PostMapping("/addfriend")
	public String addUser(@RequestBody FriendRequest friendRequest) {
		userService.addFriend(friendRequest);
		return "friend created";
	}

	 
	@DeleteMapping("/deletefriend")
	public void deleteFriends(@RequestBody FriendRequest friendRequest) {
		userService.deleteFriend(friendRequest);
	}

	@GetMapping("/users/{id}")
	 
	public List<User> getFriendsByuserId(@PathVariable("id") Long id) {

		List<User> friends = userService.getFriends(id);
		return friends;
	}
	
}
