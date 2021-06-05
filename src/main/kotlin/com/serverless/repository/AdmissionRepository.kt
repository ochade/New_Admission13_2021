package com.serverless.repository

import com.serverless.databaseManager.DatabaseManager
import com.serverless.model.Admission
import java.sql.Connection
import java.sql.SQLException
import java.sql.Statement

interface AdmissionRepository {

    fun createAdmissionTable()
    fun createAdmission(admission: Admission)
   // fun updateClients(client: Admission)
    fun updateAdmission(admission: Admission)
    fun selectAllAdmission():List<Admission>
    fun deleteAdmission(admission_id:Int)
}
class AdmissionRepositoryImplementation: AdmissionRepository {

    var connection: Connection? = DatabaseManager.getConnection()
    var stmt: Statement? = null
    //var pstmt: PreparedStatement? = null

    override fun createAdmissionTable() {
        val sql = "CREATE TABLE IF NOT EXISTS admission\n" +
                " (admission_id INT PRIMARY KEY AUTO_INCREMENT ,\n" +
                "  admission_type VARCHAR(40) NOT NULL,\n" +
                "  admission_status VARCHAR(60) NOT NULL,\n" +
                "  admission_description VARCHAR(20) NOT NULL)"
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

    override fun createAdmission(admission: Admission) {
        val sql = "INSERT INTO admission(admission_type, admission_status, admission_description) values (?,?,?)"
        val pstmt = connection?.prepareStatement(sql)

        try {

            pstmt?.setString(1, admission.admisssion_type)
            pstmt?.setString(2, admission.admission_status)
            pstmt?.setString(3, admission.admission_description)

            pstmt?.executeUpdate()
            print("query ran successfully")
        } catch (ex: SQLException) {
            ex.printStackTrace()
        } finally {

            pstmt?.close()
            connection?.close()
            connection = null
        }
//        stmt = connection?.createStatement()
//        try {
//            val sql =
//                "INSERT INTO admission(admission_id,admission_type, " +
//                        "admission_status, admission_description)" +
//                        "VALUES ( '${admission.admission_id}','${admission.admisssion_type}'," +
//                        " '${admission.admission_status}','${admission.admission_description}')"
//            stmt?.executeUpdate(sql)
//            println("Created admission")
//        } catch (ex: SQLException) {
//            ex.printStackTrace()
//        } finally {
//            stmt?.close()
//            connection?.close()
//            stmt = null
//            connection = null
//        }
    }

    override fun updateAdmission(admission: Admission) {
        try {
            val sql = "UPDATE admission SET admission_type = ?,admission_status=?, admission_description=? WHERE admission_id = ? ;"
            val pstmt = connection?.prepareStatement(sql)

            pstmt?.setString(1, admission.admisssion_type)
            pstmt?.setString(2, admission.admission_status)
            pstmt?.setString(3, admission.admission_description)
            pstmt?.setInt(4, admission.admission_id!!)
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

    override fun selectAllAdmission(): List<Admission> {
        val admissionList= mutableListOf<Admission>()
        val sql = "SELECT * FROM admission"
        val pstmt = connection?.prepareStatement(sql)
        try {
            val resultset=pstmt?.executeQuery()
            while (resultset?.next()!!){
                val admission = Admission(
                    admission_id = resultset.getInt("admission_id"),
                    admisssion_type= resultset.getString("admission_type"),
                    admission_status= resultset.getString("admission_status"),
                    admission_description = resultset.getString("admission_description")
                )
                admissionList.add(admission)
            }
            print("query ran succesfully")
        }catch (ex: SQLException) {
            ex.printStackTrace()
        } finally {
            pstmt?.close()
            connection?.close()
            connection = null
        }
        return admissionList
    }

    override fun deleteAdmission(admission_id: Int) {
        val sql =
            " DELETE FROM  admission  WHERE admission_id=?;"
        val preparedStatement = connection?.prepareStatement(sql)
        try {
            preparedStatement?.setInt(1,admission_id)
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


