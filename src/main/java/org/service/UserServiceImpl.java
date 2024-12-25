package org.service;

import java.util.List;
import java.util.Optional;

import org.model.UserModel;
import org.repository.UserRepository;
import org.repository.UserRepositoryImpl;
public class UserServiceImpl implements UserService {
UserRepository ur= new UserRepositoryImpl();
	@Override
	public boolean isAddNewUser(UserModel user) {
		// TODO Auto-generated method stub
		return ur.isAddNewUser(user);
	}
	@Override
	public Optional<List<UserModel>> getAllUser() {
		return ur.getAllUser();
	}
	@Override
	public boolean deleteUserById(int user_id) {
		
		return ur.deleteUserById(user_id);
	}
	@Override
	public boolean updateUserByName(UserModel user) {
		
		return ur.updateUserByName(user);
	}
	@Override
	public boolean UserLoginByNamePassWard(String name, String password) {
		
		return ur.UserLoginByNamePassWard(name, password);
	}
	@Override
	public int getUserIdByUserName(String userName) {
	    return ur.getUserIdByUserName(userName);
	}

}
