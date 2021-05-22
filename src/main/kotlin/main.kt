import com.serverless.controller.AdmissionController
import com.serverless.controller.ApplicationController
import com.serverless.databaseManager.DatabaseManager
import com.serverless.model.Admission
import com.serverless.request.CreateAdmissionRequest
import com.serverless.request.DeleteAdmissionRequest


fun main(args: Array<String>) {

    println("ham")
//    val deleteAdmissionRequest= DeleteAdmissionRequest("5")
////    val admissionRequest = CreateAdmissionRequest("undergraduate","available", "public health")
// val admissioncontroller = AdmissionController()
// admissioncontroller.createAdmissionTable()

////    val admission = Admission(5, admissionRequest.admisssion_type, admissionRequest.admission_status, admissionRequest.admission_description)
////    admissioncontroller.createAdmission(admission)
//
//    admissioncontroller.deleteAdmission(deleteAdmissionRequest.toString())
    val applicationController = ApplicationController()
    applicationController.createApplicantTable()



  //  DatabaseManager.getConnection()

}

