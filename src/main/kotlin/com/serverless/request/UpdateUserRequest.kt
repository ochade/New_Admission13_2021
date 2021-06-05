package com.serverless.request

import javax.validation.constraints.NotEmpty

data class UpdateUserRequest(
    @get:NotEmpty(message = "user id is required")
    val user_id:Int?,
    @get:NotEmpty(message = "user name is required")
    val username:String?,
    @get:NotEmpty(message = "last name is required")
    val lastname:String?,
    @get:NotEmpty(message = "phone  number is required")
    val phonenumber:String?,
    @get:NotEmpty(message = "email is required")
    val email:String?,
    @get:NotEmpty(message = "password is required")
    val password:String?,
    @get:NotEmpty(message = "role id is required")
    val role_id:String?
    )