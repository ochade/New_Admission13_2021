package com.serverless.response

class ListResponse(
    var responseCode: String,
    var responseMessage: String,
    var data: List<*>
)

class SingleResponse(
    var responseCode: String,
    var responseMessage: String,
    var data: Any
)
