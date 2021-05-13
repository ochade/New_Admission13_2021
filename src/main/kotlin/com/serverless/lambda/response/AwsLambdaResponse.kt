package com.serverless.lambda.response

import com.google.gson.annotations.SerializedName

data class AwsLambdaResponse(
    val body: String,
    val isBase64Encoded: Boolean = false,
    val statusCode: String = "200",
    val headers: Headers = Headers()
)

data class Headers(
    @SerializedName("Access-Control-Allow-Origin")
    val Access_Control_Allow_Origin: String = "*",
    @SerializedName("x-custom-header")
    val x_custom_header: String = "my custom header value",
    @SerializedName("Access-Control-Allow-Methods")
    val Access_Control_Allow_Methods: String = "OPTIONS,POST,GET",
    @SerializedName("Allow")
    val Allow: String = "OPTIONS,POST,GET",
    @SerializedName("Access-Control-Allow-Headers")
    val Access_Control_Allow_Headers: String = "Content-Type",
    @SerializedName("Content-Type")
    val Content_Type: String = "application/json"
)
