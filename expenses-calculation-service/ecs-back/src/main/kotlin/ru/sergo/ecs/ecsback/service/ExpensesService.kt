package ru.sergo.ecs.ecsback.service

import org.springframework.stereotype.Service
import ru.sergo.ecs.ecsback.dto.ExpensesDto
import ru.sergo.ecs.ecsback.dto.Response
import java.util.*

@Service
class ExpensesService {

    fun getAll(): Response<List<ExpensesDto>> {
        return Response.ok(Collections.emptyList())
    }

    fun addExpenses(expensesDto: ExpensesDto): Response<ExpensesDto> {
        return Response.ok(expensesDto)
    }

}