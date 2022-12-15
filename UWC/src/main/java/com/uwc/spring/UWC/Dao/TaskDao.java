package com.uwc.spring.UWC.Dao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.*;
import java.sql.Date;
import com.uwc.spring.UWC.Model.*;

public class TaskDao {
	private UtilDb utilDb;
	private UserDao userDao = new UserDao();
	private McpDao mcpDao = new McpDao();

	public TaskDao() {
		utilDb = new UtilDb();
		utilDb.connect();
	}
	
	public List<Task> getByDay(Date c_day) {
		ArrayList<Task> list = new ArrayList<Task>();
		String sql = "SELECT * FROM TASK where Date_task = ?";
		try {
			PreparedStatement pre = utilDb.getConnection().prepareStatement(sql);
			pre.setDate(1,  c_day);
			ResultSet rs = pre.executeQuery();
			while (rs.next()) {
				Task temp = new Task();
				temp.setId_janitor(rs.getString("ID_JANITOR"));
				temp.setId_collector(rs.getString("ID_COLLECTOR"));
				temp.setId_mcp(rs.getString("ID_MCP"));
				temp.setDate_task(rs.getDate("DATE_TASK"));
				
				temp.setCollector(userDao.getById(rs.getString("ID_COLLECTOR")));
				temp.setJanitor(userDao.getById(rs.getString("ID_JANITOR")));
				temp.setMcp(mcpDao.getById(rs.getString("ID_MCP")));
				
				list.add(temp);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
		
	}

	public List<Task> getByDayAndIdMcp(Date c_day, String idMcp) {
		ArrayList<Task> list = new ArrayList<Task>();
		String sql = "SELECT * FROM TASK where Date_task = ? and ID_MCP = ?";
		try {
			PreparedStatement pre = utilDb.getConnection().prepareStatement(sql);
			pre.setDate(1,  c_day);
			pre.setString(2,  idMcp);
			ResultSet rs = pre.executeQuery();
			while (rs.next()) {
				Task temp = new Task();
				temp.setId_janitor(rs.getString("ID_JANITOR"));
				temp.setId_collector(rs.getString("ID_COLLECTOR"));
				temp.setId_mcp(rs.getString("ID_MCP"));
				temp.setDate_task(rs.getDate("DATE_TASK"));
				
				temp.setCollector(userDao.getById(rs.getString("ID_COLLECTOR")));
				temp.setJanitor(userDao.getById(rs.getString("ID_JANITOR")));
				temp.setMcp(mcpDao.getById(rs.getString("ID_MCP")));
				
				list.add(temp);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
		
	}
	
	public boolean deleteTaskByMcpAndDay(String idMcp, Date c_day) {
		String sql = "DELETE  FROM TASK WHERE ID_MCP = ? and Date_task = ?";
		try {
			PreparedStatement pre = utilDb.getConnection().prepareStatement(sql);
			pre.setString(1,  idMcp);
			pre.setDate(2,  c_day);
			int rs = pre.executeUpdate();
			if(rs > 0) {
				return true;
			}

		} catch (SQLException e) {
			System.out.print(e);
		}
		
		return false;
	}

	public List<Task> getByIdCollectorAndDay(String idCollector, Date c_day){
		ArrayList<Task> list = new ArrayList<Task>();
		String sql = "SELECT * FROM TASK where Date_task = ? and ID_COLLECTOR = ?";
		try {
			PreparedStatement pre = utilDb.getConnection().prepareStatement(sql);
			pre.setDate(1,  c_day);
			pre.setString(2,  idCollector);
			ResultSet rs = pre.executeQuery();
			while (rs.next()) {
				Task temp = new Task();
				temp.setId_janitor(rs.getString("ID_JANITOR"));
				temp.setId_collector(rs.getString("ID_COLLECTOR"));
				temp.setId_mcp(rs.getString("ID_MCP"));
				temp.setDate_task(rs.getDate("DATE_TASK"));
				
				temp.setCollector(userDao.getById(rs.getString("ID_COLLECTOR")));
				temp.setJanitor(userDao.getById(rs.getString("ID_JANITOR")));
				temp.setMcp(mcpDao.getById(rs.getString("ID_MCP")));
				
				list.add(temp);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public List<Mcp> getMcpByIdCollectorAndDay(String idCollector, Date c_day){
		ArrayList<Mcp> list = new ArrayList<Mcp>();
		String sql = "SELECT ID_MCP FROM TASK where Date_task = ? and ID_COLLECTOR = ? GROUP BY ID_MCP";
		try {
			PreparedStatement pre = utilDb.getConnection().prepareStatement(sql);
			pre.setDate(1,  c_day);
			pre.setString(2,  idCollector);
			ResultSet rs = pre.executeQuery();
			McpDao mcpDao = new McpDao();
			while (rs.next()) {
				Mcp temp = new Mcp();
				temp = mcpDao.getById(rs.getString("ID_MCP"));
				list.add(temp);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public List<User> getJanitorByIdCollectorAndDay(String idCollector, Date c_day){
		ArrayList<User> list = new ArrayList<User>();
		String sql = "SELECT ID_JANITOR FROM TASK where Date_task = ? and ID_COLLECTOR = ? GROUP BY ID_JANITOR";
		try {
			PreparedStatement pre = utilDb.getConnection().prepareStatement(sql);
			pre.setDate(1,  c_day);
			pre.setString(2,  idCollector);
			ResultSet rs = pre.executeQuery();
			UserDao userDao = new UserDao();
			while (rs.next()) {
				User temp = userDao.getById(rs.getString("ID_JANITOR"));
				list.add(temp);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public List<User> getJaniFreeInDay(Date c_day){
		ArrayList<User> list = new ArrayList<User>();
		String sql = "SELECT * FROM user_web where POSITION_USER = 'Janitor' and ID_USER not in(SELECT ID_JANITOR FROM TASK where Date_task = ? GROUP BY ID_JANITOR);";
		try {
			PreparedStatement pre = utilDb.getConnection().prepareStatement(sql);
			pre.setDate(1,  c_day);
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
	
	public boolean addJaniToTask(String idCollector, String idMcp, String idJani, Date c_day) {
		String sql = "INSERT INTO TASK VALUES (?,?,?,?);";
		try {
			PreparedStatement pre = utilDb.getConnection().prepareStatement(sql);
			pre.setString(1,  idCollector);
			pre.setString(2,  idJani);
			pre.setString(3,  idMcp);
			pre.setDate(4,  c_day);
			int rs = pre.executeUpdate();
			if(rs > 0) {
				return true;
			}

		} catch (SQLException e) {
			System.out.print(e);
		}
		
		return false;
	}
	
	public String getIdCollectorByJaniAndDay(String idJani, Date c_day) {
		
		String sql = "SELECT ID_Collector FROM TASK WHERE ID_JANITOR= ? and  DATE_TASK= ?";
		try {
			PreparedStatement pre = utilDb.getConnection().prepareStatement(sql);
			pre.setString(1,  idJani);
			pre.setDate(2,  c_day);
			ResultSet rs = pre.executeQuery();
			if (rs.next()) {
				return rs.getString("ID_Collector");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public boolean removeJaniFormTask(String idJani, Date c_day) {
		String sql = "DELETE  FROM TASK WHERE ID_JANITOR = ? and Date_task = ?";
		try {
			PreparedStatement pre = utilDb.getConnection().prepareStatement(sql);
			pre.setString(1,  idJani);
			pre.setDate(2,  c_day);
			int rs = pre.executeUpdate();
			if(rs > 0) {
				return true;
			}

		} catch (SQLException e) {
			System.out.print(e);
		}
		
		return false;
	}

}
