package com.example.schedulekpi.feature_schedule.data.db

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import com.example.schedulekpi.feature_schedule.data.relations.LessonWithTeachersAndRooms


@Dao
interface GroupScheduleDao {

    @Transaction
    @Query("SELECT * FROM lessonentity WHERE lesson_id = :lessonId")
    suspend fun getScheduleLesson(lessonId: Int): LessonWithTeachersAndRooms

    @Transaction
    @Query("SELECT * FROM lessonentity")
    suspend fun getScheduleLessons(): List<LessonWithTeachersAndRooms>

    @Transaction
    @Query("SELECT * FROM lessonentity WHERE week_number = :weekNumber")
    suspend fun getScheduleLessonsByWeek(weekNumber: Int): List<LessonWithTeachersAndRooms>
}