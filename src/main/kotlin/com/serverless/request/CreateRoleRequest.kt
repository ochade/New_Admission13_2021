package com.serverless.request

import javax.validation.constraints.NotEmpty

data class CreateRoleRequest(
    @get:NotEmpty(message = "title is required")
    val title:String?,
)