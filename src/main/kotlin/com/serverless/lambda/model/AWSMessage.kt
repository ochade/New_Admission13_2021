package com.serverless.lambda.model

import java.util.*

data class AWSMessage (
     val command:String,
     val data: Any,
     val responseMessage :String,
     val responseCode: String,
     val meta: Map<String, Any> = Collections.singletonMap(
     "Content-Type",
"application/json"
)
)