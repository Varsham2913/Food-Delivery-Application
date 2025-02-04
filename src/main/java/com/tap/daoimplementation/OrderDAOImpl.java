package com.tap.daoimplementation;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.tap.dao.OrderDAO;
import com.tap.model.Order;
import com.tap.utility.DBConnection;

public class OrderDAOImpl implements OrderDAO{

	
	

	private static final String INSERT_ORDER_QUERY = "INSERT into `order`(`userId`, `restaurantId`, `totalAmount`, `status`, `paymentMode`, `address`, `phone`) values(?,?,?,?,?,?,?)";
	private static final String UPDATE_ORDER_QUERY = "UPDATE `order` SET `userId`=?, `restaurantId`=?, `totalAmount`=?, `status`=?, `paymentMode`=?, `address`=?, `phone`=? WHERE `orderId`=?";

	
	private static final String GET_ORDER_QUERY="SELECT * from `order` WHERE `orderId`=?";
	private static final String DELETE_ORDER_QUERY="DELETE FROM `order` WHERE `orderId`=?";
	private final static String GET_ALL_ORDERS_QUERY_BY_USER="SELECT * FROM `order`  WHERE `userId`=?";
	private final static String GET_ALL_ORDERS_QUERY="SELECT * FROM `order`";
	

	
	@Override
	public int addOrder(Order order) {
	
		//driver loaded, connection established
		
		int orderId=0;
		
		try(Connection con=DBConnection.getConnection();
		//	PreparedStatement pstmt=con.prepareStatement(INSERT_ORDER_QUERY);){
			PreparedStatement pstmt=con.prepareStatement(INSERT_ORDER_QUERY,Statement.RETURN_GENERATED_KEYS);){
			
			pstmt.setInt(1,order.getUserId());
			pstmt.setInt(2,order.getRestaurantId());
			pstmt.setDouble(3,order.getTotalAmount());
			pstmt.setString(4, order.getStatus());
			pstmt.setString(5, order.getPaymentMode());
			pstmt.setString(6, order.getAddress());
			pstmt.setString(7, order.getPhone());
			
			int res=pstmt.executeUpdate();
			
			/*
			ResultSet res1=pstmt.getGeneratedKeys();
			
			
			//Retrieve the autoIncrement keys from table-orderId 
			while(res1.next()) {
				  orderId=res1.getInt(1);
			*/
			
			
			try (ResultSet res1 = pstmt.getGeneratedKeys()) { 
			    if (res1.next()) {
			        orderId = res1.getInt(1);
			    }
			}
			
			}
			
			
		
		catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return orderId;
		
	}

	
	
	

	@Override
	public Order getOrder(int orderId) {
		
		 Order  order=null;
		//driver loaded, connection established
				try(Connection con=DBConnection.getConnection();
						PreparedStatement pstmt=con.prepareStatement(GET_ORDER_QUERY);	) 
				{
					pstmt.setInt(1, orderId);
					ResultSet resultSet=pstmt.executeQuery();
					resultSet.next();
					
					// order=extractOrder(resultSet);
					if (resultSet.next()) {
					    order = extractOrder(resultSet);
					} else {
					    return null; // Or throw a custom exception
					}

				}
				catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		
		
		return  order;
	}

	
	
	
	
	@Override
	public void updateOrder(Order order) {
		
		
		try(Connection con=DBConnection.getConnection();
				PreparedStatement pstmt=con.prepareStatement(UPDATE_ORDER_QUERY);	) {
			
			
			pstmt.setInt(1, order.getUserId());
			pstmt.setInt(2, order.getRestaurantId());
			pstmt.setDouble(3, order.getTotalAmount());
			pstmt.setString(4, order.getStatus());
			pstmt.setString(5, order.getPaymentMode());
			pstmt.setString(6, order.getAddress());
			pstmt.setString(7, order.getPhone());
			pstmt.setInt(8, order.getOrderId());
			
		
			int res=pstmt.executeUpdate();
			
			
		
	}catch (SQLException e) {
		
		e.printStackTrace();
	}
		
	}
	
	
	

	@Override
	public void deleteOrder(int orderId) {


		try(Connection con=DBConnection.getConnection();
				PreparedStatement pstmt=con.prepareStatement(DELETE_ORDER_QUERY);	) {
			pstmt.setInt(1, orderId);
			int res=pstmt.executeUpdate();
			}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	
	@Override
	public List<Order> getAllOrdersByUser(int userId) {
	    List<Order> ordersList = new ArrayList<>();

	//    String query = GET_ALL_ORDERS_QUERY_BY_USER;

	    try (Connection connection = DBConnection.getConnection();
	         PreparedStatement prepareStatement = connection.prepareStatement(GET_ALL_ORDERS_QUERY_BY_USER)) {

	        prepareStatement.setInt(1, userId);

	        try (ResultSet resultSet = prepareStatement.executeQuery()) {  // Include ResultSet in try-with-resources
	            while (resultSet.next()) {
	                Order order = extractOrder(resultSet);
	                ordersList.add(order);
	            }
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return ordersList;
	}

	
private Order extractOrder(ResultSet resultSet) throws SQLException{
		
		
		int orderId=resultSet.getInt("orderId");
		int userId =resultSet.getInt("userId");
		int restaurantId =resultSet.getInt("restaurantId");
		Date orderDate=resultSet.getDate("orderDate");
		double totalAmount =resultSet.getDouble("totalAmount");
		String status=resultSet.getString("status");
		String paymentMode=resultSet.getString("paymentMode");
		String address=resultSet.getString("address");
		String phone=resultSet.getString("phone");
		
		//Order order=new Order(orderId, userId, restaurantId, orderDate, totalAmount, status, paymentMode);
		
		//Order order=new Order(orderId, userId, restaurantId, orderDate, totalAmount, status, paymentMode, address);
		
		Order order=new Order(orderId, userId, restaurantId, orderDate, totalAmount, status, paymentMode, address, phone);
		return  order;
		
	}





@Override
public List<Order> getAllOrders() {
	
	Order order;
	ArrayList<Order> orderList=new ArrayList<Order>();
	try(Connection con=DBConnection.getConnection();
		Statement stmt=con.createStatement();) {
		
		ResultSet resultSet=stmt.executeQuery(GET_ALL_ORDERS_QUERY);
		
		while(resultSet.next()) {
			 order=extractOrder(resultSet);         
			orderList.add(order);
		
			
		}
	} catch (SQLException e) {
		
		e.printStackTrace();
	}
	
	return orderList;
	
}
	
		
	

}
