package com.serverless.controller

import com.google.gson.Gson
import com.serverless.model.Applicant
import com.serverless.request.UpdateAdmissionRequest
import com.serverless.request.UpdateApplicantRequest
import com.serverless.response.BaseResponse
import com.serverless.service.AdmissionService
import com.serverless.service.ApplicantService

class ApplicantController {
  //  private  val clientService:ClientService= ClientService()
    private  val applicantService: ApplicantService = ApplicantService()

    fun createApplicantTable() {
      applicantService.createApplicationTable()
//        clientService.createClientsTable()

    }
  fun createApplicant(applicant: Applicant): Any{
//        //converting json coming from the handler to my own request class - createclientrequest
    // val createClientRequest = Gson().fromJson(request, CreateClientRequest::class.java)
//    println(request)
    //val createAdmissionRequest = Gson().fromJson(request, CreateAdmissionRequest::class.java)
   // val admission = Admission(0,createAdmissionRequest.admisssion_type, createAdmissionRequest.admission_status,createAdmissionRequest.admission_description)
//    val createApplicantRequest = Gson().fromJson(request, CreateApplicantRequest::class.java)
//    val applicant = Applicant("1",0,"naomi",19,"no 4 christiana street","ndokwa","female","09-01-2002","single","nigeian","christian","catholic")


      applicantService.createApplicantService(applicant)
      return BaseResponse("00","admission created sucesfully")

//
  }
  fun UpdateApplication(request: String):Any{
    val updateApplicantRequest = Gson().fromJson(request, UpdateApplicantRequest::class.java)
    val applicant = Applicant(updateApplicantRequest.applicant_admission, updateApplicantRequest.applicant_id,updateApplicantRequest.applicant_name,updateApplicantRequest.applicant_age, updateApplicantRequest.applicant_address, updateApplicantRequest.applicant_LGA, updateApplicantRequest.applicant_sex, updateApplicantRequest.applicant_DOB, updateApplicantRequest.applicant_maritalStatus, updateApplicantRequest.applicant_citizenship, updateApplicantRequest.applicant_religion, updateApplicantRequest.applicant_denomination )
    return runSafelyTrans {
      admissionService.updateAdmissionTable(admission)
      applicantService.
      return BaseResponse("00","admission updated sucesfully")
    }

}