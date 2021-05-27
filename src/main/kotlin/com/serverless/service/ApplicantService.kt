package com.serverless.service

import com.serverless.model.Admission
import com.serverless.model.Applicant
import com.serverless.repository.ApplicantRepositoryImplementation

class ApplicantService {
    private val applicantRepositoryImplementation: ApplicantRepositoryImplementation = ApplicantRepositoryImplementation()

    fun createApplicationTable(){
        applicantRepositoryImplementation.createApplicantTable()
    }
    fun createApplicantService(applicant: Applicant){
        applicantRepositoryImplementation.createApplicant(applicant)
    }
    fun updateApplicationTable(admission: Admission){
      //  admissionRepositoryImplementation.updateAdmission(admission)
        applicantRepositoryImplementation.updateApplicant(applicant)
    }

}