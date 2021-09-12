package com.example.schedulekpi.data.room.dao

import androidx.room.*
import com.example.schedulekpi.data.room.Lesson
import com.example.schedulekpi.data.room.LessonWithTeachersAndRooms

@Dao
interface LessonDao {

    @Transaction
    @Query("SELECT * FROM Lesson")
    suspend fun getLessons(): List<LessonWithTeachersAndRooms>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(lesson: Lesson)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(vararg lessons: Lesson)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(lessons: List<Lesson>)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun update(lesson: Lesson)

    @Delete
    suspend fun delete(lesson: Lesson)
}