package com.example.schedulekpi.feature_schedule.data.mappers

import com.example.schedulekpi.feature_schedule.data.entities.RoomEntity
import com.example.schedulekpi.feature_schedule.data.response.RoomResponse
import com.example.schedulekpi.feature_schedule.domain.model.Room

object RoomMapper {

    fun toRoom(response: RoomResponse): Room {
        return Room(
            id = response.id.toInt(),
            name = response.name,
        )
    }

    fun toRoom(entity: RoomEntity): Room {
        return Room(
            id = entity.id,
            name = entity.name
        )
    }

    fun toRoomEntity(response: RoomResponse): RoomEntity {
        return RoomEntity(
            id = response.id.toInt(),
            name = response.name,
            latitude = response.latitude,
            longitude = response.longitude
        )
    }
}