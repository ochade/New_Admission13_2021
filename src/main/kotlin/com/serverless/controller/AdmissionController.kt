package com.serverless.controller

import com.google.gson.Gson
import com.serverless.model.Admission
import com.serverless.request.CreateAdmissionRequest
import com.serverless.response.BaseResponse
import com.serverless.response.ListResponse
import com.serverless.service.AdmissionService

class AdmissionController {
    //private  val clientService:ClientService= ClientService()
    private val admissionService = AdmissionService()

    fun createAdmissionTable() {
       // clientService.createClientsTable()
        admissionService.createAdmissionTable()

    }

    fun createAdmission(request:String): Any{
//        //converting json coming from the handler to my own request class - createclientrequest
       // val createClientRequest = Gson().fromJson(request, CreateClientRequest::class.java)
        println(request)
        val createAdmissionRequest = Gson().fromJson(request, CreateAdmissionRequest::class.java)
        val admission = Admission(0,createAdmissionRequest.admisssion_type, createAdmissionRequest.admission_status,createAdmissionRequest.admission_description)

//        val client = Client(0,createClientRequest.client_name,createClientRequest.address,createClientRequest.industry)
//        clientService.createClientsService(client)
        admissionService.createAdmissionService(admission)
        return BaseResponse("00","admission created sucesfully")
//
    }
//    fun UpdateClients(request: String):Any{
//        val updateClientRequest = Gson().fromJson(request, UpdateClientRequest::class.java)
//        val client = Client(updateClientRequest.client_id!!.toInt(),updateClientRequest.client_name,updateClientRequest.address,updateClientRequest.industry)
//
//        clientService.updateClientsTable(client)
//
//        return BaseResponse("00","client updated sucesfully")
//    }
//
//
//    fun selectAllClients():Any{
//        val clients = clientService.selectAllClients()
//        return ListResponse("00","successful",clients)
//    }
    fun selectAllAdmission(): Any{
        val admission = admissionService.selectAllAdmission()
        return ListResponse("00","successful",admission)
    }
//
//    fun deleteClients(request: String):Any{
//        val deleteClientRequest = Gson().fromJson(request, DeleteClientRequest::class.java)
//        clientService.deleteClientsTable(client_id = deleteClientRequest.client_id!!.toInt())
//        return BaseResponse("00","client deleted sucesfully")
//    }
}