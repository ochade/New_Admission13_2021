package com.serverless.controller

import com.google.gson.Gson
import com.serverless.model.Applicant
import com.serverless.request.CreateApplicantRequest
import com.serverless.request.UpdateAdmissionRequest
import com.serverless.request.UpdateApplicantRequest
import com.serverless.response.BaseResponse
import com.serverless.service.AdmissionService
import com.serverless.service.ApplicantService

class ApplicantController {
  //  private  val clientService:ClientService= ClientService()
    private  val applicantService: ApplicantService = ApplicantService()

    fun createApplicantTable(): Any { 
        return runSafelyTrans{
            applicantService.createApplicationTable()
//        clientService.createClientsTable()


    }  
    }
  fun createApplicant(request:String): Any{
//        //converting json coming from the handler to my own request class - createclientrequest
    // val createClientRequest = Gson().fromJson(request, CreateClientRequest::class.java)
//    println(request)
    //val createAdmissionRequest = Gson().fromJson(request, CreateAdmissionRequest::class.java)
   // val admission = Admission(0,createAdmissionRequest.admisssion_type, createAdmissionRequest.admission_status,createAdmissionRequest.admission_description)
    val createApplicantRequest = Gson().fromJson(request, CreateApplicantRequest::class.java)
    val applicant = Applicant(
        createApplicantRequest.admission_id ,
        0,
        createApplicantRequest.applicant_name,
        createApplicantRequest.applicant_email,
        createApplicantRequest.applicant_phonenumber,
        createApplicantRequest.applicant_age,
        createApplicantRequest.applicant_address,
        createApplicantRequest.applicant_LGA,
        createApplicantRequest.applicant_sex,
        createApplicantRequest.applicant_DOB,
        createApplicantRequest.applicant_maritalStatus,
        createApplicantRequest.applicant_citizenship,
        createApplicantRequest.applicant_religion,
        createApplicantRequest.applicant_denomination,
        createApplicantRequest.applicant_status

    )


      applicantService.createApplicantService(applicant)
      return BaseResponse("00","applicant created sucesfully")

//
  }
  fun UpdateApplicant(request: String):Any {
      val updateApplicantRequest = Gson().fromJson(request, UpdateApplicantRequest::class.java)
      val applicant = Applicant(
          updateApplicantRequest.admission_id,
          updateApplicantRequest.applicant_id,
          updateApplicantRequest.applicant_name,
          updateApplicantRequest.applicant_email,
          updateApplicantRequest.applicant_phonenumber,
          updateApplicantRequest.applicant_age,
          updateApplicantRequest.applicant_address,
          updateApplicantRequest.applicant_LGA ,
          updateApplicantRequest.applicant_sex,
          updateApplicantRequest.applicant_DOB,
          updateApplicantRequest.applicant_maritalStatus,
          updateApplicantRequest.applicant_citizenship,
          updateApplicantRequest.applicant_religion,
          updateApplicantRequest.applicant_denomination,
          updateApplicantRequest.applicant_status
      )
      return runSafelyTrans {
          // admissionService.updateAdmissionTable(admission)
          applicantService.updateApplicationTable(applicant)
          return BaseResponse("00", "admission updated sucesfully")
      }

  }
    private inline fun runSafelyTrans(action: () ->Unit): Any{
        return try{
            action()
        }catch (t: Throwable){
            BaseResponse("98", "${t.message}")
        }finally {

        }
    }

}