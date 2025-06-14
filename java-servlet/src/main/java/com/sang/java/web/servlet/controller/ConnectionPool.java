package com.sang.java.web.servlet.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Vector;

public class ConnectionPool {
	private Vector<Connection> pool;
	private int poolSize;
	private String driverClass;
	private String url;
	private String username;
	private String password;
	
	public ConnectionPool(int poolSize, String driverClass, String url, 
			String username, String password) {
		System.out.println("ConnectionPool#ConnectionPool() pool object created.");
		pool = new Vector<Connection>(poolSize);
		this.poolSize = poolSize;
		this.driverClass = driverClass;
		this.url = url;
		this.username = username;
		this.password = password;
	}
	
	/**
	 * Initialize the connection object to a specific database.
	 * Then add the connection object to the connection pool.
	 * Connection pool is collection of different database connection objects.
	 * 
	 */
	public void init() {
		System.out.println("ConnectionPool#init() populates pool with connection objects.");
		try {
			Class.forName(driverClass);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		Connection con = null;
		for(int i=0; i<poolSize; i++) {
			try {
				con = DriverManager.getConnection(url, username, password);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			if(con != null) {
				pool.add(con);
				con = null;
			}
		}
	}
	
	/**
	 * checkIn method is to write new connection object into the pool if
	 * pool.size() is less than poolSize
	 * if pool.size() is greater than poolSize then
	 * close the current connection object
	 * @param con
	 */
	public void checkIn(Connection con) {
		System.out.println("ConnectionPool#checkIn() sets back one connection object to pool.");
		if(con instanceof Connection) {
			if(pool.size() < poolSize) {
				pool.add(con);
			}
		} else {
			try {
				con.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * checkOut method is to read connection object from the pool if
	 * pool.size() is greater than 0
	 * and remove the connection object at 0th place in the pool
	 * else if the pool has no connection object
	 * then create a new connection object and return it but don't write back to pool
	 * @return
	 */
	public Connection checkOut() {
		System.out.println("ConnectionPool#checkout() reading one connection object from pool.");
		Connection con = null;
		if(pool.size() > 0) {
			con = (Connection) pool.get(0);
			pool.remove(0);
		} else {
			try {
				con = DriverManager.getConnection(url, username, password);
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		return con;
	}
	
	/**
	 * release method is to release the connection objects stored in the pool
	 */
	public void release() {
		Connection con = null;
		for(int i=0; i < pool.size(); i++) {
			con = (Connection) pool.get(0);
			pool.remove(0);
			try {
				con.close();
				con = null;
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
