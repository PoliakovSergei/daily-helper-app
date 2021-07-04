package ru.sergo.ecs.ecsback.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import ru.sergo.ecs.ecsback.aspect.LogBefore
import ru.sergo.ecs.ecsback.dto.ExpensesDto
import ru.sergo.ecs.ecsback.dto.Response
import ru.sergo.ecs.ecsback.service.ExpensesService

@LogBefore
@RestController
@RequestMapping("/expenses")
class ExpensesController(open val expensesService: ExpensesService) {

    @GetMapping("/get")
    fun getAllExpenses(): Response<List<ExpensesDto>> = expensesService.getAll()

    @PostMapping("/add")
    fun addExpenses(expenses: ExpensesDto): Response<ExpensesDto> = expensesService.addExpenses(expenses)
}