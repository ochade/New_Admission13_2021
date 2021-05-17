package com.serverless.controller

import com.google.gson.Gson
import com.serverless.model.Admission
import com.serverless.request.CreateAdmissionRequest
import com.serverless.request.DeleteAdmissionRequest
import com.serverless.request.UpdateAdmissionRequest
import com.serverless.response.BaseResponse
import com.serverless.response.ListResponse
import com.serverless.service.AdmissionService

class AdmissionController {
    //private  val clientService:ClientService= ClientService()
    private val admissionService = AdmissionService()

    fun createAdmissionTable(): Any {
       // clientService.createClientsTable()
      return runSafelyTrans {
          admissionService.createAdmissionTable()
      }

    }

    fun createAdmission(request:String): Any{
//        //converting json coming from the handler to my own request class - createclientrequest
       // val createClientRequest = Gson().fromJson(request, CreateClientRequest::class.java)
        println(request)
        val createAdmissionRequest = Gson().fromJson(request, CreateAdmissionRequest::class.java)
        val admission = Admission(0,createAdmissionRequest.admisssion_type, createAdmissionRequest.admission_status,createAdmissionRequest.admission_description)

//        val client = Client(0,createClientRequest.client_name,createClientRequest.address,createClientRequest.industry)
//        clientService.createClientsService(client)
      return runSafelyTrans {
          admissionService.createAdmissionService(admission)
          return BaseResponse("00","admission created sucesfully")
      }
//
    }
    fun UpdateAdmission(request: String):Any{
        val updateAdmissionRequest = Gson().fromJson(request, UpdateAdmissionRequest::class.java)
        val admission = Admission(updateAdmissionRequest.admission_id,updateAdmissionRequest.admisssion_type,updateAdmissionRequest.admission_status,updateAdmissionRequest.admission_description)
        return runSafelyTrans {
            admissionService.updateAdmissionTable(admission)

            return BaseResponse("00","admission updated sucesfully")
        }
    }

//
//
//    fun selectAllClients():Any{
//        val clients = clientService.selectAllClients()
//        return ListResponse("00","successful",clients)
//    }
    fun selectAllAdmission(): Any{
       return runSafelyTrans {
           val admission = admissionService.selectAllAdmission()
           return ListResponse("00","successful",admission)
       }
    }
//
    fun deleteAdmission(request: String):Any{
        val deleteAdmissionRequest = Gson().fromJson(request, DeleteAdmissionRequest::class.java)
       return runSafelyTrans {
           admissionService.deleteAdmissionTable(admission_id = deleteAdmissionRequest.admission_id!!.toInt())
           return BaseResponse("00","admission deleted sucesfully")
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