package ru.sergo.ecs.ecsback.controller

import org.springframework.web.bind.annotation.*
import ru.sergo.ecs.ecsback.aspect.LogBefore
import ru.sergo.ecs.ecsback.dto.ExpensesDto
import ru.sergo.ecs.ecsback.dto.Response
import ru.sergo.ecs.ecsback.service.ExpensesService
import java.util.*

@LogBefore
@RestController
@RequestMapping("/expenses")
class ExpensesController(open val expensesService: ExpensesService) {

    @GetMapping("/get")
    fun getAllExpenses(): Response<List<ExpensesDto>> = expensesService.getAll()

    @PostMapping("/add")
    fun addExpenses(@RequestBody expenses: ExpensesDto): Response<ExpensesDto> = expensesService.addExpenses(expenses)

    @PutMapping("/update")
    fun updateExpenses(@RequestBody expenses: ExpensesDto): Response<ExpensesDto> = expensesService.updateExpenses(expenses)

    @DeleteMapping("/delete/{uuid}")
    fun deleteExpenses(@PathVariable uuid: UUID): Response<UUID> = expensesService.deleteExpensesById(uuid)

    @GetMapping("/available-currencies")
    fun getAvailableCurrency(): Response<Set<Currency>> = expensesService.getAvailableCurrencies()
}