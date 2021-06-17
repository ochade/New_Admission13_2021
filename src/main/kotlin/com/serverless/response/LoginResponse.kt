package com.serverless.response

class LoginResponse(
    val code: String,
    val message: String,
    val token: String,
    var user_id: Int?,
    var username:String?,
    var firstname: String?,
    var lastname:String?,
    var phonenumber:String?,
    var email: String?,
    var password: String?,
    var role_id: String?
)