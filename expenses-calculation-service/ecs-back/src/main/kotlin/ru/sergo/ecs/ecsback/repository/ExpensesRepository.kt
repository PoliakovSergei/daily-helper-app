package ru.sergo.ecs.ecsback.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import ru.sergo.ecs.ecsback.entity.ExpensesEntity
import java.util.*

@Repository
interface ExpensesRepository : JpaRepository<ExpensesEntity, UUID>
