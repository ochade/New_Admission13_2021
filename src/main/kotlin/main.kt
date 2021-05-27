import com.serverless.controller.AdmissionController
import com.serverless.controller.ApplicantController
import com.serverless.databaseManager.DatabaseManager
import com.serverless.model.Admission
import com.serverless.model.Applicant
import com.serverless.request.CreateAdmissionRequest
import com.serverless.request.CreateApplicantRequest
import com.serverless.request.DeleteAdmissionRequest


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
    val applicantController = ApplicantController()
    applicantController.createApplicantTable()

    val applicantRequest = CreateApplicantRequest("1","naomi","16","no 4 christiana street","ndokwa east","female","09-01-20021","married","Nigerian","christian","catholic")

    val applicant = Applicant(applicantRequest.applicant_admission,5, applicantRequest.applicant_name,
        applicantRequest.applicant_age?.toInt(), applicantRequest.applicant_address, applicantRequest.applicant_LGA, applicantRequest.applicant_sex, applicantRequest.applicant_maritalStatus, applicantRequest.applicant_citizenship, applicantRequest.applicant_religion, applicantRequest.applicant_denomination)
    applicantController.createApplicant(applicant)
  //  DatabaseManager.getConnection()

}

