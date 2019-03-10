package com.perscholas.springmvc_sba.dao;

import java.sql.*; // 1st step

import com.perscholas.springmvc_sba.models.User;

public class UserDAO {
	
    private int userId;
    private String userName;
    private String url;
    private String password;
    private String user;
    private String pass;
    private Connection jdbcConnection;
     
    public UserDAO(String url, String user, String pass) {
        this.url = url;
        this.user = user;
        this.pass = pass;
    }
    
    public UserDAO() {
    	
    }
	// 2nd step load and register driver
	public Connection getConnection() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String url = "jdbc:oracle:thin:@localhost:1521:orcl";
		String user = "student";
		String password = "123";

		// 3rd step is create connection
		Connection conn = null; // declare connection object here
		try {
			conn = DriverManager.getConnection(url, user, password);
			return conn;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public User getUserByUserName(String userName)  {
		Connection conn = getConnection();
		// 4th step is create statement
		PreparedStatement pst = null;
		try {
			pst = conn.prepareStatement("select * from users where userName=?");
			pst.setString(1,userName);
			// 5th step is Execute query
			ResultSet rs = null;
			rs = pst.executeQuery();
			User user = null;
			// 6th step is process ResultSet
			while (rs.next()) {
				user = new User();
				user.userId = rs.getInt("userId");
				user.userName = rs.getString("userName");
				user.password = rs.getString("password");
			}
			// 7th, and final, step is close connection and other resources
			conn.close();
			return user;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public int registerUser(User user) throws SQLException {		
			Connection conn = null;
		    PreparedStatement stmt = null;
		    ResultSet result = null;
		    
		    String SAVE = "INSERT INTO users "
		            + "(userName, password) "
		            + "VALUES(?, ?)";
		    
		    int ID = -1;
		    String[] COL = {"userId"};
		    
		    conn = getConnection();
		    try
		    {
		        conn = getConnection();
		        stmt = conn.prepareStatement(SAVE, COL);
		        stmt.setString(1, user.getUserName());
		        stmt.setString(2, user.getPassword());
		        
		        stmt.executeUpdate();
		        result = stmt.getGeneratedKeys();
		        if(result != null && result.next()) {
		            userId = result.getInt(1);
		        }
		        System.out.println(userId);
		    }
		    catch (SQLException e)
		    {
		        e.printStackTrace();
		    }
		    finally {
		    	if (result != null) {
		    		result.close();
		    	}
		    	if (stmt != null) {
		    		stmt.close();
		    	}
		    	if (conn != null) {
		    		conn.close();
		    	}
		    }        
		return userId;
	}
}
