package org.jesperancinha.spot.on.service

import org.jesperancinha.spot.on.domain.SpotOn
import org.jesperancinha.spot.on.domain.SpotOnRepository
import org.springframework.stereotype.Service
import java.util.*

class SpotOnDto (
    val id: UUID,
    val url:String,
    val name:String,
    val intro:String,
)

@Service
class SpotOnService(
    val spotOnRepository: SpotOnRepository
) {
    suspend fun upsert(spotOnDto: SpotOnDto) = spotOnRepository.save(spotOnDto.toData()).toDto()

    fun getAll() = spotOnRepository.findAll()
}

fun SpotOnDto.toData() = SpotOn(
    id = this.id,
    url = this.url,
    name = this.name,
    intro = this.intro
)

fun SpotOn.toDto() = SpotOnDto(
    id = this.id,
    url = this.url,
    name = this.name,
    intro = this.intro
)