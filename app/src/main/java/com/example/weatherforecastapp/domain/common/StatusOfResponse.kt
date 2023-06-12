package com.example.weatherforecastapp.domain.common

interface StatusOfResponse {
    var status: String
}

class StatusResponse(override var status: String): StatusOfResponse