package com.example.schedulekpi.feature_schedule.data.db

import androidx.room.*
import com.example.schedulekpi.feature_schedule.data.entities.RoomEntity

@Dao
interface RoomDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertRoom(room: RoomEntity)

    @Delete
    suspend fun deleteRoom(room: RoomEntity)

    @Query("DELETE FROM roomentity")
    suspend fun deleteAll()
}