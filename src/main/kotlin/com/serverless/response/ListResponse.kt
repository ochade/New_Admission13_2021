package com.serverless.response

data class ListResponse(
    var responseCode: String,
    var responseMessage: String,
    var data: List<*>
)


