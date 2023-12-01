package com.packt.chapterfourteen

import com.google.common.io.Resources
import okhttp3.mockwebserver.Dispatcher
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.RecordedRequest
import java.io.File
import java.net.HttpURLConnection

class MockRequestDispatcher : Dispatcher() {

    override fun dispatch(request: RecordedRequest): MockResponse {
        return when (request.path) {
            "/cats?tag=cute" -> {
                MockResponse()
                    .setResponseCode(HttpURLConnection.HTTP_OK)
                    .setBody(getJson("catsresponse.json"))
            }

            else -> throw IllegalArgumentException("Unknown Request Path ${request.path}")
        }
    }

    private fun getJson(path: String): String {
        val uri = Resources.getResource(path)
        val file = File(uri.path)
        return String(file.readBytes())
    }
}