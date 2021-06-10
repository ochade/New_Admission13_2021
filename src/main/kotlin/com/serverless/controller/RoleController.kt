package com.serverless.controller

import com.google.gson.Gson
import com.serverless.model.Admission
import com.serverless.model.Role
import com.serverless.request.CreateAdmissionRequest
import com.serverless.request.CreateRoleRequest
import com.serverless.response.BaseResponse
import com.serverless.service.AdmissionService
import com.serverless.service.RoleService

class RoleController {
    private val roleService = RoleService()

    fun createRoleTable(): Any {

        return runSafelyTrans {
            roleService.createRoleTable()

            return BaseResponse("00","role Table created sucesfully")
        }

    }
    fun createRole(request:String): Any{
//        //converting json coming from the handler to my own request class - createclientrequest
        // val createClientRequest = Gson().fromJson(request, CreateClientRequest::class.java)
        println(request)
        val createRoleRequest = Gson().fromJson(request, CreateRoleRequest::class.java)

        val role = Role(0,createRoleRequest.title)
        roleService.createRoleService(role)

        return runSafelyTrans {
            roleService.createRoleService(role)
            return BaseResponse("00","admission created sucesfully")
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

    private fun runSafelyTrans(action: () ->Unit): Any {
        return  try{
            action()
        }catch(t:Throwable){
            BaseResponse("98","${t.message}")
        }finally {

        }
    }

    }
