package com.serverless.lambda
//
//import com.amazonaws.services.lambda.runtime.Context
//import com.amazonaws.services.lambda.runtime.LambdaLogger
//import com.amazonaws.services.lambda.runtime.RequestStreamHandler
//import com.google.gson.Gson
//import com.serverless.controller.PostController
//import com.serverless.modules.module
//import com.serverless.com.serverless.response.BaseResponse
//import com.serverless.service.WebSocketIntegrationService
//import com.lambda.model.AWSSocketRequest
//import com.lambda.model.AWSSocketResponse
//import com.serverless.request.FetchPostRequest
//import org.koin.core.context.startKoin
//import org.koin.java.KoinJavaComponent
//import software.amazon.awssdk.http.HttpStatusCode
//import java.io.*
//import java.util.HashMap
//
//
//class SocketHandler : RequestStreamHandler {
//    init { startKoin { modules(module) } }
//    private lateinit var logger: LambdaLogger
//    override fun handleRequest(inputStream: InputStream, outputStream: OutputStream, context: Context) {
//        logger = context.logger
//        val gson = Gson()
//        val inputStreamReader = InputStreamReader(inputStream)
//        val request = gson.fromJson(inputStreamReader, AWSSocketRequest::class.java)
//        logger.log("handleRequest: Handling incoming task request. Input: $request")
//        val postController : PostController by KoinJavaComponent.inject(PostController::class.java)
//        val routeKey = request.requestContext.routeKey
//        val eventType = request.requestContext.eventType
//        val messageID = request.requestContext.messageId
//        val requestID = request.requestContext.requestId
//        val apiId = request.requestContext.apiId
//        val connectionId = request.requestContext.connectionId
//        when (eventType.toUpperCase()) {
//            "CONNECT" -> {
//                  runSafelyTrans(outputStream) {
//                      val webSocketIntegrationService = WebSocketIntegrationService(logger)
//                      webSocketIntegrationService.onConnect(request)
//                      //Passing a custom response as the output string
//                      //Passing a custom response as the output string
//                      val response = AWSSocketResponse(body = Gson().toJson(getSuccessResponseAsMap(true)), statusCode = HttpStatusCode.OK)
//                      val writer = OutputStreamWriter(outputStream, "UTF-8")
//                      writer.closeStreamWith(Gson().toJson(response))
//                  }
//                runSafelyTrans(outputStream) {
//                    val webSocketIntegrationService = WebSocketIntegrationService(logger)
//                    webSocketIntegrationService.onConnect(request)
//                    println(connectionId)
//                    val response = AWSSocketResponse(body = Gson().toJson(getSuccessResponseAsMap(true)), statusCode = HttpStatusCode.OK)
//                    val writer = OutputStreamWriter(outputStream, "UTF-8")
//                    writer.closeStreamWith(Gson().toJson(response))
//                }
//
//            }
//            "MESSAGE"->{
//                runSafelyTrans(outputStream){
//                    val webSocketIntegrationService = WebSocketIntegrationService(logger)
//                    val requestBody = Gson().fromJson(request.body, FetchPostRequest::class.java)
//                    val message = when(requestBody.command){
//                        "posts" -> postController.getAllPosts()
//                        else -> "Unknown Routes"
//                    }
//                    webSocketIntegrationService.onMessage(request, message, requestBody.command!!)
//                    val resp = BaseResponse("00", "Welcome Adeyemi")
//                    val response = AWSSocketResponse(body =  Gson().toJson(resp), statusCode = HttpStatusCode.OK)
//                    val writer = OutputStreamWriter(outputStream, "UTF-8")
//                    writer.closeStreamWith(Gson().toJson(response))
//                }
//            }
//            "DISCONNECT" -> {  runSafelyTrans(outputStream) { println("Hello World") } }
//        }
//
//    }
//
//
//    private inline fun runSafelyTrans(outputStream: OutputStream, action: () -> Unit): Any {
//        return try {
//            action()
//        } catch (t: Throwable) {
//            val resp  = BaseResponse("92", "${t.message}")
//            val writer = OutputStreamWriter(outputStream, "UTF-8")
//            writer.closeStreamWith(Gson().toJson(resp))
//        }
//    }
//
//    private fun getSuccessResponseAsMap(success: Boolean): Map<String, Any> {
//        val response = HashMap<String, Boolean>()
//        response["success"] = success
//        return response
//    }
//
//    private fun OutputStreamWriter.closeStreamWith(response: String) {
//        this.write(response)
//        this.close()
//    }
//}
