package com.tap.daoimplementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.tap.dao.RestaurantDAO;
import com.tap.model.Restaurant;
import com.tap.utility.DBConnection;

public class RestaurantDAOImpl implements RestaurantDAO {

	
	private static final String INSERT_RESTAURANT_QUERY="INSERT into `restaurant`(`name`,`address`,`phone`,`rating`,`cusineType`,`isActive`,`deliveryTime`,``adminUserId,`imagePath`)values(?,?,?,?,?,?,?,?,?)";
	private static final String GET_RESTAURANT_QUERY="SELECT * from `restaurant` WHERE `restaurantId`=?";
	//private static final String UPDATE_RESTAURANT_QUERY="UPDATE `restaurant` SET `name`=? `address`=? `phone`=? `isActive`=? `deliveryTime`=? `cusineType`=? `imagePath`=? `rating`=? where `restaurantId'=?";
	private static final String UPDATE_RESTAURANT_QUERY = "UPDATE restaurant SET name= ?, address = ? , phone = ? , rating = ? , cusineType = ? , isActive = ? , deliveryTime = ? , adminUserId = ? , imagePath = ? WHERE restaurantId = ?";
	private static final String DELETE_QUERY="DELETE FROM `restaurant` WHERE `restaurantId`=?";
	private final static String GET_ALL_RESTAURANTS_QUERY="SELECT * FROM `restaurant`";
	
	
	@Override
	public void addRestaurant(Restaurant restaurant) {
		
		//driver loaded, connection established
		
		try(Connection con=DBConnection.getConnection();
			PreparedStatement pstmt=con.prepareStatement(INSERT_RESTAURANT_QUERY);	) {
			pstmt.setString(1, restaurant.getName());
			pstmt.setString(2,restaurant.getAddress());
			pstmt.setString(3, restaurant.getPhone());
			pstmt.setDouble(4, restaurant.getRating());
			pstmt.setString(5, restaurant.getCusineType());
			pstmt.setBoolean(6, restaurant.getisActive());
			pstmt.setInt(7, restaurant.getdeliveryTime());
			pstmt.setInt(8, restaurant.getAdminUserId());
			pstmt.setString(9,restaurant.getImagePath());
			
			
			int res=pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
	}

	@Override
	public Restaurant getRestaurant(int restaurantId) {
		
		
		Restaurant restaurant = null;
		
		//driver loaded, connection established
		try(Connection con=DBConnection.getConnection();
				PreparedStatement pstmt=con.prepareStatement(GET_RESTAURANT_QUERY);	) 
		{
			pstmt.setInt(1, restaurantId);
			ResultSet resultSet=pstmt.executeQuery();
			resultSet.next();
			restaurant=extractRestaurant(resultSet);
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return restaurant;
	}
	
	
	

	@Override
	public void updateRestaurant(Restaurant restaurant) {
		try(Connection con=DBConnection.getConnection();
				PreparedStatement pstmt=con.prepareStatement(UPDATE_RESTAURANT_QUERY);	) {
			pstmt.setString(1, restaurant.getName());
			pstmt.setString(2, restaurant.getAddress());
			pstmt.setString(3, restaurant.getPhone());
			pstmt.setDouble(4, restaurant.getRating());
			pstmt.setString(5, restaurant.getCusineType());
			pstmt.setBoolean(6, restaurant.getisActive());
			pstmt.setInt(7, restaurant.getdeliveryTime());
			pstmt.setInt(8, restaurant.getAdminUserId());
			pstmt.setString(9, restaurant.getImagePath());
			pstmt.setInt(10, restaurant.getRestaurantId());

	
			
			
			int res=pstmt.executeUpdate();
			
			
		
	}catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}

	@Override
	public void deleteRestaurant(int restaurantId) {
		try(Connection con=DBConnection.getConnection();
				PreparedStatement pstmt=con.prepareStatement(DELETE_QUERY);	) {
			pstmt.setInt(1, restaurantId);
			int res=pstmt.executeUpdate();
			}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Restaurant> getAllRestaurants() {

		List<Restaurant> restaurantsList=new ArrayList<Restaurant>();
		try(Connection con=DBConnection.getConnection();
			Statement stmt=con.createStatement();) {
			
			ResultSet resultSet=stmt.executeQuery(GET_ALL_RESTAURANTS_QUERY);
			
			while(resultSet.next()) {
				Restaurant restaurant=extractRestaurant(resultSet);         
				restaurantsList.add(restaurant);
			
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
		return restaurantsList;
	}

	
	
	private Restaurant extractRestaurant(ResultSet resultSet) throws SQLException{
		
		
		 int restaurantId=resultSet.getInt("restaurantId");
	     String name=resultSet.getString("name");
		 String address=resultSet.getString("address");
		 String phone=resultSet.getString("phone");
		 Double rating=resultSet.getDouble("rating");
		 String cusineType=resultSet.getString("cusineType");
		 Boolean isActive=resultSet.getBoolean("isActive");
		 int  deliveryTime=resultSet.getInt("deliveryTime");
		 int adminUserId=resultSet.getInt("adminUserId");
		 String imagePath=resultSet.getString("imagePath");
		                                                               
		 //Restaurant restaurant =new Restaurant(restaurantId, name, address, phone, rating, cusineType, isActive, eta, restaurantId, cusineType);
		// Restaurant restaurant=new Restaurant(restaurantId, name, address, phone, rating, cusineType, isActive, deliveryTime, restaurantId, imagePath);
		 Restaurant restaurant =new Restaurant(restaurantId, name, address, phone, rating, cusineType, isActive, deliveryTime, adminUserId, imagePath);
		return restaurant;
		
	}


}
