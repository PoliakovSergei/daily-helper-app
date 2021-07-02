plugins {
    java
    id("org.springframework.boot") version "2.0.1.RELEASE"
    id("io.freefair.lombok") version "6.0.0-m2"
}

val mainClassPath = "ru.sergo.todoapp.todoback.TodoBackApplication"

group = "ru.sergo.todoapp"
version = "0.0.1"
description = "todo-back"

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
    implementation("org.springframework.boot:spring-boot-starter:2.3.4.RELEASE")
    implementation("org.springframework.boot:spring-boot-starter-web:2.3.4.RELEASE")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa:2.3.4.RELEASE")
    implementation("org.springframework.boot:spring-boot-starter-security:2.3.4.RELEASE")
    implementation("org.liquibase:liquibase-core:3.8.9")
    implementation("org.postgresql:postgresql:42.2.16")
    implementation("org.projectlombok:lombok:1.18.12")

    testImplementation("org.springframework.boot:spring-boot-starter-test:2.3.4.RELEASE")
}

repositories {
    mavenLocal()
    mavenCentral()
}
