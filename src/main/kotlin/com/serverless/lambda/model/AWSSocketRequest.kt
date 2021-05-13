package com.serverless.lambda.model

import java.util.*

data class AWSSocketRequest(
    val headers: Headers,
    val isBase64Encoded: Boolean,
//    val multiValueHeaders: MultiValueHeaders,
    val requestContext: RequestContext,
    var body:String
)

data class AWSSocketResponse(
     val body: String,  val headers: Map<String, String> = Collections.singletonMap(
    "Content-Type",
    "application/json"
),
    private val statusCode: Int
)