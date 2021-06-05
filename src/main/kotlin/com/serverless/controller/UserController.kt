package com.serverless.controller

import com.google.gson.Gson
import com.serverless.model.User
import com.serverless.request.*
import com.serverless.response.BaseResponse
import com.serverless.service.UserService

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
        val user = User(0, createUserRequest.username, createUserRequest.lastname, createUserRequest.phonenumber, createUserRequest.email,createUserRequest.password, createUserRequest.role_id )

        return runSafelyTrans {
            userService.createUserService(user)
            return BaseResponse("00","user created sucesfully")
        }
//
    }
    fun UpdateUser(request: String):Any{
        val updateUserRequest = Gson().fromJson(request, UpdateUserRequest::class.java)
       // val user = User(updateAdmissionRequest.admission_id,updateAdmissionRequest.admisssion_type,updateAdmissionRequest.admission_status,updateAdmissionRequest.admission_description)

        val user = User(updateUserRequest.user_id, updateUserRequest.username, updateUserRequest.lastname, updateUserRequest.phonenumber, updateUserRequest.email, updateUserRequest.password, updateUserRequest.role_id )
        return runSafelyTrans {
            userService.updateUserTable(user)

            return BaseResponse("00","user updated sucesfully")
        }
    }
    fun SelectUser(request: String): Any{
        val selectUserRequest = Gson().fromJson(request, SelectUserRequest::class.java)
        val user = User( selectUserRequest.user_id, selectUserRequest.username, selectUserRequest.lastname, selectUserRequest.phonenumber, selectUserRequest.email, selectUserRequest.password, selectUserRequest.role_id)

        return runSafelyTrans {
            userService.selectUser(user.username!!)

            return BaseResponse("00","user selected successfully")
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