package org.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.model.CategoryModel;

public class CategoryRepositoryImpl extends DBState implements CategoryRepository {
    List list;
	@Override
	public boolean AddNewCategory(CategoryModel model) {
		try{
			stmt=conn.prepareStatement("insert into  categories values(?,?,?) ");
			stmt.setInt(1,model.getCategory_id());
			stmt.setString(2, model.getCategory_name());
			stmt.setString(3, model.getDiscrption());
			int value=stmt.executeUpdate();
			return value>0?true:false;
		}
		catch(SQLException ex) {
			System.out.println("Error is"+ex);
		}
		
		return false;
	}

	@Override
	public List<CategoryModel> AllCatrgory() {
		List<CategoryModel> list = new ArrayList<>();

		try {
			stmt= conn.prepareStatement("select * from categories");
			ResultSet v=stmt.executeQuery();
			while(v.next()) {
				list.add( new CategoryModel(v.getInt(1),v.getString(2),v.getString(3)));
				
			}
			return list.size() > 0 ?list :null;
		}
		catch(SQLException ex) {
			System.out.println("Error is"+ex);
		}
		
		return null;
	}

	
}
