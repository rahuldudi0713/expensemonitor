package com.expense.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.expense.model.Details;

public class DetailsDAO {
	
	private String jdbcURl="jdbc:mysql://localhost:3306/userdetailsdb";
	private String jdbcUserName="root";
	private String jdbcPassword="";
	
	private static final String INSERT_USER_SQL="INSERT INTO userdetailsdb"+"(S_No,UserName,Email,Passwd) VALUES "+"(?,?,?,?);";
	private static final String SELECT_USER_BY_ID="SELECt * FROM DETAILS WHERE S_No=?;";
	private static final String SELECT_ALL_USERS="SELECT * FROM DETAILS;";
	private static final String DELETE_USERS_SQL="DELETE FROM DETAILS WHERE S_No=?;";
	private static final String UPDATE_USERS_SQL="UPDATE DETAILS SET UserName=?, Email=?, Passwd=? where S_No=?;";
	
	public DetailsDAO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Connection getConnection()
	{
		Connection connection=null;
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection=DriverManager.getConnection(jdbcURl, jdbcUserName, jdbcPassword);
		}
		
		catch(SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return connection;
	}
	
	public void insertUser(Details details) 
	{
		DetailsDAO dao=new DetailsDAO();
		
		try(Connection connection= dao.getConnection()){
			PreparedStatement preparedStatement=connection.prepareStatement(INSERT_USER_SQL);
			preparedStatement.setInt(1,details.getS_No());
			preparedStatement.setString(2,details.getUserName());
			preparedStatement.setString(3,details.getEmail());
			preparedStatement.setString(4,details.getPasswd());
			
			preparedStatement.executeUpdate();
			
		}
		catch(Exception e){
			e.printStackTrace();  
		}
	}
	
	public Details selectUser(int S_No) {
		Details details=new Details();
		DetailsDAO dao=new DetailsDAO();
		try(Connection connection= dao.getConnection()){
			PreparedStatement preparedStatement=connection.prepareStatement(SELECT_USER_BY_ID);
			preparedStatement.setInt(1,S_No);
			
			ResultSet resultSet=preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				details.setS_No(S_No);
				details.setUserName(resultSet.getString("UserName"));
				details.setEmail(resultSet.getString("Email"));
				details.setPasswd(resultSet.getString("Passwd"));
			
			}
		}
		catch(Exception e){
			e.printStackTrace();  
		}  
		return details;
	}
	
	public List<Details> selectAllUsers(){
		List<Details> details=new ArrayList<Details>(); 
		DetailsDAO dao=new DetailsDAO();
		
		try(Connection connection= dao.getConnection()){
			PreparedStatement preparedStatement=connection.prepareStatement(SELECT_ALL_USERS);
			ResultSet resultSet=preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				int S_No=resultSet.getInt("S_No");
				String UserName=resultSet.getString("UserName");
				String Email=resultSet.getString("Email");
				String Passwd=resultSet.getString("Passwd");
				
				details.add(new Details(S_No,UserName,Email,Passwd));
				
				
			}
		}
		catch(Exception e){
			e.printStackTrace();  
		}  
		return details;
	}
	
	public boolean deleteUser(int S_No) {
		boolean status=false;
		DetailsDAO dao=new DetailsDAO();
		
		try(Connection connection= dao.getConnection()){
			PreparedStatement preparedStatement=connection.prepareStatement(DELETE_USERS_SQL);
			preparedStatement.setInt(1, S_No);
			
			status=preparedStatement.execute();
			
		}
		catch(Exception e){
			e.printStackTrace();  
		}  
		return status; 
	}
	
	public void updateuser(Details details) {
		DetailsDAO dao=new DetailsDAO();
		
		try(Connection connection= dao.getConnection()){
			PreparedStatement preparedStatement=connection.prepareStatement(UPDATE_USERS_SQL);
			preparedStatement.setInt(1,details.getS_No());
			preparedStatement.setString(2,details.getUserName());
			preparedStatement.setString(3,details.getEmail());
			preparedStatement.setString(4,details.getPasswd());
			
			preparedStatement.executeUpdate();
			
		}
		catch(Exception e){
			e.printStackTrace(); 
		} 

		
	}
}
