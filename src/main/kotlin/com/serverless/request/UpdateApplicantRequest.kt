package com.serverless.request

import javax.validation.constraints.NotEmpty

data class UpdateApplicantRequest(
    @get:NotEmpty(message = "admission type is required")
    val admission_id: Int?,
    @get:NotEmpty(message = "applicant id is required")
    val applicant_id:Int?,
    @get:NotEmpty(message = "applicant name is required")
    val applicant_name:String?,
    @get:NotEmpty(message = "applicant name is required")
    val applicant_email:String?,
    @get:NotEmpty(message = "applicant name is required")
    val applicant_phonenumber:String?,
    @get:NotEmpty(message = "applicant age is required")
    val applicant_age:Int?,
    @get:NotEmpty(message = "applicant address is required")
    val applicant_address:String?,
    @get:NotEmpty(message = "applicant LGA is required")
    val applicant_LGA:String?,
    @get:NotEmpty(message = "applicant sex is required")
    val applicant_sex:String?,
    @get:NotEmpty(message = "applicanat DOB is required")
    val applicant_DOB:String?,
    @get:NotEmpty(message = "applicant marital status is required")
    val applicant_maritalStatus:String?,
    @get:NotEmpty(message = "applicant citizenship is required")
    val applicant_citizenship:String?,
    @get:NotEmpty(message = "applicanat religion is required")
    val applicant_religion:String?,
    @get:NotEmpty(message = "applicant denomination is required")
    val applicant_denomination:String?,
    @get:NotEmpty(message = "applicant denomination is required")
    val applicant_status :String?,

)