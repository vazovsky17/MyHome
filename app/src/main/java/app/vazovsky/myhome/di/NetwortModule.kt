package app.vazovsky.myhome.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.ktor.client.HttpClient
import io.ktor.client.engine.okhttp.OkHttp
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.ANDROID
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.serialization.kotlinx.json.json
import javax.inject.Qualifier
import javax.inject.Singleton
import kotlinx.serialization.json.Json

@Qualifier
annotation class ApiClient

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    @Provides
    @Singleton
    fun provideJsonConverter() = Json {
        ignoreUnknownKeys = true
    }

    @Provides
    @Singleton
    @ApiClient
    fun provideApiClient(
        json: Json,
    ) = HttpClient(OkHttp) {
        install(Logging) {
            logger = Logger.ANDROID
        }

        install(ContentNegotiation) {
            json(json)
        }
    }
}