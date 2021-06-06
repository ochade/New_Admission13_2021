import com.google.gson.Gson
import com.serverless.controller.AdmissionController
import com.serverless.controller.ApplicantController
import com.serverless.controller.UserController
import com.serverless.databaseManager.DatabaseManager
import com.serverless.model.Admission
import com.serverless.model.Applicant
import com.serverless.model.User
import com.serverless.request.*


fun main(args: Array<String>) {

    println("ham")
//    val deleteAdmissionRequest= DeleteAdmissionRequest("5")
 //   val admissionRequest = CreateAdmissionRequest("undergraduate","available", "public health")
//   val admissioncontroller = AdmissionController()
//// admissioncontroller.createAdmissionTable()
//
//    val admission = Admission(5, admissionRequest.admisssion_type, admissionRequest.admission_status, admissionRequest.admission_description)
//    admissioncontroller.createAdmission(admission)
////
//    admissioncontroller.deleteAdmission(deleteAdmissionRequest.toString())
//    val applicantController = ApplicantController()
////    applicantController.createApplicantTable()
//
//    val applicantRequest = UpdateApplicantRequest("1",1,"brume","16","no 4 christiana street","ndokwa east","female","09-01-20021","married","Nigerian","christian","catholic")
//
//    val applicant = Applicant(applicantRequest.applicant_admission,5, applicantRequest.applicant_name,
//        applicantRequest.applicant_age?.toString() , applicantRequest.applicant_address.toString(), applicantRequest.applicant_LGA, applicantRequest.applicant_sex, applicantRequest.applicant_DOB, applicantRequest.applicant_maritalStatus, applicantRequest.applicant_citizenship, applicantRequest.applicant_religion, applicantRequest.applicant_denomination)
    var gson = Gson()

//    applicantController.UpdateApplicant(request = balla)
//
    val userController = UserController()
   // userController.createUserTable()

//    val userRequest = CreateUserRequest("nana","udo","090939494","udo@gmail.com","mini01","1")
//    val user = User(1,userRequest.username, userRequest.lastname, userRequest.phonenumber, userRequest.email,userRequest.password, userRequest.role_id )
//
//    val balla: String = gson.toJson(userRequest)
//
//    userController.createUser(balla)
//    val userupdateRequest = UpdateUserRequest(1,"nana","udo","090939494","udo02@gmail.com","RUM","2")
//
//    val user = User(1,userupdateRequest.username, userupdateRequest.lastname, userupdateRequest.phonenumber, userupdateRequest.email,userupdateRequest.password, userupdateRequest.role_id )
    val selectUserRequest = SelectUserRequest("nana")
    val balla: String = gson.toJson(selectUserRequest)

    println(userController.SelectUser(balla))






  //  DatabaseManager.getConnection()

}

