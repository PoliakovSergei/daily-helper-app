package ru.sergo.ecs.ecsback.dto

import java.time.LocalDateTime
import java.util.*

data class ExpensesDto(val id: UUID, val group: String, val description: String, val created: LocalDateTime)