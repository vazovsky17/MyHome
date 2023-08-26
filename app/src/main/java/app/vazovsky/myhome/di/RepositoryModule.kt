package app.vazovsky.myhome.di

import app.vazovsky.myhome.data.repository.CameraRepository
import app.vazovsky.myhome.data.repository.CameraRepositoryImpl
import app.vazovsky.myhome.data.repository.DoorRepository
import app.vazovsky.myhome.data.repository.DoorRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun bindDoorRepository(impl: DoorRepositoryImpl): DoorRepository

    @Binds
    abstract fun bindCameraRepository(impl: CameraRepositoryImpl): CameraRepository

}