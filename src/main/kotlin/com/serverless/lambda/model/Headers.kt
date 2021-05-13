package com.serverless.lambda.model

import com.google.gson.annotations.SerializedName

data class Headers(
    val Accept: String,
    @SerializedName("Accept-Encoding")
    val Accept_Encoding: String,
    @SerializedName("Cache-Control")
    val Cache_Control: String,
    @SerializedName("Content-Type")
    val Content_Type: String,
//    val Host: String,
//    @SerializedName("Postman-Token")
//    val Postman_Token: String,
//    @SerializedName("User-Agent")
//    val User_Agent: String,
//    @SerializedName("X-Amzn-Trace-Id")
//    val X_Amzn_Trace_Id: String,
    @SerializedName("X-Forwarded-For")
    val X_Forwarded_For: String,
    @SerializedName("X-Forwarded-Port")
    val X_Forwarded_Port: String,
    @SerializedName("X-Forwarded-Proto")
    val X_Forwarded_Proto: String
)