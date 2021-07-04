package ru.sergo.ecs.ecsback

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class EcsBackApplication

fun main(args: Array<String>) {
    runApplication<EcsBackApplication>(*args)
}

