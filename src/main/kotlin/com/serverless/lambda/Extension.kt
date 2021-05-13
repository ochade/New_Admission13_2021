package com.serverless.lambda

import java.io.OutputStreamWriter

fun OutputStreamWriter.closeStreamWith(response: String){
    this.write(response)
    this.close()
}