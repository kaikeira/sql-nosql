package com.kaikeventura.sql_nosql

import com.github.javafaker.Faker
import java.util.Locale
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SqlNosqlApplication

fun main(args: Array<String>) {
	runApplication<SqlNosqlApplication>(*args)
}

val faker: Faker = Faker(Locale("pt-BR"))
