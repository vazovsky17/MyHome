package app.vazovsky.myhome.data.repository

import app.vazovsky.myhome.domain.model.DoorList

interface DoorRepository {
    suspend fun getDoors(): DoorList
}