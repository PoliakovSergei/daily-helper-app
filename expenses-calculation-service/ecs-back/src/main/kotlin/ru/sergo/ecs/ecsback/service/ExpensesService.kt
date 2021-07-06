package ru.sergo.ecs.ecsback.service

import org.springframework.stereotype.Service
import ru.sergo.ecs.ecsback.converter.expensesFromDtoToEntity
import ru.sergo.ecs.ecsback.converter.expensesFromEntityToDto
import ru.sergo.ecs.ecsback.dto.ExpensesDto
import ru.sergo.ecs.ecsback.dto.Response
import ru.sergo.ecs.ecsback.repository.ExpensesRepository
import java.util.*

@Service
class ExpensesService(val expensesRepository: ExpensesRepository) {

    fun getAll(): Response<List<ExpensesDto>> {
        val expensesDtoList = expensesRepository.findAll()
            .map { expensesFromEntityToDto(it) }
        return Response.ok(expensesDtoList)
    }

    fun addExpenses(expensesDto: ExpensesDto): Response<ExpensesDto> {
        val expensesEntity = expensesRepository.save(expensesFromDtoToEntity(expensesDto))
        return Response.ok(expensesFromEntityToDto(expensesEntity))
    }

    fun updateExpenses(expensesDto: ExpensesDto): Response<ExpensesDto> {
        val expensesEntity = expensesRepository.save(expensesFromDtoToEntity(expensesDto))
        return Response.ok(expensesFromEntityToDto(expensesEntity))
    }

    fun deleteExpensesById(uuid: UUID): Response<UUID> {
        expensesRepository.deleteById(uuid)
        return Response.ok(uuid)
    }

    fun getAvailableCurrencies(): Response<Set<Currency>> {
        return Response.ok(Currency.getAvailableCurrencies())
    }

}