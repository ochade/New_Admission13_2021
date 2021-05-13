package com.serverless.response

class ListResponse(
    var responseCode: String,
    var responseMessage: String,
    var data: List<*>
)
