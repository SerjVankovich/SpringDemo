package com.example.springDemo.controllers.responses

import java.sql.Timestamp
import java.util.*

data class OkResponse (val message: String, val status: Int, val path: String, val timestamp: Date)