package ru.sergo.ecs.ecsback.dto

import org.springframework.http.HttpStatus

data class Response<T> (val code: Int, val data: T?, val message: String) {

    companion object ResponseBuilder {
        fun <T> ok(data: T): Response<T> {
            return Response(HttpStatus.OK.value(), data, HttpStatus.OK.reasonPhrase)
        }

        fun <T> fail(status: HttpStatus , message: String): Response<T> {
            return Response(status.value(), null, message)
        }
    }
}