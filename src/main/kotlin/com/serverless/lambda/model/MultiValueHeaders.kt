package com.serverless.lambda.model

import com.google.gson.annotations.SerializedName

data class MultiValueHeaders(
    val Accept: List<String>,
    @SerializedName("Accept-Encoding")
    val Accept_Encoding: List<String>,
    @SerializedName("Accept-Language")
    val Accept_Language: List<String>,
    @SerializedName("Cache-Control")
    val Cache_Control: List<String>,
    val Host: List<String>,
    @SerializedName("Origin")
    val Origin: List<String>,
    @SerializedName("Pragma")
    val Pragma: List<String>,
    @SerializedName(" Sec-WebSocket-Version")
    val  Sec_WebSocket_Version: List<String>,
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


