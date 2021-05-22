package com.serverless.repository

import com.serverless.databaseManager.DatabaseManager
import com.serverless.model.Applicant

import java.sql.Connection
import java.sql.SQLException
import java.sql.Statement

interface ApplicantRepository{
    fun createApplicantTable()
    fun createApplicant(applicant: Applicant)
}
class ApplicantRepositoryImplementation: ApplicantRepository{
    var connection: Connection? = DatabaseManager.getConnection()
    var stmt: Statement? = null

    override fun createApplicantTable(){
        val sql = "CREATE TABLE IF NOT EXISTS applicant\n" +
                " (applicant_id INT PRIMARY KEY AUTO_INCREMENT ,\n" +
                "  applicant_admission VARCHAR(40),\n" +
                "  applicant_name VARCHAR(60) NOT NULL,\n" +
                "  applicant_age VARCHAR(20) NOT NULL,\n"+
                "  applicant_address VARCHAR(60) NOT NULL,\n" +
                "  applicant_lga VARCHAR(40) NOT NULL,\n" +
                "  applicant_sex VARCHAR(60) NOT NULL,\n" +
                "  applicant_dob VARCHAR(20) NOT NULL,\n"+
                "  applicant_maritalStatus VARCHAR(40) NOT NULL,\n" +
                "  applicant_citizenship VARCHAR(60) NOT NULL,\n" +
                "  applicant_religion VARCHAR(20) NOT NULL)"

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

    override fun createApplicant(applicant: Applicant) {
        val sql = "INSERT INTO applicant( applicant_admission, applicant_name, applicant_age, applicant_address, applicant_lga, applicant_sex, applicant_dob, applicant_maritalStatus, applicant_citizenship, applicant_religion ) values (?,?,?,?,?,?,?,?,?,?,?)"
        val pstmt = connection?.prepareStatement(sql)

        try {

            pstmt?.setString(1, applicant.applicant_admission)
            pstmt?.setString(2, applicant.applicant_name)
            pstmt?.setString(3, applicant.applicant_age)
            pstmt?.setString(3, applicant.applicant_address)
            pstmt?.setString(3, applicant.applicant_LGA)
            pstmt?.setString(3, applicant.applicant_sex)
            pstmt?.setString(3, applicant.applicant_DOB)
            pstmt?.setString(3, applicant.applicant_maritalStatus)
            pstmt?.setString(3, applicant.applicant_citizenship)
            pstmt?.setString(3, applicant.applicant_religion)
            pstmt?.setString(3, applicant.applicant_denomination )


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