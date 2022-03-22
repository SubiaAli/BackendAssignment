package assignment.java.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import assignment.java.dao.UserRepository;
import assignment.java.model.FriendRequest;
import assignment.java.model.User;

@Service
public class UserService {
	

	@Autowired
	private UserRepository userRepository;

	public List<User> getAllUsers() {
		List<User> users = userRepository.getAllUsers();
		return users;
	}

	public User getUserById(Long id) {
		User user = userRepository.getUserById(id);
		return user;
	}

	public void addUser(User user) {
		userRepository.saveUser(user);
		
	}

	public void updateUserById(User user) {
		userRepository.updateUserById(user);
		
	}

	public void deleteUserById(Long id) {
		userRepository.deleteUserById(id);

		
	}

	public void addFriend(FriendRequest friendRequest) {
		userRepository.addFriend(friendRequest);
	}

	public void deleteFriend(FriendRequest friendRequest) {
		userRepository.deleteFriend(friendRequest);
		
	}

	public List<User> getFriends(Long id) {
		List<User> friends= userRepository.findFriends(id);

		return friends;
	}


}


