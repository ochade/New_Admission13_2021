package com.serverless.repository

import com.serverless.databaseManager.DatabaseManager
import com.serverless.model.Role
import java.sql.Connection
import java.sql.SQLException
import java.sql.Statement

interface RoleRepository {
    fun createRoleTable()
    fun createRole(role: Role)
}

class RoleRepositoryImplementation: RoleRepository {
    var connection: Connection? = DatabaseManager.getConnection()
    var stmt: Statement? = null

    override fun createRoleTable() {
        val sql = "CREATE TABLE IF NOT EXISTS role\n" +
                " (role_id INT PRIMARY KEY AUTO_INCREMENT ,\n" +
                "  title VARCHAR(40) NOT NULL,\n"

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

    override fun createRole(role: Role) {
        val sql = "INSERT INTO role(title) values (?)"
        val pstmt = connection?.prepareStatement(sql)

        try {

            pstmt?.setString(1, role.title)

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
}