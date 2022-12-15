package com.uwc.spring.UWC.Dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.uwc.spring.UWC.Model.*;

public class UserDao {
	private UtilDb utilDb;

	public UserDao() {
		utilDb = new UtilDb();
		utilDb.connect();
	}

	public List<User> getAllUser() {
		ArrayList<User> list = new ArrayList<User>();
		String sql = "SELECT * FROM user_web";
		Statement stm;

		try {
			stm = utilDb.getConnection().createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while (rs.next()) {
				User temp = new User();
				temp.setId_user(rs.getString("id_user"));
				temp.setName(rs.getString("name_user"));
				temp.setUsername(rs.getString("username"));
				temp.setPassword(rs.getString("password"));
				temp.setPosition_user(rs.getString("POSITION_USER"));
				temp.setDob(rs.getDate("dob"));
				list.add(temp);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public User checkLogin(User user) {
		String sql = "SELECT * FROM user_web where username = ? and password = ?";
		try {
			PreparedStatement pre = utilDb.getConnection().prepareStatement(sql);
			pre.setString(1, user.getUsername());
			pre.setString(2, user.getPassword());
			ResultSet rs = pre.executeQuery();
			if (rs.next()) {
				User temp = new User();
				temp.setId_user(rs.getString("id_user"));
				temp.setName(rs.getString("name_user"));
				temp.setUsername(rs.getString("username"));
				temp.setPassword(rs.getString("password"));
				temp.setPosition_user(rs.getString("POSITION_USER"));
				temp.setDob(rs.getDate("dob"));
				return temp;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public User getById(String id) {
		String sql = "SELECT * FROM user_web where ID_USER = ?";
		try {
			PreparedStatement pre = utilDb.getConnection().prepareStatement(sql);
			pre.setString(1, id);
			ResultSet rs = pre.executeQuery();
			if (rs.next()) {
				User temp = new User();
				temp.setId_user(rs.getString("id_user"));
				temp.setName(rs.getString("name_user"));
				temp.setUsername(rs.getString("username"));
				temp.setPassword(rs.getString("password"));
				temp.setPosition_user(rs.getString("POSITION_USER"));
				temp.setDob(rs.getDate("dob"));
				return temp;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public List<User> getByPosition(String position) {
		ArrayList<User> list = new ArrayList<User>();
		String sql = "SELECT * FROM user_web where POSITION_USER = ?";
		try {
			PreparedStatement pre = utilDb.getConnection().prepareStatement(sql);
			pre.setString(1, position);
			ResultSet rs = pre.executeQuery();
			while (rs.next()) {
				User temp = new User();
				temp.setId_user(rs.getString("id_user"));
				temp.setName(rs.getString("name_user"));
				temp.setUsername(rs.getString("username"));
				temp.setPassword(rs.getString("password"));
				temp.setPosition_user(rs.getString("POSITION_USER"));
				temp.setDob(rs.getDate("dob"));
				list.add(temp);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
}
