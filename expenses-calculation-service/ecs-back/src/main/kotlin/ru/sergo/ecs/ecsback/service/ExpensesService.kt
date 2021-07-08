package ru.sergo.ecs.ecsback.service

import org.springframework.stereotype.Service
import ru.sergo.ecs.ecsback.converter.expensesFromDtoToEntity
import ru.sergo.ecs.ecsback.converter.expensesFromEntityToDto
import ru.sergo.ecs.ecsback.dto.ExpensesDto
import ru.sergo.ecs.ecsback.repository.ExpensesRepository
import java.util.*

@Service
class ExpensesService(val expensesRepository: ExpensesRepository) {

    fun getAll(): List<ExpensesDto> =
        expensesRepository.findAll().map { expensesFromEntityToDto(it) }

    fun addExpenses(expensesDto: ExpensesDto): ExpensesDto {
        val expensesEntity = expensesRepository.save(expensesFromDtoToEntity(expensesDto))
        return expensesFromEntityToDto(expensesEntity)
    }

    fun updateExpenses(expensesDto: ExpensesDto): ExpensesDto {
        val expensesEntity = expensesRepository.save(expensesFromDtoToEntity(expensesDto))
        return expensesFromEntityToDto(expensesEntity)
    }

    fun deleteExpensesById(uuid: UUID): UUID {
        expensesRepository.deleteById(uuid)
        return uuid
    }

    fun getAvailableCurrencies(): Set<Currency> = Currency.getAvailableCurrencies()

}