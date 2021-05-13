package com.serverless.lambda.model

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