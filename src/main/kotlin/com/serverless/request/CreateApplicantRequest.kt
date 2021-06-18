package com.serverless.request

import javax.validation.constraints.NotEmpty

data class CreateApplicantRequest(
    @get:NotEmpty(message = "admission type is required")
    val admission_id: Int?,
    @get:NotEmpty(message = "admission name is required")
    val applicant_name:String?,
    @get:NotEmpty(message = "admission age is required")
    val applicant_email:String?,
    @get:NotEmpty(message = "admission age is required")
    val applicant_phonenumber:String?,
    @get:NotEmpty(message = "admission address is required")
    val applicant_age:Int?,
    @get:NotEmpty(message = "admission address is required")
    val applicant_address:String?,
    @get:NotEmpty(message = "admission LGA is required")
    val applicant_LGA:String?,
    @get:NotEmpty(message = "admission sex is required")
    val applicant_sex:String?,
    @get:NotEmpty(message = "admission date of birth is required")
    val applicant_DOB:String?,
    @get:NotEmpty(message = "marital status is required")
    val applicant_maritalStatus:String?,
    @get:NotEmpty(message = "admission citizenship is required")
    val applicant_citizenship:String?,
    @get:NotEmpty(message = "admission religion is required")
    val applicant_religion:String?,
    @get:NotEmpty(message = "admission denomination is required")
    val applicant_denomination:String?,
    @get:NotEmpty(message = "admission denomination is required")
    val applicant_status :String?,




)