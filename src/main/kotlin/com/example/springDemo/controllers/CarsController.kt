package com.example.springDemo.controllers

import com.example.springDemo.controllers.responses.OkResponse
import com.example.springDemo.db.CarsRepository
import com.example.springDemo.db.entities.Car
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
class CarsController {
    @Autowired
    lateinit var carsRepository: CarsRepository

    @GetMapping("/cars")
    fun getCars() = carsRepository.findAll()

    @GetMapping("/cars/{id}")
    fun getCarById(@PathVariable id: Long) = carsRepository.findById(id)

    @GetMapping("/cars/findByCompany/{company}")
    fun getCarsByCompany(@PathVariable company: String) = carsRepository.findByCompany(company)

    @GetMapping("/cars/findByModel/{model}")
    fun getCarsByModel(@PathVariable model: String) = carsRepository.findByModel(model)

    @PostMapping("/createCar")
    fun createCar(@RequestBody car: Car): OkResponse {
        carsRepository.save(car)
        return OkResponse("Successfully added new car", 200, "/createCar", Date())
    }

    @PutMapping("/updateCar/{id}")
    fun updateCar(@RequestBody car: Car, @PathVariable id: Long): OkResponse {
        val dbCar = carsRepository.findById(id).get()
        dbCar.company = car.company
        dbCar.model = car.model
        dbCar.year = car.year

        carsRepository.save(dbCar)

        return OkResponse("Successfully updated car with id: ${id}", 200, "/updateCar/${id}", Date())
    }

    @DeleteMapping("/deleteCar/{id}")
    fun deleteCar(@PathVariable id: Long) : OkResponse {
        carsRepository.deleteById(id)

        return OkResponse("Successfully deleted car with id: ${id}", 200, "/deleteCar/${id}", Date())
    }
}