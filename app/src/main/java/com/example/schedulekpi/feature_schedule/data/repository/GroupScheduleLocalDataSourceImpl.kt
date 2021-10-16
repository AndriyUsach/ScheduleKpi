package com.example.schedulekpi.feature_schedule.data.repository

import com.example.schedulekpi.feature_schedule.data.db.*
import com.example.schedulekpi.feature_schedule.data.mappers.LessonMapper
import com.example.schedulekpi.feature_schedule.data.mappers.RoomMapper
import com.example.schedulekpi.feature_schedule.data.mappers.TeacherMapper
import com.example.schedulekpi.feature_schedule.data.relations.LessonRoomCrossRef
import com.example.schedulekpi.feature_schedule.data.relations.LessonTeacherCrossRef
import com.example.schedulekpi.feature_schedule.data.response.LessonResponse
import com.example.schedulekpi.feature_schedule.domain.model.Lesson

class GroupScheduleLocalDataSourceImpl(
    private val lessonDao: LessonDao,
    private val teacherDao: TeacherDao,
    private val roomDao: RoomDao,
    private val lessonRoomDao: LessonRoomDao,
    private val lessonTeacherDao: LessonTeacherDao,
    private val groupScheduleDao: GroupScheduleDao

) : GroupScheduleLocalDataSource {
    override suspend fun getSchedule(): List<Lesson> {
        val schedule = groupScheduleDao.getScheduleLessons()
        return schedule.map { LessonMapper.toLesson(it) }
    }

    override suspend fun saveSchedule(lessons: List<LessonResponse>) {
        lessons.forEach { lessonResponse ->
            val lessonEntity = LessonMapper.toLessonEntity(lessonResponse)
            val roomEntities = lessonResponse.rooms.map { RoomMapper.toRoomEntity(it) }
            val teacherEntities = lessonResponse.teachers.map { TeacherMapper.toTeacherEntity(it) }
            lessonDao.insertLesson(lessonEntity)
            roomEntities.forEach {
                roomDao.insertRoom(it)
                lessonRoomDao.insertLessonRoom(
                    LessonRoomCrossRef(
                        lessonId = lessonEntity.lessonId,
                        roomId = it.id
                    )
                )
            }
            teacherEntities.forEach {
                teacherDao.insertTeacher(it)
                lessonTeacherDao.insertLessonTeacher(
                    LessonTeacherCrossRef(
                        lessonId = lessonEntity.lessonId,
                        it.teacherId
                    )
                )
            }
        }
    }

    override suspend fun clearSchedule() {
        lessonRoomDao.deleteAll()
        lessonTeacherDao.deleteAll()
        roomDao.deleteAll()
        teacherDao.deleteAll()
        lessonDao.deleteAll()
    }
}