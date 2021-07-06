package ru.sergo.ecs.ecsback.dto

import com.fasterxml.jackson.annotation.JsonFormat
import java.time.LocalDateTime
import java.util.*

class ExpensesDto {
    var id: UUID? = null

    var value: Double = 0.0

    lateinit var currency: Currency

    lateinit var group: String

    lateinit var description: String

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    lateinit var date: LocalDateTime
}