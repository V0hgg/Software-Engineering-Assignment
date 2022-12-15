package com.uwc.spring.UWC.Model;

import java.util.*;

public class Task {
	private String id_collector;
	private String id_janitor;
	private String id_mcp;
	private Date date_task;
	
	private Mcp mcp;
	private User janitor;
	private User collector;
	
	
	
	
	public Mcp getMcp() {
		return mcp;
	}
	public void setMcp(Mcp mcp) {
		this.mcp = mcp;
	}
	public User getJanitor() {
		return janitor;
	}
	public void setJanitor(User janitor) {
		this.janitor = janitor;
	}
	public User getCollector() {
		return collector;
	}
	public void setCollector(User collector) {
		this.collector = collector;
	}
	public String getId_collector() {
		return id_collector;
	}
	public void setId_collector(String id_collector) {
		this.id_collector = id_collector;
	}
	public String getId_janitor() {
		return id_janitor;
	}
	public void setId_janitor(String id_janitor) {
		this.id_janitor = id_janitor;
	}
	public String getId_mcp() {
		return id_mcp;
	}
	public void setId_mcp(String id_mcp) {
		this.id_mcp = id_mcp;
	}
	public Date getDate_task() {
		return date_task;
	}
	public void setDate_task(Date date_task) {
		this.date_task = date_task;
	}
	
	
}
