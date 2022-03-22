package assignment.java.repo.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;


import assignment.java.dao.UserRepository;
import assignment.java.model.FriendRequest;
import assignment.java.model.User;

@Repository
public class UserRepositoryImpl implements UserRepository  {
	
	@Autowired
	NamedParameterJdbcTemplate npJdbcTemplate;

	@Override
	public List<User> getAllUsers() {
		SqlParameterSource ps = new MapSqlParameterSource();
		String query = "select * from user;";
		List<User> users = npJdbcTemplate.query(query, ps, new BeanPropertyRowMapper<User>(User.class));

		return users;
	}

	@Override
	public User getUserById(Long id) {
		SqlParameterSource ps = new MapSqlParameterSource().addValue("id", id);
		String query = "select * from user where id =:id";
		User user = npJdbcTemplate.queryForObject(query, ps, new BeanPropertyRowMapper<User>(User.class));
		return user;
	}

	@Override
	public void saveUser(User user) {
		SqlParameterSource ps1 = new MapSqlParameterSource();
		String query1 = "select count(id) from user;";
		int id  = 100 + npJdbcTemplate.queryForObject(query1, ps1, Integer.class);
		
		
		SqlParameterSource ps = new MapSqlParameterSource()
				.addValue("id", id)
				.addValue("name", user.getName())
				.addValue("email", user.getEmail());
		
		String query = "INSERT INTO user(id , name, email)\r\n"
				+ "VALUES (:id,:name , :email);";
		npJdbcTemplate.update(query, ps);
		
	}

	@Override
	public void updateUserById(User user) {
		SqlParameterSource ps = new MapSqlParameterSource()
				.addValue("id", user.getId())
				.addValue("name", user.getName())
				.addValue("email", user.getEmail());
		String query = "UPDATE user\r\n"
				+ "SET name =:name , email =:email\r\n"
				+ "WHERE id = :id;\r\n";
		npJdbcTemplate.update(query, ps);

	}

	@Override
	public void deleteUserById(Long id) {
		SqlParameterSource ps = new MapSqlParameterSource().addValue("id", id);
		String query = "delete from user where id=:id";
		npJdbcTemplate.update(query, ps);	

	}

	@Override
	public void addFriend(FriendRequest friendRequest) {
	
		SqlParameterSource ps = new MapSqlParameterSource()
				.addValue("userid1", friendRequest.getUserid1())
				.addValue("userid2", friendRequest.getUserid2());
			
		String query = "INSERT INTO friend(userid1 , userid2)\r\n"
				+ "VALUES (:userid1,:userid2);";
		npJdbcTemplate.update(query, ps);
		
	
		SqlParameterSource ps2 = new MapSqlParameterSource()
				.addValue("userid1", friendRequest.getUserid2())
				.addValue("userid2", friendRequest.getUserid1());
			
		String query2 = "INSERT INTO friend(userid1 , userid2)\r\n"
				+ "VALUES (:userid1,:userid2);";
		npJdbcTemplate.update(query2, ps2);
		
	}

	@Override
	public void deleteFriend(FriendRequest friendRequest) {
		
		SqlParameterSource ps1 = new MapSqlParameterSource()
				.addValue("userid1", friendRequest.getUserid1())
				.addValue("userid2", friendRequest.getUserid2());
		String query1 = "delete from friend where userid1=:userid1 and userid2=:userid2";
		npJdbcTemplate.update(query1, ps1);	

		
		SqlParameterSource ps2 = new MapSqlParameterSource()
				.addValue("userid2", friendRequest.getUserid1())
				.addValue("userid1", friendRequest.getUserid2());
		String query2 = "delete from friend where userid1=:userid1 and userid2=:userid2";
		npJdbcTemplate.update(query2, ps2);	
		
    }

	@Override
	public List<User> findFriends(Long id) {
		SqlParameterSource ps = new MapSqlParameterSource().addValue("id", id)
				.addValue("userid1", id);
		String query = "select * from user where id in (select userid2 from friend where userid1 =:userid1)";
		List<User> friends = npJdbcTemplate.query(query, ps, new BeanPropertyRowMapper<User>(User.class));
		return friends;

	}




}




