package com.example.springDemo.controllers

import com.example.springDemo.db.CarsRepository
import com.example.springDemo.db.entities.Car
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class CarsController {
    @Autowired
    lateinit var carsRepository: CarsRepository

    @GetMapping("/cars")
    fun getCars() = carsRepository.findAll()

    @PostMapping("/createCar")
    fun createCar(@RequestBody car: Car): String {
        carsRepository.save(car)
        return "OK"
    }
}