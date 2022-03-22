package assignment.java.dao;

import java.util.List;

import assignment.java.model.FriendRequest;
import assignment.java.model.User;

public interface UserRepository {

	List<User> getAllUsers();

	User getUserById(Long id);
	
	void saveUser(User user);

	void updateUserById(User user);

void deleteUserById(Long id);

void addFriend(FriendRequest friendRequest);

void deleteFriend(FriendRequest friendRequest);

List<User> findFriends(Long id);



	

}
