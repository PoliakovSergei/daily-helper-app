package ru.sergo.ecs.ecsback.entity

import java.time.LocalDateTime
import java.util.*
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "EXPENSES", schema = "ecs_app")
class ExpensesEntity {

    @Id
    @Column(name = "EXPENSES_ID")
    var id: UUID = UUID.randomUUID()

    @Column(name = "EXPENSES_VALUE")
    var value: Double = 0.0

    @Column(name = "EXPENSES_CURRENCY")
    lateinit var currency: String

    @Column(name = "EXPENSES_GROUP")
    lateinit var group: String

    @Column(name = "EXPENSES_DESCRIPTION")
    lateinit var description: String

    @Column(name = "EXPENSES_DATE")
    lateinit var date: LocalDateTime

}
