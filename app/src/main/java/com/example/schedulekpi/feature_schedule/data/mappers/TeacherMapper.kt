package com.example.schedulekpi.feature_schedule.data.mappers

import com.example.schedulekpi.feature_schedule.data.entities.TeacherEntity
import com.example.schedulekpi.feature_schedule.data.response.GroupTeacherDataResponse
import com.example.schedulekpi.feature_schedule.domain.model.Teacher

object TeacherMapper {

    fun toTeacher(entity: TeacherEntity): Teacher {
        return Teacher(
            id = entity.teacherId,
            name = entity.name,
            fullName = entity.fullName,
            shortName = entity.shortName,
            url = entity.url
        )
    }

    fun toTeacher(response: GroupTeacherDataResponse): Teacher {
        return Teacher(
            id = response.id.toInt(),
            name = response.name,
            fullName = response.fullName,
            shortName = response.shortName,
            url = response.url
        )
    }

    fun toTeacherEntity(response: GroupTeacherDataResponse): TeacherEntity {
        return TeacherEntity(
            teacherId = response.id.toInt(),
            name = response.name,
            fullName = response.fullName,
            shortName = response.shortName,
            url = response.url,
            rating = response.rating
        )
    }
}