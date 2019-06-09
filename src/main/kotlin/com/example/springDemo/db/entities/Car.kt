package com.example.springDemo.db.entities

import javax.persistence.*

@Entity
class Car (
        val company: String,
        val model: String,
        val year: Int,

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        val id: Long = -1
) {
        private constructor(): this("", "", 2019)
}
