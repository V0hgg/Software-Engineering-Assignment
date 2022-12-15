package com.uwc.spring.UWC.Dao;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.*;

import com.uwc.spring.UWC.Model.*;
public class McpDao {
	private UtilDb utilDb;

	public McpDao() {
		utilDb = new UtilDb();
		utilDb.connect();
	}
	
	public List<Mcp> getAllMcp(){
		
		ArrayList<Mcp> list = new ArrayList<Mcp>();
		String sql = "SELECT * FROM MCP";
		Statement stm;

		try {
			stm = utilDb.getConnection().createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while (rs.next()) {
				Mcp temp = new Mcp();
				temp.setId(rs.getString("ID_MCP"));
				temp.setName(rs.getString("Name_MCP"));
				list.add(temp);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public Mcp getById(String id) {
		String sql = "SELECT * FROM MCP where ID_MCP = ?";
		try {
			PreparedStatement pre = utilDb.getConnection().prepareStatement(sql);
			pre.setString(1, id);
			ResultSet rs = pre.executeQuery();
			if (rs.next()) {
				Mcp temp = new Mcp();
				temp.setId(id);
				temp.setName(rs.getString("Name_MCP"));
				return temp;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public Mcp getByName(String name) {
		String sql = "SELECT * FROM MCP where Name_MCP = ?";
		try {
			PreparedStatement pre = utilDb.getConnection().prepareStatement(sql);
			pre.setString(1, name);
			ResultSet rs = pre.executeQuery();
			if (rs.next()) {
				Mcp temp = new Mcp();
				temp.setId(rs.getString("ID_MCP"));
				temp.setName(name);
				return temp;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
