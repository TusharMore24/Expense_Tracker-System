package org.repository;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.model.UserModel;

public class UserRepositoryImpl extends DBState implements UserRepository {
	
   private static final Logger logger= LogManager.getFormatterLogger(UserRepositoryImpl.class);
	List<UserModel> list;
	@Override
	public boolean isAddNewUser(UserModel user)  {
		try {
			 stmt=conn.prepareStatement(" insert into  userMaster values('0',?,?,?,?,?) ");
			 stmt.setString(1, user.getUserName());
			 stmt.setString(2, user.getPassWord());
			 stmt.setString(3, user.getEmail());
			 stmt.setString(4, user.getP_number());
			 stmt.setString(5, user.getAddress());
		    int value =stmt.executeUpdate();
		    return value>0 ?true :false;
		    
		}
		catch(SQLException ex) {
			logger.error("UserRepositoryImpl::  SQL Exception generate in isAddNewUser method");
		}
		 return false;
	}

	@Override
	public Optional<List<UserModel>> getAllUser() {
		
		try {
			list =new ArrayList<UserModel>();
			  stmt= conn.prepareStatement("select * from UserMaster");
			  rs= stmt.executeQuery();
			  while(rs.next()) {
				  list.add(new UserModel(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6)));
			  }
			  return list.size() > 0 ? Optional.of(list) : Optional.empty();
			
		}
		catch(SQLException ex) {
			logger.error("UserRepositoryImpl::  SQL Exception generate in getAllUser method");
					}
		
		
		return null;
	}

	@Override
	public boolean deleteUserById(int user_id) {
		try {
			stmt=conn.prepareStatement("delete from userMaster where User_id=?");
			stmt.setInt(1,user_id);
			int value=stmt.executeUpdate();
			return value>0 ? true :false;
		}
		catch(SQLException ex) {
			logger.error("UserRepositoryImpl::  SQL Exception generate in deleteUserById method");
				
		}
		return false;
	}

	@Override
	public boolean updateUserByName(UserModel user) {
		try {
			stmt= conn.prepareStatement("update usermaster set  password=?, email=?, p_number=?, Address=? where userName=? ");
			stmt.setString(1, user.getPassWord());
			stmt.setString(2, user.getEmail());
			stmt.setString(3, user.getP_number());
			stmt.setString(4, user.getAddress());
			stmt.setString(5, user.getUserName());
			int value =stmt.executeUpdate();
			return value>0?true:false;
			
			
		}
		catch(SQLException ex) {
			logger.error("UserRepositoryImpl::  SQL Exception generate in updateUserByName method");
					}
		
		return false;
	}

	@Override
	public boolean UserLoginByNamePassWard(String name, String password) {
		try {
			stmt=conn.prepareStatement("select * from usermaster where username=? and passWord=?");
			stmt.setString(1, name);
			stmt.setString(2, password);
			ResultSet v=stmt.executeQuery();
			 if (v.next()) {
		            return true;
		        } else {
		            return false; 
		        }
		}
		catch(SQLException ex) {
			logger.error("UserRepositoryImpl::  SQL Exception generate in UserLoginByNamePassWard method");
					}
		
		return false;
	}
	@Override
	public int getUserIdByUserName(String userName) {
	    int userId = -1;
	    try {
	        Connection conn = DBConfig.getConnection();
	        String sql = "SELECT User_id FROM usermaster WHERE UserName = ?";
	        PreparedStatement stmt = conn.prepareStatement(sql);
	        stmt.setString(1, userName);
	        ResultSet rs = stmt.executeQuery();
	        if (rs.next()) {
	            userId = rs.getInt("User_id");
	        }
	    } catch (SQLException e) {
	    	logger.error("UserRepositoryImpl::  SQL Exception generate in getUserIdByUserName method");
			
	    }
	    return userId; 
	}


	

}
