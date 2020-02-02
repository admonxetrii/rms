package com.restaurant.rbs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.restaurant.rbs.model.User;
import com.restaurant.rbs.util.DbConnection;

public class UserDaoImplement implements UserDao {
	public static final String INSERT_SQL = "insert into users(uname,pword)values(?,?)";
	public static final String SELECT_SQL = "select * from users";
	public static final String DELETE_SQL = "delete from users where id = ?";
	public static final String EDIT_SQL = "update users set uname = ?, pword=? where id=?";

	@Override
	public int createUser(User user) {
		int saved = 0;
		try (Connection con = DbConnection.getConnection(); PreparedStatement ps = con.prepareStatement(INSERT_SQL);) {
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getPassword());
			saved = ps.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return saved;
	}

	@Override
	public int updateUser(User user) {
		int updated = 0;
		try(
				Connection con = DbConnection.getConnection();
				PreparedStatement ps = con.prepareStatement(EDIT_SQL);
				){
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getPassword());
			ps.setInt(3, user.getId());
			updated = ps.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} 
		return updated;
	}

	@Override
	public List<User> getAllUsers() {
		List<User> userList = new ArrayList<>();
		try (Connection con = DbConnection.getConnection(); PreparedStatement ps = con.prepareStatement(SELECT_SQL);) {
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				User user = new User();
				user.setId(rs.getInt("id"));
				user.setUsername(rs.getString("uname"));
				user.setPassword(rs.getString("pword"));
				userList.add(user);
			}

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return userList;
	}

	@Override
	public void deleteUser(int id) {
		try (Connection con = DbConnection.getConnection(); PreparedStatement ps = con.prepareStatement(DELETE_SQL);) {

			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (ClassNotFoundException |SQLException e) {
			e.printStackTrace();
		}
	}

}
