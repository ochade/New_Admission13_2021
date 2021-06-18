package com.serverless.controller

import com.google.gson.Gson
import com.serverless.model.Admission
import com.serverless.model.Category
import com.serverless.request.CreateAdmissionRequest
import com.serverless.request.CreateCategoryRequest
import com.serverless.request.UpdateAdmissionRequest
import com.serverless.response.BaseResponse
import com.serverless.service.CategoryService

class CategoryController {

    private val categoryService: CategoryService = CategoryService()

    fun createCategoryTable(): Any {

        return runSafelyTrans {

            categoryService.createCategoryTable()
            return BaseResponse("00","category Table created sucesfully")
        }

    }


    fun createCategory(request:String): Any{
//        //converting json coming from the handler to my own request class - createclientrequest
        // val createClientRequest = Gson().fromJson(request, CreateClientRequest::class.java)
        println(request)
        val createCategoryRequest = Gson().fromJson(request, CreateCategoryRequest::class.java)
        val category = Category(0,createCategoryRequest.category_name , createCategoryRequest.form_price)

//        val client = Client(0,createClientRequest.client_name,createClientRequest.address,createClientRequest.industry)
//        clientService.createClientsService(client)
        return runSafelyTrans {

            categoryService.createCategoryService(category)
            return BaseResponse("00","category created sucesfully")
        }
//
    }
//
//    fun UpdateCategory(request: String):Any{
//        val updateAdmissionRequest = Gson().fromJson(request, UpdateAdmissionRequest::class.java)
//        val admission = Admission(updateAdmissionRequest.admission_id,updateAdmissionRequest.admisssion_type,updateAdmissionRequest.admission_status,updateAdmissionRequest.admission_description)
//        return runSafelyTrans {
//            admissionService.updateAdmissionTable(admission)
//
//            return BaseResponse("00","admission updated sucesfully")
//        }
    private inline fun runSafelyTrans(action: () ->Unit): Any{
        return try{
            action()
        }catch (t: Throwable){
            BaseResponse("98", "${t.message}")
        }finally {

        }
    }
    }