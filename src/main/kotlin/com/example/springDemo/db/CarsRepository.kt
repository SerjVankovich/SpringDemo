package com.example.springDemo.db

import com.example.springDemo.db.entities.Car
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface CarsRepository : CrudRepository<Car, Long>{
    fun findByCompany(company: String): Iterable<Car>
    fun findByModel(model: String): Iterable<Car>
}