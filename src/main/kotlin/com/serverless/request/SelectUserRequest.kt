package com.serverless.request

import javax.validation.constraints.NotEmpty

class SelectUserRequest(
    @get:NotEmpty(message = "user name is required")
    val username:String?


)
