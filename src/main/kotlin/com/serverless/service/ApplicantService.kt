package com.serverless.service

import com.serverless.repository.ApplicantRepositoryImplementation

class ApplicantService {
    private val applicantRepositoryImplementation: ApplicantRepositoryImplementation = ApplicantRepositoryImplementation()

    fun createApplicationTable(){
        applicantRepositoryImplementation.createApplicantTable()
    }

}