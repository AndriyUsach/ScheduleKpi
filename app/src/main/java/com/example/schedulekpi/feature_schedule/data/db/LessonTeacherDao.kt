package com.example.schedulekpi.feature_schedule.data.db

import androidx.core.provider.FontsContractCompat
import androidx.room.*
import com.example.schedulekpi.feature_schedule.data.relations.LessonTeacherCrossRef


@Dao
interface LessonTeacherDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertLessonTeacher(crossRef: LessonTeacherCrossRef)

    @Delete
    suspend fun deleteLessonTeacher(crossRef: LessonTeacherCrossRef)

    @Query("DELETE FROM lessonteachercrossref")
    suspend fun deleteAll()
}