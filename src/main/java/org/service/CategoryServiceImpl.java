package org.service;

import java.util.List;

import org.model.CategoryModel;
import org.repository.CategoryRepository;
import org.repository.CategoryRepositoryImpl;

public class CategoryServiceImpl implements CategoryService {
   CategoryRepository cr= new CategoryRepositoryImpl();
	@Override
	public boolean AddNewCategory(CategoryModel model) {
		// TODO Auto-generated method stub
		return cr.AddNewCategory(model);
	}
	@Override
	public List<CategoryModel> AllCatrgory() {
		// TODO Auto-generated method stub
		return cr.AllCatrgory();
	}

}
