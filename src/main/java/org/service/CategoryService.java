package org.service;

import java.util.List;

import org.model.CategoryModel;

public interface CategoryService {
	public boolean AddNewCategory(CategoryModel model);
	public List<CategoryModel> AllCatrgory();
}
