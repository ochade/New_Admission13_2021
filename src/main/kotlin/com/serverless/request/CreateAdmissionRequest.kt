package com.serverless.request

import javax.validation.constraints.NotEmpty

data class CreateAdmissionRequest(
    @get:NotEmpty(message = "admission type is required")
    val admisssion_type:String?,
    @get:NotEmpty(message = "admission status is required")
    val admission_status:String?,
    @get:NotEmpty(message = "admission description is required")
    val admission_description:String?,
)
