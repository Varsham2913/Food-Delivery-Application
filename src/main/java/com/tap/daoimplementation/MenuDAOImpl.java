package com.tap.daoimplementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.tap.dao.MenuDAO;
import com.tap.model.Menu;
import com.tap.utility.DBConnection;

public class MenuDAOImpl  implements MenuDAO{

	
	private static final String INSERT_MENU_QUERY="INSERT into `menu`(`restaurantId`,`itemName`,`description`,`price`,`ratings`,`isAvailable`,`imagePath`)values(?,?,?,?,?,?,?)";
	private static final String GET_MENU_QUERY="SELECT * from `menu` WHERE `menuId`=?";
	private static final String UPDATE_MENU_QUERY="UPDATE `menu` SET `restaurantId`=? `itemName`=? `description`=? `price`=? `ratings`=? `isAvailable`=? `imagePath`=? WHERE menuId=?";
	private static final String DELETE_MENU_QUERY="DELETE FROM `menu` WHERE `menuId`=?";
	private final static String GET_RESTAURANT_MENUS_QUERY="SELECT * FROM `menu` WHERE restaurantId=?";
	private final static String GET_ALL_MENUS_QUERY="SELECT * FROM `menu`";
	
	


	@Override
	public void addMenu(Menu menu) {
		
		//driver loaded, connection established
		
				try(Connection con=DBConnection.getConnection();
					PreparedStatement pstmt=con.prepareStatement(INSERT_MENU_QUERY);){
					
					pstmt.setInt(1, menu.getRestaurantId());
					pstmt.setString(2,menu.getItemName());
					pstmt.setString(3, menu.getDescription());
					pstmt.setInt(4, menu.getPrice());
					pstmt.setFloat(5, menu.getRatings());
					pstmt.setBoolean(6, menu.getIsAvailable());
					pstmt.setString(7, menu.getImagePath());
					
					
					int res=pstmt.executeUpdate();
					
					
				}
				
	 catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
				
	}
	
	
	
	
	

	@Override
	public Menu getMenu(int menuId) {
		
		Menu menu=null;
		//driver loaded, connection established
				try(Connection con=DBConnection.getConnection();
						PreparedStatement pstmt=con.prepareStatement(GET_MENU_QUERY);	) 
				{
					pstmt.setInt(1, menuId);
					ResultSet resultSet=pstmt.executeQuery();
					resultSet.next();
					menu=extractMenu(resultSet);
				}
				catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		
		
		return menu;
	}
	
	

	@Override
	public void updateMenu(Menu menu) {
		
		try(Connection con=DBConnection.getConnection();
				PreparedStatement pstmt=con.prepareStatement(UPDATE_MENU_QUERY);	) {
			
			pstmt.setInt(1, menu.getRestaurantId());
			pstmt.setString(2, menu.getItemName());
			pstmt.setString(3, menu.getDescription());
			pstmt.setInt(4, menu.getPrice());
			pstmt.setFloat(5, menu.getRatings());
			pstmt.setBoolean(6, menu.getIsAvailable());
			pstmt.setString(7, menu.getImagePath());
			pstmt.setInt(8, menu.getMenuId());
			
			
	
			int res=pstmt.executeUpdate();
			
			
		
	}catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
		
	}

	@Override
	public void deleteMenu(int menuId) {


		try(Connection con=DBConnection.getConnection();
				PreparedStatement pstmt=con.prepareStatement(DELETE_MENU_QUERY);	) {
			pstmt.setInt(1, menuId);
			int res=pstmt.executeUpdate();
			}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Menu> getAllMenusByRestaurant(int restaurantId) {


		List<Menu> menuList=new ArrayList<Menu>();
		try {
			Connection con=DBConnection.getConnection();
			PreparedStatement stmt=con.prepareStatement(GET_RESTAURANT_MENUS_QUERY);
			stmt.setInt(1, restaurantId);
			
			ResultSet resultSet=stmt.executeQuery();
			
			while(resultSet.next()) {
				Menu menu=extractMenu(resultSet);         
				menuList.add(menu);
			
				
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
		return menuList;
	}
	
	
	
	private Menu extractMenu(ResultSet resultSet) throws SQLException{
		
		
		int menuId=resultSet.getInt("menuId");
		int restaurantId =resultSet.getInt("restaurantId");
		String itemName =resultSet.getString("itemName");
		String description =resultSet.getString("description");
		int price =resultSet.getInt("price");
		float ratings =resultSet.getFloat("ratings");
		Boolean isAvailable =resultSet.getBoolean("isAvailable");
		String imagePath =resultSet.getString("imagePath");
		
		//Menu menu =new Menu(menuId, restaurantId, itemName, description, price, isAvailable, imagePath);                                               
		Menu menu=new Menu(menuId, restaurantId, itemName, description, price,ratings, isAvailable, imagePath);
		
		return menu;
		
	}






	@Override
	public List<Menu> getAllMenu() {
		
			Menu menu;
		ArrayList<Menu> menuList  = new ArrayList<Menu>();
		
		try(Connection connection = DBConnection.getConnection();
				Statement statement = connection.createStatement()){
		

			 ResultSet resultSet =  statement.executeQuery(GET_ALL_MENUS_QUERY);

			while(resultSet.next()) {

				menu = extractMenu(resultSet);

				menuList.add(menu);
			}



		}
		catch(SQLException e) {
			e.printStackTrace();
		}

		return menuList;
	}
	
}
