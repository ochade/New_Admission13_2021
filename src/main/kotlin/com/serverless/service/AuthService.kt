package com.serverless.service

import com.serverless.model.Applicant
import com.serverless.model.User
import com.serverless.request.LoginRequest
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.security.Keys
import org.mindrot.jbcrypt.BCrypt

class AuthService(private val userService: UserService) {

    private val JWT_KEY = "DummyKeyStringDummyKeyStringDummyKeyStringDummyKeyStringDummyKeyStringDummyKeyStrings"

    fun generateJWT(user : User, applicant: List<Applicant>) : String{
        val key = Keys.hmacShaKeyFor(JWT_KEY.toByteArray())
        val claims = hashMapOf(
            "userid" to user.user_id,
            "email" to user.username,
            "firstname" to user.firstname,
            "lastname" to user.lastname,
            "mobilenumber" to user.phonenumber ,
            "customerid" to user.email ,
            "status" to user.password ,
            "applicants" to applicant.map { it.applicant_id },
            "key" to "value")
        return Jwts.builder().addClaims(claims).signWith(key).compact()
    }

    fun verifyPassword(login: LoginRequest, user: User) =
        BCrypt.checkpw(login.password, user.password)

    fun decodeJWT(jwt : String) : String{
        val claims = Jwts.parser().setSigningKey(JWT_KEY.toByteArray()).parseClaimsJws(jwt)
        println("Decode result: $claims email: ${claims.body["email"]}")
        println(claims.body)
        return claims.body["email"].toString()
    }


//    fun authenticateUser(userLogin : UserLoginRequest) : Boolean{
//        val user = this.userRepository.findByEmail(userLogin.username)
//        println(user.toString())
//        return if (user == null){
//            false
//        }else BCrypt.checkpw(userLogin.password, user.password)
//    }


}