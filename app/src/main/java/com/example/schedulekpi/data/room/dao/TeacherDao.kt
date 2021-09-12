package com.example.schedulekpi.data.room.dao

import androidx.room.*
import com.example.schedulekpi.data.room.Teacher

@Dao
interface TeacherDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(teacher: Teacher)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(vararg teachers: Teacher)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(teachers: List<Teacher>)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun update(teachers: Teacher)

    @Delete
    suspend fun delete(teacher: Teacher)
}