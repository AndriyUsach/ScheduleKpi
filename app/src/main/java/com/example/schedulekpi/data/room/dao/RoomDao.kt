package com.example.schedulekpi.data.room.dao

import androidx.room.*
import com.example.schedulekpi.data.room.Room


@Dao
interface RoomDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(room: Room)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(vararg rooms: Room)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(rooms: List<Room>)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun update(room: Room)

    @Delete
    suspend fun delete(room: Room)
}