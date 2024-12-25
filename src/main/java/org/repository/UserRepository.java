package org.repository;

import java.util.List;
import java.util.*;

import org.model.UserModel;

public interface UserRepository {
	public boolean isAddNewUser(UserModel user);
	public Optional<List<UserModel>> getAllUser();
	public boolean deleteUserById(int user_id);
	public boolean updateUserByName(UserModel user);
	public boolean UserLoginByNamePassWard(String name,String password);
	int getUserIdByUserName(String userName);
}