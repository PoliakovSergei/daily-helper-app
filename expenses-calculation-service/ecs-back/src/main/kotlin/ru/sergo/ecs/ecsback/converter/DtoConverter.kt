package ru.sergo.ecs.ecsback.converter

import ru.sergo.ecs.ecsback.dto.ExpensesDto
import ru.sergo.ecs.ecsback.entity.ExpensesEntity
import java.util.*

fun expensesFromEntityToDto(expensesEntity: ExpensesEntity): ExpensesDto {
    val expensesDto = ExpensesDto()
    expensesDto.id = expensesEntity.id
    expensesDto.value = expensesEntity.value
    expensesDto.currency = Currency.getInstance(expensesEntity.currency)
    expensesDto.group = expensesEntity.group
    expensesDto.description = expensesEntity.description
    expensesDto.date = expensesEntity.date
    return expensesDto
}

fun expensesFromDtoToEntity(expensesDto: ExpensesDto): ExpensesEntity {
    val expensesEntity = ExpensesEntity()
    expensesEntity.id = expensesDto.id ?: expensesEntity.id
    expensesEntity.value = expensesDto.value
    expensesEntity.currency = expensesDto.currency.currencyCode
    expensesEntity.group = expensesDto.group
    expensesEntity.description = expensesDto.description
    expensesEntity.date = expensesDto.date
    return expensesEntity
}
