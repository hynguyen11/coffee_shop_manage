	package com.cafeshopmanage.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cafeshopmanage.entity.Category;
import com.cafeshopmanage.model.CategoryModel;
import com.cafeshopmanage.repository.CategoryRepository;
import com.cafeshopmanage.utils.MapperUtils;

@Service
public class CategoryService {

	@Autowired
	CategoryRepository categoryRepository;

	public List<CategoryModel> getAllCategory() {
		List<CategoryModel> listCategoryModel = new ArrayList<>();
		List<Category> listCategory = categoryRepository.findAll();
		for (Category category : listCategory) {
			CategoryModel categoryModel = new CategoryModel();
			MapperUtils.map(category, categoryModel);
			listCategoryModel.add(categoryModel);
		}
		return listCategoryModel;
	}
	
	public CategoryModel getCategory(Integer id) {
		Optional<Category> category = categoryRepository.findById(id);
		if (category.isPresent()) {
			CategoryModel model = new CategoryModel();
			MapperUtils.map(category.get(), model);
			return model;
		}
		return new CategoryModel();
	}
	
	public void createUpdateCategory(CategoryModel categoryModel) {
		Category category = null;
		if (categoryModel.getId() != null) {
			Optional<Category> categoryEntity = categoryRepository.findById(categoryModel.getId());
			if (categoryEntity.isPresent()) {
				category = categoryEntity.get();
			}
		}
		if (category == null) {
			category = new Category();
		}

		MapperUtils.map(categoryModel, category);
		categoryRepository.save(category);
	}

	public void deleteCategory(CategoryModel categoryModel) {
		categoryRepository.deleteById(categoryModel.getId());
	}
}
