package com.serverless.lambda

import com.amazonaws.services.lambda.runtime.Context
import com.amazonaws.services.lambda.runtime.LambdaLogger
import com.amazonaws.services.lambda.runtime.RequestStreamHandler
import com.google.gson.Gson
import com.serverless.controller.*
import com.serverless.controller.AdmissionController

import com.serverless.lambda.request.AWSLambdaRequest
import com.serverless.lambda.response.AwsLambdaResponse
import org.apache.logging.log4j.LogManager
import java.io.InputStream
import java.io.InputStreamReader
import java.io.OutputStream
import java.io.OutputStreamWriter

class Handler: RequestStreamHandler {
  private lateinit var logger: LambdaLogger

//  init { startKoin { modules(module) } }

  override fun handleRequest(input: InputStream, output: OutputStream, context: Context) {
    logger = context.logger
    val gson = Gson()
    val inputStreamReader = InputStreamReader(input)
    val request  = gson.fromJson(inputStreamReader, AWSLambdaRequest::class.java)
    logger.log("handleRequest: Handling incoming task request. Input: ${request.body}")
    val path = request.pathParameters.proxy
    println(path)
    val admissionController =AdmissionController()
    val applicantController = ApplicantController()
////    val merchant: MerchantController by KoinJavaComponent.inject(MerchantController::class.java)
////    val customer: CustomerController by KoinJavaComponent.inject(CustomerController::class.java)
////    val receipts: ReceiptController by KoinJavaComponent.inject(ReceiptController::class.java)
////    val postController: PostController by KoinJavaComponent.inject(PostController::class.java)
////    val auth : AuthController by KoinJavaComponent.inject(AuthController::class.java)
    val response : Any  = when(path.toLowerCase()) {
    //  "client/all" ->  client.selectAllClient()
      //"admission/all"
     // "client/create" ->  client.createClient(request.body)
      "admission/create" -> admissionController.createAdmission(request.body)
      "admission/all" -> admissionController.selectAllAdmission()
      "admission/update" -> admissionController.UpdateAdmission(request.body)
      "admission/delete" -> admissionController.deleteAdmission(request.body)

      "applicant/create" -> applicantController.createApplicant(request.body)
//      "person/createprofile" ->  person.createRubiesProfile(request.body)
//      "person/all" -> person.getAllPersons()
//      "person/findall" -> person.getAllAgentsCustomerid(request.body)
//      "person/completeenrollment" -> person.confirmPerson(request.body)
//      "person/checkuserexist" -> person.checkUserExists(request.body)
//      "person/logincomplete" -> person.loginCompleteBusiness(request.body)
//      "person/progressstatus" -> person.progressStatus(request.body)


//      "auth/login" -> auth.login(request.body)
//      "auth/queryuser" -> auth.queryCustomer(request.body)
//
//      "profile/initiate" -> auth.enrollmentInitiate(request.body)
//      "profile/complete" -> auth.enrollmentComplete(request.body)
//
//
//      "company/create" -> auth.createCompany(request.body)
//      "merchant/enroll" -> merchant.newBusiness(request.body)
//      "company/get" -> auth.getUserCompany(request.body)
//      "merchant/get" -> merchant.getBusinessAccounts(request.body)
//      "merchant/addaccounts" -> merchant.addSubAccount(request.body)
//      "merchant/suggested" -> merchant.getSuggestedMerchants()
//      "merchant/generatesubaccount" -> merchant.generateSubAccount(request.body)
//      "merchant/deleteaccount" -> merchant.deleteAccount(request.body)
//      "merchant/invoices" -> merchant.getMerchantInvoices(request.body)
//      "merchant/customers" -> merchant.getMerchantCustomers(request.body)
//      "merchant/customer/create" -> merchant.createCustomers(request.body)
//      "merchant/customer/delete" -> merchant.deleteCustomer(request.body)
//      "merchant/customer/edit" -> merchant.editCustomer(request.body)
//      "merchant/invoice/create" -> merchant.raiseInvoiceOnCustomer(request.body)
//      "merchant/overview" -> merchant.merchantOverview(request.body)
//      "merchant/sales" -> merchant.getMerchantSales(request.body)
//
//
//      "merchant/orders" -> receipts.merchantOrders(request.body)
//      "orders/create" -> receipts.createReceipt(request.body)
//      "orders/item/add" -> receipts.addItem(request.body)
//      "orders/item/remove" -> receipts.removeItem(request.body)
//      "orders/items" -> receipts.findReceiptItems(request.body)
//      "orders/submit" -> receipts.submitOrder(request.body)
//      "customers/orders" -> receipts.customerOrders(request.body)
//




//      "customer/invoices" -> customer.getCustomerInvoices(request.body)
//
//
//
//
//      "bank/nameenquiry" -> merchant.nameEnquiry(request.body)
//      "bank/getbanks" -> merchant.getAllBanks()
//
//
//      "post/all" -> postController.getAllPosts(request.body)
//      "post/comment" -> postController.createReactions(request.body)
//
//
//      "product/all" -> product.getAllProducts()
//      "product/create" -> product.createProduct(request.body)
//      "product/update" -> product.editProduct(request.body)
//      "product/findbymerchant" -> product.getProductByMerchantId(request.body)
//      "product/delete" -> product.deleteProduct(request.body)
//      "product/category/create" -> product.createCategory(request.body)
//      "product/category/all" -> product.getCategories()





      "user/register" -> "welcome to register endpoint"
      "user/login" -> "welcome to user login endpoint"
      "user/all" -> "welcome to all users"
      "user/find/email" -> "welcome to email find"
      "user/find/userid" -> "welcome to find user"
      "user/find" -> "welcome to find privilege"

      else ->  "Incorrect Path"
    }


    logger.log("Response: ${gson.toJson(AwsLambdaResponse(body =  gson.toJson(response)).body)}")
    val writer = OutputStreamWriter(output, "UTF-8")
    writer.closeStreamWith(gson.toJson(AwsLambdaResponse(body = gson.toJson(response))))

  }
  companion object {
    private val LOG = LogManager.getLogger(Handler::class.java)
  }
}
