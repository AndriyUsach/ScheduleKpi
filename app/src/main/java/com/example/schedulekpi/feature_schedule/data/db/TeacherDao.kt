package com.example.schedulekpi.feature_schedule.data.db

import androidx.room.*
import com.example.schedulekpi.feature_schedule.data.entities.TeacherEntity

@Dao
interface TeacherDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTeacher(teacher: TeacherEntity)

    @Delete
    suspend fun deleteTeacher(teacher: TeacherEntity)

    @Query("DELETE FROM teacherentity")
    suspend fun deleteAll()
}