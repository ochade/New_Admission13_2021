package com.serverless.response

import com.serverless.model.User

data class SingleResponse(
    var responseCode: String,
    var responseMessage: String,
    var data: User?
)

