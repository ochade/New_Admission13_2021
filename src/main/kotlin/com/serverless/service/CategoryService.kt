package com.serverless.service

import com.serverless.model.Admission
import com.serverless.model.Category
import com.serverless.repository.AdmissionRepositoryImplementation
import com.serverless.repository.CategoryRepositoryImplementation

class CategoryService {
    private val categoryRepositoryImplementation: CategoryRepositoryImplementation = CategoryRepositoryImplementation()

    fun createCategoryTable(){

        categoryRepositoryImplementation.createCategoryTable()
    }
    fun createCategoryService(category: Category){
        categoryRepositoryImplementation.createCategory(category)
    }
    fun updateCategoryTable(category: Category){
        categoryRepositoryImplementation.updateCategory(category)
    }
    fun selectAllCategory():List<Category>{
        return categoryRepositoryImplementation.selectAllCategory()

    }
    fun deleteCategoryTable(category_name :Int){

        categoryRepositoryImplementation.deleteCategory(category_name = "undergraduate")
    }
}