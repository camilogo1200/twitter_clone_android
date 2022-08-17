package com.example.mptwitterclone.common.network

import okhttp3.*
import okhttp3.Interceptor.Chain
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.internal.http2.Http2Reader.Companion.logger

class LoggingInterceptor : Interceptor {
    private val isMockEnvironmentActive = false //Postman Mock

    companion object {
        const val INITIAL_DELIMITER =
            ":::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::"
        const val DELIMITER =
            "================================================================================================================="

    }

    override fun intercept(chain: Chain): Response {

        val request: Request = chain.request()

        val t1 = System.nanoTime()
        logger.info(
            buildString {
                appendLine(" ")
                appendLine(INITIAL_DELIMITER)
                appendLine("SENDING REQUEST: [${request.method.uppercase()}] method to { ${request.url} }")
                appendLine("CONNECTION : ${chain.connection()}")
                appendLine("HTTPS : ${request.isHttps}")
                append("HEADERS : \n${request.headers}")
                append(DELIMITER)
                if (request.method in listOf("POST", "PUT", "PATCH")) {
                    appendLine("BODY : ${request.body}")
                    appendLine(DELIMITER)
                }
                appendLine()
            }
        )
        val response = if (isMockEnvironmentActive) {
            getResponseByUrl(chain, request.method, request.url)
        } else {
            chain.proceed(request)
        }
        val t2 = System.nanoTime()

        val st = String.format(
            "RECEIVED RESPONSE : for %s in [ %.1fms ]%n",
            response.request.url, (t2 - t1) / 1e6
        )
        logger.info(
            buildString {
                appendLine(" ")
                appendLine(INITIAL_DELIMITER)
                append(st)
                append("HEADERS : \n${response.headers}")
                appendLine("BODY : ${request.body}")
                append(DELIMITER)
                appendLine()
            }
        )
        return response
    }

    private fun getResponseByUrl(chain: Chain, method: String, url: HttpUrl): Response {


        val rawJson = loadResponseByUrl(method, url)
        val body = ResponseBody.create(
            "application/json".toMediaTypeOrNull(),
            rawJson.toByteArray()
        )

        val response = Response.Builder()
            .code(200)
            .message(rawJson)
            .body(body)
            .request(chain.request())
            .addHeader("content-type", "application/json")
            .protocol(Protocol.HTTP_2)
            .build()
        return response
    }

    private fun loadResponseByUrl(method: String, url: HttpUrl): String {
        val fileName = getFilenameByRequestUrl(url, method)
        val json = readFile(fileName)
        return json
    }

    private fun readFile(fileName: String): String {
        //TODO readFile
        return "" //Json.encodeToString(tweetsData)
    }

    private fun getFilenameByRequestUrl(url: HttpUrl, method: String): String {
        return "gettimeline.json"
    }
}
