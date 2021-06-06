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
            pstmt?.setString(4, user.email)
            pstmt?.setString(5, user.password)
            pstmt?.setString(6, user.role_id)

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
    override fun selectUser(username : String): User?{
    val sql = "SELECT * FROM user WHERE username = ? LIMIT 1;"
    var user = User(0,"","","","","","")

    val pstmt = connection?.prepareStatement(sql)
    pstmt?.setString(1, username)
     try {
        val resultset = pstmt?.executeQuery()
    while (resultset!!.next()){
          var user2 = User(
            resultset.getInt("user_id"),
            resultset.getString("username"),
            resultset.getString("lastname"),
            resultset.getString("phonenumber"),
            resultset.getString("email"),
            resultset.getString("password"),
            resultset.getString("role_id")
        )
        user = user2.copy()
}

    } catch (ex: SQLException) {
        ex.printStackTrace()
    } finally {
        pstmt?.close()
        connection?.close()
        connection = null
    }
    return user
}
}



