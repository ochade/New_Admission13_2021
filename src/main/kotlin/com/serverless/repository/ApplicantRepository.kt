package com.serverless.repository

import com.serverless.databaseManager.DatabaseManager
import com.serverless.model.ApplicantModel
import java.sql.Connection
import java.sql.SQLException
import java.sql.Statement

interface ApplicantRepository{
    fun createApplicantTable()
 //   fun createApplicant()
}
class ApplicantRepositoryImplementation: ApplicantRepository{
    var connection: Connection? = DatabaseManager.getConnection()
    var stmt: Statement? = null

    override fun createApplicantTable(){
        val sql = "CREATE TABLE IF NOT EXISTS applicant\n" +
                " (applicant_admission VARCHAR(40),\n" +
                " applicant_id INT PRIMARY KEY AUTO_INCREMENT,\n" +
                "  applicant_name VARCHAR(60) NOT NULL,\n" +
                "  applicant_age VARCHAR(20) NOT NULL),\n"+
                "applicant_address VARCHAR(60) NOT NULL,\n" +
                "  applicant_LGA VARCHAR(40) NOT NULL,\n" +
                "  applicant_sex VARCHAR(60) NOT NULL,\n" +
                "  applicant_DOB VARCHAR(20) NOT NULL),\n"+
                "  applicant_maritalStatus VARCHAR(40) NOT NULL,\n" +
                "  applicant_citizenship VARCHAR(60) NOT NULL,\n" +
                "  applicant_religion VARCHAR(20) NOT NULL),\n"

        val pstmt = connection?.prepareStatement(sql)
        try {
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