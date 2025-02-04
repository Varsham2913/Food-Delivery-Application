package com.tap.daoimplementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.tap.dao.OrderItemDAO;
import com.tap.model.OrderItem;
import com.tap.utility.DBConnection;

public class OrderItemDAOImpl implements OrderItemDAO{

	private static final String INSERT_ORDERITEM_QUERY="INSERT into `orderItem`(`orderId`,`menuId`,`quantity`,`totalPrice`)values(?,?,?,?)";
	private static final String GET_ORDERITEM_QUERY="SELECT * from `orderItem` WHERE `orderItemId`=?";
	private static final String UPDATE_ORDERITEM_QUERY="UPDATE `orderItem` SET `orderId`=?, `menuId`=?, `quantity`=?, `totalPrice`=? WHERE `orderItemId`=?";
	private static final String DELETE_ORDERITEM_QUERY="DELETE FROM `orderItem` WHERE `orderItemId`=?";
	private final static String GET_ALL_ORDERITEMUS_QUERY="SELECT * FROM `orderItem`";
	private final static String GET_ALL_ORDER_ITEM_BY_ORDER_QUERY="SELECT * FROM `orderItem` WHERE `orderId`=? ";
	
	


	
	@Override
	public void addOrderItem(OrderItem orderItem) {

		
	
		//driver loaded, connection established
		
				try(Connection con=DBConnection.getConnection();
					PreparedStatement pstmt=con.prepareStatement(INSERT_ORDERITEM_QUERY);){
					
				
				pstmt.setInt(1, orderItem.getOrderId());
				pstmt.setInt(2, orderItem.getMenuId());
				pstmt.setInt(3, orderItem.getQuantity());
				pstmt.setInt(4, orderItem.getTotalPrice());
						
					int res=pstmt.executeUpdate();
				
				}
				
	 catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
	}

	
	
	
	
	@Override
	public OrderItem getOrderItem(int orderItemId) {
		
		
		OrderItem orderItem=null;
		//driver loaded, connection established
		try(Connection con=DBConnection.getConnection();
				PreparedStatement pstmt=con.prepareStatement(GET_ORDERITEM_QUERY);	) 
		{
			pstmt.setInt(1, orderItemId);
			ResultSet resultSet=pstmt.executeQuery();
			orderItem=extractOrderItem(resultSet);
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return orderItem;
	}
	
	
	
	

	@Override
	public void updateOrderItem(OrderItem orderItem) {



		try(Connection con=DBConnection.getConnection();
				PreparedStatement pstmt=con.prepareStatement(UPDATE_ORDERITEM_QUERY);	) {
			
			
			pstmt.setInt(1, orderItem.getOrderId());
			pstmt.setInt(2, orderItem.getMenuId());
			pstmt.setInt(3, orderItem.getQuantity());
			pstmt.setInt(4, orderItem.getTotalPrice());
			pstmt.setInt(5, orderItem.getOrderItemId());
			
			int res=pstmt.executeUpdate();
			
			
		
	}catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
	}
	
	
	

	@Override
	public void deleteOrderItem(int orderItemId) {
		
		
		try(Connection con=DBConnection.getConnection();
				PreparedStatement pstmt=con.prepareStatement(DELETE_ORDERITEM_QUERY);	) {
			pstmt.setInt(1, orderItemId);
			int res=pstmt.executeUpdate();
			}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	

	@Override
	public List<OrderItem> getAllOrderItemsByOrder(int orderId) {


		ArrayList<OrderItem> orderItemList=new ArrayList<OrderItem>();
		try(Connection con=DBConnection.getConnection();
				PreparedStatement pstmt=con.prepareStatement(GET_ALL_ORDER_ITEM_BY_ORDER_QUERY);) {
			
			pstmt.setInt(1, orderId);
			ResultSet resultSet=pstmt.executeQuery();
			
			while(resultSet.next()) {
				OrderItem orderItem=extractOrderItem(resultSet);         
				orderItemList.add(orderItem);
			
				
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
		
		return orderItemList;
	}
	
	
	
private OrderItem extractOrderItem(ResultSet resultSet) throws SQLException{
		
		
		int orderItemId=resultSet.getInt("orderItemId");
		int orderId =resultSet.getInt("orderId");
		int menuId =resultSet.getInt("menuId");
		int quantity =resultSet.getInt("quantity");
		int totalPrice =resultSet.getInt("totalPrice");
		                                       
		 OrderItem  orderItem=new OrderItem(orderItemId, orderId, menuId, quantity, totalPrice);
		
		return orderItem;
		
	}





@Override
public List<OrderItem> getAllOrderItems() {
	
	ArrayList<OrderItem> orderItemsList = new ArrayList<OrderItem>();

	try(Connection connection = DBConnection.getConnection();
			Statement statement = connection.createStatement()){

		ResultSet resultSet = statement.executeQuery(GET_ALL_ORDERITEMUS_QUERY);
		while(resultSet.next()) {

			 OrderItem orderItem = extractOrderItem(resultSet);
			orderItemsList.add(orderItem);
		}

	}
	catch(SQLException e) {
		e.printStackTrace();
	}
	return orderItemsList;
	
}

}
