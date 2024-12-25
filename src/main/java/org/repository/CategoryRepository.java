package org.repository;

import java.util.List;

import org.model.CategoryModel;

public interface CategoryRepository {
	public boolean AddNewCategory(CategoryModel model);
	public List<CategoryModel> AllCatrgory();

}
