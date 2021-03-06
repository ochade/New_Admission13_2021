package com.serverless.repository

import com.serverless.databaseManager.DatabaseManager
import com.serverless.model.Applicant

import java.sql.Connection
import java.sql.SQLException
import java.sql.Statement

interface ApplicantRepository{
    fun createApplicantTable()
    fun createApplicant(applicant: Applicant)
    fun updateApplicant(applicant: Applicant)
    fun selectAllApplicantAndAdmission()
}
class ApplicantRepositoryImplementation: ApplicantRepository{
    var connection: Connection? = DatabaseManager.getConnection()
    var stmt: Statement? = null

    override fun createApplicantTable(){
        val sql = "CREATE TABLE IF NOT EXISTS applicant\n" +
                " (applicant_id INT PRIMARY KEY AUTO_INCREMENT ,\n" +
                "  admission_id INT ,\n" +
                "  applicant_name VARCHAR(60) NOT NULL,\n" +
                "  applicant_email VARCHAR(60) NOT NULL,\n" +
                "  applicant_phonenumber VARCHAR(60) NOT NULL,\n" +
                "  applicant_age VARCHAR(20) NOT NULL,\n"+
                "  applicant_address VARCHAR(60) NOT NULL,\n" +
                "  applicant_lga VARCHAR(40) NOT NULL,\n" +
                "  applicant_sex VARCHAR(60) NOT NULL,\n" +
                "  applicant_dob VARCHAR(20) NOT NULL,\n"+
                "  applicant_maritalStatus VARCHAR(40) NOT NULL,\n" +
                "  applicant_citizenship VARCHAR(60) NOT NULL,\n" +
                "  applicant_religion VARCHAR(20) NOT NULL,\n"+
                "  applicant_denomination VARCHAR(20) NOT NULL,\n" +
                "  applicant_status VARCHAR(60) NOT NULL,\n" +
                " CREATED_DATE timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP," +
                "FOREIGN KEY (admission_id) REFERENCES admission(admission_id) ON DELETE CASCADE )"


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
        val sql = "INSERT INTO applicant( applicant_admission, applicant_name, applicant_age, applicant_address, applicant_lga, applicant_sex, applicant_dob, applicant_maritalStatus, applicant_citizenship, applicant_religion, applicant_denomination ) values (?,?,?,?,?,?,?,?,?,?,?)"
        val pstmt = connection?.prepareStatement(sql)

        try {

            pstmt?.setInt(1, applicant.admission_id!!)
            pstmt?.setString(2, applicant.applicant_name)
            pstmt?.setInt(3, applicant.applicant_age!!)
            pstmt?.setString(4, applicant.applicant_address.toString())
            pstmt?.setString(5, applicant.applicant_LGA)
            pstmt?.setString(6, applicant.applicant_sex)
            pstmt?.setString(7, applicant.applicant_DOB)
            pstmt?.setString(8, applicant.applicant_maritalStatus)
            pstmt?.setString(9, applicant.applicant_citizenship)
            pstmt?.setString(10, applicant.applicant_religion)
            pstmt?.setString(11, applicant.applicant_denomination )


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

    override fun updateApplicant(applicant: Applicant) {
        try {
            val sql = "UPDATE applicant SET" +
                    " applicant_admission = ?," +
                    "applicant_name=?, " +
                    "applicant_age=?," +
                    " applicant_address=?," +
                    " applicant_LGA=?, " +
                    "applicant_sex=?, " +
                    "applicant_DOB=?," +
                    "applicant_maritalStatus=?, " +
                    "applicant_citizenship=?, " +
                    "applicant_religion=?, " +
                    " applicant_denomination=? " +
                    " WHERE applicant_id = ? ;"
            val pstmt = connection?.prepareStatement(sql)

            pstmt?.setInt(1, applicant.admission_id!!)
            pstmt?.setString(2, applicant.applicant_name)
            pstmt?.setInt(3, applicant.applicant_age!!)
            pstmt?.setString(4, applicant.applicant_address)
            pstmt?.setString(5, applicant.applicant_LGA)
            pstmt?.setString(6, applicant.applicant_sex)
            pstmt?.setString(7, applicant.applicant_DOB)
            pstmt?.setString(8, applicant.applicant_maritalStatus)
            pstmt?.setString(9, applicant.applicant_citizenship)
            pstmt?.setString(10, applicant.applicant_religion)
            pstmt?.setString(11, applicant.applicant_denomination )
            pstmt?.setInt(12, applicant.applicant_id!!)
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

    override fun selectAllApplicantAndAdmission() {

    }

}
