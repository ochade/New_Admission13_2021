package com.serverless.repository

import com.serverless.databaseManager.DatabaseManager
import com.serverless.model.Admission
import com.serverless.model.Category
import java.sql.Connection
import java.sql.SQLException
import java.sql.Statement

interface CategoryRepository {
    fun createCategoryTable()
    fun createCategory(category: Category)
    fun updateCategory(category: Category)
    fun selectAllCategory(): List<Category>
    fun deleteCategory(category_name: String)
}


class CategoryRepositoryImplementation: CategoryRepository {
    var connection: Connection? = DatabaseManager.getConnection()
    var stmt: Statement? = null

    override fun createCategoryTable() {
        val sql = "CREATE TABLE IF NOT EXISTS category\n" +
                " (category_id INT PRIMARY KEY AUTO_INCREMENT ,\n" +
                "  category_name VARCHAR(40) NOT NULL,\n" +
                "  admission_status VARCHAR(60) NOT NULL,\n" +
                " CREATED_DATE timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP," +
                "  form_price VARCHAR(20) NOT NULL)"
        val pstmt = connection?.prepareStatement(sql)
        try {
            pstmt?.execute()
            print("query ran successfully")
        } catch (ex: SQLException) {
            ex.printStackTrace()
        } finally {
            pstmt?.close()
            connection?.close()
            connection = null
        }

    }

    override fun createCategory(category: Category) {
        val sql = "INSERT INTO category(category_id, category_name, form_price) values (?,?,?)"
        val pstmt = connection?.prepareStatement(sql)

        try {

            pstmt?.setInt(1, category.category_id!! )
            pstmt?.setString(2, category.category_name)
            pstmt?.setString(3, category.form_price)

            pstmt?.executeUpdate()
            print("query ran successfully")
        } catch (ex: SQLException) {
            ex.printStackTrace()
        } finally {

            pstmt?.close()
            connection?.close()
            connection = null
        }
    }

    override fun updateCategory(category: Category) {
        try {
            val sql = "UPDATE category SET category_name = ?,form_price=? WHERE category_id = ? ;"
            val pstmt = connection?.prepareStatement(sql)

            pstmt?.setString(1, category.category_name)
            pstmt?.setString(2, category.form_price)
            pstmt?.setInt(3, category.category_id!!)
            pstmt?.executeUpdate()
            print("query ran successfully")
        } catch (ex: SQLException) {
            ex.printStackTrace()
        } finally {
            stmt?.close()
            connection?.close()
            stmt = null
            connection = null
        }
    }

    override fun selectAllCategory(): List<Category> {
        val categoryList= mutableListOf<Category>()
        val sql = "SELECT * FROM category"
        val pstmt = connection?.prepareStatement(sql)
        try {
            val resultset=pstmt?.executeQuery()
            while (resultset?.next()!!){
                val category = Category(
                    category_id = resultset.getInt("category_id"),
                    category_name= resultset.getString("category_name"),
                    form_price= resultset.getString("form_price"),
                )
                categoryList.add(category)
            }
            print("query ran succesfully")
        }catch (ex: SQLException) {
            ex.printStackTrace()
        } finally {
            pstmt?.close()
            connection?.close()
            connection = null
        }
        return categoryList
    }

    override fun deleteCategory(category_name: String) {
        val sql =
            " DELETE FROM  category  WHERE category_name=?;"
        val preparedStatement = connection?.prepareStatement(sql)
        try {
            preparedStatement?.setString(1,category_name)
            preparedStatement?.executeUpdate()
            print("query ran successfully")
        } catch (ex: SQLException) {
            ex.printStackTrace()
        } finally {
            preparedStatement?.close()
            connection?.close()
            connection = null
        }
    }
    }

