package com.example.seollyongdan_frontend.data.mapper

import com.example.seollyongdan_frontend.data.dto.response.ResponseGetExampleDto
import com.example.seollyongdan_frontend.domain.entity.ExampleEntity

fun ResponseGetExampleDto.toExampleEntity() = ExampleEntity(
    email, firstName, avatar
)