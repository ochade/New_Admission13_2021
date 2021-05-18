package com.serverless.service

import com.serverless.model.ApplicantModel
import com.serverless.repository.AdmissionRepositoryImplementation

class ApplicantService {
    private val admissionRepositoryImplementation: AdmissionRepositoryImplementation = AdmissionRepositoryImplementation()

    fun createApplicationTable(){
        admissionRepositoryImplementation.createAdmissionTable()
    }

}