package com.serverless.repository

import com.serverless.databaseManager.DatabaseManager
import com.serverless.model.Admission
import com.serverless.model.User
import java.sql.Connection
import java.sql.SQLException
import java.sql.Statement


interface UserRepository {
    fun createUserTable()
    fun createUser(user: User)
   // fun deleteUser()
    fun updateUser(user: User)
    fun selectUser(username : String): User?
}
class UserRepositoryImplementation: UserRepository {
    var connection: Connection? = DatabaseManager.getConnection()
    var stmt: Statement? = null

    override fun createUserTable() {
        val sql = "CREATE TABLE IF NOT EXISTS user\n" +
                " (user_id INT PRIMARY KEY AUTO_INCREMENT ,\n" +
                "  username VARCHAR(40) NOT NULL,\n" +
                "  lastname VARCHAR(60) NOT NULL,\n" +
                "  phonenumber VARCHAR(40) NOT NULL,\n" +
                "  email VARCHAR(60) NOT NULL,\n" +
                "  password VARCHAR(60) NOT NULL,\n" +
                "  role_id VARCHAR(20) NOT NULL)"
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


    override fun createUser(user: User) {
        val sql =
            "INSERT INTO user(username, lastname, phonenumber ,email ,password , role_id) values (?,?,?,?,?,?)"
        val pstmt = connection?.prepareStatement(sql)

        try {

            pstmt?.setString(1, user.username)
            pstmt?.setString(2, user.lastname)
            pstmt?.setString(3, user.phonenumber)
            pstmt?.setString(4, user.password)
            pstmt?.setString(5, user.role_id)
            pstmt?.setString(6, user.lastname)

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

    override fun updateUser(user: User) {
        try {
            val sql = "UPDATE user SET username = ?,lastname=?, phonenumber=?, email= ?, password= ?,role_id =? WHERE user_id = ? ;"
            val pstmt = connection?.prepareStatement(sql)

            pstmt?.setString(1, user.username)
            pstmt?.setString(2, user.lastname)
            pstmt?.setString(3, user.phonenumber)
            pstmt?.setString(4, user.email)
            pstmt?.setString(5, user.password)
            pstmt?.setString(6,user.email)
            pstmt?.setInt(7, user.user_id!!)
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

//    }
//
    override fun selectUser(username : String): User? {
    val sql = "SELECT * FROM user WHERE username = ?;"
    val pstmt = connection?.prepareStatement(sql)
    pstmt?.setString(1, username)
    try {
        val resultset = pstmt?.executeQuery()
        val user = User(
            user_id = resultset?.getInt("user_id"),
            username = resultset?.getString("username"),
            lastname = resultset?.getString("lastname"),
            phonenumber = resultset?.getString("phonenumber"),
            email = resultset?.getString("email"),
            password = resultset?.getString("password"),
            role_id = resultset?.getString("role_id")
        )
        return user
    } catch (ex: SQLException) {
        ex.printStackTrace()
    } finally {
        pstmt?.close()
        connection?.close()
        connection = null
    }

}
}



