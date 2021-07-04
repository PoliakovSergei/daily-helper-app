import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    java
    kotlin("jvm") version "1.5.20"
    id("org.springframework.boot") version "2.0.1.RELEASE"
    id("org.jetbrains.kotlin.plugin.spring") version "1.5.20"
}

val mainClassPath = "ru.sergo.ecs.ecsback.EcsBackApplication"

group = "ru.sergo.ecs"
version = "0.0.1"
description = "ecs-back"

java {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
}

tasks.compileJava {
    options.encoding = "UTF-8"
}

springBoot {
    mainClassName = mainClassName
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web:2.3.4.RELEASE")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa:2.3.4.RELEASE")
    implementation("org.springframework.boot:spring-boot-starter-security:2.3.4.RELEASE")
    implementation("org.liquibase:liquibase-core:3.8.9")
    implementation("org.postgresql:postgresql:42.2.16")
    implementation("org.projectlombok:lombok:1.18.12")

    annotationProcessor("org.projectlombok:lombok:1.18.12")

    testImplementation("org.springframework.boot:spring-boot-starter-test:2.3.4.RELEASE")
    implementation(kotlin("stdlib-jdk8"))
}

repositories {
    mavenLocal()
    mavenCentral()
}
val compileKotlin: KotlinCompile by tasks
compileKotlin.kotlinOptions {
    jvmTarget = "1.8"
}
val compileTestKotlin: KotlinCompile by tasks
compileTestKotlin.kotlinOptions {
    jvmTarget = "1.8"
}