package com.serverless.model

data class User(
    var user_id: Int?,
    var username:String?,
    var lastname:String?,
    var phonenumber:String?,
    var email: String?,
    var password: String?,
    var role_id: String?

)