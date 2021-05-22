package com.serverless.databaseManager

import java.sql.*
import java.util.*

object DatabaseManager {

    private var conn: Connection? = null
    private var username = "CfdOlFdTAQ"
    private var password="ECHTrAwW2F"
    private var host = "remotemysql.com"
    private var portnumber = "3306"
    private var databasename = "CfdOlFdTAQ"
    private var drivername = "com.mysql.cj.jdbc.Driver"

    fun getConnection() : Connection? {
        val connectionProps = Properties()
        connectionProps.put("user", username)
        connectionProps.put("password", password)
        try {
            Class.forName(drivername)
            conn = DriverManager.getConnection("jdbc:mysql://${host}:${portnumber}/${databasename}", connectionProps)
        } catch (ex: SQLException) {
            // handle any errors
            ex.printStackTrace()
        } catch (ex: Exception) {
            // handle any errors
            ex.printStackTrace()
        }
        return conn
    }


    fun executeMySQLQuery() {
        var stmt: Statement? = null
        var resultset: ResultSet? = null

        try {
            stmt = conn!!.createStatement()
            resultset = stmt!!.executeQuery("SHOW DATABASES;")

            if (stmt.execute("SHOW DATABASES;")) {
                resultset = stmt.resultSet
            }

            while (resultset!!.next()) {
                println(resultset.getString("Database"))
            }
        } catch (ex: SQLException) {
            // handle any errors
            ex.printStackTrace()
        } finally {
            // release resources
            if (resultset != null) {
                try {
                    resultset.close()
                } catch (sqlEx: SQLException) {
                }

                resultset = null
            }

            if (stmt != null) {
                try {
                    stmt.close()
                } catch (sqlEx: SQLException) {
                }

                stmt = null
            }

            if (conn != null) {
                try {
                    conn!!.close()
                } catch (sqlEx: SQLException) {
                }

                conn = null
            }
        }
    }
}
