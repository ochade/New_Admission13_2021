package com.serverless.lambda.model

data class RequestContext(
//        val apiId: String,
        val connectedAt: Long,
        val connectionId: String,
        val domainName: String,
        val eventType: String,
        val extendedRequestId: String,
        val identity: Identity,
        val messageDirection: String,
        val messageId: Any,
        val requestId: String,
        val requestTime: String,
        val requestTimeEpoch: Long,
//        val routeKey: String,
        val stage: String
)