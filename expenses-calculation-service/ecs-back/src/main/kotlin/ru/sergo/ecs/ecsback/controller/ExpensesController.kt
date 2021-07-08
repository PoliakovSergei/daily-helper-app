package ru.sergo.ecs.ecsback.controller

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
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

    companion object {
        private val log: Logger = LoggerFactory.getLogger(this::class.java)
    }

    @GetMapping("/get")
    fun getAllExpenses(): Response<List<ExpensesDto>> =
        Response.ok(expensesService.getAll())

    @PostMapping("/add")
    fun addExpenses(@RequestBody expenses: ExpensesDto): Response<ExpensesDto> =
        Response.ok(expensesService.addExpenses(expenses))

    @PutMapping("/update")
    fun updateExpenses(@RequestBody expenses: ExpensesDto): Response<ExpensesDto> =
        Response.ok(expensesService.updateExpenses(expenses))

    @DeleteMapping("/delete/{uuid}")
    fun deleteExpenses(@PathVariable uuid: UUID): Response<UUID> =
        Response.ok(expensesService.deleteExpensesById(uuid))

    @GetMapping("/available-currencies")
    fun getAvailableCurrency(): Response<Set<Currency>> =
        Response.ok(expensesService.getAvailableCurrencies())

    @ExceptionHandler(Exception::class)
    protected fun handleException(e: Exception): Response<Any> {
        val msg = "Ошибка в контроллере Expenses: " + e.message
        log.error(msg)
        return Response.fail(HttpStatus.INTERNAL_SERVER_ERROR, msg)
    }
}
