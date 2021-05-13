package com.serverless.lambda.request

import com.google.gson.annotations.SerializedName

//import models.responses.SingleUserResponse

data class AWSLambdaRequest(
        val body: String,
        val headers: Headers,
        val httpMethod: String,
        val isBase64Encoded: Boolean,
        val multiValueHeaders: MultiValueHeaders,
        val multiValueQueryStringParameters: Any,
        val path: String,
        val pathParameters: PathParameters,
        val queryStringParameters: Any,
        val requestContext: RequestContext,
        val resource: String,
        val stageVariables: Any
)

data class PathParameters(
        val proxy: String
)

data class Headers(
        val Accept: String,
        @SerializedName("Accept-Encoding")
        val Accept_Encoding: String,
        @SerializedName("Cache-Control")
        val Cache_Control: String,
        @SerializedName("Content-Type")
        val Content_Type: String,
        val Host: String,
        @SerializedName("Postman-Token")
        val Postman_Token: String,
        @SerializedName("User-Agent")
        val User_Agent: String,
        @SerializedName("X-Amzn-Trace-Id")
        val X_Amzn_Trace_Id: String,
        @SerializedName("X-Forwarded-For")
        val X_Forwarded_For: String,
        @SerializedName("X-Forwarded-Port")
        val X_Forwarded_Port: String,
        @SerializedName("X-Forwarded-Proto")
        val X_Forwarded_Proto: String,
        val Authorization: String
)

data class MultiValueHeaders(
        val Accept: List<String>,
        @SerializedName("Accept-Encoding")
        val Accept_Encoding: List<String>,
        @SerializedName("Cache-Control")
        val Cache_Control: List<String>,
        @SerializedName("Content-Type")
        val Content_Type: List<String>,
        val Host: List<String>,
        @SerializedName("Postman-Token")
        val Postman_Token: List<String>,
        @SerializedName("User-Agent")
        val User_Agent: List<String>,
        @SerializedName("X-Amzn-Trace-Id")
        val X_Amzn_Trace_Id: List<String>,
        @SerializedName("X-Forwarded-For")
        val X_Forwarded_For: List<String>,
        @SerializedName("X-Forwarded-Port")
        val X_Forwarded_Port: List<String>,
        @SerializedName("X-Forwarded-Proto")
        val X_Forwarded_Proto: List<String>
)

data class RequestContext(
        val accountId: String,
        val apiId: String,
        val domainName: String,
        val domainPrefix: String,
        val extendedRequestId: String,
        val httpMethod: String,
        val identity: Identity,
        val path: String,
        val protocol: String,
        val requestId: String,
        val requestTime: String,
        val requestTimeEpoch: Long,
        val resourceId: String,
        val resourcePath: String,
        val stage: String
)

data class Identity(
        val accessKey: Any,
        val accountId: Any,
        val caller: Any,
        val cognitoAuthenticationProvider: Any,
        val cognitoAuthenticationType: Any,
        val cognitoIdentityId: Any,
        val cognitoIdentityPoolId: Any,
        val principalOrgId: Any,
        val sourceIp: String,
        val user: Any,
        val userAgent: String,
        val userArn: Any
)

data class BasicResponse(val responseCode:String, val responseMessage:String)

//data class JWTResponse(val payload: SingleUserResponse, val responseCode:String, val responseMessage:String)

//data class Payload( val alg:String, val typ:String, val iss:String, val ist:String, val exp:String)