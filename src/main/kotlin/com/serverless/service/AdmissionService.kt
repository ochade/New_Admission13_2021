package com.serverless.service

import com.serverless.model.Admission
import com.serverless.repository.AdmissionRepositoryImplementation

class AdmissionService {
    private val admissionRepositoryImplementation: AdmissionRepositoryImplementation = AdmissionRepositoryImplementation()

    fun createAdmissionTable(){
        admissionRepositoryImplementation.createAdmissionTable()
    }
    fun createAdmissionService(admission: Admission){
      //  admissionRepositoryImplementation.createAdmission(admission)
    }
    fun updateAdmissionTable(admission: Admission){
      //  admissionRepositoryImplementation.updateAdmission(admission)
    }
  //  fun selectAllAdmission():List<Admission>{
       // return admissionRepositoryImplementation.selectAllAdmission()

//    }
    fun deleteAdmissionTable(admission_id:Int){
//        admissionRepositoryImplementation.deleteAdmission(admission_id=3)
    }

}