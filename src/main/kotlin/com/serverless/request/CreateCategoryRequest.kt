package com.serverless.request

import javax.validation.constraints.NotEmpty

class CreateCategoryRequest(
    @get:NotEmpty(message = "admission type is required")
    val category_name:String?,
    @get:NotEmpty(message = "admission status is required")
    val form_price:String?,

)