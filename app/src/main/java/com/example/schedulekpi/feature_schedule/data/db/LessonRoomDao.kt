package com.example.schedulekpi.feature_schedule.data.db

import androidx.room.*
import com.example.schedulekpi.feature_schedule.data.relations.LessonRoomCrossRef

@Dao
interface LessonRoomDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertLessonRoom(crossRef: LessonRoomCrossRef)

    @Delete
    suspend fun deleteLessonRoom(crossRef: LessonRoomCrossRef)

    @Query("DELETE FROM lessonroomcrossref")
    suspend fun deleteAll()
}