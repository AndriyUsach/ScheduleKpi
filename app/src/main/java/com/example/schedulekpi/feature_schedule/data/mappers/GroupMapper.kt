package com.example.schedulekpi.feature_schedule.data.mappers

import com.example.schedulekpi.feature_schedule.data.response.GroupResponse
import com.example.schedulekpi.feature_schedule.domain.model.Group


object GroupMapper {

    fun toGroup(group: GroupResponse): Group {
        return Group(
            id = group.id,
            fullName = group.fullName,
            prefix = group.prefix,
            url = group.url
        )
    }
}