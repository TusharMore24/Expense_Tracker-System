package org.service;

import java.util.List;
import java.util.Optional;

import org.model.UserModel;

public interface UserService {
	public boolean isAddNewUser(UserModel user);
	public Optional<List<UserModel>> getAllUser();
	public boolean deleteUserById(int user_id);
	public boolean updateUserByName(UserModel user);
	public boolean UserLoginByNamePassWard(String name, String password);
	public int getUserIdByUserName(String userName);
}
