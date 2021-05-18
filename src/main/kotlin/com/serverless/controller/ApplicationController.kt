package com.serverless.controller

import com.serverless.service.AdmissionService
import com.serverless.service.ApplicantService

class ApplicationController {
  //  private  val clientService:ClientService= ClientService()
    private  val applicationService: ApplicantService = ApplicantService()

    fun createApplicantTable() {
      applicationService.createApplicationTable()
//        clientService.createClientsTable()

    }

}