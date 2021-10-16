package com.example.schedulekpi.feature_schedule.data.db

import androidx.room.*
import com.example.schedulekpi.feature_schedule.data.entities.LessonEntity

@Dao
interface LessonDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertLesson(lesson: LessonEntity)

    @Delete
    suspend fun deleteLesson(lesson: LessonEntity)

    @Query("DELETE FROM lessonentity")
    suspend fun deleteAll()
}