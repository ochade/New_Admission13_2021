package com.serverless.controller

import com.google.gson.Gson
import com.serverless.model.User
import com.serverless.repository.ApplicantRepositoryImplementation
import com.serverless.request.*
import com.serverless.response.BaseResponse
import com.serverless.response.LoginResponse
import com.serverless.response.SingleResponse
import com.serverless.service.AuthService
import com.serverless.service.UserService
import java.lang.IllegalArgumentException
import java.lang.IllegalStateException

class UserController {
    private val userService = UserService()

    fun createUserTable(): Any {

        return runSafelyTrans {
            userService.createUserTable()
            return BaseResponse("00","user table created sucesfully")

        }
    }
    fun createUser(request:String): Any{
//        //converting json coming from the handler to my own request class - createclientrequest
        // val createClientRequest = Gson().fromJson(request, CreateClientRequest::class.java)

        val createUserRequest = Gson().fromJson(request, CreateUserRequest::class.java)
        val user = User(0, createUserRequest.username, createUserRequest.firstname, createUserRequest.lastname, createUserRequest.phonenumber, createUserRequest.email,createUserRequest.password, createUserRequest.role_id )

        return runSafelyTrans {
            userService.createUserService(user)
            return BaseResponse("00","user created sucesfully")
        }
//
    }
    fun UpdateUser(request: String):Any{
        val updateUserRequest = Gson().fromJson(request, UpdateUserRequest::class.java)
       // val user = User(updateAdmissionRequest.admission_id,updateAdmissionRequest.admisssion_type,updateAdmissionRequest.admission_status,updateAdmissionRequest.admission_description)

        val user = User(updateUserRequest.user_id, updateUserRequest.username, updateUserRequest.firstname , updateUserRequest.lastname, updateUserRequest.phonenumber, updateUserRequest.email, updateUserRequest.password, updateUserRequest.role_id )
        return runSafelyTrans {
            userService.updateUserTable(user)

            return BaseResponse("00","user updated sucesfully")
        }
    }
    fun Login(request: String): Any{
        val loginRequest = Gson().fromJson(request, LoginRequest::class.java)
        val userService = UserService()
        val authService = AuthService(userService)
        val applicantRepository = ApplicantRepositoryImplementation()

        return runSafelyTrans {
            val isUser =  userService.selectUser(loginRequest.username!!) ?: throw(IllegalStateException("username not found"))
            if(isUser.password == loginRequest.password){


                val token = authService.generateJWT(isUser)
                // create a response
                // pass the response to the applicants
                // return token
      //          return LoginResponse("00","user selected successfully","", isUser.firstname)
            }else{
                throw(IllegalArgumentException("Incorrect Password"))
            }
            return LoginResponse("00","user selected successfully","",1,"fisayo","fisayo","brume","85392020293","fisayobrume@gmail.com","dracaris","2")
        }
    }
    private inline fun runSafelyTrans(action: () ->Unit): Any{
        return try{
            action()
        }catch (t: Throwable){
            BaseResponse("98", "${t.message}")
        }finally {

        }
    }
}