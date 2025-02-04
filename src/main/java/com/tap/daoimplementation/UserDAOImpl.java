package com.tap.daoimplementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.tap.dao.UserDAO;
import com.tap.model.User;
import com.tap.utility.DBConnection;

public class UserDAOImpl implements UserDAO {

	private final static String INSERT_USER_QUERY="INSERT into `user`(`name`,`username`,`password`,`email`,`phone`,`address`,`role`) values (?,?,?,?,?,?,? )";
	private final static String GET_USER_QUERY="SELECT * FROM `user` WHERE `userId`=?";
	private final static String UPDATE_QUERY="UPDATE `user` SET `name`=? `password`=? `phone`=? `address`=? `role`=? where `userId'=?";
	private final static String DELETE_QUERY="DELETE FROM `user` WHERE `useId`=?";
	private final static String GET_ALL_USERS_SQL="SELECT * FROM `user`";
	private static final String GET_USER_BY_EMAIL = "SELECT * FROM user WHERE email = ?";
	
	 

	@Override
	public void addUser(User user) {
		
		
		//follow all 5 steps
		 
		//driver loaded, connection established
		
		
		try( Connection con=DBConnection.getConnection();
			 PreparedStatement pstmt=con.prepareStatement(INSERT_USER_QUERY);) {
			 
			pstmt.setString(1,user.getName());
			pstmt.setString(2,user.getUsername());
			pstmt.setString(3,user.getPassword());
			pstmt.setString(4,user.getEmail());
			pstmt.setString(5,user.getPhone());
			pstmt.setString(6,user.getAddress());
			pstmt.setString(7,user.getRole());
			
			
			int res=pstmt.executeUpdate();
		
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}  
		
		
	}
	
	
	

	@Override
	public User getUser(int userId) {
		
			User user=null;
			//driver loaded, connection established
		 try(Connection con=DBConnection.getConnection();
		     PreparedStatement pstmt=con.prepareStatement(GET_USER_QUERY);) {
			
			 pstmt.setInt(1, userId);
			 ResultSet resultSet = pstmt.executeQuery();
			 
			 resultSet.next();
			 user=extractUser(resultSet);
			 
			
			 
			 
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return user;
	}
	
	
	
	

	@Override
	public void updateUser(User user) {
		
		
		//driver loaded, connection established
		 try(Connection con=DBConnection.getConnection();
		     PreparedStatement pstmt=con.prepareStatement(UPDATE_QUERY);) {
			 
			 pstmt.setString(1,user.getName());
			 pstmt.setString(2,user.getPassword());
			 pstmt.setString(3,user.getPhone());
			 pstmt.setString(4,user.getAddress());
			 pstmt.setString(5,user.getRole());
			 pstmt.setInt(6, user.getUserId());

			 
			int res= pstmt.executeUpdate();
		
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
	
	
	
	

	@Override
	public void deleteUser(int userId) {

			 try(Connection con=DBConnection.getConnection();
				     PreparedStatement pstmt=con.prepareStatement(DELETE_QUERY);) {
				 pstmt.setInt(1,userId);
				 int res=pstmt.executeUpdate();
		} catch (SQLException e) {
		
		e.printStackTrace();
		}
	}

	@Override
	public List<User> getAllUsers() {
		
		
	
		ArrayList<User> usersList=new ArrayList<User>();
		try(Connection con=DBConnection.getConnection();
				Statement stmt=con.createStatement(); ){
			
			ResultSet resultSet=stmt.executeQuery(GET_ALL_USERS_SQL);
			
			while(resultSet.next()) {
				User user=extractUser(resultSet);         
				 usersList.add(user);
			
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
		
		return usersList;
	}
	
	private User extractUser(ResultSet resultSet) throws SQLException{
		
		
		 int userId=resultSet.getInt("userId");
	     String name=resultSet.getString("name");
		 String username=resultSet.getString("username");
		 String password=resultSet.getString("password");
		 String email=resultSet.getString("email");
		 String phone=resultSet.getString("phone");
		 String address=resultSet.getString("address");
		 String role=resultSet.getString("role");
		                                                               
		 User user =new User(userId, name, username, password, email, phone, address, role, null, null);
		
		return user;
		
	}
	
	@Override
	public User getUserByEmail(String email) {
		
		User user=null;
		try (Connection connection = DBConnection.getConnection();
				PreparedStatement prepareStatement = connection.prepareStatement(GET_USER_BY_EMAIL)){

			prepareStatement.setString(1, email);

			 ResultSet resultSet = prepareStatement.executeQuery();

			if(resultSet.next()) {
			  user = extractUser(resultSet);
			}
			else {
				user = null;
			}



		}
		catch(SQLException e) {
			e.printStackTrace();
		}

		return user;	
	}
	
	
	
	
	public boolean updateLastLoginDate(int userId, Timestamp lastLoginDate) {
	    String query = "UPDATE user SET lastLoginDate = ? WHERE userId = ?";
	    try (Connection connection = DBConnection.getConnection();
	         PreparedStatement preparedStatement = connection.prepareStatement(query)) {
	         
	        preparedStatement.setTimestamp(1, lastLoginDate);
	        preparedStatement.setInt(2, userId);

	        int rowsUpdated = preparedStatement.executeUpdate();
	        return rowsUpdated > 0;
	        
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return false;
	}
	
	
	

}
