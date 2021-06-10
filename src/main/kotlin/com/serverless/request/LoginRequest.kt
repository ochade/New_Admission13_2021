package com.serverless.request

import javax.validation.constraints.NotEmpty

class LoginRequest(
    @get:NotEmpty(message = "user name is required")
    val username:String?,
    @get:NotEmpty(message = "password is required")
    val password:String?
)